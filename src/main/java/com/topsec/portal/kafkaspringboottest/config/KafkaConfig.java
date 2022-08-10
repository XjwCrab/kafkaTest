package com.topsec.portal.kafkaspringboottest.config;

import com.topsec.portal.kafkaspringboottest.Tasks;
import com.topsec.portal.kafkaspringboottest.controller.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.springframework.stereotype.Component;

//
//import com.topsec.portal.kafkaspringboottest.Tasks;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.ByteArrayDeserializer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author zzx
// * @creat 2020-03-11-20:23
// */
//@Configuration
public class KafkaConfig {
//
//    @Autowired
//    private KafkaProperties kafkaProperties;
//
//    @Bean
//    public ConsumerFactory<String, Object> consumerFactory() {
////        final JsonDeserializer<Object> jsonDeserializer = new JsonDeserializer<>();
////        jsonDeserializer.addTrustedPackages("*");
//        return new DefaultKafkaConsumerFactory<>(
//                kafkaProperties.buildConsumerProperties(), new StringDeserializer(), new AvroDeserializer(Tasks.class)
//        );
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String bootstrapServers;
//
//    @Value("${spring.kafka.producer.max-request-size}")
//    private String maxRequestSize;
//
//    @Bean
//    public Map<String, Object> avroProducerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, maxRequestSize);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, AvroSerializer.class);
//        return props;
//    }
//
//    @Bean
//    public ProducerFactory<String, Tasks> elProducerFactory() {
//        return new DefaultKafkaProducerFactory<>(avroProducerConfigs());
//    }
//
//    @Bean
//    public KafkaTemplate<String, Tasks> elKafkaTemplate() {
//        return new KafkaTemplate<>(elProducerFactory());
//    }
//
//
//
//
//    @Bean
//    public Map<String, Object> consumerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
////        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AvroDeserializer.class);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "avro");
//
//
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
//        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
//        return props;
//    }
//
//    @Bean
//    public ConsumerFactory<String, Tasks> consumerFactory() {
//            return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
//                    new AvroDeserializer<>(Tasks.class));
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Tasks> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, Tasks> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//
//        return factory;
//    }
//
}