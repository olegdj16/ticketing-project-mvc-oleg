package net.endeffect.enums;

public enum Gender {

    MALE("Male"), FEMALE("Female"), STATUS("In Progress");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
