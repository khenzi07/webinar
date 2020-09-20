package com.acn.demo.webinar.providedservice;

import com.acn.demo.webinar.model.Post;
import com.acn.demo.webinar.model.PostModel;
import com.acn.demo.webinar.persistence.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List getPosts() {
        List posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);

        List postList = new ArrayList<>();
        for (Object postModel : posts) {
            Post post = new Post();
            BeanUtils.copyProperties(postModel, post);
            postList.add(post);
        }
        return postList;
    }

    public Post getPost(Integer id) {
        Optional post = postRepository.findById(id);
        Post postData = new Post();
        BeanUtils.copyProperties(post.get(), postData);
        return postData;
    }

    public List<Post> getPostByUserId(Integer id) {
        List<PostModel> posts  = postRepository.findByUserId(id);
        List postList = new ArrayList<>();
        for (Object postModel : posts) {
            Post post = new Post();
            BeanUtils.copyProperties(postModel, post);
            postList.add(post);
        }
        return postList;
    }

    public Post createPost(final Post post) {
        PostModel postModel = new PostModel();
        BeanUtils.copyProperties(post, postModel);
        postModel = postRepository.save(postModel);
        Post postData = new Post();
        BeanUtils.copyProperties(postModel, postData);
        return postData;
    }

    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }
}
