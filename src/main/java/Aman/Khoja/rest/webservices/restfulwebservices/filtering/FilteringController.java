package Aman.Khoja.rest.webservices.restfulwebservices.filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filter")
    public MappingJacksonValue filter(){
        beanTest testbean = new beanTest("Value 1", "Value 2" , "Value 3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(testbean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1","value3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("beanTest Filter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filter-list")
    public MappingJacksonValue filterList(){
        List<beanTest> list = Arrays.asList(new beanTest("Value 1", "Value 2" , "Value 3"),
                new beanTest("Value 4", "Value 5" , "Value 6"),
                new beanTest("Value 7", "Value 8" , "Value 9"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value2","value3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("beanTest Filter",filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
