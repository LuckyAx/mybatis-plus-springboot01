package com.heima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.entity.Countries;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Countries mapper.
 *
 * @author Administrator
 */
public interface CountriesMapper extends BaseMapper<Countries> {
    /**
     * Query all by country id list.
     *
     * @param countryId the country id
     * @return the list
     */
    List<Countries> queryAllByCountryId(@Param("countryId") String countryId);

    /**
     * Update by country id int.
     *
     * @param updated   the updated
     * @param countryId the country id
     * @return the int
     */
    int updateByCountryId(@Param("updated") Countries updated, @Param("countryId") String countryId);


    /**
     * Find by all order by country id list.
     *
     * @param countries the countries
     * @return the list
     */
    List<Countries> findByAllOrderByCountryId(Countries countries);


}




