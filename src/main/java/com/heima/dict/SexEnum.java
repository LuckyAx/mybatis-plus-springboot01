package com.heima.dict;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Administrator
 */
@Getter
@ToString
public enum SexEnum {
    MAN(1, "男"), WOMAN(2, "女");

    @EnumValue
    private Integer id;
    private String value;

    SexEnum(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
