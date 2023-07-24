 import java.util.ArrayList;

public class ScanTicket {

    public int checkNumber(String inputNumber, ArrayList<ParkingTicket> parkedCars) {
        for (ParkingTicket parkingTicket : parkedCars) {
            String storedNumber = parkingTicket.getAssignedCar().getNumberPlate();
            if (inputNumber.equals(storedNumber)) {
                return 1; // Car number matches a parked car
            }
        }
        return 0; // Car number does not match any parked car
    }
}
