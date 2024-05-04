package repository;

import dto.Topic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TopicRepository {
    public static Map<String, Topic> getTopicMap() {
        return topicMap;
    }

    public TopicRepository() {
        topicMap=new ConcurrentHashMap<>();
    }

    public static Map<String, Topic> topicMap;
}
