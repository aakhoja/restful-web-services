package Aman.Khoja.rest.webservices.restfulwebservices.jpa;

import Aman.Khoja.rest.webservices.restfulwebservices.user.Post;
import Aman.Khoja.rest.webservices.restfulwebservices.user.User;
import Aman.Khoja.rest.webservices.restfulwebservices.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    private UserRepository repository;
    private PostRepository postRepository;

    public UserJpaResource(UserRepository repository, PostRepository postRepository){
        this.postRepository = postRepository;
        this.repository = repository;
    }


    @GetMapping(path = "/jpa/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public EntityModel<User> retriveUser(@PathVariable int id){
        Optional<User> savedUser = repository.findById(id);

        if(savedUser.isEmpty())
            throw new UserNotFoundException("id: " + id);

        EntityModel<User> entityModel = EntityModel.of(savedUser.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @GetMapping(path = "/jpa/users/{id}/posts")
    public List<Post> retreivePostFromUser(@PathVariable int id){

        Optional<User> savedUser = repository.findById(id);

        if(savedUser.isEmpty())
            throw new UserNotFoundException("id: " + id);

        List<Post> userPost = savedUser.get().getPosts();

        return userPost;
    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping(path = "/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){

        Optional<User> savedUser = repository.findById(id);

        if(savedUser.isEmpty())
            throw new UserNotFoundException("id: " + id);

        post.setUser(savedUser.get());

        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @DeleteMapping(path = "/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }
}
