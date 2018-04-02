package net.sportlife.enums;

public enum CardStatusEnum {

    PREMIUM("PREMIUM"),
    CLASSIC("CLASSIC");

    private String paramName;

    CardStatusEnum(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return paramName;
    }
}
