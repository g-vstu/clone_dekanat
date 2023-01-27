package com.company.postgre;

import javax.persistence.Embeddable;

@Embeddable
public class FullName {
    private String surname;
    private String name;
    private String patronymic;
}
