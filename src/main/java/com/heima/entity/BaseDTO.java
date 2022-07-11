package com.heima.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * The type Base dto.
 *
 * @author Administrator
 */
@Data
public class BaseDTO {

    @Version
    private Integer version;

}
