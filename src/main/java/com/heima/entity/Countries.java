package com.heima.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName countries
 */
@TableName(value = "countries")
@Data
public class Countries implements Serializable {
    /**
     *
     */
    @TableId
    private String countryId;

    /**
     *
     */
    private String countryName;

    /**
     *
     */
    private Integer regionId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}