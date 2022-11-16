package baseball.view;

import java.util.List;

public class EndView {
    public static void printGameResult(List<Integer> gameResult){
        if(gameResult.get(0) == 0 && gameResult.get(1) == 0){
            System.out.println("낫싱");
            return;
        }

        if(gameResult.get(0) != 0 && gameResult.get(1) != 0){
            System.out.printf("%d볼 %d스트라이크%n", gameResult.get(1), gameResult.get(0));
            return;
        }

        if(gameResult.get(0) != 0){
            System.out.printf("%d스트라이크%n", gameResult.get(0));
            return;
        }

        System.out.printf("%d볼%n", gameResult.get(1));
    }
}
