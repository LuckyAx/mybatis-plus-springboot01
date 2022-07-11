package com.heima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * The interface User mapper.
 *
 * @author buyunxiang
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * Find map by id map.
     *
     * @param id the id
     * @return the map
     */
    @MapKey("name")
    Map<String, User> findMapById(Integer id);

    /**
     * Find all user page.
     *
     * @param page the page
     * @return the page
     */
    Page<User> findAllUser(Page<User> page);

}
