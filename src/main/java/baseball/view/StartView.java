package baseball.view;

import baseball.controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class StartView {

    private static BufferedReader in;

    public static List<Integer> startGame(){
        System.out.print("숫자를 입력해주세요 : ");
        in = new BufferedReader(new InputStreamReader(System.in));
        return Controller.checkInput(in);
    }

}


