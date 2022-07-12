package com.heima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.entity.Countries;
import com.heima.mapper.CountriesMapper;
import com.heima.service.CountriesService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【countries】的数据库操作Service实现
 * @createDate 2022-07-12 22:46:56
 */
@Service
public class CountriesServiceImpl extends ServiceImpl<CountriesMapper, Countries>
        implements CountriesService {

}




