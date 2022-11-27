package com.smarttransaction.transactionsimulation.kafkaconfigurartion;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


import com.smarttransaction.transactionsimulation.transactionobject.Authentication_Object;
import com.smarttransaction.transactionsimulation.model.AggregationRequest_Object;
import com.smarttransaction.transactionsimulation.model.PredictionObject;


@Configuration
public class KafkaConfig {

	@Bean
	public ProducerFactory<String,PredictionObject> producerFactory() {
		
		Map<String, Object> config= new HashMap<>();
		
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean
	public KafkaTemplate<String,PredictionObject> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
	
	
	@Bean
	public ProducerFactory<String,Authentication_Object> producerFactory2() {
		
		Map<String, Object> config= new HashMap<>();
		
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean
	public KafkaTemplate<String,Authentication_Object> kafkaTemplate2(){
		return new KafkaTemplate<>(producerFactory2());
	}
}
