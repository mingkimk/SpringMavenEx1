package com.human.cal;

public class CalCenter {
	
	private Cal myCal;
	private int a;
	private int b;
	
	CalCenter(){
		
	}
	
	public Cal getMyCal() {
		return myCal;
	}

	public void setMyCal(Cal myCal) {
		this.myCal = myCal;
	}



	public void result() {
		myCal.sum(a,b);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

}
