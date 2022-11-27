package com.smarttransaction.transactionsimulation.model;


public class AggregatedResponse_Object {


	private String acquirer;
	private String cardNetwork;
	private String cardType;
	private String issuer;
	private long Succesful_Transactions;
	private long Total_Transactions;
	private long SUCCESS_RATE;
	private double Average_Latency;
	public String getAcquirer() {
		return acquirer;
	}
	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
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
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public long getSuccesful_Transactions() {
		return Succesful_Transactions;
	}
	public void setSuccesful_Transactions(long succesful_Transactions) {
		Succesful_Transactions = succesful_Transactions;
	}
	public long getTotal_Transactions() {
		return Total_Transactions;
	}
	public void setTotal_Transactions(long total_Transactions) {
		Total_Transactions = total_Transactions;
	}
	public long getSUCCESS_RATE() {
		return SUCCESS_RATE;
	}
	public void setSUCCESS_RATE(long sUCCESS_RATE) {
		SUCCESS_RATE = sUCCESS_RATE;
	}
	public double getAverage_Latency() {
		return Average_Latency;
	}
	public void setAverage_Latency(double average_Latency) {
		Average_Latency = average_Latency;
	}
	public AggregatedResponse_Object(String acquirer, String cardNetwork, String cardType, String issuer, long succesful_Transactions,
			long total_Transactions, long sUCCESS_RATE, double average_Latency) {
		super();
		this.acquirer = acquirer;
		this.cardNetwork = cardNetwork;
		this.cardType = cardType;
		this.issuer = issuer;
		Succesful_Transactions = succesful_Transactions;
		Total_Transactions = total_Transactions;
		SUCCESS_RATE = sUCCESS_RATE;
		Average_Latency = average_Latency;
	}
	@Override
	public String toString() {
		return "att11 [acquirer=" + acquirer + ", cardNetwork=" + cardNetwork + ", cardType=" + cardType + ", issuer="
				+ issuer + ", Succesful_Transactions=" + Succesful_Transactions + ", Total_Transactions="
				+ Total_Transactions + ", SUCCESS_RATE=" + SUCCESS_RATE + ", Average_Latency=" + Average_Latency + "]";
	}
	public AggregatedResponse_Object() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
