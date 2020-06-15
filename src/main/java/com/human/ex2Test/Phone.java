package com.human.ex2Test;

public class Phone {
	
	String[] phoneInputData = { "회사", "모델명", "가격" };
	String[] phoneDataValue= new String[phoneInputData.length];
//	private String com;
//	private String modelName;
//	private String price;
	
	public String getCom() {
		return phoneDataValue[0];
	}
	public void setCom(String com) {
		this.phoneDataValue[0] = com;
	}
	public String getModelName() {
		return phoneDataValue[1];
	}
	public void setModelName(String modelName) {
		this.phoneDataValue[1] = modelName;
	}
	public String getPrice() {
		return phoneDataValue[2];
	}
	public void setPrice(String price) {
		this.phoneDataValue[2] = price;
	}
	public void setAll(String[] data) {
		for(int i=0; i < data.length; i++) {
			phoneDataValue[i]=data[i];
		}
	}
	public void prt() {
		for(int i=0; i < phoneDataValue.length; i++) {
			System.out.print(phoneDataValue[i]+"/");
		}
		System.out.println();
	}

}
