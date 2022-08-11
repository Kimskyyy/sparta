public class bus extends trans{

    int maxPass = 30;		// 버스 최대 승객 수 30명
    int fare = 1000;		// 요금
    String state = "운행"; //버스 기본값은 운행

    bus(){ // 기본 생성자
    }


    // 버스 상태 변경
    public void busState(String toword) {
        if (toword == "차고지행") {
            state = "차고지행";
            System.out.println("상태: = " + state);
        } else {
            state = "운행";
            System.out.println("상태: = " + state);
        }
    }

    // 버스 현재 상태
    void currentBus() {
        System.out.println("상태 = "+state);
        System.out.println("주유량 = "+currentOil);
        if(currentOil < 10)
            System.out.println("주유 필요");
    }

    // 버스 기름에 따른 상태 변경
    void oilState() {
        if(currentOil > 10) {
            System.out.println("남은 기름 : "+ currentOil);
            System.out.println("운행 가능");
        } else {
            state = "차고지행";
            System.out.println("주유 필요");
            System.out.println("상태 ="+state);
        }
    }

    // 주유량 변화
    int refuel(int oil) {
        currentOil += oil;
        System.out.println("주유량 = "+currentOil);
        if(currentOil < 10) {
            state = "차고지행";
            currentPass = 0;
        }
        return currentOil;
    }

    // 승객 탑승
    public void board(int pass) {
        if (pass >= (maxPass - currentPass)) {
            System.out.println("최대 승객 수 초과");
        } else {
                currentPass += pass;
                System.out.println("탑승 승객 수 = "+pass+"명");
                System.out.println("잔여 승객 수 = "+(maxPass-currentPass)+"명");
                System.out.println("요금 확인 = "+(fare*pass));
            }
    }

    // 속도변경
    int changeSpeed(int changeSpeed) {
        if(currentOil > 10) { //주유 상태를 체크하고 주유량이 10 이상이어야 운행할 수 있음
            this.currentSpeed = changeSpeed;
            System.out.println("현재 속도는 "+ currentSpeed+"입니다.");
        }
        System.out.println("주유량을 확인해주세요. 현재 주유량:"+currentOil);
        return currentOil;
    }
}
