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
public class MemberDetailDto {
    private Long memberSeq;
    private String roleCode;
    private String email;
    private String name;
    private String telNo;
    private int age;
    private String nationallity;
    private String tierCode;
    private String statusMessage;
    private String nickName;
    private String ticketCode;
    private String paymentTypeCode;
    private String paymentMethodCode;

    public static MemberDetailDto fromEntity(Member member) {
        return MemberDetailDto.builder()
                .memberSeq(member.getMemberSeq())
                .roleCode(member.getRoleCode())
                .email(member.getEmail())
                .name(member.getName())
                .telNo(member.getTelNo())
                .age(member.getAge())
                .nationallity(member.getNationallity())
                .tierCode(member.getTierCode())
                .statusMessage(member.getStatusMessage())
                .nickName(member.getNickName())
                .tierCode(member.getTierCode())
                .paymentTypeCode(member.getPaymentTypeCode())
                .paymentMethodCode(member.getPaymentMethodCode())
                .build();
    }
}
