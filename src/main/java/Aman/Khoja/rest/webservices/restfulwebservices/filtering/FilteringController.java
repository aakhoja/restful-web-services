package Aman.Khoja.rest.webservices.restfulwebservices.filtering;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filter")
    public beanTest filter(){
        return new beanTest("Value 1", "Value 2" , "Value 3");
    }

    @GetMapping("/filter-list")
    public List<beanTest> filterList(){
        return Arrays.asList(new beanTest("Value 1", "Value 2" , "Value 3"),
                new beanTest("Value 4", "Value 5" , "Value 6"),
                new beanTest("Value 7", "Value 8" , "Value 9"));
    }
}
