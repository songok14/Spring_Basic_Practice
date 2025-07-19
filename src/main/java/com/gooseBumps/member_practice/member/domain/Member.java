package com.gooseBumps.member_practice.member.domain;

import com.gooseBumps.member_practice.common.DateTimeEntity;
import com.gooseBumps.member_practice.common.constant.ROLE;
import com.gooseBumps.member_practice.common.constant.TIER;
import com.gooseBumps.member_practice.post.domain.Post;
import jakarta.persistence.*;
import lombok.*;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Builder
public class Member extends DateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberSeq;
    @Builder.Default
    private String roleCode = ROLE.USER.getCode();
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String name;
    private String telNo;
    private int age;
    private String nationallity;
    @Builder.Default
    private String tierCode = TIER.GEN.getCode();
    @Builder.Default
    private String ynDel="N";
    private String statusMessage;
    private String nickName;
    private String ticketCode;
    private String paymentTypeCode;
    private String paymentMethodCode;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    @Builder.Default
    List<Post> postList = new ArrayList<>();
    public void updateMessage(String statusMessage){
        this.statusMessage = statusMessage;
    }
}
