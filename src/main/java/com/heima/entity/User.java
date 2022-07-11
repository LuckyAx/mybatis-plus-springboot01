package com.heima.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
@Builder
@TableName(value = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseDTO implements Serializable {
    private static final long serialVersionUID = 1157056783323160536L;
    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

}
