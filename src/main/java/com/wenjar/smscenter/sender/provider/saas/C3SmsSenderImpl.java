package com.wenjar.smscenter.sender.provider.saas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wenjar.smscenter.sender.common.client.C3ClientConfig;
import com.wenjar.smscenter.sender.common.client.C3Credentials;
import com.wenjar.smscenter.sender.common.client.C3SmsBaseClient;
import com.wenjar.smscenter.sender.common.model.SmsSendResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
@Slf4j
public class C3SmsSenderImpl extends C3SmsBaseClient {
  private static Gson gson = new GsonBuilder().create();

  private C3Credentials cred;
  private C3ClientConfig clientConfig;
  private RequestConfig requestConfig;

  public C3SmsSenderImpl(C3Credentials cred, C3ClientConfig config) {
    rejectNull(cred, "cred cannot be null");
    rejectNull(config, "config cannot be null");

    this.cred = cred;
    this.clientConfig = config;
  }

  protected void build() {
    //超时设置
    requestConfig = RequestConfig.custom().setConnectTimeout(clientConfig.getConnectionTimeout()).setSocketTimeout(clientConfig.getSocketTimeout()).build();
  }

  public SmsSendResp send(String mobile, String content) {
    return send(Arrays.asList(mobile), content);
  }

  public SmsSendResp send(List<String> mobiles, String content) {

    return send(mobiles, content, cred.getAppSignature());
  }

  public SmsSendResp send(List<String> mobiles, String content, String signature) {

    SmsReqVO req = new SmsReqVO();
    req.setAppId(cred.getAppId());
    req.setAppToken(cred.getAppToken());
    req.setMsgSignature(signature);
    req.setMsgContent(content);
    req.setMobiles(mobiles);

    return this.send0(clientConfig.getServiceEndpoint(), req);
  }

  private SmsSendResp send0(String url, SmsReqVO req) {
    rejectNull(url, "url cannot be null");
    rejectNull(req, "req cannot be null");
    rejectNull(req.getAppId(), "appId cannot be null");
    rejectNull(req.getAppToken(), "appToken cannot be null");
    rejectNull(req.getMsgSignature(), "msgSignature cannot be null");
    rejectNull(req.getMsgContent(), "msgContent cannot be null");
    rejectNull(req.getMobiles(), "mobiles cannot be null");
    validateSignature(req.getMsgSignature(), "signature cannot be wrong format");

    HttpPost method = null;
    String responseBody = null;
    CloseableHttpResponse response = null;
    CloseableHttpClient httpClient = null;

    try {
      httpClient = HttpClients.createDefault();

      method = new HttpPost(url);
      final String bodyContent = gson.toJson(req);

      ContentType ct = ContentType.create(ContentType.APPLICATION_JSON.getMimeType(), StandardCharsets.UTF_8);
      method.addHeader(new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "gzip"));
      method.setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, ct.toString()));

      method.setConfig(requestConfig);
      method.setEntity(new StringEntity(bodyContent, StandardCharsets.UTF_8));

      response = httpClient.execute(method);

      int statusCode = response.getStatusLine().getStatusCode();
      if (statusCode != HttpStatus.SC_OK) {
        method.abort();
        throw new RuntimeException("HttpClient,error status code :" + statusCode);
      }
      HttpEntity entity = response.getEntity();
      responseBody = EntityUtils.toString(entity, StandardCharsets.UTF_8);
      return gson.fromJson(responseBody, SmsSendResp.class);
    } catch (Exception e) {
      log.error("Exception:", e);
    } finally {
      if (httpClient != null) {
        try {
          httpClient.close();
        } catch (IOException ex) {
          log.error("when close httpClient", ex);
        }
      }

    }

    return null;
  }

}
