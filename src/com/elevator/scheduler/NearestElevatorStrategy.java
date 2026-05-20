package com.elevator.scheduler;




import com.elevator.entity.ElevatorCar;
import com.elevator.entity.ElevatorRequest;
import com.elevator.enums.Direction;
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

            // Prefer IDLE elevators first
            if (elevator.getDirection() == Direction.IDLE) {

                int distance = Math.abs(
                        elevator.getCurrentFloor()
                                - request.getSourceFloor());

                if (distance < minDistance) {

                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }

        // fallback if no idle elevator
        if (bestElevator == null) {

            for (ElevatorCar elevator : elevators) {

                int distance = Math.abs(
                        elevator.getCurrentFloor()
                                - request.getSourceFloor());

                if (distance < minDistance) {

                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }

        return bestElevator;
    }
}
