package com.gooseBumps.member_practice.post.dto;

import com.gooseBumps.member_practice.common.constant.PostType;
import com.gooseBumps.member_practice.member.domain.Member;
import com.gooseBumps.member_practice.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostCreateDto {
    private String postCode = PostType.QNA.getCodeValue();
    private String title;
    private String contents;
    private Long memberSeq;

    public Post toEntity(Member member) {
        return Post.builder()
                .postCode(PostType.fromCode(this.postCode))
                .title(this.title)
                .contents(this.contents)
                .member(member)
                .build();
    }
}
