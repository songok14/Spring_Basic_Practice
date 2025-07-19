package com.gooseBumps.member_practice.post.dto;

import com.gooseBumps.member_practice.member.domain.Member;
import com.gooseBumps.member_practice.post.domain.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostCreateDto {
    private String postCode = "P003";
    private String title;
    private String contents;
    private Long memberSeq;

    public Post toEntity(Member member) {
        return Post.builder()
                .postCode(this.postCode)
                .title(this.title)
                .contents(this.contents)
                .member(member)
                .build();
    }
}
