package com.elevator.enums;

import com.elevator.entity.ElevatorCar;
import com.elevator.entity.ElevatorRequest;

import java.util.List;

public  enum RequestType {
    INTERNAL,
    EXTERNAL;

    public static interface SchedulingStrategy {

        ElevatorCar selectElevator(
                List<ElevatorCar> elevators,
                ElevatorRequest request);
    }
}
