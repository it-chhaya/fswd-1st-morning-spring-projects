package kh.edu.cstad.customer.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpInterfaceWebClientConfig {

    @Bean
    public PlatziFakeStoreClient categoryClient() {

        // Step 1 -> Create web client object
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.escuelajs.co/api/v1")
                .build();

        // Step 2 -> Create HTTP service proxy factory object
        HttpServiceProxyFactory httpFactory = HttpServiceProxyFactory
                .builder()
                .exchangeAdapter(WebClientAdapter.create(webClient))
                .build();

        return httpFactory.createClient(PlatziFakeStoreClient.class);
    }


}
