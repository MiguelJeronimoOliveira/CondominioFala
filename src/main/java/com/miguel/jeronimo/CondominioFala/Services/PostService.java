package com.miguel.jeronimo.CondominioFala.Services;


import com.miguel.jeronimo.CondominioFala.DTOS.PostRequest;
import com.miguel.jeronimo.CondominioFala.Entities.Post;
import com.miguel.jeronimo.CondominioFala.Repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public void createPost(PostRequest request) {
        Post post = new Post();
        post = post.postDTO(request);
        repository.save(post);
    }

    public List<Post> getAllPosts(){
        return repository.findAllPosts();
    }

    public Optional<Post> findById(Long id) {
        Optional<Post> post = repository.findById(id);
        return post;
    }

    public void deletePost(Long id){
        Optional<Post> postOptional = repository.findById(id);

        if(postOptional.isPresent()){
            Post post = postOptional.get();

            post.setDeleted(true);
            repository.save(post);
        }

    }

    public void likePost(Long id){
        Post post = repository.findById(id).get();

        if(post != null){
            post.setLikes(post.getLikes() + 1);
            repository.save(post);
        }
    }

    public void dislikePost(Long id){
        Post post = repository.findById(id).get();

        if(post != null){
            post.setDislikes(post.getDislikes() + 1);
            repository.save(post);
        }
    }

    public void reportPost(Long id){
        Post post = repository.findById(id).get();

        if(post != null){
            post.setReports(post.getReports() + 1);
            repository.save(post);
        }
    }

}
