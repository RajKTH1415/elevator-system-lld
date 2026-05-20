import com.elevator.controller.ElevatorSystemController;
import com.elevator.enums.Direction;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== Elevator-system-lld =====");

        ElevatorSystemController system =
                new ElevatorSystemController(3);

        system.requestElevator(
                0,
                5,
                Direction.UP);

        system.requestElevator(
                3,
                1,
                Direction.DOWN);

        system.requestElevator(
                2,
                8,
                Direction.UP);

    }
}