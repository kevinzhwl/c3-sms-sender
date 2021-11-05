package com.wenjar.smscenter.sender.provider.saas;

import lombok.Data;

import java.util.List;

@Data
public class SmsReqVO {

    private String appToken;//app对应的token
    private String appId;//app的id
    private String msgContent;//
    private String msgSignature;//
    private List<String> mobiles;//

    public SmsReqVO() {
    }

    public SmsReqVO(String appId, String appToken, String msgContent, String msgSignature, List<String> mobiles) {
        this.appToken = appToken;
        this.appId = appId;
        this.msgContent = msgContent;
        this.msgSignature = msgSignature;
        this.mobiles = mobiles;

    }

}
