package com.acn.demo.webinar.controller;

import com.acn.demo.webinar.model.Post;
import com.acn.demo.webinar.providedservice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostRC {

    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        List < Post > posts = postService.getPosts();
        return new ResponseEntity < >(posts, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Post> getPost(@PathVariable Integer id) {
        Post post = postService.getPost(id);
        return new ResponseEntity < >(post, HttpStatus.OK);
    }

    @GetMapping(params  = "userId")
    public ResponseEntity <List<Post>> getPostByUserId(@RequestParam Integer userId){
        List<Post> postList = postService.getPostByUserId(userId);
        return new ResponseEntity < >(postList, HttpStatus.OK);
    }

    @GetMapping(params  = "/{id}/comments")
    public ResponseEntity <List<Post>> getPostComments(@PathVariable Integer id){
        List<Post> postList = postService.getPostComments(id);
        return new ResponseEntity < >(postList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Post> createPosts(@RequestBody Post post) {
        final Post finalPost = postService.createPost(post);
        return new ResponseEntity < >(finalPost, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity < String > deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return new ResponseEntity < >(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable(value = "id") Integer id,
                                                   @RequestBody Post post) {
        try {
            return ResponseEntity.ok(postService.updatePost(id, post));
        } catch (Exception e) {
            return new ResponseEntity < >(null, HttpStatus.BAD_REQUEST);
        }

    }

}
