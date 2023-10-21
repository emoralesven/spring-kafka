package com.emorales.spring.kafka.configuration;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.producer.properties.sasl.mechanism}")
    private String saslMechanism;

    @Value("${spring.kafka.producer.properties.security.protocol}")
    private String securityProtocol;

    @Value("${spring.kafka.producer.properties.sasl.jaas.config}")
    private String saslJaasConfig;

    @Bean
    public AdminClient adminClient() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configs.put("sasl.mechanism", saslMechanism);
        configs.put("security.protocol", securityProtocol);
        configs.put("sasl.jaas.config", saslJaasConfig);

        return AdminClient.create(configs);
    }
}

