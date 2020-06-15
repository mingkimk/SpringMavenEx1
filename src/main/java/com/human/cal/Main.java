package com.human.cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:cal.xml");
		CalCenter c = ctx.getBean("calCenterA", CalCenter.class);
		
		//CalCenter c1=new CalCenter(new CalA());
			
		//c.setA(10);
		//c.setB(20);
		c.result();
//		Member m = ctx.getBean("member",Member.class);
//		m.setName("kkkk");
//		Member m1 = ctx.getBean("member",Member.class);
//		m1.setName("aaaaa");
//		
//		System.out.println(m.getName());
//		System.out.println(m1.getName());
	}

}
