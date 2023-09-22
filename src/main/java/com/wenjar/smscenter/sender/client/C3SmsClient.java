package com.wenjar.smscenter.sender.client;

import com.wenjar.smscenter.sender.model.SmsSendRequest;
import com.wenjar.smscenter.sender.model.SmsSendResponse;

public interface C3SmsClient {
  boolean doesSuccess(SmsSendResponse resp);
  String getMsgSignature();

  SmsSendResponse send(String mobile, String content);

  SmsSendResponse send(SmsSendRequest request);

}
