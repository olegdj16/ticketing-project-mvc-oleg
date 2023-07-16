package net.endeffect.enums;

public enum Status {

    OPEN("Open"), IN_PROGRESS("In Progress"), COMPLETE("Completed");

    private final String value;

    private Status(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }
}
