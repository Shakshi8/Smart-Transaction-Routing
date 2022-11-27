package com.smarttransaction.transactionsimulation.kafkaconfigurartion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smarttransaction.transactionsimulation.model.AggregationRequest_Object;

import com.smarttransaction.transactionsimulation.model.AggregatedResponse_Object;
import com.smarttransaction.transactionsimulation.transactionobject.Authentication_Object;


@EnableKafka
@Configuration

public class KafkaConsumerConfiguration {

	
	
	@Bean
	public ConsumerFactory<String,Authentication_Object> kafkarConsumerFactory(){
		Map<String, Object> config = new HashMap<>();
		
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_transaction");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		
		return new DefaultKafkaConsumerFactory<String,Authentication_Object>(config,new StringDeserializer(),new JsonDeserializer<>(Authentication_Object.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Authentication_Object> kafkaListenerContainerFactoryTransaction(){
		ConcurrentKafkaListenerContainerFactory<String, Authentication_Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(kafkarConsumerFactory());
		return factory;
	}
	
	
	
	JsonDeserializer<List<AggregatedResponse_Object>> kafkaDeserializer() {
	    ObjectMapper om = new ObjectMapper();
	    JavaType type = om.getTypeFactory().constructParametricType(List.class, AggregatedResponse_Object.class);
	    return  new JsonDeserializer<List<AggregatedResponse_Object>>(type, om, false);
	}
	
	///consumer2 config
	@Bean
	public ConsumerFactory<String,List<AggregatedResponse_Object>> kafkarConsumerFactory2(){
		Map<String, Object> config = new HashMap<>();
		
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_transaction2");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		
		
		
		return new DefaultKafkaConsumerFactory<String,List<AggregatedResponse_Object>>(config,new StringDeserializer(), kafkaDeserializer());
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, List<AggregatedResponse_Object>> kafkaListenerContainerFactoryTransaction2(){
		ConcurrentKafkaListenerContainerFactory<String, List<AggregatedResponse_Object>> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(kafkarConsumerFactory2());
		return factory;
	}
}
