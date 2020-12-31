package cn.caojiantao.study.springbootredis.service;

import cn.caojiantao.study.springbootredis.entity.User;

import java.util.List;

public interface IUserService {

    User getById(Integer id);

    List<User> getByIdList(List<Integer> idList);
}
