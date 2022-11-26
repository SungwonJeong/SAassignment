package AssignmentW3;

public class PublicTransport {
    int number;  // 차 번호
    static int amountOfFuel = 100;    // 주유량
    static int speed = 0;           //현재 속도

    boolean state = true;      // 상태
    String status;

    //기름이 10 이상 남아있는지.
    boolean remainOfFuel() {
        return amountOfFuel > 10;
    }

    // 현재 남아 있는 연료
    int nowFuel(int usedFuel) {
        amountOfFuel += usedFuel;
        if (!(remainOfFuel())) {
            status = "";
        }
        return amountOfFuel;
    }




    int speedChange(int changedSpeed) {
        if (remainOfFuel()) {
            speed += changedSpeed;
            System.out.println("현재 속도는 = "+speed);
        }
        System.out.println("주유량을 확인해 주세요. 현재 주유량 : " + amountOfFuel);

        return speed;
    }


}