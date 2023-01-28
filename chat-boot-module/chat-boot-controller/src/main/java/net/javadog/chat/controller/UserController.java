package net.javadog.chat.controller;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.javadog.chat.entity.User;
import net.javadog.chat.request.UserRequest;
import net.javadog.chat.response.UserResponse;
import net.javadog.chat.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户控制器
 *
 * @author: hdx
 * @Date: 2022-12-07 15:48
 * @version: 1.0
 **/
@Api(tags = "用户控制器")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户详情", notes = "用户详情")
    @GetMapping
    public UserResponse detail(UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        User user = userService.getById(userRequest.getId());
        BeanUtil.copyProperties(user, userResponse);
        return userResponse;
    }

}
