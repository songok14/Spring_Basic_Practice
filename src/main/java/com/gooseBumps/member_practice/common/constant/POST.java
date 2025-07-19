package com.gooseBumps.member_practice.common.constant;

public enum POST {
    NOTICE("P001", "공지사항"),
    FAQ("P002", "FAQ"),
    QNA("P003", "QNA");

    private String code;
    private String name;

    POST(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

}
