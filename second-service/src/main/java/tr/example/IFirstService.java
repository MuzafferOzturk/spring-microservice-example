package tr.example;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "first-service", url = "localhost:8080")
//@FeignClient(name = "first-service")
@FeignClient(name = "zuul-gateway-server")
@RibbonClient(name = "first-service")
public interface IFirstService {
//    @GetMapping("/first-service/getVal")
    @GetMapping("first-service/first-service/getVal")
    String getVal();
}
