package com.elevator.controller;

import com.elevator.entity.ElevatorCar;
import com.elevator.entity.ElevatorRequest;
import com.elevator.enums.Direction;
import com.elevator.enums.RequestType;
import com.elevator.scheduler.ElevatorScheduler;
import com.elevator.scheduler.NearestElevatorStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystemController {

    private List<ElevatorController> controllers;
    private ElevatorScheduler scheduler;

    public ElevatorSystemController(
            int numberOfElevators) {

        controllers = new ArrayList<>();

        scheduler = new ElevatorScheduler(
                new NearestElevatorStrategy());

        for (int i = 1; i <= numberOfElevators; i++) {

            controllers.add(
                    new ElevatorController(
                            new ElevatorCar(i)));
        }
    }

    public void requestElevator(
            int sourceFloor,
            int destinationFloor,
            Direction direction) {

        ElevatorRequest request =
                new ElevatorRequest(
                        sourceFloor,
                        destinationFloor,
                        direction,
                        RequestType.EXTERNAL);

        List<ElevatorCar> elevators =
                new ArrayList<>();

        for (ElevatorController controller
                : controllers) {

            elevators.add(
                    controller.getElevatorCar());
        }

        ElevatorCar selected =
                scheduler.scheduleElevator(
                        elevators,
                        request);

        System.out.println(
                "\nRequest assigned to Elevator "
                        + selected.getId());

        for (ElevatorController controller
                : controllers) {

            if (controller.getElevatorCar()
                    .getId() == selected.getId()) {

                controller.submitRequest(
                        sourceFloor);

                controller.submitRequest(
                        destinationFloor);

                controller.controlElevator();
            }
        }
    }
}