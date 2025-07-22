package com.gooseBumps.member_practice.post.service;

import com.gooseBumps.member_practice.member.domain.Member;
import com.gooseBumps.member_practice.member.repogitory.MemberRepository;
import com.gooseBumps.member_practice.post.domain.Post;
import com.gooseBumps.member_practice.post.dto.PostCreateDto;
import com.gooseBumps.member_practice.post.dto.PostDetailDto;
import com.gooseBumps.member_practice.post.dto.PostListDto;
import com.gooseBumps.member_practice.post.dto.PostUpdateContents;
import com.gooseBumps.member_practice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Collectors;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public PostService(PostRepository postRepository, MemberRepository memberRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }


    // 게시글 등록
    public void save(PostCreateDto postCreateDto){
        Member member = memberRepository.findById(postCreateDto.getMemberSeq()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));
        Post post = postRepository.save(postCreateDto.toEntity(member));
    }

    // 게시글 목록 조회
    @Transactional(readOnly = true)
    public Page<PostListDto> findAll(Pageable pageable){
        Page<Post> postList = postRepository.findAllByDelYn(pageable, "N");
        return postList.map(a -> PostListDto.fromEntity(a));
    }

    // 게시글 상세 조회
    @Transactional(readOnly = true)
    public PostDetailDto detail(@PathVariable Long postSeq){
        Post post = postRepository.findById(postSeq).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 번호입니다."));
        return PostDetailDto.fromEntity(post);
    }

    // 게시글 내용 수정
    public void update(@PathVariable PostUpdateContents postUpdateContents){
        Post post = postRepository.findById(postUpdateContents.getPostSeq()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 번호입니다."));
        post.updateContents(postUpdateContents.getContents());
    }

    // 게시글 삭제
    public void delete(@PathVariable Long postSeq){
        Post post = postRepository.findById(postSeq).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 번호입니다."));
        postRepository.delete(post);
    }
}
