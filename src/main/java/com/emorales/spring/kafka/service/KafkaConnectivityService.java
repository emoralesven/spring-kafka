package com.emorales.spring.kafka.service;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeClusterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class KafkaConnectivityService {

    @Autowired
    private AdminClient adminClient;

    public boolean checkConnectivity() {
        try {
            adminClient.listTopics(new ListTopicsOptions().timeoutMs(5000)).names().get();
            return true;
        } catch (InterruptedException | ExecutionException e) {
            return false;
        }
    }
}

