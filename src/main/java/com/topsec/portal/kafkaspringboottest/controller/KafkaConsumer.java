package com.topsec.portal.kafkaspringboottest.controller;

import com.topsec.portal.kafkaspringboottest.Tasks;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * kafka消费者
 *
 * @author 有梦想的肥宅
 * @date 2021/10/29
 */
@Component
public class KafkaConsumer {

    //kafka的监听器，topic为"zhTest"，消费者组为"zhTestGroup"
    @KafkaListener(topics = "tasks", groupId = "zhTestGroup")
    public void listenZhugeGroup(ConsumerRecord<String, byte[]> record, Acknowledgment ack) {
        SpecificDatumReader<Tasks> reader = new SpecificDatumReader<>(Tasks.getClassSchema());
        Decoder decoder = DecoderFactory.get().binaryDecoder(record.value(), null);
        Tasks tasks;
        try {
            tasks=reader.read(null,decoder);
            System.out.println("taskID:"+tasks.getTaskId()+"\t"
                    +"taskName："+tasks.getTaskName()+"\t"
                    +"URL："+tasks.getDisposalUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}