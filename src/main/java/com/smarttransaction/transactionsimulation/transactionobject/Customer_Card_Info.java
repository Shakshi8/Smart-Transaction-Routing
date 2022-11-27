package com.smarttransaction.transactionsimulation.transactionobject;

public class Customer_Card_Info {
	private String CardToken;
	private String masked_value;
	private String network;
	private String issuer;
	private String type;
	private String expiry_month;
	private String expiry_year;
	private String holder_name;
	public Customer_Card_Info(String type) {
		super();
		this.type = type;
	}
	public Customer_Card_Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMasked_value() {
		return masked_value;
	}
	public void setMasked_value(String masked_value) {
		this.masked_value = masked_value;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Card [masked_value=" + masked_value + ", network=" + network + ", issuer=" + issuer + ", type=" + type
				+ "]";
	}
	
	
}
