package Aman.Khoja.rest.webservices.restfulwebservices.helloWorld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//RestAPI
@RestController
public class HelloWorldController {

    //  URL - http://localhost:8080/hello-world

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWordPathVariable(@PathVariable String name){
        return new HelloWorldBean("This is from path variable : HELLO WORLD " + name);
    }
}
