package com.ssafy.trippy.Repository;

import com.ssafy.trippy.Domain.LikePost;
import com.ssafy.trippy.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikePostRepository extends JpaRepository<LikePost, Long> {
    List<LikePost> findAllLikePostByMember(Member member);
    Optional<LikePost> findByMember(Member member);


}