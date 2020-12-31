package cn.caojiantao.study.springbootredis.controller;

import cn.caojiantao.study.springbootredis.entity.HttpResponse;
import cn.caojiantao.study.springbootredis.entity.User;
import cn.caojiantao.study.springbootredis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getById")
    public HttpResponse<User> getById(Integer id) {
        User user = userService.getById(id);
        return HttpResponse.success(user);
    }

    @GetMapping("/getByIdList")
    public HttpResponse<List<User>> getByIdList(@RequestParam("idList") List<Integer> idList) {
        List<User> list = userService.getByIdList(idList);
        return HttpResponse.success(list);
    }
}
