package com.dev.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * QQ第三方登录
     */
    private String qqOpenid;

    /**
     * 微信第三方登录
     */
    private String wxOpenid;

    /**
     * gitee第三方登录
     */
    private String giteeOpenid;

    /**
     * github第三方登录
     */
    private String githubOpenid;


}
