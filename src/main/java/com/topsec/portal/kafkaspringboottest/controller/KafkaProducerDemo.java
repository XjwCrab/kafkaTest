package com.topsec.portal.kafkaspringboottest.controller;

import com.topsec.portal.kafkaspringboottest.Tasks;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.kafka.clients.producer.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author joy
 */
public class KafkaProducerDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Map<String, Object> configs = new HashMap<>();
        // 设置连接Kafka的初始连接用到的服务器地址
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://192.168.124.128:9092");
        // 设置key的序列化类
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        // 设置value的序列化类
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArraySerializer");
        configs.put(ProducerConfig.ACKS_CONFIG,"all");
        KafkaProducer<String,byte[]> producer=new KafkaProducer<String, byte[]>(configs);
        //发送100条消息
        for (int i = 0; i < 100; i++) {
             Tasks tasks=Tasks.newBuilder()
                     .setTaskId(i+1+"")
                     .setTaskName("订单: "+(i+1)+" iphone 13 pro 256G")
                     .setDisposalUrl("http://")
                     .setTaskFrom("xiejiaweiTest")
                     .setTaskContent("content")
                     .setTaskType("type")
                     .setStatus("status")
                     .setServiceState("serviceStatus")
                     .setMessageState("mess")
                     .setTime("2022")
                     .setUnit("unit")
                     .setPromoter("pro")
                     .setHandler("handle")
                     .setHandlerUnit("handleunit")

                     .build();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(out, (BinaryEncoder)null);
            SpecificDatumWriter writer = new SpecificDatumWriter(tasks.getSchema());
            try {
                writer.write(tasks, encoder);
                encoder.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
           ProducerRecord<String,byte[]> record=new ProducerRecord<>(
                   "tasks",
                   0,
                   tasks.getTaskId().toString(),
                   out.toByteArray());
            //发送消息
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                      if (exception==null){
                          System.out.println("消息的主题："+metadata.topic());
                          System.out.println("消息的分区："+metadata.partition());
                          System.out.println("消息的偏移量："+metadata.offset());
                      }else {
                          System.out.println("发送消息异常");
                      }
                }
            });
        }
        // 关闭生产者
        producer.close();
    }
}
