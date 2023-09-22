package com.wenjar.smscenter.sender.model;

import lombok.Data;

import java.util.List;

@Data
public class SmsSendRequest {

  private String msgContent;//
  private String msgSignature;//
  private List<String> mobiles;//


}
