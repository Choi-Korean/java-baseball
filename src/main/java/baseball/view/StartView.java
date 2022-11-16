package baseball.view;

import baseball.controller.Controller;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class StartView {

    public List<Integer> startGame(){
        System.out.print("숫자를 입력해주세요 : ");
        return Controller.checkInput(Console.readLine());
    }

    public String reGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

}


