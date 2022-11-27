package com.smarttransaction.transactionsimulation.transactionobject;






public class Authentication_Object {

	private String objectid;
public String getObjectid() {
		return objectid;
	}

	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}

	//	private String transactionid ;
	private String orderid;
	private String mercid;
	private String date;
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private String amount;
//	private String surcharge;
//	private String discount;
//	private String charge_amount;
	private String currency;
	
	private String itemcode;
	private String authentication_type;
	private String ru;
	private Customer_Additional_Info additional_info;
	
	
	

	private Customer_Info customer;
	
	private String txn_process_type;
	
	
//	private String settlement_lob;
//	private String bank_ref_no;

//	private String transaction_error_code;
//	private String transaction_error_desc;
//	private String transaction_error_type;
	private String payment_method_type;
	
	private Customer_Card_Info card;
	
	private String cust_ref_id;
	
	private String Acquirer;
	private String auth_status;
	private int latency;
//	

	public Authentication_Object() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getMercid() {
		return mercid;
	}

	public void setMercid(String mercid) {
		this.mercid = mercid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAcquirer() {
		return Acquirer;
	}

	public void setAcquirer(String acquirer) {
		Acquirer = acquirer;
	}

	public String getAuth_status() {
		return auth_status;
	}

	public void setAuth_status(String auth_status) {
		this.auth_status = auth_status;
	}

	public int getLatency() {
		return latency;
	}

	public void setLatency(int latency) {
		this.latency = latency;
	}

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getAuthentication_type() {
		return authentication_type;
	}

	public void setAuthentication_type(String authentication_type) {
		this.authentication_type = authentication_type;
	}

	public String getRu() {
		return ru;
	}

	public void setRu(String ru) {
		this.ru = ru;
	}

	public Customer_Additional_Info getAdditional_info() {
		return additional_info;
	}

	public void setAdditional_info(Customer_Additional_Info additional_info) {
		this.additional_info = additional_info;
	}

	public Customer_Info getCustomer() {
		return customer;
	}

	public void setCustomer(Customer_Info customer) {
		this.customer = customer;
	}

	public String getTxn_process_type() {
		return txn_process_type;
	}

	public void setTxn_process_type(String txn_process_type) {
		this.txn_process_type = txn_process_type;
	}

	public String getPayment_method_type() {
		return payment_method_type;
	}

	public void setPayment_method_type(String payment_method_type) {
		this.payment_method_type = payment_method_type;
	}

	public Customer_Card_Info getCard() {
		return card;
	}

	public void setCard(Customer_Card_Info card) {
		this.card = card;
	}

	public String getCust_ref_id() {
		return cust_ref_id;
	}

	public void setCust_ref_id(String cust_ref_id) {
		this.cust_ref_id = cust_ref_id;
	}

	public Authentication_Object(String orderid, String mercid, String amount, String currency,String transaction_date, String acquirer,
			String itemcode, String authentication_type, String ru, Customer_Additional_Info additional_info,
			Customer_Info customer, String txn_process_type, String payment_method_type, Customer_Card_Info card,
			String cust_ref_id) {
		super();
		this.orderid = orderid;
		this.mercid = mercid;
		this.amount = amount;
		this.currency = currency;
		this.date=transaction_date;
		this.Acquirer = acquirer;
		this.itemcode = itemcode;
		this.authentication_type = authentication_type;
		this.ru = ru;
		this.additional_info = additional_info;
		this.customer = customer;
		this.txn_process_type = txn_process_type;
		this.payment_method_type = payment_method_type;
		this.card = card;
		this.cust_ref_id = cust_ref_id;
	}

	@Override
	public String toString() {
		return "Transaction_Object {orderid=" + orderid + ", mercid=" + mercid + ", amount=" + amount + ", currency="
				+ currency +", Date="+date+ ", Acquirer=" + Acquirer + ", itemcode=" + itemcode + ", authentication_type="
				+ authentication_type + ", ru=" + ru + ", additional_info=" + additional_info + ", customer=" + customer
				+ ", txn_process_type=" + txn_process_type + ", payment_method_type=" + payment_method_type + ", card="
				+ card + ", cust_ref_id=" + cust_ref_id + "}";
	}



	
    
    
    
    
	
	
}
