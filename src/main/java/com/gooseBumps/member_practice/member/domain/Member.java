package com.gooseBumps.member_practice.member.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberSeq;

    private String roleCode;
    @Column(unique = true, nullable = false)
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

    public Member(String roleCode, String email, String password, String name, String telNo, int age, String nationallity, String tierCode, String ynDel, String nickName){
        this.roleCode = roleCode;
        this.email = email;
        this.password = password;
        this.name = name;
        this.telNo = telNo;
        this.age = age;
        this.nationallity = nationallity;
        this.tierCode = tierCode;
        this.ynDel = ynDel;
        this.nickName = nickName;
    }

    public void updateMessage(String statusMessage){
        this.statusMessage = statusMessage;
    }
}
