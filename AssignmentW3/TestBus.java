package AssignmentW3;

public class TestBus {
    public static void main(String[] args) {
        Bus b1 = new Bus();
        Bus b2 = new Bus();

        b1.boarding(2);
        b1.nowFuel(-50);
        System.out.println("주유량 = " +b1.amountOfFuel);
        b1.busStatus(false);
        b1.nowFuel(10);
        b1.printBus();
        b1.busStatus(true);
        b1.boarding(45);
        b1.boarding(5);
        b1.nowFuel(-55);

    }
}
