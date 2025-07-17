package com.gooseBumps.member_practice.member.dto;

import com.gooseBumps.member_practice.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberCreateDto {
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

    public Member memberToEntity() {
        return new Member(this.roleCode, this.email, this.password, this.name, this.telNo, this.age,
                this.nationallity, this.tierCode, this.ynDel, this.nickName);
    }
}
