package com.studies.str_consumer.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

@Retention(RetentionPolicy.RUNTIME) //A anotação estará disponível em tempo de execução
@Target(ElementType.METHOD) //Especifica os tipos de elementos de programa aos quais essa anotação pode ser aplicada
@KafkaListener
public @interface StrConsumerCustomListener {
	
	@AliasFor(annotation =  KafkaListener.class, attribute = "topicPartitions")
	TopicPartition[] topicPartitions() default{};
	
	@AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String[] topics() default "str-topic";

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "strContainerFactory";

    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupId() default "";
}
