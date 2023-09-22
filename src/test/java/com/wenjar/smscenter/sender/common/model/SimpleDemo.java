package com.wenjar.smscenter.sender.common.model;


import com.wenjar.smscenter.sender.config.C3ClientConfig;
import com.wenjar.smscenter.sender.config.C3Credentials;
import com.wenjar.smscenter.sender.config.impl.C3SimpleCredentialsImpl;
import com.wenjar.smscenter.sender.client.C3SmsClient;
import com.wenjar.smscenter.sender.client.impl.C3SmsSimpleClientImpl;
import com.wenjar.smscenter.sender.model.SmsSendResponse;

public class SimpleDemo {


  public static void SimpleDemo() {
    // 1 初始化用户身份信息(secretId, secretKey)
    C3Credentials cred = new C3SimpleCredentialsImpl("Your_App_Id", "Your_App_Token", "【签名】");

    C3ClientConfig cf = new C3ClientConfig("http://message.center.url/api/send");

    C3SmsClient ossClient = new C3SmsSimpleClientImpl(cred, cf);

    try {
      String phone = "13601239876";
      String content = "验证码475482，请尽快填写！";

      SmsSendResponse resp = ossClient.send(phone, content);
      System.out.println(resp);
      final boolean success = ossClient.doesSuccess(resp);
      if (success) {
        System.out.println("Send is succeed");
      } else {
        System.out.println("Send is failed");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    // 关闭客户端
  }

  public static void main(String[] args) {
    SimpleDemo();
  }

}
