package Aman.Khoja.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"Aman", LocalDate.now().minusYears(25)));
        users.add(new User(2,"Toby", LocalDate.now().minusYears(30)));
        users.add(new User(3,"Malcom", LocalDate.now().minusYears(42)));

    }

    public List<User> findAll(){
        return users;
    }


}
