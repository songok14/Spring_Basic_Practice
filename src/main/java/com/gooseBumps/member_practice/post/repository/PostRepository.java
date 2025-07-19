package com.gooseBumps.member_practice.post.repository;

import com.gooseBumps.member_practice.post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    public Post findByTitle(String Title);
    Page<Post> findAllByDelYn(Pageable pageable, String delYn);
}
