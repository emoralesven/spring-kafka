package com.emorales.spring.kafka.controller;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeClusterResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class KafkaController {

    private final AdminClient adminClient;

    public KafkaController(AdminClient adminClient) {
        this.adminClient = adminClient;
    }

    @GetMapping("/kafka/info")
    public String getKafkaInfo() throws ExecutionException, InterruptedException {
        DescribeClusterResult describeClusterResult = adminClient.describeCluster();
        return "Cluster ID: " + describeClusterResult.clusterId().get() +
                ", Controller: " + describeClusterResult.controller().get();
    }
}

