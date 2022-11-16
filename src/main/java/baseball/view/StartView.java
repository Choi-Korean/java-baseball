package baseball.view;

import baseball.controller.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class StartView {

    public static List<Integer> startGame(){
        System.out.print("숫자를 입력해주세요 : ");
        return Controller.checkInput(new BufferedReader(new InputStreamReader(System.in)));
    }

    public static BufferedReader reGame(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return new BufferedReader(new InputStreamReader(System.in));
    }

}


