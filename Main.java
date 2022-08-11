public class Main {
    public static void main(String[] args) {
        // 버스 테스트
        bus bus1 = new bus(); // 버스 2대 생성
        bus bus2 = new bus();

        System.out.println(bus1.num); // 버스 번호 출력
        System.out.println(bus2.num);
        bus1.board(2); // 1~2. 승객 +2 & 출력
        bus1.refuel(-50); // 3~4. 주유량 변화 출력
        bus1.oilState(); // 5. 주유량 변화에 따른 버스 상태
        bus1.busState("차고지행"); // 5. 상태 변경 => 차고지행
        bus1.refuel(10); // 6. 주유량 +10
        bus1.currentBus(); // 7. 버스 상태와 주유량 출력
        bus1.busState("운행"); // 8. 상태 변경 => 운행중
        bus1.board(45); // 9 ~ 10. 승객 +45 => 최대 승객 수 초과
        bus1.board(5); // 11 ~ 12. 승객 +5 & 출력
        bus1.refuel(-55); // 13. 주유량 -55
        bus1.currentBus(); // 14. 버스 상태와 주유량 출력
        bus1.changeSpeed(40); // 속도 변경



        // 택시 테스트
        taxi taxi1 = new taxi();        // 1~2. 버스 2대 생성 & 출력

        taxi taxi2 = new taxi();

        System.out.println(bus1.num); // 택시 번호 출력
        System.out.println(bus2.num);

        System.out.println("taxi1 주유량 = "+taxi1.currentOil);
        System.out.println("taxi1 상태 = "+taxi1.state);
        System.out.println("taxi2 주유량 = "+taxi2.currentOil);
        System.out.println("taxi2 상태 = "+taxi2.state);
        taxi1.board(2, "서울역", 2); // 1~2.승객+2 목적지 = 서울역 목적지까지 거리 2km & 출력
        taxi1.refuel(-80); // 3~4. 주유량 -80 & 요금결제
        taxi1.purchase(); //4~5. 요금 결제 & 출력
        taxi1.board(5, " ", 0); // 6~7. 승객+5 & 최대승객수 초과
        taxi1.board(3, "구로디지털단지역", 12); // 8~9. 승객+3 목적지 = 구로디지털단지역 목적지까지 거리 12km & 출력
        taxi1.refuel(-20); // 10. 주유량 -20
        taxi1.purchase(); // 11~12. 요금 결제 & 출력
        taxi1.oilState(0); //13. 주유 상태
        taxi1.changeSpeed(40); // 속도 변경


    }

}

