package com.acn.demo.webinar.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostModel, Integer> {

    List<PostModel> findByUserId(Integer userId);
}
