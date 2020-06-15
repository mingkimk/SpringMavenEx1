package com.human.ex2Test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PhoneStart {

	
	String mysqlConfigLocation = null;
	AbstractApplicationContext mysqlCtx = null;// xml을 파싱해서 추상클래스에 인식한다??
	MysqlConnectCfg mysqlConn=null;

	PhoneStart() {
		// Spring DI
		
		mysqlConfigLocation = "classpath:ex2TestMysql.xml";
		mysqlCtx = new GenericXmlApplicationContext(mysqlConfigLocation); // xml을 파싱해서 추상클래스에 인식한다??
		PhoneAdmin padmin = mysqlCtx.getBean("phoneAdmin", PhoneAdmin.class);
		padmin.init();
		
		/*MysqlConnectCfg m1=mysqlCtx.getBean("phoneConn",MysqlConnectCfg.class);
		MysqlConnectCfg m2=mysqlCtx.getBean("memberConn",MysqlConnectCfg.class);
		System.out.println(m1.getUrl());
		System.out.println(m2.getUrl());*/
	}
	
}
