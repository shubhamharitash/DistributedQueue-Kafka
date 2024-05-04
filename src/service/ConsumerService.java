package service;

import dto.Consumer;
import dto.Topic;
import repository.ConsumerRepository;
import repository.TopicRepository;

import java.util.List;
import java.util.Map;

public class ConsumerService {

    Map<String,Consumer> consumerMap= ConsumerRepository.getConsumerMap();

    public Consumer createConsumer(String consumerId){
        Consumer consumer=new Consumer(consumerId);
        ConsumerRepository.getConsumerMap().put(consumerId,consumer);
        return consumer;
    }

    public void consumer(String consumerId){

        List<String> topicIdList =consumerMap.get(consumerId).getTopicIdList();

        for (String topicId:topicIdList
             ) {
            int currOffset=TopicRepository.getTopicMap().get(topicId).getConsumerOffset().get(consumerId);
            if (currOffset>TopicRepository.getTopicMap().get(topicId).getMessage().size()-1){
                continue;
            }
            String message=TopicRepository.getTopicMap().get(topicId).getMessage().
                    get(currOffset);
            TopicRepository.getTopicMap().get(topicId).getConsumerOffset().put(consumerId,currOffset+1);

            System.out.println(consumerId+" received "+message);

        }

    }

    public void subscribeToTopic(String consumerId,String topicId){

        TopicRepository.getTopicMap().get(topicId).getConsumerList().add(consumerId);
        TopicRepository.getTopicMap().get(topicId).getConsumerOffset().put(consumerId,0);
        ConsumerRepository.getConsumerMap().get(consumerId).getTopicIdList().add(topicId);

    }

    public void pullMessages(){
        while (true){
            consumerMap.keySet().forEach(consumerID->consumer(consumerID));
        }
    }
}
