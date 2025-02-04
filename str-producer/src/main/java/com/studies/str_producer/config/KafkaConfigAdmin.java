package com.studies.str_producer.config;

import java.util.HashMap;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import lombok.RequiredArgsConstructor;

/* configs para acesso ao servidor e criação de tópico - Admin */

@RequiredArgsConstructor
@Configuration
public class KafkaConfigAdmin {
	
	public final KafkaProperties properties;
	
	@Bean
	public KafkaAdmin kafkaAdmin() {
		var configs = new HashMap<String, Object>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
		return new KafkaAdmin(configs);
	}
	
	@Bean
	public KafkaAdmin.NewTopics topics(){
		return new KafkaAdmin.NewTopics(TopicBuilder.name("str-topic").partitions(2).replicas(1).build());
	}
}
