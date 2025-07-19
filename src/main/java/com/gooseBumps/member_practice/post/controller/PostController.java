package com.gooseBumps.member_practice.post.controller;

import com.gooseBumps.member_practice.common.CommonDto;
import com.gooseBumps.member_practice.post.dto.PostCreateDto;
import com.gooseBumps.member_practice.post.dto.PostDetailDto;
import com.gooseBumps.member_practice.post.dto.PostListDto;
import com.gooseBumps.member_practice.post.dto.PostUpdateContents;
import com.gooseBumps.member_practice.post.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시글 등록
    @PostMapping("/create")
    public ResponseEntity<?> save(@Valid @RequestBody PostCreateDto postCreateDto){
        postService.save(postCreateDto);
        return new ResponseEntity<>(new CommonDto("ok", HttpStatus.CREATED.value(), "게시글 등록 완료"), HttpStatus.CREATED);
    }

    // 게시글 목록 조회
    @GetMapping("/list")
    public ResponseEntity<?> list(@PageableDefault(size = 10, page = 0, sort = "postSeq", direction = Sort.Direction.DESC) Pageable pageable){
        Page<PostListDto> postListDtos = postService.findAll(pageable);
        return new ResponseEntity<>(new CommonDto(postListDtos, HttpStatus.OK.value(), "게시물 조회 완료"), HttpStatus.OK);
    }

    // 게시글 상세 조회
    @GetMapping("/detail/{postSeq}")
    public ResponseEntity<?> detail(@PathVariable Long postSeq){
        return new ResponseEntity<>(new CommonDto(postService.detail(postSeq), HttpStatus.OK.value(), "게시물 조회 완료"), HttpStatus.OK);
    }

    // 게시글 내용 수정
    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody PostUpdateContents postUpdateContents){
        postService.update(postUpdateContents);
        return new ResponseEntity<>(new CommonDto("ok", HttpStatus.OK.value(), "게시글 수정 완료"), HttpStatus.OK);
    }

    // 게시글 삭제
    @DeleteMapping("/delete/{postSeq}")
    public ResponseEntity<?> delete(@PathVariable Long postSeq){
        postService.delete(postSeq);
        return new ResponseEntity<>(new CommonDto("ok", HttpStatus.OK.value(), "게시글 삭제 완료"), HttpStatus.OK);
    }
}
