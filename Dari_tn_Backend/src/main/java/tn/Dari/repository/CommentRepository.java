package tn.Dari.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.entities.Comment;

@Repository
public interface CommentRepository extends CrudRepository <Comment, Long> {



}