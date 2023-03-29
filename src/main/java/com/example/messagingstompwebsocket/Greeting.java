package com.example.messagingstompwebsocket;

public class Greeting {

	private String num1;

	public Greeting(String a) {
		this.num1=a;
	}

	public String getNum1() {
		return num1;
	}

	@Override
	public String toString() {
		return "Greeting{" +
				"num1='" + num1 + '\'' +
				'}';
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}


}
