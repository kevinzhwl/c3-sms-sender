package com.wenjar.smscenter.sender.client.impl;

import lombok.Data;

import java.util.List;

@Data
public class SmsParams {

  private String appToken;//app对应的token
  private String appId;//app的id
  private String msgContent;//
  private String msgSignature;//
  private List<String> mobiles;//


}
