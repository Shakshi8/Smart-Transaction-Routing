package com.smarttransaction.transactionsimulation.model;

public class PredictionObject {

	
	private String issuer;
	
	private String type;

	private String network;

	private String valid_date;

	private String txn_process_type;

	public PredictionObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PredictionObject(String issuer, String type, String network, String valid_date,
			String txn_process_type) {
		super();
		this.issuer = issuer;
		this.type = type;
		this.network = network;
		this.valid_date = valid_date;
		this.txn_process_type = txn_process_type;
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

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getValid_date() {
		return valid_date;
	}

	public void setValid_date(String valid_date) {
		this.valid_date = valid_date;
	}

	public String getTxn_process_type() {
		return txn_process_type;
	}

	public void setTxn_process_type(String txn_process_type) {
		this.txn_process_type = txn_process_type;
	}

	@Override
	public String toString() {
		return "PredictionObject {issuer=" + issuer + ", type=" + type + ", network=" + network + ", valid_date="
				+ valid_date + ", txn_process_type=" + txn_process_type + "}";
	}
	
	
}
