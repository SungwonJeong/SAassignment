package AssignmentW3;

public class Bus extends PublicTransport {
    int maxPassengers = 30;
    int nowPassengers = 0;
    int cost = 1000;

    public Bus() {
        //버스 번호 랜덤
        this.number = (int) (Math.random() * 1000) + 1;
        System.out.println("버스 번호 = " + this.number);
    }

    //버스 상태가 운행 / 차고지행 - 차고지로 들어가면은 승객은 다 내림.
    boolean busStatus(boolean state) {
        if (state) {
            status = "운행";
        } else {
            status = "차고지행";
            nowPassengers = 0;
            maxPassengers = 30;
        }
        return state;
    }

    //버스 상태
    void printBus() {
        System.out.println("주유량 = " + amountOfFuel);
        System.out.println("상태 = " + status);
        if (!(remainOfFuel())) {
            System.out.println("주유 필요");
        }
    }


    //주유에 따른 상태
    @Override
    int nowFuel(int usedFuel) {
        amountOfFuel += usedFuel;
        if (!(remainOfFuel())) {
            status = "차고지행";
            System.out.println("주유량 = " + amountOfFuel);
            System.out.println("상태 = " + status);
            System.out.println("주유 필요");
        } else {
            if (amountOfFuel > 100) {
                amountOfFuel = 100;
                System.out.println("기름은 100까지만 채울 수 있습니다.");
                System.out.println("주유량 = " + amountOfFuel);
            }
        }
        return amountOfFuel;
    }

    //탑승 승객이 30이 넘어가면 안됨
    boolean possiblePass() {
        return maxPassengers >= nowPassengers;
    }

    //승객 탑승
    int boarding(int passengr) {
        if (passengr >= (maxPassengers - nowPassengers)) {
            System.out.println("최대 승객 수 초과");
        } else {
            if (possiblePass()) {
                nowPassengers += passengr;
                System.out.println("탑승 승객 수 = " + passengr);
                System.out.println("잔여 승객 수 = " + (maxPassengers - nowPassengers));
                System.out.println("요금 = " + cost * passengr);
            } else {
                System.out.println("최대 승객 수 초과");
            }
        }
        return nowPassengers;
    }


}
