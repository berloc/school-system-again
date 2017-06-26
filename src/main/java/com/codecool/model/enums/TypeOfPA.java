package com.codecool.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TypeOfPA {

    PYTHONBASICS("Python basics"),
    PYTHONOOP("Python OOP"),
    WEBBASICS("Web basics"),
    JAVABASICS("Java basics"),
    ADVANCEDJAVA("Advanced Java"),
    ALGORITHM("Algorithm"),
    TECHINTERVIEW("Tech interview"),
    TRIALINTERVIEW("Trial interview");

    private String type;

}
