package com.gooseBumps.member_practice.member.dto;

import com.gooseBumps.member_practice.common.constant.ROLE;
import com.gooseBumps.member_practice.member.domain.Member;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MemberCreateDto {
    private String roleCode = "R003";
    @NotEmpty(message = "이메일을 입력해 주세요.")
    private String email;
    @NotEmpty(message = "비밀번호를 입력해 주세요.")
    @Size(min = 8, message = "비밀번호가 너무 짧습니다.")
    private String password;
    @NotEmpty(message = "이름을 입력해 주세요.")
    private String name;
    @NotEmpty(message = "휴대폰 번호를 입력해 주세요.")
    private String telNo;
    private int age;
    private String nationallity;
    private String tierCode;
    private String ynDel;
    private String nickName;

    public Member memberToEntity() {
        return Member.builder()
                .roleCode(this.roleCode)
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .telNo(this.telNo)
                .age(this.age)
                .nationallity(this.nationallity)
                .tierCode(this.tierCode)
                .ynDel("N")
                .nickName(this.nickName)
                .build();
    }
}
