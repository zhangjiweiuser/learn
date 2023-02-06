package learn.rabbitmq;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Consumer {
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "127.0.0.1";
    private static final int PORT = 5672;
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        Address[] addresses = new Address[]{
                new Address(IP_ADDRESS,PORT)
        };
        Connection connection = factory.newConnection(addresses);
        Channel channel = connection.createChannel();
        channel.basicQos(64);
        com.rabbitmq.client.Consumer rabbitConsumer = new DefaultConsumer(channel){
            @SneakyThrows
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("recv message:"+new String(body));
                TimeUnit.SECONDS.sleep(1);
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(QUEUE_NAME,rabbitConsumer);
        TimeUnit.SECONDS.sleep(3);
        channel.close();
        connection.close();
    }
}
