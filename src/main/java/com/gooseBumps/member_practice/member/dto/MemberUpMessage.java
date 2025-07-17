package com.gooseBumps.member_practice.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberUpMessage {
    private String email;
    private String statusMessage;

}
