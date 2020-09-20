package com.acn.demo.webinar.persistence;

import com.acn.demo.webinar.model.PostModel;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostModel, Integer> {
}
