import java.util.Random;

public class trans {
    int num = (int) (Math.random()*10000 +1); // 랜덤함수 기본형 Double형 -> 강제 int형, 랜덤함수는 0부터 생성 -> +1 해준다
    int currentOil = 100; // 현재 주유량
    int currentPass = 0; // 현재 승객 수
    int currentSpeed = 0; //현재 속도
}
