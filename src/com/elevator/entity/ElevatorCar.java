package com.elevator.entity;

import com.elevator.enums.Direction;
import com.elevator.enums.ElevatorState;

import java.util.Collections;
import java.util.PriorityQueue;

public class ElevatorCar {

    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;

    private PriorityQueue<Integer> upStops;
    private PriorityQueue<Integer> downStops;

    public ElevatorCar(int id) {

        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;

        upStops = new PriorityQueue<>();
        downStops = new PriorityQueue<>(Collections.reverseOrder());
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getState() {
        return state;
    }

    public void addRequest(int floor) {

        if (floor > currentFloor) {
            upStops.offer(floor);
        } else if (floor < currentFloor) {
            downStops.offer(floor);
        }

        if (direction == Direction.IDLE) {
            direction = floor > currentFloor
                    ? Direction.UP
                    : Direction.DOWN;
        }
    }

    public void move() {

        if (direction == Direction.UP) {
            moveUp();
        } else if (direction == Direction.DOWN) {
            moveDown();
        } else {
            System.out.println("Elevator " + id + " is idle.");
        }
    }

    private void moveUp() {

        state = ElevatorState.MOVING;

        while (!upStops.isEmpty()) {

            int destination = upStops.poll();

            while (currentFloor < destination) {
                currentFloor++;
                System.out.println(
                        "Elevator "
                                + id
                                + " moving UP -> Floor "
                                + currentFloor);
            }

            stop(destination);
        }

        if (!downStops.isEmpty()) {
            direction = Direction.DOWN;
            moveDown();
        } else {
            direction = Direction.IDLE;
            state = ElevatorState.IDLE;
        }
    }

    private void moveDown() {

        state = ElevatorState.MOVING;

        while (!downStops.isEmpty()) {

            int destination = downStops.poll();

            while (currentFloor > destination) {
                currentFloor--;
                System.out.println(
                        "Elevator "
                                + id
                                + " moving DOWN -> Floor "
                                + currentFloor);
            }

            stop(destination);
        }

        if (!upStops.isEmpty()) {
            direction = Direction.UP;
            moveUp();
        } else {
            direction = Direction.IDLE;
            state = ElevatorState.IDLE;
        }
    }

    private void stop(int floor) {

        state = ElevatorState.STOPPED;

        System.out.println(
                "Elevator "
                        + id
                        + " stopped at floor "
                        + floor);

        state = ElevatorState.MOVING;
    }
}