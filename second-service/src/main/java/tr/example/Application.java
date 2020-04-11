package tr.example;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


/**
 * HATEOAS and JsonFilter http://localhost:8081/second-service/getUser/2
 * Swagger Ui http://localhost:8085/swagger-ui.html
 * Swagger doc http://localhost:8085/v2/api-docs
 * Actuator http://localhost:8085/actuator
 * Zipkin http://localhost:9411/zipkin/
 * */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
