package com.model;

public class InputText {
	private String firstString;
	private String secondString;
	
	public InputText(String firstString, String secondString) {
		this.firstString = firstString;
		this.secondString = secondString;
	}
	public InputText(String firstString) {
		this.firstString = firstString;
		this.secondString=null;
	}
	public String getFirstString() {
		return firstString;
	}
	public void setFirstString(String firstString) {
		this.firstString = firstString;
	}
	public String getSecondString() {
		return secondString;
	}
	public void setSecondString(String secondString) {
		this.secondString = secondString;
	}
	
}
