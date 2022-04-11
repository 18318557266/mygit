package com.jinqiancao.order.rocketmq.base.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author jinqiancao
 * @date 2022/1/12 12:27
 */
public class SyncProducer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer=new DefaultMQProducer("group1");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        for(int i=0;i<1;i++){
            Message message = new Message("base","tag",("消息"+i).getBytes(StandardCharsets.UTF_8));
            SendResult result = producer.send(message);
            System.out.println(result);

            TimeUnit.SECONDS.sleep(1);

        }
    }
}
