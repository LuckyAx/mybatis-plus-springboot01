package com.heima.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.entity.User;
import com.heima.mapper.UserMapper;
import com.heima.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
