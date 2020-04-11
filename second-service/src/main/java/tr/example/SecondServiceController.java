package tr.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.example.data.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/second-service")
public class SecondServiceController {
    Logger logger = LogManager.getLogger(SecondServiceController.class);
    @Autowired
    IFirstService service;

    @GetMapping("/getVal")
    public String getVal(){
        return "1";
    }

    @GetMapping("/getUser/{id}")
    public EntityModel<User> getUserById(@PathVariable("id") Integer id){
        User user = new User(id, "Muzaffer", "555");
        EntityModel<User> model = new EntityModel<>(user);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder
                .linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUser());
        model.add(linkBuilder.withRel("all-users"));
        return model;
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return new ArrayList<>();
    }


    @GetMapping("/getValFirstService")
    public String getValFirstService(){
        logger.info("First Service ");
        return service.getVal();
    }
}
