package com.gooseBumps.member_practice.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PostType {

    NOTIFICATION("P001", "공지사항"),
    FAQ("P002", "자주묻는질문"),
    QNA("P003", "1:1문의");

    private final String codeValue;
    private final String codeName;

    public static PostType fromCode(String code) {
        return Arrays.stream(values())
                .filter(v -> v.codeValue.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown PostType code: " + code));
    }
}
