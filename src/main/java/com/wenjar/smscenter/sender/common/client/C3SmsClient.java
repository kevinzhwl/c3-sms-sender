package com.wenjar.smscenter.sender.common.client;

import com.wenjar.smscenter.sender.common.model.SmsSendResp;

import java.util.List;

public interface C3SmsClient {
  boolean doesSuccess(SmsSendResp resp);

  SmsSendResp send(String mobile, String content);

  SmsSendResp send(List<String> mobiles, String content);

  SmsSendResp send(List<String> mobiles, String content, String signature);

}
