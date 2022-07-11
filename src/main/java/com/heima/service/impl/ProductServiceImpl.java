package com.heima.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.entity.Product;
import com.heima.mapper.ProductMapper;
import com.heima.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
@DS("slave1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
