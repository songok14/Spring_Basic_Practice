package com.gooseBumps.member_practice.post.domain;

import com.gooseBumps.member_practice.common.DateTimeEntity;
import com.gooseBumps.member_practice.common.PostTypeConverter;
import com.gooseBumps.member_practice.common.constant.PostType;
import com.gooseBumps.member_practice.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Builder
public class Post extends DateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postSeq;
    @Convert(converter = PostTypeConverter.class)
    private PostType postCode;
    private String title;
    private String contents;
    @Builder.Default
    private String delYn = "N";
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_seq")
    private Member member;

    public void updateContents(String contents){
        this.contents = contents;
    }
}
