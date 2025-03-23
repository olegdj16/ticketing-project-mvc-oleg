package net.endeffect.enums;

public enum Status {

    OPEN("Open"),IN_PROGRESS("In Progress"),COMPLETED("Completed"),ON_HOLD("On Hold"),CANCELLED("Cancelled");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
