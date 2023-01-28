package net.javadog.chat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.javadog.chat.entity.User;
import net.javadog.chat.mapper.UserMapper;
import net.javadog.chat.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户接口实现类
 *
 * @author: hdx
 * @Date: 2023-01-10 11:55
 * @version: 1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
