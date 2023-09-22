package com.wenjar.smscenter.sender.model;

import lombok.Getter;

@Getter
public enum ApiStatusCode {
  REQUEST_DONE(200, "处理成功(非业务成功，兼容旧接口)"),//表示处理成功，
  ALL_SEND_FAILED(50010, "发送全部失败Failed."),

  OK(20000, "成功"),
  OK_ASYNC(20000, "异步方式成功"),//表示处理成功

  ;

  private final int code;
  private final String msg;

  ApiStatusCode(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

}
