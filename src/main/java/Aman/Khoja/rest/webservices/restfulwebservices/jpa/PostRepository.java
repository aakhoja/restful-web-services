package Aman.Khoja.rest.webservices.restfulwebservices.jpa;

import Aman.Khoja.rest.webservices.restfulwebservices.user.Post;
import Aman.Khoja.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
