package com.elevator.controller;


import com.elevator.entity.ElevatorCar;

public class ElevatorController {

    private ElevatorCar elevatorCar;

    public ElevatorController(
            ElevatorCar elevatorCar) {

        this.elevatorCar = elevatorCar;
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public void submitRequest(int floor) {
        elevatorCar.addRequest(floor);
    }

    public void controlElevator() {
        elevatorCar.move();
    }
}