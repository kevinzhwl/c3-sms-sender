package com.wenjar.smscenter.sender.client;


import com.wenjar.smscenter.sender.model.ApiStatusCode;
import com.wenjar.smscenter.sender.model.SmsSendRequest;
import com.wenjar.smscenter.sender.model.SmsSendResponse;

import java.util.Arrays;

public abstract class C3SmsBaseClient implements C3SmsClient {
  public abstract String readSignature();

  protected void rejectNull(Object parameterValue, String errorMessage) {
    if (parameterValue == null) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  protected void rejectEmpty(String parameterValue, String errorMessage) {
    if (parameterValue.isEmpty()) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  protected void validateSignature(String sig, String errorMessage) {
    if (sig == null || sig.length() == 0) {
      throw new IllegalArgumentException(errorMessage);
    }
    if (!sig.matches("^【.*】$")) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  public boolean doesSuccess(SmsSendResponse resp) {
    if (resp != null && resp.getCode() != null) {
      //支持当前的值 REQUEST_DONE 和 预留的值 OK
      return (resp.getCode() == ApiStatusCode.REQUEST_DONE.getCode() || resp.getCode() == ApiStatusCode.OK.getCode());
    }

    return false;
  }

  public SmsSendResponse send(String mobile, String content) {

    SmsSendRequest request = new SmsSendRequest();
    request.setMobiles(Arrays.asList(mobile));
    request.setMsgContent(content);
    request.setMsgSignature(this.readSignature());
    return send(request);
  }
}
