package com.gooseBumps.member_practice.member.dto;

import com.gooseBumps.member_practice.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class MemberListDto {
    private String roleCode;
    private String email;
    private String password;
    private String name;
    private String telNo;
    private int age;
    private String nationallity;
    private String tierCode;
    private String ynDel;
    private String nickName;

    public static MemberListDto fromEntity(Member member) {
        return new MemberListDto(member.getRoleCode(), member.getEmail(), member.getPassword(), member.getName(),
                member.getTelNo(), member.getAge(), member.getNationallity(), member.getTierCode(), member.getYnDel(), member.getNickName());
    }
}
