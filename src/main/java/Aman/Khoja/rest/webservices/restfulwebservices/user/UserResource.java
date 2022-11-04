package Aman.Khoja.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }


    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retriveUser(@PathVariable int id){
        return service.findOne(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        service.save(user);

        return ResponseEntity.created(null).build();
    }
}
