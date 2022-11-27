package com.smarttransaction.transactionsimulation.model;



	
	

public class AggregationRequest_Object {
	private int id;
	private String acquirer;
	private String issuer;
	private String transactionTime;
	private String transactionType;
	private String cardNetwork;
	private String cardType;
	private String authstatus;
	private int latency;
	public AggregationRequest_Object() {
	super();
	// TODO Auto-generated constructor stub
	}
	public AggregationRequest_Object(String acquirer, String issuer, String transactionTime, String transactionType,
	String cardNetwork, String cardType, String authstatus, int latency) {
	super();
	this.acquirer = acquirer;
	this.issuer = issuer;
	this.transactionTime = transactionTime;
	this.transactionType = transactionType;
	this.cardNetwork = cardNetwork;
	this.cardType = cardType;
	this.authstatus = authstatus;
	this.latency = latency;
	}
	
	
	public AggregationRequest_Object(int id, String acquirer, String issuer, String transactionTime, String transactionType,
			String cardNetwork, String cardType, String authstatus, int latency) {
		super();
		this.id = id;
		this.acquirer = acquirer;
		this.issuer = issuer;
		this.transactionTime = transactionTime;
		this.transactionType = transactionType;
		this.cardNetwork = cardNetwork;
		this.cardType = cardType;
		this.authstatus = authstatus;
		this.latency = latency;
	}
	public String getAcquirer() {
	return acquirer;
	}
	public void setAcquirer(String acquirer) {
	this.acquirer = acquirer;
	}
	public String getIssuer() {
	return issuer;
	}
	public void setIssuer(String issuer) {
	this.issuer = issuer;
	}
	public String getTransactionTime() {
	return transactionTime;
	}
	public void setTransactionTime(String transactionTime) {
	this.transactionTime = transactionTime;
	}
	public String getTransactionType() {
	return transactionType;
	}
	public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
	}
	public String getCardNetwork() {
	return cardNetwork;
	}
	public void setCardNetwork(String cardNetwork) {
	this.cardNetwork = cardNetwork;
	}
	public String getCardType() {
	return cardType;
	}
	public void setCardType(String cardType) {
	this.cardType = cardType;
	}
	public String getAuthstatus() {
	return authstatus;
	}
	public void setAuthstatus(String authstatus) {
	this.authstatus = authstatus;
	}
	public int getLatency() {
	return latency;
	}
	public void setLatency(int latency) {
	this.latency = latency;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Attributes [id=" + id + ", acquirer=" + acquirer + ", issuer=" + issuer + ", transactionTime="
				+ transactionTime + ", transactionType=" + transactionType + ", cardNetwork=" + cardNetwork
				+ ", cardType=" + cardType + ", authstatus=" + authstatus + ", latency=" + latency + "]";
	}
	
	
	
	
	}
	

