package com.smarttransaction.transactionsimulation.transactionobject;

public class Customer_Info {

	private String first_name;
	private String last_name;
	private String mobile;
	private String mobile_alt;
	private String email;
	private String email_alt;
	public Customer_Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer_Info(String first_name, String last_name, String mobile, String mobile_alt, String email,
			String email_alt) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.mobile_alt = mobile_alt;
		this.email = email;
		this.email_alt = email_alt;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobile_alt() {
		return mobile_alt;
	}
	public void setMobile_alt(String mobile_alt) {
		this.mobile_alt = mobile_alt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_alt() {
		return email_alt;
	}
	public void setEmail_alt(String email_alt) {
		this.email_alt = email_alt;
	}
	@Override
	public String toString() {
		return "Customer [first_name=" + first_name + ", last_name=" + last_name + ", mobile=" + mobile
				+ ", mobile_alt=" + mobile_alt + ", email=" + email + ", email_alt=" + email_alt + "]";
	}
	
	
}
