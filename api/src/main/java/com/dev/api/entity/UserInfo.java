package com.dev.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 昵称
     */
    private String name;

    /**
     * 头像
     */
    private String headPortrait;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private Integer phone;

    /**
     * 用户表id
     */
    private Long userId;

}
