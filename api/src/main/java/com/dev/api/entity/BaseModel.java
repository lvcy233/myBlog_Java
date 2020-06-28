package com.dev.api.entity;

import com.dev.common.util.JsonTimeDeserializer;
import com.dev.common.util.JsonTimeSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description:表基础字段
 * @Author lvcy
 * @Date 2020/5/28
 **/
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel implements Serializable, Comparable<BaseModel> {

    private static final long serialVersionUID = 1L;

    @Id
    @JsonProperty(value = "id")
    @Column(length = 20, columnDefinition = "int(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长
    private Integer id;

    @JsonDeserialize(using = JsonTimeDeserializer.class)
    @JsonSerialize(using = JsonTimeSerializer.class)
    @JsonProperty(value = "create_time")
    @Column(columnDefinition = "datetime comment '数据创建时间'")
    private Date createTime;

    @JsonDeserialize(using = JsonTimeDeserializer.class)
    @JsonSerialize(using = JsonTimeSerializer.class)
    @JsonProperty(value = "edit_time")
    @Column(columnDefinition = "datetime comment '数据修改时间'")
    private Date editTime;

    @JsonProperty(value = "create_user")
    @Column(columnDefinition = "varchar(255) comment '创建人'")
    private String createUser;

    @JsonProperty(value = "edit_user")
    @Column(columnDefinition = "varchar(255) comment '修改人'")
    private String editUser;

    @JsonProperty(value = "del_flag")
    @Column(columnDefinition = "char(1) comment '删除标识'")
    private String delFlag;

    //创建默认时间
    @PrePersist
    protected void onCreate() {
        if (createTime == null) {
            this.createTime = new Date();
        }
        if (editTime == null) {
            this.editTime = new Date();
        }
        //默认给删除标识
        this.delFlag = "0";
    }

    //修改默认时间
    @PreUpdate
    protected void onUpdate() {
        this.editTime = new Date();
        if (this.createTime == null) {
            this.createTime = this.editTime;
        }
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof BaseModel)) {
            return false;
        }
        final BaseModel other = (BaseModel) object;
        Serializable id = this.getId();
        Serializable otherId = other.getId();
        if ((id == null && otherId != null) || (id != null && !id.equals(otherId))) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(BaseModel another) {
        if (this.getId() > another.getId()) {
            return -1;
        } else if (this.getId() < another.getId()) {
            return 1;
        }
        return 0;
    }
}
