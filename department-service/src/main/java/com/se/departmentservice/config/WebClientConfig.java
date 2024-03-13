package com.se.departmentservice.config;

import com.se.departmentservice.client.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
    @Autowired
    private LoadBalancedExchangeFilterFunction exchangeFilterFunction;
    @Bean
    public WebClient employeeWebClient() {
        return WebClient
                .builder()
                .baseUrl("http://employee-service")
                .filter(exchangeFilterFunction)
                .build();
    }

    @Bean
    public EmployeeClient employeeClient() {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(employeeWebClient()))
                .build();

        return factory.createClient(EmployeeClient.class);
    }
}
