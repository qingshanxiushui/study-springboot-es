package org.example.yqs.configuration;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import org.example.yqs.configuration.properties.EsProperties;

import java.time.Duration;

@Slf4j
@Configuration
@EnableElasticsearchRepositories(basePackages="com.neusoft.nriht.term.repository.es")
@EnableConfigurationProperties(EsProperties.class)
public class EsConfiguration extends AbstractElasticsearchConfiguration {

    @Autowired
    private EsProperties properties;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(properties.getHosts())
                .withBasicAuth(properties.getAccount(), properties.getPassword())
                .withConnectTimeout(Duration.ofSeconds(3))
                .withSocketTimeout(Duration.ofSeconds(300))
                .build();
        log.info("[Elasticsearch配置]初始化成功!!");
        return RestClients.create(clientConfiguration).rest();
    }
}
