package baseball;

import baseball.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        System.out.println("숫자 야구 게임을 시작합니다.");
        controller.run();
    }
}
