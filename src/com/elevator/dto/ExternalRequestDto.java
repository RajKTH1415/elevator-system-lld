package com.elevator.dto;



import com.elevator.enums.Direction;

public class ExternalRequestDto {

    private int floor;
    private Direction direction;

    public ExternalRequestDto(
            int floor,
            Direction direction) {

        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}