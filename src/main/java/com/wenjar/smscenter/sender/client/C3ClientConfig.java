package com.wenjar.smscenter.sender.client;

import lombok.Data;

@Data
public class C3ClientConfig {

  // 默认的获取连接的超时时间, 单位ms
  private static final int DEFAULT_CONNECTION_REQUEST_TIMEOUT = -1;
  // 默认连接超时, 单位ms
  private static final int DEFAULT_CONNECTION_TIMEOUT = 30 * 1000;
  // 默认的SOCKET读取超时时间, 单位ms
  private static final int DEFAULT_SOCKET_TIMEOUT = 30 * 1000;
  // 默认的维护最大HTTP连接数
  private static final int DEFAULT_MAX_CONNECTIONS_COUNT = 1024;
  // 多次签名的默认过期时间,单位秒
  private static final long DEFAULT_SIGN_EXPIRED = 3600;
  // Read Limit
  private static final int DEFAULT_READ_LIMIT = (2 << 17) + 1;
  /**
   * default retry times is 3 when retryable exception occured
   **/
  private static final int DEFAULT_RETRY_TIMES = 3;
  /**
   * The max retry times if retryable exception occured
   **/
  private int maxErrorRetry = DEFAULT_RETRY_TIMES;

  private String endPointSuffix = null;
  private String serviceEndpoint = null;

  private boolean useBasicAuth = false;
  private long signExpired = DEFAULT_SIGN_EXPIRED;
  private int connectionRequestTimeout = DEFAULT_CONNECTION_REQUEST_TIMEOUT;
  private int connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
  private int socketTimeout = DEFAULT_SOCKET_TIMEOUT;
  private int maxConnectionsCount = DEFAULT_MAX_CONNECTIONS_COUNT;
  private int readLimit = DEFAULT_READ_LIMIT;

  public C3ClientConfig(String serviceEndpoint) {
    this.serviceEndpoint = serviceEndpoint;
  }
}
