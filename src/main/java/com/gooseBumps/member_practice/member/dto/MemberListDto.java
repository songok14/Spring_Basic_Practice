package com.gooseBumps.member_practice.member.dto;

import com.gooseBumps.member_practice.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MemberListDto {
    private Long memberSeq;
    private String roleCode;
    private String email;
    private String name;
    private String telNo;
    private int age;
    private String nationallity;
    private String tierCode;
    private String nickName;

    public static MemberListDto fromEntity(Member member) {
        return MemberListDto.builder()
                .memberSeq(member.getMemberSeq())
                .roleCode(member.getRoleCode())
                .email(member.getEmail())
                .name(member.getName())
                .telNo(member.getTelNo())
                .age(member.getAge())
                .nationallity(member.getNationallity())
                .tierCode(member.getTierCode())
                .nickName(member.getNickName())
                .build();
    }
}
