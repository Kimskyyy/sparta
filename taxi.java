public class taxi extends trans {
    int maxPass = 4;
    int plusFare = 1000;
    int distance = 0;
    String destination;
    int defFare = 3000;
    int wallet = 0;
    String state = "일반";
    int payFare = 0;

    public void board(int pass, String des, int dis) {
        if (pass > maxPass) {
            System.out.println("최대 승객수 초과");
        } else if (currentOil < 10) {
            System.out.println("경고 : 주유 필요");
        } else {
            state = "운행중";
            currentPass += pass;
            payFare = 3000 + (dis - 1) * 1000;
            distance = dis;
            destination = des;
            System.out.println("탑승 승객 수 = " + currentPass);
            System.out.println("잔여 승객 수 = " + (maxPass - pass));
            System.out.println("기본 요금 확인 = " + defFare);
            System.out.println("목적지 = " + destination);
            System.out.println("목적지까지 거리 = " + distance);
            System.out.println("지불할 요금 = " + payFare);
            System.out.println("상태 = " + state);
        }
    }

    public void purchase() {
        wallet += payFare;
        plusFare = 0;
        state = "일반";
        System.out.println("주유량 = " + currentOil);
        System.out.println("누적 요금 = " + wallet);
    }

    public void refuel(int x) {
            currentOil += x;
            System.out.println("주유량 = " + currentOil);
    }

    public void oilState (int x){
        if (currentOil - x < 10) {
            state = "운행 불가";
            currentOil -= x;
            System.out.println("주유량 = "+currentOil);
            System.out.println("상태 = "+state);
            System.out.println("경고 : 주유 필요");
        } else {
            currentOil -= x;
            System.out.println("주유량 = "+currentOil);
        }
    }
    // 속도변경
    int changeSpeed(int changeSpeed) {
        if(currentOil > 10) { //주유 상태를 체크하고 주유량이 10 이상이어야 운행할 수 있음
            this.currentSpeed = changeSpeed;
            System.out.println("현재 속도는 "+ currentSpeed+"입니다.");
        }
        System.out.println("주유량을 확인해주세요.현재 주유량:"+currentOil);
        return currentOil;
    }
}