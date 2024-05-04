package repository;

import dto.Producer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProducerRepository {
    public static Map<String, Producer> getProducerMap() {
        return producerMap;
    }

    public ProducerRepository() {
        producerMap=new ConcurrentHashMap<>();
    }

    public static Map<String, Producer> producerMap;
}
