package com.wenjar.smscenter.sender.model;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString(callSuper = true)
@Data
public class SmsSendResponse extends ApiBaseResult {

  private Map<String, Integer> results = new HashMap<>();
  private Map<String, String> channel = new HashMap<>();

  private Map<String, ChannelResult> details = new HashMap<>();

  @Data
  public static class ChannelResult {

    private String channelName;
    private Integer resultCode;
    private String resultNote;

  }
}
