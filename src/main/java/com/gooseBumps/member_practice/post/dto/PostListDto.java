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
public class PostListDto {
    private Long postSeq;
    private String title;
    private String nickName;

    public static PostListDto fromEntity(Post post) {
        return PostListDto.builder()
                .postSeq(post.getPostSeq())
                .title(post.getTitle())
                .nickName(post.getMember().getNickName())
                .build();
    }
}
