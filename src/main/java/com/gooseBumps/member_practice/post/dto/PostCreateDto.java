package com.gooseBumps.member_practice.post.dto;

import com.gooseBumps.member_practice.common.constant.POST;
import com.gooseBumps.member_practice.common.constant.ROLE;
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
    private POST postCode = POST.QNA;
    private String title;
    private String contents;
    private Long memberSeq;

    public Post toEntity(Member member) {
        return Post.builder()
                .postCode(this.postCode.getCode())
                .title(this.title)
                .contents(this.contents)
                .member(member)
                .build();
    }
}
