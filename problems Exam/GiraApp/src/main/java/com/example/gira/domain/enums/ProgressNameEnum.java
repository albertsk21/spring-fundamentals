package com.example.gira.domain.enums;

public enum ProgressNameEnum {
    OPEN, IN_PROGRESS, COMPLETED, OTHER;


    public static ProgressNameEnum getValue(int index){
        return switch (index) {
            case 0 -> OPEN;
            case 1 -> IN_PROGRESS;
            case 2 -> COMPLETED;
            case 3 -> OTHER;
            default -> null;
        };
    }


    public static int indexOf(String name){

        return switch (name) {
            case "OPEN" -> 0;
            case "IN_PROGRESS" -> 1;
            case "COMPLETED" -> 2;
            case "OTHER" -> 3;
            default -> -1;
        };

    }
}
