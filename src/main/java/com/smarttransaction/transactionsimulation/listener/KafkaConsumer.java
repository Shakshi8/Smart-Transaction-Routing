//package com.smarttransaction.transactionsimulation.listener;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import com.smarttransaction.transactionsimulation.kafka.KafkaInitiation;
//import com.smarttransaction.transactionsimulation.model.Attributes;
//import com.smarttransaction.transactionsimulation.model.ListAttri;
//import com.smarttransaction.transactionsimulation.model.PredictionAttributes;
//import com.smarttransaction.transactionsimulation.model.TransactionAttributes;
//import com.smarttransaction.transactionsimulation.model.attr11;
//import com.smarttransaction.transactionsimulation.prediction.Prediction;
//import com.smarttransaction.transactionsimulation.prediction.Ranking;
//import com.smarttransaction.transactionsimulation.transactionobject.Trans_attr;
//
//
//
//
//@Service
//public class KafkaConsumer {
//	
//	PredictionAttributes pred_attributes=new PredictionAttributes();
//	Prediction pred_fun=new Prediction();
//	Ranking ranking = new Ranking();
//	Attributes attri=new Attributes();
//	Trans_attr response = new Trans_attr();
//	List<attr11> list1=new ArrayList<attr11>();
//	
//	KafkaInitiation kafka=new KafkaInitiation();
//
//	private String aquirer;
//	@KafkaListener(topics = "transactionRequest",groupId = "group_transaction", containerFactory = "kafkaListenerContainerFactoryTransaction" )
//	
//	public void consumetransactionAttributes(Trans_attr attributes) throws Exception {
//		
//		response = attributes;
//		
//		pred_attributes.setIssuer(attributes.getCard().getIssuer());
//		pred_attributes.setNetwork(attributes.getCard().getNetwork());
//		pred_attributes.setTxn_process_type(attributes.getTxn_process_type());
//		pred_attributes.setType(attributes.getCard().getType());
//		pred_attributes.setValid_date(attributes.getTransaction_date());
//		
//		
//		System.out.println(attributes);
//	  // pred_fun.prediction(pred_attributes);
//		
//		
//		
//	   
//	   
//	   
//	   
//	   ////calling ranking function return best acquirer
//	   
////		aquirer= ranking.ranking(pred_attributes);
//	   
//	   
//	   
//		
////		Random random = new Random();
////		attri.setCardNetwork(pred_attributes.getNetwork());
////		attri.setCardType(pred_attributes.getType());
////		attri.setIssuer(pred_attributes.getIssuer());
////		attri.setTransactionType(pred_attributes.getTxn_process_type());
////		attri.setLatency(random.nextInt(9));
////		attri.setAuthstatus(random.nextInt(2));
////		attri.setAcquirer("HDFC");
//		
//		
//		System.out.println(attri);
//		
//		
//		///last step
//		//kafka.kafkainitiate(attri);
//	}
//	
//	
//	//consume2 accepting list of last 15min data
////	
////@KafkaListener(topics = "aggregationResponse",groupId = "group_transaction2", containerFactory = "kafkaListenerContainerFactoryTransaction2" )
////	
////	public void consumetransactionAttributes(List<attr11> list) throws Exception {
////		
////		
////	list1=list;
////	
////	System.out.println("In consumer 2:"+list);
//////	
//////	
////	System.out.println("Before Ranking Function");
////	aquirer= ranking.ranking(pred_attributes, list);
////	System.out.println("After Rabking Function:");
////	
//////	
//////	
//////	Random random = new Random();
//////	
//////	String[] Auth_Status= {"0300","0399"};
//////
//////	
//////	attri.setLatency(random.nextInt(9000));
//////	attri.setAuthstatus(Auth_Status[random.nextInt(1)]);
//////
//////
//////	
//////	
//////
//////	attri.setTransactionTime(pred_attributes.getValid_date());
//////	attri.setCardNetwork(pred_attributes.getNetwork());
//////	attri.setCardType(pred_attributes.getType());
//////	
//////	attri.setTransactionType(pred_attributes.getTxn_process_type());
//////
//////	
//////	attri.setAcquirer(aquirer);
//////	
//////	response.setAuth_status(attri.getAuthstatus());
//////	response.setLatency(attri.getLatency());
//////	response.setAquirer(aquirer);
//////	
//////	kafka.producer2(response);
//////	
//////	
//////	kafka.kafkainitiate(attri);
//////	
//////	
//////			
////
////	
//}
//	
//	
//	
//	
//	
//	
//	
//	
//}
