package com.hellozq.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThisLi(Bin)
 * @date 2018/9/17
 * time: 17:43
 * To change this template use File | Settings | File Templates.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Result<T> implements Serializable {

    private Integer code = 200;

    private String msg = "操作成功";

    private String description;

    private T data;

    /**
     * 失败的返回
     * @param code 失败代码
     * @param msg 失败信息
     * @param data 内容
     * @param <T> 类型
     * @return 工厂返回对象
     */
    public static<T> Result<T> failure(int code, String msg,T data){
        Result<T> result = new Result<>();

        result.code = code;
        result.msg = msg;
        result.data = data;

        return result;
    }

    /**
     * 成功的返回
     * @param data 信息
     * @param <T> 泛型
     * @return 成功的工厂返回对象
     */
    public static<T> Result<T> success(T data){
        Result<T> result = new Result<>();

        result.data = data;

        return result;
    }
}
