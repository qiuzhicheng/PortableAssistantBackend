package com.codejstudio.common;

import com.bcloud.msg.http.HttpSender;
import com.codejstudio.service.util.PropertiesUtils;

/**
 * @Description: 短息发送工厂
 * @author Marco
 * @date 2015年6月30日 下午7:58:13
 *
 */
public class SmsSendFactory {

    /**
     * 应用地址
     */
    private String uri = PropertiesUtils.getValue("msg.uri");

    // "http://222.73.117.158/msg/index.jsp";

    /**
     * 账号
     */
    private String account = PropertiesUtils.getValue("msg.account");

    // "jiekou-clcs-01";

    /**
     * 密码
     */
    private String pswd = PropertiesUtils.getValue("msg.pswd");

    // "Tch498965";

    /**
     * 是否需要状态报告，需要true，不需要false
     */
    private boolean needstatus = true;

    /**
     * 产品ID
     */
    private String product = PropertiesUtils.getValue("msg.product");

    private SmsSendFactory() {

    };

    private static SmsSendFactory f;

    /**
     * @Title: getInstance
     * @Description: 单例短信发送工厂类
     * @return
     * @throws
     */
    public static SmsSendFactory getInstanceDefault() {

        if (f == null) {
            f = new SmsSendFactory();
        }
        f.setUri(PropertiesUtils.getValue("msg.uri"));
        f.setAccount(PropertiesUtils.getValue("msg.account"));
        f.setPswd(PropertiesUtils.getValue("msg.pswd"));
        f.setProduct(PropertiesUtils.getValue("msg.product"));
        f.setNeedstatus(true);
        return f;
    }

    /**
     * @Title: sendMsg
     * @Description: TODO
     * @param mobiles
     *            手机号字符串，多个手机号英文逗号隔开，如13511112222,18900001111
     * @param content
     *            发送的文本内容
     * @return
     * @throws
     */
    public String sendMsg(String mobiles, String content) {

        String returnString = null;
        try {
            returnString = HttpSender.batchSend(uri, account, pswd, mobiles, content, needstatus, product, null);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return returnString;
    }

    /**
     * @Title: sendMsg
     * @Description: TODO
     * @param mobiles
     *            手机号字符串，多个手机号英文逗号隔开，如13511112222,18900001111
     * @param content
     *            发送的文本内容
     * @param extno
     *            扩展字段，6位
     * @return
     * @throws
     */
    public String sendMsg(String mobiles, String content, String extno) {

        String returnString = null;
        try {
            returnString = HttpSender.batchSend(uri, account, pswd, mobiles, content, needstatus, product, extno);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return returnString;
    }

    public String getUri() {

        return uri;
    }

    public void setUri(String uri) {

        this.uri = uri;
    }

    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {

        this.account = account;
    }

    public String getPswd() {

        return pswd;
    }

    public void setPswd(String pswd) {

        this.pswd = pswd;
    }

    public boolean isNeedstatus() {

        return needstatus;
    }

    public void setNeedstatus(boolean needstatus) {

        this.needstatus = needstatus;
    }

    public String getProduct() {

        return product;
    }

    public void setProduct(String product) {

        this.product = product;
    }

}
