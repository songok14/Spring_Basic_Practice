package com.gooseBumps.member_practice.common.constant;

public enum TIER {
    GEN("TOO1", "일반"),
    GREEN("TOO2", "GREEN"),
    SILVER("TOO3", "SILVER"),
    GOLD("TOO4", "GOLD"),
    VIP("T005", "VIP"),
    MVIP("T006", "MVIP");

    private String code;
    private String name;

    TIER(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

}
