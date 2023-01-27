package com.company.postgre;

public enum Status {
    ACTIVE("ACTIVE"), NOACTIVE("NOACTIVE"), DELETED("DELETED");

    String status;

    Status(String status) {
        this.status = status;
    }
}
