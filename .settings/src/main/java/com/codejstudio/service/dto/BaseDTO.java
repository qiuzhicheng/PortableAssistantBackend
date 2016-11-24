package com.codejstudio.service.dto;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.codejstudio.service.util.CustomDateSerializer;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//spring MVC 3.X 支持注解，在需要序列化为json输出的类上增加@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)//页面提交过来的属性在实体类上不存在：忽略未知属性（防止报错400）
public class BaseDTO implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private int id;
    
    @JsonSerialize(using = CustomDateSerializer.class)// 日期类型格式化:  CustomDateSerializer(自定义格式类型)  必须实现JsonSerializer<Date>接口
    @JsonProperty("createAt")//2 属性别名  序列化/反序列化都有效；
    private Date create_time;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonProperty("updateAt")
    private Date modify_time;

    /*@JsonIgnore//1 排除属性     一般标记在属性或方法上；作用于序列化与反序列化；
    private int createBy;

    // @JsonIgnore
    private int updateBy;

    @JsonIgnore
    private int deleteFlag;

 

    @JsonProperty("objectId")
    private String token;

    *//**
     * 资源所属的用户id
     *//*
    private String uidToken;
*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

  

   

}
