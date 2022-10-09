package org.example.yqs.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "elasticsearch")
public class EsProperties {
    private String hosts;

    private String account;

    private String password;
}
