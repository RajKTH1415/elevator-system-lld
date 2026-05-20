package com.elevator.scheduler;



import com.elevator.entity.ElevatorCar;
import com.elevator.entity.ElevatorRequest;
import com.elevator.enums.RequestType;

import java.util.List;

public class ElevatorScheduler {

    private RequestType.SchedulingStrategy strategy;

    public ElevatorScheduler(
            RequestType.SchedulingStrategy strategy) {

        this.strategy = strategy;
    }

    public ElevatorCar scheduleElevator(
            List<ElevatorCar> elevators,
            ElevatorRequest request) {

        return strategy.selectElevator(
                elevators,
                request);
    }
}