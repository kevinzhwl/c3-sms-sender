package com.wenjar.smscenter.sender.common.model;


import lombok.Data;
import lombok.ToString;

/**
 * Created by zzk-PC on 2016/4/19.
 */
@ToString
@Data
public class ApiBaseResult {
    private Integer code;

    private String message;

    public ApiBaseResult() {
    }
}
