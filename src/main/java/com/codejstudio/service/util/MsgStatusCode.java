package com.codejstudio.service.util;

/**
 * @Description: 创蓝短信接口返回状态说明
 * @author Marco
 * @date 2015年6月30日 下午6:49:47
 *
 */
public interface MsgStatusCode {
//	0	提交成功
//	101	无此用户
//	102	密码错
//	103	提交过快（提交速度超过流速限制）
//	104	系统忙（因平台侧原因，暂时无法处理提交的短信）
//	105	敏感短信（短信内容包含敏感词）
//	106	消息长度错（>536或<=0）
//	107	包含错误的手机号码
//	108	手机号码个数错（群发>50000或<=0;单发>200或<=0）
//	109	无发送额度（该用户可用短信数已使用完）
//	110	不在发送时间内
//	111	超出该账户当月发送额度限制
//	112	无此产品，用户没有订购该产品
//	113	extno格式错（非数字或者长度不对）
//	115	自动审核驳回
//	116	签名不合法，未带签名（用户必须带签名的前提下）
//	117	IP地址认证错,请求调用的IP地址不是系统登记的IP地址
//	118	用户没有相应的发送权限
//	119	用户已过期
//	
	/**
	 * 提交成功
	 */
	int CB_MSG_RETURN_CODE_0 = 0;
	/**
	 * 提交成功
	 */
	int CB_MSG_RETURN_CODE_101 = 101;
	/**
	 * 密码错
	 */
	int CB_MSG_RETURN_CODE_102 = 102;
	/**
	 * 提交过快（提交速度超过流速限制）
	 */
	int CB_MSG_RETURN_CODE_103 = 103;
	/**
	 * 系统忙（因平台侧原因，暂时无法处理提交的短信）
	 */
	int CB_MSG_RETURN_CODE_104 = 104;
	/**
	 * 敏感短信（短信内容包含敏感词）
	 */
	int CB_MSG_RETURN_CODE_105 = 105;
	/**
	 * 消息长度错（>536或<=0）
	 */
	int CB_MSG_RETURN_CODE_106 = 106;
	/**
	 * 包含错误的手机号码
	 */
	int CB_MSG_RETURN_CODE_107 = 107;
	/**
	 * 手机号码个数错（群发>50000或<=0;单发>200或<=0）
	 */
	int CB_MSG_RETURN_CODE_108 = 108;
	/**
	 * 无发送额度（该用户可用短信数已使用完）
	 */
	int CB_MSG_RETURN_CODE_109 = 109;
	/**
	 * 不在发送时间内
	 */
	int CB_MSG_RETURN_CODE_110 = 110;
	/**
	 * 超出该账户当月发送额度限制
	 */
	int CB_MSG_RETURN_CODE_111 = 111;
	/**
	 * 无此产品，用户没有订购该产品
	 */
	int CB_MSG_RETURN_CODE_112 = 112;
	/**
	 * extno格式错（非数字或者长度不对）
	 */
	int CB_MSG_RETURN_CODE_113 = 113;
	/**
	 * 自动审核驳回
	 */
	int CB_MSG_RETURN_CODE_115 = 115;
	/**
	 * 签名不合法，未带签名（用户必须带签名的前提下）
	 */
	int CB_MSG_RETURN_CODE_116 = 116;
	/**
	 * IP地址认证错,请求调用的IP地址不是系统登记的IP地址
	 */
	int CB_MSG_RETURN_CODE_117 = 117;
	/**
	 * 用户没有相应的发送权限
	 */
	int CB_MSG_RETURN_CODE_118 = 118;
	/**
	 * 用户已过期提交成功
	 */
	int CB_MSG_RETURN_CODE_119 = 119;
	
	
	
	/**
	 * 验证码正确
	 */
	public static final int VCODE_CHECK_OK = 1;
	/**
	 * 验证码错误
	 */
	public static final int VCODE_CHECK_ERROR = 2;
	/**
	 * 不存在或者已超时
	 */
	public static final int VCODE_CHECK_NOTFOUND = 3;
	
	/**
	 * 注册验证码
	 */
	public static final String SMS_TYPE_VCODE = "vcode";
	/**
	 * 忘记密码的验证码
	 */
	public static final String SMS_TYPE_EDIT_PASS = "vcode";

}
