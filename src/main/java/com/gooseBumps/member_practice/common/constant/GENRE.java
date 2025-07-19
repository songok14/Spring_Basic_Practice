package com.gooseBumps.member_practice.common.constant;

public enum GENRE {
    POP("G001", "팝"),
    RNB("G002", "알앤비"),
    DANCE("G003", "댄스"),
    RAP("G004", "랩"),
    HIPHOP("G005", "힙합"),
    SOUL("G006", "소울");

    private String code;
    private String name;

    GENRE(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }
}
