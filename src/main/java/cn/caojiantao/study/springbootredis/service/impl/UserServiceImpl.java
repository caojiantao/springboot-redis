package cn.caojiantao.study.springbootredis.service.impl;

import cn.caojiantao.study.springbootredis.entity.Addr;
import cn.caojiantao.study.springbootredis.entity.User;
import cn.caojiantao.study.springbootredis.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private static List<User> userList = new ArrayList<>();

    static {
        Addr m = new Addr(1, 1, "湖北武汉");
        User a = new User(1, "曹建涛", m);
        userList.add(a);
        Addr n = new Addr(2, 2, "北京海淀");
        User b = new User(2, "张大仙", n);
        userList.add(b);
    }

    @Cacheable(cacheNames = "springboot-redis")
    @Override
    public User getById(Integer id) {
        User user = userList.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
        log.info("act=getById id={} result={}", id, user);
        return user;
    }

    @Cacheable(cacheNames = "springboot-redis")
    @Override
    public List<User> getByIdList(List<Integer> idList) {
        List<User> list = userList.stream().filter(item -> idList.contains(item.getId())).collect(Collectors.toList());
        log.info("act=getByIdList id={} result={}", idList, list);
        return list;
    }
}
