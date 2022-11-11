package Aman.Khoja.rest.webservices.restfulwebservices.jpa;

import Aman.Khoja.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
