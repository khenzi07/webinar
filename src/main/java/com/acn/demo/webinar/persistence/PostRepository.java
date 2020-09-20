package com.acn.demo.webinar.persistence;

import com.acn.demo.webinar.model.PostModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<PostModel, Integer> {

    List<PostModel> findByUserId(Integer userId);
}
