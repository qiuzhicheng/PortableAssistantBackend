package com.codejstudio.service;

import java.util.Map;

public interface ISmsSenderService {

    /**
     * 发送手机验证码
     * 
     * @param mobile
     *            手机号,多个手机号用逗号分开，如18900001111,13500001111
     * @param code
     *            验证码，存在cache中
     * @param msgTitle
     * 
     *            短信标题
     * @return 短信发送状态码，0表示成功。
     */
    public String sendVCode(String mobile, String code, String msgTitle);

    /**
     * @Title: sendRegPwdCode
     * 
     * @Description: 注册发送默认密码
     * @param mobile
     *            手机号,多个手机号用逗号分开，如18900001111,13500001111
     * @param passWord
     *            默认密码（6位随机数字）
     * @param msgTitle
     *            模板title
     * @return 短信发送状态码，0表示成功
     * @throws
     */
    public String sendRegPwdCode(String mobile, String passWord, String msgTitle);

    /**
     * @Title: sendMsgNoTemplate
     * 
     * @Description: 使用参数发送制定的短信
     * @param mobile
     *            要发送的手机号，多个用逗号分开
     * @param paramsMap
     *            动态参数，key：模板中的占位参数，value：实际发送的值
     * @param msgText
     *            短信内容
     * @return
     * @throws
     */
    public String sendMsgNoTemplate(String mobiles, Map<String, String> paramsMap, String msgText);

    /**
     * @Title: sendMarketingMsgNoTemplate
     * 
     * @Description: 使用参数发送制定的短信(营销)
     * @param mobile
     *            要发送的手机号，多个用逗号分开
     * @param paramsMap
     *            动态参数，key：模板中的占位参数，value：实际发送的值
     * @param msgText
     *            短信内容
     * @return
     * @throws
     */
    public String sendMarketingMsgNoTemplate(String mobiles, Map<String, String> paramsMap, String msgText);

    /**
     * @Title: sendMsg
     * @Description: 使用参数发送制定的短信
     * @param mobile
     *            要发送的手机号，多个用逗号分开
     * @param paramsMap
     *            动态参数，key：模板中的占位参数，value：实际发送的值
     * @param msgTitle
     *            短信类型或短信标题
     * @return 短信发送状态码，0表示成功
     * @throws
     */
    public String sendMsg(String mobiles, Map<String, String> paramsMap, String msgTitle);

    /**
     * 检查验证码是否正确
     * 
     * @param mobile
     *            手机号
     * @param code
     *            填写的验证码
     * @return VCODE_CHECK_OK,VCODE_CHECK_ERROR,VCODE_CHECK_NOTFOUND
     */
    public int checkVCode(String mobile, String code);

    /**
     * 设置验证码超时时间
     * 
     * @param timeoutSeconds
     *            ，单位秒
     */
    public void setTimeoutSeconds(int timeoutSeconds);

    /**
     * 获取短信广本
     * 
     * @param type
     * @param params
     * @return
     */
    public String getSmsText(String type, Map<String, String> params);
}
