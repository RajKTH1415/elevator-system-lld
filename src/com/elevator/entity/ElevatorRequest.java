package com.elevator.entity;

import com.elevator.enums.Direction;
import com.elevator.enums.RequestType;

public class ElevatorRequest {

    private int sourceFloor;
    private int destinationFloor;
    private Direction direction;
    private RequestType requestType;

    public ElevatorRequest(
            int sourceFloor,
            int destinationFloor,
            Direction direction,
            RequestType requestType) {

        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
        this.direction = direction;
        this.requestType = requestType;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public RequestType getRequestType() {
        return requestType;
    }
}