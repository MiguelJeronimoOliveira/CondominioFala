package com.miguel.jeronimo.CondominioFala.Repositories;

import com.miguel.jeronimo.CondominioFala.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.deleted = false")
    List<Post> findAllPosts();

}
