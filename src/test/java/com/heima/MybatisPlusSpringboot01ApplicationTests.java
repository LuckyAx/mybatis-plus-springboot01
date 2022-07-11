package com.heima;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.entity.Product;
import com.heima.entity.User;
import com.heima.mapper.UserMapper;
import com.heima.service.ProductService;
import com.heima.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class MybatisPlusSpringboot01ApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    void test01() {
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setEmail("285669927@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(user.getId());
    }

    @Test
    void test02() {
        Map<String, User> userMaps = userMapper.findMapById(2);
        Set<Map.Entry<String, User>> entries = userMaps.entrySet();
        entries.forEach(stringUserEntry -> {
            System.out.println(stringUserEntry.getKey() + "====" + stringUserEntry.getValue());
        });
    }

    @Test
    void test03() {
        List<User> users = new ArrayList<>(16);
        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setName("张三" + i);
            user.setAge(i);
            user.setEmail("285669927@qq.com" + i);
            users.add(user);
        }
        boolean b = userService.saveBatch(users, 100);
        System.out.println(b);
    }

    @Test
    void test04() {
        Map<String, User> mapById = userMapper.findMapById(1);
        mapById.forEach((s, user) -> System.out.println(s + "==" + user));
//        mbs%Of,0*H?r
    }

    @Test
    void test05() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a");
        List<Map<String, Object>> mapList = userMapper.selectMaps(queryWrapper);
        mapList.forEach(stringObjectMap -> System.out.println(stringObjectMap));
    }

    @Test
    void test06() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.in("id", 2, 4);
        User user = new User();
        user.setName("a");
        user.setEmail("2222");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);
    }

    @Test
    void test07() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1).and(userQueryWrapper -> queryWrapper.le("age", 20).or().eq("name", "Jone"));
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test08() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "age", "email").like("name", "o");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test09() {
        Integer age = 0;
        String name = "";
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set(StrUtil.isNotBlank(name), "name", name);
        updateWrapper.set(age != null, "age", age);
        updateWrapper.eq("id", 1);
        int update = userMapper.update(null, updateWrapper);
        System.out.println(update);
    }

    @Test
    void test10() {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getId, 1);
        Long selectCount = userMapper.selectCount(userLambdaQueryWrapper);
        System.out.println(selectCount);
    }

    @Test
    void test11() {
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper();
        lambdaUpdateWrapper.set(User::getName, "aaa").set(User::getEmail, "25689613@qq.com");
        lambdaUpdateWrapper.ge(User::getId, 1);
        int update = userMapper.update(null, lambdaUpdateWrapper);
        System.out.println(update);
    }

    @Test
    void test12() {
        Page<User> userPage = userMapper.findAllUser(new Page<>(2, 3));
        List<User> records = userPage.getRecords();
        System.out.println(records);
        System.out.println(userPage.getCurrent());
        System.out.println(userPage.getPages());
        System.out.println(userPage.getTotal());
        System.out.println(userPage.getSize());
    }

    @Test
    void test13() {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(User::getName, "wangwu");
        updateWrapper.set(User::getAge, 22);
        updateWrapper.eq(User::getId, 1);
        int update = userMapper.update(null, updateWrapper);
        System.out.println(update);
    }

    @Test
    void test14() throws Exception {
        Product product = productService.getById(1);
        User user = userService.getById(1);
        System.out.println(product);
        System.out.println(user);

//        String password = "buyunxiang";
//        String password1 = "pyx0510.";
//        String password2 = "jdbc:mysql://192.168.207.134:3306/atguigudb?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&serverTimezone=GMT%2B8";
//        //使用默认的publicKey ，建议还是使用下面的自定义
//        String encodePassword = CryptoUtils.encrypt(password);
//        String encodePassword1 = CryptoUtils.encrypt(password1);
//        System.out.println(encodePassword);
//        System.out.println(encodePassword1);
    }
}
