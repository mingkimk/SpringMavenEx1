package com.human.ex2Test;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PhoneAdmin {

	private Phone newP;
	private String configLocation = null;
	private AbstractApplicationContext ctx = null;// xml을 파싱해서 추상클래스에 인식한다
	
	private MysqlConnectCfg mysqlConn=null;
	
	//private PhoneStart ps = null;
	private ArrayList<Phone> phoneList = new ArrayList();
	private Scanner in = new Scanner(System.in);
	private Phone p = null;
	private PhoneDao myDao= null;
	public PhoneDao getMyDao() {
		return myDao;
	}
	public void setMyDao(PhoneDao myDao) {
		this.myDao = myDao;
	}

	PhoneAdmin() {
		
	}

	public void init() {
		configLocation = "classpath:ex2TestBean.xml";
		ctx = new GenericXmlApplicationContext(configLocation); // xml을 파싱해서 추상클래스에 인식한다
		
		selmenu();
	}
	
	public Phone getP() {
		p = ctx.getBean("phone", Phone.class);
		return p;
	}
	
	public void selmenu() {
		boolean flag=true;
		while (flag) {
			menu();
			String a = input("메뉴");
			switch (a) {
			case "1":
				savePhoneInput();
				break;
			case "2":
				viewList();
				break;
			default:
				flag = false;
			}
		}
	}

	private void menu() {
		System.out.println("1. save");
		System.out.println("2. list");
	}

	private String input(String name) {
		System.out.println(name + " 입력하세요");
		return in.nextLine();
	}

	private void savePhoneInput() {
		getP();
		for (int i = 0; i < p.phoneInputData.length; i++) {
			p.phoneDataValue[i] = input(p.phoneInputData[i]);
		}

		savePhone(p);
		myDao.insertDB(p);
	}

	private void savePhone(Phone p) {
		phoneList.add(p);
	}

	private void viewList() {
		for(int i=0; i < phoneList.size(); i++) {
			phoneList.get(i).prt();
		}
	}
}
