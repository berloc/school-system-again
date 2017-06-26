package com.codecool.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Place {
    GARAGE("Garage"),
    KITCHENONE("Kitchen1"),
    KITCHENTWO("Kitchen2"),
    MEETINGROOM("Meeting Room"),
    STUFFAREA("Stuff area");

    private String place;

}
