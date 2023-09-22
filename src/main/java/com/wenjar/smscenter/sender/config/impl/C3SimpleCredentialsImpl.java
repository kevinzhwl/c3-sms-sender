package com.wenjar.smscenter.sender.config.impl;


import com.wenjar.smscenter.sender.config.C3Credentials;
import lombok.Data;

@Data
public class C3SimpleCredentialsImpl implements C3Credentials {

  private String appId;
  private String appToken;

  private String appSignature;

  public C3SimpleCredentialsImpl(String accessKey, String secretKey) {
    if (accessKey == null) {
      throw new IllegalArgumentException("AppId cannot be null.");
    }
    if (secretKey == null) {
      throw new IllegalArgumentException("AppToken cannot be null.");
    }
    this.appSignature = null;
    this.appId = accessKey;
    this.appToken = secretKey;
  }

  public C3SimpleCredentialsImpl(String appId, String appToken, String appSignature) {
    if (appId == null) {
      throw new IllegalArgumentException("AppId cannot be null.");
    }
    if (appToken == null) {
      throw new IllegalArgumentException("AppToken cannot be null.");
    }
    this.appId = appId;
    this.appToken = appToken;
    this.appSignature = appSignature;
  }
}
