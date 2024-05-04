
import service.ConsumerService;
import service.InMemoryService;
import service.ProducerService;
import service.TopicService;

public class Application {
    public static void main(String[] args) {

        InMemoryService inMemoryService=new InMemoryService();

        TopicService topicService=new TopicService();
        topicService.createTopic("topic1");
        topicService.createTopic("topic2");


        ConsumerService consumerService=new ConsumerService();

        consumerService.createConsumer("consumer1");
        consumerService.createConsumer("consumer2");
        consumerService.createConsumer("consumer3");
        consumerService.createConsumer("consumer4");
        consumerService.createConsumer("consumer5");

        consumerService.subscribeToTopic("consumer1","topic1");
        consumerService.subscribeToTopic("consumer2","topic1");
        consumerService.subscribeToTopic("consumer3","topic1");
        consumerService.subscribeToTopic("consumer4","topic1");
        consumerService.subscribeToTopic("consumer5","topic1");

        consumerService.subscribeToTopic("consumer1","topic2");
        consumerService.subscribeToTopic("consumer3","topic2");
        consumerService.subscribeToTopic("consumer4","topic2");

        ProducerService producerService=new ProducerService();

        producerService.createProducer("producer1");
        producerService.createProducer("producer2");

        producerService.publish("producer1","message1","topic1");
        producerService.publish("producer1","message2","topic1");
        producerService.publish("producer1","message4","topic2");
        producerService.publish("producer2","message3","topic1");
        producerService.publish("producer2","message5","topic2");



        Runnable job=()->{
            consumerService.pullMessages();
        };

        Thread t1=new Thread(job);
        t1.start();

        producerService.publish("producer2","shubham","topic2");

        producerService.publish("producer2","aman","topic2");

    }
}
