package AssignmentW3;

public class TestTaxi {
    public static void main(String[] args) {
        Taxi t1 = new Taxi();
        Taxi t2 = new Taxi();

        t1.boarding(2, "서울역", 2);
        System.out.println("상태 = "+t1.status);
        t1.nowFuel(-80);
        t1.pay();
        t1.pass(5);
        t1.boarding(3, "구로디지털단지역", 12);
        t1.nowFuel(-20);
        t1.pay();
        System.out.println("상태 = "+t1.status);
    }
}
