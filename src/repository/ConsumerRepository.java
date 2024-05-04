package repository;

import dto.Consumer;
import dto.Producer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConsumerRepository {
    public static Map<String, Consumer> getConsumerMap() {
        return consumerMap;
    }

    public ConsumerRepository() {
        consumerMap=new ConcurrentHashMap<>();
    }

    public static Map<String, Consumer> consumerMap;
}
