package com.emorales.spring.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "kafkaConnectivity")
public class KafkaConnectivityEndpoint {

    @Autowired
    private KafkaConnectivityService kafkaConnectivityService;

    @ReadOperation
    public ConnectivityStatus checkConnectivity() {
        boolean isConnected = kafkaConnectivityService.checkConnectivity();
        return new ConnectivityStatus(isConnected ? "UP" : "DOWN");
    }

    public static class ConnectivityStatus {
        private String status;

        public ConnectivityStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
