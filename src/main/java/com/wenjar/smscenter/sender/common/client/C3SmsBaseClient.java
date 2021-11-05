package com.wenjar.smscenter.sender.common.client;


import com.wenjar.smscenter.sender.common.model.ApiStatusCode;
import com.wenjar.smscenter.sender.common.model.SmsSendResp;

public abstract class C3SmsBaseClient implements C3SmsClient {

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
        if (sig == null || sig.length() == 0){
            throw new IllegalArgumentException(errorMessage);
        }
        if (!sig.matches("^【.*】$")){
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public boolean doesSuccess(SmsSendResp resp) {
        if (resp != null && resp.getCode() != null) {
            //支持当前的值 REQUEST_DONE 和 预留的值 OK
            return (resp.getCode() == ApiStatusCode.REQUEST_DONE.getCode() || resp.getCode() == ApiStatusCode.OK.getCode());
        }

        return false;
    }
}
