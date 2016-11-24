package com.codejstudio.service.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;




/**
 * 模板工具类
 * @Description: 
 * 模板操作，包括模板内容的读写，维护；
 * 短信内容的替换
 * @author Marco
 * @date 2015年7月1日 下午7:05:13
 *
 */
public class MsgTemplateUtil {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 注册短信模板
	 */
	public final static String MSG_TEMPLATE_REGISTER_ = "msg_register";

	/**
	 * 忘记密码短信模板
	 */
	public final static String MSG_TEMPLATE_FORGET_PW_ = "msg_forget_pw_";


	/**
	 * 生日提醒
	 */
	public final static String MSG_TEMPLATE_BIRTHDAT_WITH_ = "msg_birthday_wish_";
	
	/**
	 * 注册用户随机6位数字密码
	 */
	public final static String MSG_TEMPLATE_REGISTER_RANDOM_PWD_ = "msg_reg_pw_";

	private  final String DEFAULT_SPLIT = "$$";

	/**
	 * 使用context中对应的值替换templet中用$$包围的变量名(也是context的key)
	 * @param templet 模板
	 * @param context 用于替换模板中的变量
	 * @return 例如  参数 : dddd$$aaa$$$$bbb$$ccc$$, $$, {<aaa, value1>, <bbb, value2>}  结果:ddddvalue1value2ccc$$
	 */
	public  String renderDefault(String templet, Map<String, String> paramsMap) {
		return render(templet, DEFAULT_SPLIT, paramsMap);
	}


	/**
	 * 简易版的替换处理，模板替换参数只有一个
	 * @Title: renderDefaultSimple
	 * @Description: TODO
	 * @param templet 模板
	 * @param value 替换的变量值
	 * @return 
	 * @throws 
	 */
	public  String renderDefaultSimple(String templet, String value) {
		Map<String,String> paramsMap = new HashMap<String,String>();
		Set<String> paramNames = getParamNames(templet, DEFAULT_SPLIT);
		for (String name : paramNames) {
			paramsMap.put(name, value);
		}
		return render(templet, DEFAULT_SPLIT, paramsMap);
	}

	/**
	 * 使用context中对应的值替换templet中用split包围的变量名(也是context的key)
	 * @param templet 模板
	 * @param split 用于标识变量名的标志
	 * @param context 用于替换模板中的变量
	 * @return 例如  参数 : dddd$$aaa$$$$bbb$$ccc$$, $$, {<aaa, value1>, <bbb, value2>}  结果:ddddvalue1value2ccc$$
	 */
	public  String render(String templet, String split, Map<String, String> paramsMap) {
		logger.debug("send msg params is : {}",paramsMap);
		
		Set<String> paramNames = getParamNames(templet, split);

		for (String name : paramNames) {
			String value = paramsMap.get(name);
			value = value == null ? "" : value;
			String regex = "\\Q" + split + name + split + "\\E";
			templet = templet.replaceAll(regex, value);
		}

		return templet;
	}

	/**
	 * 根据分割符从模板中取得变量的名字($$变量名$$) eg:
	 * $$aaa$$$$bbb$$ccc$$ 返回   aaa,bbb
	 * @param templet 模板
	 * @param split 包围变量名的字符串
	 * @return 模板中的变量名
	 */
	public  Set<String> getParamNames(String templet, String split) {
		Set<String> paramNames = new HashSet<String>();
		int start = 0, end = 0;
		while (end < templet.length()) {
			start = templet.indexOf(split, end) + split.length();
			if (start == -1) {
				break;
			}
			end = templet.indexOf(split, start);
			if (end == -1) {
				break;
			}
			paramNames.add(templet.substring(start, end));
			end = end + split.length();
		}
		return paramNames;
	}

	@SuppressWarnings({  "unchecked" })
	private String getMsgFromXML(String title){
		logger.debug("send msg title is ：{}",title);
		SAXReader  saxReader = new SAXReader();
		Document document;
		try {
			document = saxReader.read(this.getClass().getResourceAsStream("/messageTemplate.xml"));
			Element rootElement=document.getRootElement();
			List<Element> elementList = rootElement.elements("msg");
			for(Element element:elementList){
				String eTitle = element.attributeValue("title");
				if(title.equals(eTitle)){
					return element.elementText("content");
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}


	/**
	 * @Title: getMsgTemplate
	 * @Description: 获取消息体模板
	 * @param msgTitle 模板标题
	 * @return
	 * @throws 
	 */
	public  String getMsgTemplate(String msgTitle){
		String template  = getMsgFromXML(msgTitle);
		if(StringUtils.isEmpty(template)){
			if(MsgTemplateUtil.MSG_TEMPLATE_REGISTER_.contentEquals(msgTitle)){
				template = "【哥斯拉】尊贵的用户，您的验证码为:$$code$$。2分钟内有效，请勿泄露您的验证码。";
			}if(MsgTemplateUtil.MSG_TEMPLATE_FORGET_PW_.contentEquals(msgTitle)){
				template = "【哥斯拉】正在申请重置密码，您的验证码为:$$code$$。2分钟内有效，请勿泄露您的验证码。";
			}
		}
		
		return template;
	}


	/** 
	 * @Title: getInstance
	 * @Description: 单例模式
	 * @return
	 * @throws 
	 */
	public static MsgTemplateUtil getInstance(){
		if(u==null){
			u=new MsgTemplateUtil();
		}
		return u;
	}

	private MsgTemplateUtil(){};

	private static MsgTemplateUtil u;


}
