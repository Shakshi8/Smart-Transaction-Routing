package com.smarttransaction.transactionsimulation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.smarttransaction.transactionsimulation.AcquirerIdentificationFunctions.Prediction;
import com.smarttransaction.transactionsimulation.AcquirerIdentificationFunctions.Ranking;

import com.smarttransaction.transactionsimulation.kafka.KafkaInitiation;
//import com.smarttransaction.transactionsimulation.listener.KafkaConsumer;

import com.smarttransaction.transactionsimulation.model.AggregatedResponse_Object;
import com.smarttransaction.transactionsimulation.model.AggregationRequest_Object;
import com.smarttransaction.transactionsimulation.model.PredictionObject;
import com.smarttransaction.transactionsimulation.transactionobject.Authentication_Object;


@RestController

public class Controller {
	
	
	PredictionObject predictionObject=new PredictionObject();
	Prediction predictionFunction=new Prediction();
	Ranking rankingFunction = new Ranking();
	AggregationRequest_Object AggregationObject=new AggregationRequest_Object();
	Authentication_Object Transaction_response = new Authentication_Object();
	KafkaInitiation kafka=new KafkaInitiation();
	List<AggregatedResponse_Object> AggregationResponseList= new ArrayList<AggregatedResponse_Object>();
	private String acquirer;
	Random random = new Random();
	//	
		String[] Auth_Status= {"0300","0300","0300","0399"};
	

	@PostMapping("/TransactionSimulator")
	public String post(@RequestBody Authentication_Object Transaction_Request) throws Exception {
		
		
		
		

		
		Transaction_response = Transaction_Request;
		
		predictionObject.setIssuer(Transaction_Request.getCard().getIssuer());
		predictionObject.setNetwork(Transaction_Request.getCard().getNetwork());
		predictionObject.setTxn_process_type(Transaction_Request.getTxn_process_type());
		predictionObject.setType(Transaction_Request.getCard().getType());
		predictionObject.setValid_date(Transaction_Request.getDate());
		
		
		
		System.out.println("Transaction Request Object:"+ Transaction_Request);
	
		acquirer= rankingFunction.ranking(predictionObject, AggregationResponseList);
	
		Transaction_response.setObjectid("authentication");
		Transaction_response.setAcquirer(acquirer);
		Transaction_response.setLatency(random.nextInt(9000));
		Transaction_response.setAuth_status(Auth_Status[random.nextInt(3)]);

		System.out.println("Response Transaction Object: "+Transaction_response);

		AggregationObject.setTransactionTime(predictionObject.getValid_date());
		AggregationObject.setCardNetwork(predictionObject.getNetwork());
		AggregationObject.setCardType(predictionObject.getType());
		AggregationObject.setIssuer(predictionObject.getIssuer());
		AggregationObject.setTransactionType(predictionObject.getTxn_process_type());
		AggregationObject.setAcquirer(acquirer);
		AggregationObject.setLatency(Transaction_response.getLatency());
		AggregationObject.setAuthstatus(Transaction_response.getAuth_status());
		
		
		kafka.produceAggregationData(AggregationObject);
		kafka.produceAuthenticationResponse(Transaction_response);

		
		
		
		return new Gson().toJson(Transaction_response);
	}
	
	
@KafkaListener(topics = "aggregationResponse",groupId = "group_transaction2", containerFactory = "kafkaListenerContainerFactoryTransaction2" )
	
	public void consumetransactionAttributes(List<AggregatedResponse_Object> list) throws Exception {
		
	AggregationResponseList=list;
	
}
	


}
