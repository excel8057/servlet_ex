package com.example;

public class Calc {
	private int result;
	
	public Calc() {
		result=0;
	}
	
	public Calc(int num1, int num2, String op) {
		if(op.equals("+")) {
			result = num1+num2;
		} else if(op.equals("-")) {
			result = num1-num2;
		} else if(op.equals("*")) {
			result = num1*num2;
		} else if(op.equals("/")) {
			if(num2 != 0) result = num1/num2;
			else result = 0;
		}
	}
	
	public int getResult() {
		return result;
	}
}
