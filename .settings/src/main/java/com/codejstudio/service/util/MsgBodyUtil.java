package com.codejstudio.service.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 消息体工具类
 * 
 * @Description: 处理不同短信消息的工具类
 * @author Marco
 * @date 2015年7月1日 下午4:29:07
 *
 */
public class MsgBodyUtil {

    Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 消息模板处理类
     */
    private MsgTemplateUtil mtu;

    /**
     * @Title: messageRegister
     * @Description: 处理注册验证码消息体
     * @param rCode
     * @return
     * @throws
     */
    public String messageRegister(String code) {

        log.debug("register code is 【{}】", code);
        String template = mtu.getMsgTemplate(MsgTemplateUtil.MSG_TEMPLATE_REGISTER_);
        String msgBody = mtu.renderDefaultSimple(template, code);
        return msgBody;
    }

    /**
     * @Title: messageForgetPd
     * @Description: 处理忘记密码消息体
     * @param rCode
     * @return
     * @throws
     */
    public String messageForgetPd(String code) {

        log.debug("register code is 【{}】", code);
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("code", code);
        String msgBody = messageByTitle(MsgTemplateUtil.MSG_TEMPLATE_FORGET_PW_, paramsMap);
        return msgBody;
    }

    /**
     * 获取消息通用类
     * 
     * @Title: messageByTitle
     * @Description: 根据消息标题和传入的Map参数进行模板内容的替换
     * @param msgTitle
     *            消息标题
     * @param paramsMap
     *            替换内容参数
     * @return
     * @throws
     */
    public String messageByTitle(String msgTitle, Map<String, String> paramsMap) {

        String template = mtu.getMsgTemplate(msgTitle);
        if (StringUtils.isEmpty(template)) {
            return null;
        }
        if (paramsMap == null) {
            paramsMap = new HashMap<String, String>();
        }
        String msgBody = mtu.renderDefault(template, paramsMap);
        return msgBody;
    }

    /**
     * @Title: messageByText
     * @Description: 根据消息体和传入的Map参数进行模板内容的替换
     * @param msgText
     *            消息体
     * @param paramsMap
     *            替换内容参数
     * @return
     * @throws
     */
    public String messageByText(String msgText, Map<String, String> paramsMap) {

        String template = msgText;
        if (StringUtils.isEmpty(template)) {
            return null;
        }
        if (paramsMap == null) {
            paramsMap = new HashMap<String, String>();
        }
        String msgBody = mtu.renderDefault(template, paramsMap);
        return msgBody;
    }

    /**
     * @Title: getInstance
     * @Description: 单例实力
     * @return
     * @throws
     */
    public static MsgBodyUtil getInstance() {

        if (t == null) {
            t = new MsgBodyUtil();
        }
        return t;
    };

    private static MsgBodyUtil t;

    private MsgBodyUtil() {

        mtu = MsgTemplateUtil.getInstance();

    };
}
