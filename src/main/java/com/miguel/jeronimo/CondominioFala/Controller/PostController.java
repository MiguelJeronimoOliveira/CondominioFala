package com.miguel.jeronimo.CondominioFala.Controller;


import com.miguel.jeronimo.CondominioFala.DTOS.PostRequest;
import com.miguel.jeronimo.CondominioFala.Entities.Post;
import com.miguel.jeronimo.CondominioFala.Services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity allPost(){
        List<Post> posts = service.getAllPosts();
        return new ResponseEntity(posts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostRequest request) {
        service.createPost(request);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable Long id){
        Optional<Post> post = service.findById(id);
        if(post.isPresent()){
            service.deletePost(id);
            return ResponseEntity.ok("Post Deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/like/{id}")
    public ResponseEntity likePost(@PathVariable Long id){
        Optional<Post> post = service.findById(id);

        if(post.isPresent()){
            service.likePost(id);
            return ResponseEntity.ok("Post Liked");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/dislike/{id}")
    public ResponseEntity dislikePost(@PathVariable Long id){
        Optional<Post> post = service.findById(id);

        if(post.isPresent()){
            service.dislikePost(id);
            return ResponseEntity.ok("Post Disliked");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/report/{id}")
    public ResponseEntity reportPost(@PathVariable Long id){
        Optional<Post> post = service.findById(id);

        if(post.isPresent()){
            service.reportPost(id);

            if(post.get().getReports() >= 3){
                service.deletePost(id);
                return ResponseEntity.ok("Post Deleted");
            }

            return ResponseEntity.ok("Post Reported");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
