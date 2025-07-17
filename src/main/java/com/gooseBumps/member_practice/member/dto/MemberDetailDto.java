package com.gooseBumps.member_practice.member.dto;

import com.gooseBumps.member_practice.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class MemberDetailDto {
    private Long memberSeq;
    private String roleCode;
    private String email;
    private String password;
    private String name;
    private String telNo;
    private int age;
    private String nationallity;
    private String tierCode;
    private String ynDel;
    private String statusMessage;
    private String nickName;
    private String ticketCode;
    private String paymentTypeCode;
    private String paymentMethodCode;

    public static MemberDetailDto fromEntity(Member member) {
        return new MemberDetailDto(member.getMemberSeq(), member.getRoleCode(), member.getEmail(), member.getPassword(),
                member.getName(), member.getTelNo(), member.getAge(), member.getNationallity(), member.getTierCode(),
                member.getYnDel(), member.getStatusMessage(), member.getNickName(), member.getTicketCode(), member.getPaymentTypeCode(), member.getPaymentMethodCode());
    }
}
