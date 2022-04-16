package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {
        // step0 - 제약사항 테스트용
        System.out.println(pickNumberInRange(0, 9));
        System.out.println(pickNumberInRange(0, 9));
        System.out.println(pickNumberInRange(0, 9));
        System.out.println(readLine());
    }
}
