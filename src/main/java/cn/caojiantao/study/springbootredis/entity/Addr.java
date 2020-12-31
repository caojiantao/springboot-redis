package cn.caojiantao.study.springbootredis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Addr {

    private Integer id;
    private Integer userId;
    private String detail;
}
