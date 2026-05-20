package com.elevator.scheduler;



import com.elevator.entity.ElevatorCar;
import com.elevator.entity.ElevatorRequest;

import java.util.List;

public interface SchedulingStrategy {

    ElevatorCar selectElevator(
            List<ElevatorCar> elevators,
            ElevatorRequest request);
}