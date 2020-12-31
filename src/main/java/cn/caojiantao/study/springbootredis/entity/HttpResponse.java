package cn.caojiantao.study.springbootredis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResponse<T> {

    private Integer code;
    private T data;
    private String message;

    public static <T> HttpResponse<T> success(T data) {
        return new HttpResponse<>(0, data, null);
    }
}
