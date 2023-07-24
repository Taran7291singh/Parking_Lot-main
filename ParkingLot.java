import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ParkingLot {

    public static void main(String[] args) {
        ArrayList<ParkingTicket> assignedSpotList = new ArrayList<>();
        ParkingSpot parkingSpot = new ParkingSpot();
        RandomInfo randomInfo = new RandomInfo();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Enter 'P' to park your vehicle or 'U' to unpark your vehicle: ");
            String userInput = scan.nextLine().toUpperCase();

            if (userInput.equals("P")) {
                System.out.print("Enter car color: ");
                String carColor = scan.nextLine();

                String numberPlate = randomInfo.generateNumberPlate();

                System.out.print("Enter car type: ");
                String carType = scan.nextLine();

                carColor = randomInfo.getCarColor(carColor);
                carType = randomInfo.getCarType(carType);

                Car car = new Car();
                car.setNumberPlate(numberPlate);
                car.setCarColor(carColor);
                car.setCarType(carType);

                int spotNum = parkingSpot.SpotNum();
                if (spotNum == 0) {
                    System.out.println("Sorry, spot is not available.");
                } else {
                    ParkingTicket parkingTicket = new ParkingTicket();
                    parkingTicket.setAssignedCar(car);
                    parkingTicket.setSpotNumber(spotNum);

                    String time = randomInfo.getTime();
                    String date = randomInfo.getDate();
                    parkingTicket.setEnterTime(time);
                    parkingTicket.setEnterDate(date);

                    System.out.println("\t\t== Parking Ticket ==\n" +
                            "Car Number : " + numberPlate + "    Car Color : " + carColor + "    Car Type : " + carType +
                            "\nParking Time : " + time + "    Date : " + date +
                            "\nSpot Number : " + spotNum + "\n");

                    assignedSpotList.add(parkingTicket);
                    System.out.println("Total parked vehicles: " + assignedSpotList.size());
                }
            } else if (userInput.equals("U")) {
                if (assignedSpotList.isEmpty()) {
                    System.out.println("There are no parked cars.");
                } else {
                    System.out.print("Enter your car number: ");
                    String inputNumber = scan.nextLine();

                    ScanTicket scanTicket = new ScanTicket();
                    boolean foundCar = false;

                    for (ParkingTicket parkingTicket : assignedSpotList) {
                        Car assignedCar = parkingTicket.getAssignedCar();
                        if (assignedCar.getNumberPlate().equals(inputNumber)) {
                            foundCar = true;
                            int spot = assignedSpotList.indexOf(parkingTicket);

                            String exitDate = randomInfo.getExitDate();
                            String exitTime = randomInfo.getExitTime();
                            String enterDate = assignedSpotList.get(spot).getEnterDate();
                            String enterTime = assignedSpotList.get(spot).getEnterTime();

                            int[] time = TotalTime.calculateTime(enterDate, exitDate, enterTime, exitTime);
                            float amount = Payment.calculateTotalAmount(time[0], time[1]);

                            System.out.println("\n\t\t=== Your Parking Information ===\n" +
                                    "Car Number : " + assignedCar.getNumberPlate() +
                                    "    Car Color : " + assignedCar.getCarColor() +
                                    "    Car Type : " + assignedCar.getCarType() +
                                    "\nParking Time : " + enterTime +
                                    "    Exit Time : " + exitTime +
                                    "\nParking Date : " + enterDate +
                                    "    Exit Date : " + exitDate +
                                    "    Spot Number : " + assignedSpotList.get(spot).getSpotNumber() +
                                    "\nTotal Time : " + time[0] + " Hour " + time[1] + " Minute " +
                                    "\nTotal Amount : " + amount + " rupees\n"
                            );

                            parkingSpot.FreeSpot(assignedSpotList.get(spot).getSpotNumber());
                            assignedSpotList.remove(spot);
                            break;
                        }
                    }

                    if (!foundCar) {
                        System.out.println("Invalid car number. Please check your car number and try again.");
                    }
                }
            } else {
                System.out.println("Invalid input. Please enter 'P' to park or 'U' to unpark a vehicle.");
            }

            System.out.print("Do you want to continue (Y/N): ");
            String continueOption = scan.nextLine().toUpperCase();
            if (!continueOption.equals("Y")) {
                System.out.println("Thank you for using the Parking Lot system. Have a great day!");
                break;
            }
        }
    }
}
