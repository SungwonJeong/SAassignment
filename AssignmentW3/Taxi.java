package AssignmentW3;

public class Taxi extends PublicTransport {
    String destination;     //목적지
    int distanceToDest;     //목적지까지 거리
    int distanceDefault = 1;    //기본거리
    int fareMin = 3000;    //기본요금
    int farePerDis = 1000;    //거리당 요금
    int fareAccumulated = 0;    // 누적요금
    int maxPassengers = 4;      //최대 승객 수
    int nowPassengers =0 ;          //현재 승객 수
    String status = "일반";
    int cost;   //지불할 금액

    public Taxi() {
        //택시번호 랜덤
        this.number = (int) (Math.random() * 1000) + 1;
        System.out.println("택시 번호 = " + this.number);
        System.out.println("주유량 = " + amountOfFuel);
        System.out.println("상태 = " + status);
    }

    boolean busStatus(boolean state) {
        if (state) {
            status = "일반";
        } else {
            status = "운행중";
            nowPassengers = 0;
            maxPassengers = 4;
        }
        return state;
    }

    //연료에 따른 택시 상태
    @Override
    int nowFuel(int usedFuel) {
        amountOfFuel += usedFuel;
        if (!(remainOfFuel())) {
            status = "운행 불가";
//            System.out.println("주유량 = " + amountOfFuel);
//            System.out.println("상태 = " + status);
//            System.out.println("누적요금 = " + fareAccumulated);
//            System.out.println("주유 필요");
        } else {
            if (amountOfFuel > 100) {
                amountOfFuel = 100;
                System.out.println("기름은 100까지만 채울 수 있습니다.");
                System.out.println("주유량 = " + amountOfFuel);
            }
        }
        return amountOfFuel;
    }

    void pass(int passenger){
        if(passenger>4)
            System.out.println("최대 승객 수 초과");
    }


    //승객 탑승
    void boarding(int nowPassengers, String des, int distanceToDest) {
        if (status.equals("일반")) {
            if (nowPassengers >4) {
                System.out.println("최대 승객 수 초과");
            } else {
                if (distanceToDest == 1) {
                    cost = fareMin;
                } else {
                    cost = farePerDis * (distanceToDest - distanceDefault) + fareMin;
                    status = "운행중";
                    System.out.println("탑승 승객 수 = " + nowPassengers);
                    System.out.println("잔여 승객 수 = " + (maxPassengers - nowPassengers));
                    System.out.println("기본 요금 확인 = " + fareMin);
                    System.out.println("목적지 = " + des);
                    System.out.println("목적지까지의 거리 = " + distanceToDest + "km");
                    System.out.println("지불할 요금 = " + cost);
                    fareAccumulated += cost;
                }
            }
        } else {
            System.out.println("탑승 불가");
        }
    }

    //요금 지불 - 승객이 내림 - 다시 상태 일반
    int pay() {
        status = "일반";
        maxPassengers = 4;
        nowPassengers = 0;
        System.out.println("주유량 = " + amountOfFuel);
        System.out.println("누적요금 = " + fareAccumulated);
        if (!remainOfFuel()){
            status = "운행불가";
            System.out.println("주유 필요");
        }
        return fareAccumulated;
    }
}



