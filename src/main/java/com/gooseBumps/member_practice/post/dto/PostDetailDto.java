package com.gooseBumps.member_practice.post.dto;

import com.gooseBumps.member_practice.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PostDetailDto {
    private Long postSeq;
    private String title;
    private String contents;
    private String nickName;
    private String email;

    public static PostDetailDto fromEntity(Post post){
        return PostDetailDto.builder()
                .postSeq(post.getPostSeq())
                .title(post.getTitle())
                .contents(post.getContents())
                .nickName(post.getMember().getNickName())
                .email(post.getMember().getEmail())
                .build();
    }
}
