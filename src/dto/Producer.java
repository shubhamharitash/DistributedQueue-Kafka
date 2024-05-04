package dto;

import java.util.ArrayList;
import java.util.List;

public class Producer {
    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public Producer(String producerId) {
        this.producerId=producerId;
        producerIdList=new ArrayList<>();
    }

    String producerId;
    List<String> producerIdList;

}
