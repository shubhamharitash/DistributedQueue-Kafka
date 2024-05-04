package service;

import dto.Consumer;
import dto.Topic;
import repository.ConsumerRepository;
import repository.TopicRepository;

public class TopicService {
    public void createTopic(String topicId){
        Topic topic=new Topic(topicId);
        TopicRepository.getTopicMap().put(topicId,topic);
    }
}
