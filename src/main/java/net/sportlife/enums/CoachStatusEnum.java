package net.sportlife.enums;

import org.springframework.ui.Model;

public enum CoachStatusEnum {

    AVAILABLE("AVAILABLE"),
    BUSY("BUSY"),
    ABSENT("OUT_OF_WORK");

    private String paramName;

    CoachStatusEnum(String paramName) { this.paramName = paramName; }

    public String getParamName() {
        return paramName;
    }

    private Model model;
}
