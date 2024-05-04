package service;

import repository.ConsumerRepository;
import repository.ProducerRepository;
import repository.TopicRepository;

public class InMemoryService {
    public InMemoryService() {
        ConsumerRepository consumerRepository=new ConsumerRepository();
        ProducerRepository producerRepository=new ProducerRepository();
        TopicRepository topicRepository=new TopicRepository();
    }
}
