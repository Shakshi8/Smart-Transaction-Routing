package com.smarttransaction.transactionsimulation.kafka
;




import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

import com.smarttransaction.transactionsimulation.kafkaconfigurartion.KafkaConfig;
import com.smarttransaction.transactionsimulation.model.AggregationRequest_Object;
import com.smarttransaction.transactionsimulation.transactionobject.Authentication_Object;


public class KafkaInitiation {

	

	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(KafkaConfig.class);
	private static final String TOPIC = "aggregationRequest1";
	private static final String TOPIC2 = "transactionResponse";
		
	
	
	public void produceAggregationData(AggregationRequest_Object attri) {
		KafkaTemplate<String, AggregationRequest_Object> template =context.getBean("kafkaTemplate",KafkaTemplate.class);
	
	
	template.send(TOPIC, attri);
	
//	context.close();

	
	}
	
	public void produceAuthenticationResponse(Authentication_Object attri) {
		
		KafkaTemplate<String, Authentication_Object> template2 =	context.getBean("kafkaTemplate2",KafkaTemplate.class);
		
		template2.send(TOPIC2, attri);
		
//		context.close();
		
	}
	
	
	
}
