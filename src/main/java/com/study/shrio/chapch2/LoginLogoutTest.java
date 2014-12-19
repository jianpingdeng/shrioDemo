/**
 * Project Name:shrioDemo
 * File Name:LoginLogoutTest.java
 * Package Name:com.study.shrio.chapch2
 * Date:2014-12-19����10:36:24
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
 * Date: 2014-12-19 ����10:36:24 <br/>
 * 
 * @author jianping deng
 * @version
 * @since JDK 1.6
 * @see
 */
public class LoginLogoutTest {
	@Test
	public void testHelloworld() {
		//1����ȡSecurityManager�������˴�ʹ��Ini�����ļ���ʼ��SecurityManager 
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:Shrio.ini");
		 //2���õ�SecurityManagerʵ�� ���󶨸�SecurityUtils 
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3���õ�Subject�������û���/���������֤Token�����û����/ƾ֤��  
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		 try{
			 //4����¼���������֤ 
			 subject.login(token);
		 }catch (Exception e) {
			 //5�������֤ʧ��  
		}
		Assert.assertEquals(true, subject.isAuthenticated()); //�����û��Ѿ���½�ɹ�
		//6���˳�
		subject.logout();
	}
}
