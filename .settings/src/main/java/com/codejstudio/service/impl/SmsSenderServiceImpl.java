package com.codejstudio.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.codejstudio.service.ISmsSenderService;
import com.codejstudio.common.SmsSendFactory;
import com.codejstudio.common.SmsSendMarketingFactory;
import com.codejstudio.service.util.MsgBodyUtil;
import com.codejstudio.service.util.MsgStatusCode;
import com.codejstudio.common.MemcacheHelper;
import com.codejstudio.common.ValidatorUtils;

@Service("smsSenderService")
public class SmsSenderServiceImpl implements ISmsSenderService {

    Logger logger = LoggerFactory.getLogger(getClass());

    private int timeoutSeconds = 30 * 60;

    public static boolean isSmsSend = true;

    /**
     * 获取发送消息工具类
     */
    MsgBodyUtil msgBodyUtil = MsgBodyUtil.getInstance();

    SmsSendFactory smsSendFactory = SmsSendFactory.getInstanceDefault();

    SmsSendMarketingFactory smsSendMarketingFactory = SmsSendMarketingFactory.getInstanceMarketing();

    public String getVCodeKey(String mobile) {

        return "vcode-" + mobile;
    }

    public String sendVCode(String mobile, String code, String msgTitle) {

        String msgStatus = "0";
        String[] params = { mobile, code, msgTitle };
        Map<String, String> paramsMap = new HashMap<String, String>();
        logger.info("mobile:{},code:{},smsTitle:{}", params);
        paramsMap.put("code", code);

        if (SmsSenderServiceImpl.isSmsSend) {
            String returnStr = sendMsg(mobile, paramsMap, msgTitle);
            msgStatus = returnStrHandle(returnStr);
        }
        logger.info("return msg send status : {}", msgStatus);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, timeoutSeconds);
        MemcacheHelper.set(getVCodeKey(mobile), code, cal.getTime());
        return msgStatus;
    }

    public int checkVCode(String mobile, String code) {

        Object o = MemcacheHelper.get(getVCodeKey(mobile));
        String realCode = o == null ? "" : String.valueOf(o);
        if (ValidatorUtils.isEmptyString(realCode)) {
            return MsgStatusCode.VCODE_CHECK_NOTFOUND;
        } else if (!realCode.equals(code)) {
            return MsgStatusCode.VCODE_CHECK_ERROR;
        }
        return MsgStatusCode.VCODE_CHECK_OK;

    }

    public int getTimeoutSeconds() {

        return timeoutSeconds;
    }

    public void setTimeoutSeconds(int timeoutSeconds) {

        this.timeoutSeconds = timeoutSeconds;
    }

    public String getSmsText(String type, Map<String, String> params) {

        // Map<String,String> tplList =
        // ResourceHelper.list("/smstpl.properties");
        // String smsText = tplList.get("smstpl." + type);
        // if (smsText == null)return "";
        //
        // for (Entry<String, String> entry : params.entrySet()){
        // smsText = smsText.replace("{" + entry.getKey() + "}",
        // entry.getValue());
        // }
        String msg = msgBodyUtil.messageByTitle(type, params);
        return msg;
    }

    public String sendMsg(String mobiles, Map<String, String> paramsMap, String msgTitle) {

        String msg = msgBodyUtil.messageByTitle(msgTitle, paramsMap);
        String returnStr = smsSendFactory.sendMsg(mobiles, msg);
        logger.debug(returnStr);
        return returnStr;
    }

    public String sendMarketingMsgNoTemplate(String mobiles, Map<String, String> paramsMap, String msgText) {

        String msg = msgBodyUtil.messageByText(msgText, paramsMap);
        String returnStr = "";
        if (SmsSenderServiceImpl.isSmsSend) {

            returnStr = smsSendMarketingFactory.sendMsg(mobiles, msg);
        }
        logger.debug("send msg:{}...................", msg);
        logger.debug(returnStr);
        return returnStr;
    }

    public String sendMsgNoTemplate(String mobiles, Map<String, String> paramsMap, String msgText) {

        String msg = msgBodyUtil.messageByText(msgText, paramsMap);
        String returnStr = "";
        if (SmsSenderServiceImpl.isSmsSend) {

            returnStr = smsSendFactory.sendMsg(mobiles, msg);
        }
        logger.debug("send msg:{}...................", msg);
        logger.debug(returnStr);
        return returnStr;
    }

    public static SmsSenderServiceImpl getInstance(SmsSendFactory f) {

        SmsSenderServiceImpl s = new SmsSenderServiceImpl();
        SmsSendFactory sf = s.smsSendFactory;
        if (sf == null) {
            s.smsSendFactory = f;
        }
        return s;
    }

    public static SmsSenderServiceImpl getMarktingInstance(SmsSendMarketingFactory f) {

        SmsSenderServiceImpl s = new SmsSenderServiceImpl();
        SmsSendMarketingFactory sf = s.smsSendMarketingFactory;
        if (sf == null) {
            s.smsSendMarketingFactory = f;
        }
        return s;
    }

    /**
     * @Title: returnStrHandle
     * @Description: 处理服务商返回的字符串
     * @param str
     * @return
     * @throws
     */
    private String returnStrHandle(String str) {

        Map<String, String> pm = new HashMap<String, String>();
        // 2行
        String[] l1 = str.split("\n");
        // 时间和状态
        String[] l2 = l1[0].split(",");
        if (l1.length == 2) {
            pm.put("msgid", l1[1]);
        }
        pm.put("resTime", l2[0]);
        pm.put("msgStatus", l2[1]);
        logger.info("return msg send info : {}", pm);
        return l2[1];
    }
    @Override
    public String sendRegPwdCode(String mobile, String passWord, String msgTitle) {

        String msgStatus = "0";
        String[] params = { mobile, passWord, msgTitle };
        Map<String, String> paramsMap = new HashMap<String, String>();
        logger.debug("mobile:{},code:{},smsTitle:{}.......", params);
        paramsMap.put("passWord", passWord);

        if (SmsSenderServiceImpl.isSmsSend) {
            String returnStr = sendMsg(mobile, paramsMap, msgTitle);
            msgStatus = returnStrHandle(returnStr);
        }
        return msgStatus;

    }

}
