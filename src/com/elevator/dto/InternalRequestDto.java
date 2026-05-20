package com.elevator.dto;


public class InternalRequestDto {

    private int destinationFloor;

    public InternalRequestDto(
            int destinationFloor) {

        this.destinationFloor =
                destinationFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}