package com.gooseBumps.member_practice.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostUpdateContents {
    private Long postSeq;
    private String contents;
}
