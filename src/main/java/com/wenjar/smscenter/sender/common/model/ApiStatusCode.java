package com.wenjar.smscenter.sender.common.model;


/**
 *
 */
public enum ApiStatusCode {
  REQUEST_DONE(200, "处理成功(非业务成功，兼容旧接口)"),//表示处理成功，
  REQUEST_FAILED(500, "处理失败(兼容旧接口)."),
  ALL_SEND_FAILED(50010, "发送全部失败Failed."),

  OK(20000, "成功"),
  OK_ASYNC(20000, "异步方式成功"),//表示处理成功

  BAD_REQUEST(40000, "错误的请求Bad Request."),
  BAD_METHOD(40010, "METHOD ERROR"),
  UNAUTHORIZED(40100, "前请求需要用户验证"),
  PAYMENT_REQUIRED(40200, "当前请求需要数字支付"),
  FORBIDDEN(40300, "服务器已经理解请求，但是拒绝执行它"),
  NOT_FOUND(40400, "请求失败，请求所希望得到的资源未被在服务器上发现"),

  UPGRADE_REQUIRED(42600, "客户机需要升级"),
  PRECONDITION_REQUIRED(42800, "原始服务器要求该请求是有条件的"),
  TOO_MANY_REQUESTS(42900, "请求超出了频次限制"),
  REQUEST_HEADER_FIELDS_TOO_LARGE(43100, "请求头过大"),
  UNAVAILABLE_FOR_LEGAL_REASONS(45100, "用户请求非法律资源"),

  NO_APP_OR_TOKEN(46000, "访问凭据必填Empty id or token."),
  BAD_TOKEN(46001, "访问凭据无效Validate failed,wrong id or token."),
  NO_SMS_CONTENT(46002, "短信内容Sms content is required."),
  NO_SMS_SIGNATURE(46003, "短信签名必填Sms signature is required."),
  BAD_SMS_SIGNATURE(46004, "短信签名不匹配Sms signature is wrong,please check."),
  BAD_MOBILE_NUMBER(46005, "手机号错误mobiles contains wrong number , please check it."),
  NO_MAILS(46006, "邮件地址必填Emails is required."),
  NO_GROUP_AND_MOBILES(46007, "分组和手机号至少选择其一Groups or mobiles is required."),
  NO_GROUP_AND_MOBILES_AND_EMAILS(46008, "分组、手机号或邮件地址至少选择一种Groups , mobiles or emails is required."),
  NO_MOBILES(46009, "手机号是必填mobiles is required."),
  NOT_FOUND_SMS_TEMPLATE(46010, "无匹配的内容模版"),
  NOT_FOUND_SMS_PROVIDER(46011, "未指定短信发送渠道"),
  OUT_OF_LIMIT(46012, "因流控设置而不能发送Out of limit to send"), // 因流控设置而不能发送

  FAILED(50000, "处理失败"),
  INTERNAL_ERROR(50001, "内部错误"),
  INTERNAL_DAO_ERROR(50002, "内部数据存储错误"),
  INTERNAL_EXCEPTION(50003, "处理失败Failed."),

  BAD_GATEWAY(50200, "此错误响应表明服务器作为网关需要得到一个处理这个请求的响应，但是得到一个错误的响应."),
  SERVICE_UNAVAILABLE(50300, "服务器没有准备好处理请求。 常见原因是服务器因维护或重载而停机."),
  GATEWAY_TIMEOUT(50400, "当服务器作为网关，不能及时得到响应时."),
  DEPRECATED_CALL(50900, "本接口已经失效，请查阅文档更新调用 https://wiki.corp.agrant.cn/pages/viewpage.action?pageId=10520615"),

  ;

  private int code;
  private String msg;

  ApiStatusCode(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  public String toString() {
    return this.name() + "[" + this.getCode() + "]" + this.getMsg();
  }

}
