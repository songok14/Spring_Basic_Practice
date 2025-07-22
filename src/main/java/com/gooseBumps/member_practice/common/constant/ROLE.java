package com.gooseBumps.member_practice.common.constant;

public enum ROLE {
    AMIND("R001", "ADMIN"),
    DISTRIBUTOR("R002", "DISTRIBUTOR"),
    USER("R003", "USER");

    private String code;
    private String name;

    ROLE(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return code;
    }

}
