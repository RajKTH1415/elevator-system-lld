package com.elevator.scheduler;




import com.elevator.entity.ElevatorCar;
import com.elevator.entity.ElevatorRequest;
import com.elevator.enums.RequestType;

import java.util.List;

public class NearestElevatorStrategy
        implements RequestType.SchedulingStrategy {

    @Override
    public ElevatorCar selectElevator(
            List<ElevatorCar> elevators,
            ElevatorRequest request) {

        ElevatorCar bestElevator = null;

        int minDistance = Integer.MAX_VALUE;

        for (ElevatorCar elevator : elevators) {

            int distance = Math.abs(
                    elevator.getCurrentFloor()
                            - request.getSourceFloor());

            if (distance < minDistance) {
                minDistance = distance;
                bestElevator = elevator;
            }
        }

        return bestElevator;
    }
}
