/**
 * Project Name:shrioDemo
 * File Name:LoginLogoutTest.java
 * Package Name:com.study.shrio.chapch2
 * Date:2014-12-19上午10:36:24
 * Copyright (c) 2014, jianping deng@kuwo.cn All Rights Reserved.
 *
 */

package com.study.shrio.chapch2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName:LoginLogoutTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-12-19 上午10:36:24 <br/>
 * 
 * @author jianping deng
 * @version
 * @since JDK 1.6
 * @see
 */
public class LoginLogoutTest {
	@Test
	public void testHelloworld() {
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager 
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:Shrio.ini");
		 //2、得到SecurityManager实例 并绑定给SecurityUtils 
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		 try{
			 //4、登录，即身份验证 
			 subject.login(token);
		 }catch (Exception e) {
			 //5、身份验证失败  
		}
		Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登陆成功
		//6、退出
		subject.logout();
	}
}
