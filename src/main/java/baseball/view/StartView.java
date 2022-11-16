package baseball.view;

import baseball.controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StartView {

    private static String in;
    private static char[] charIn;
    private static Integer[] intIn;

    public static Integer[] startGame(){
        System.out.print("숫자를 입력해주세요 : ");
        try{
            in = new BufferedReader(new InputStreamReader(System.in)).readLine();
        }catch (IOException e) {
            System.out.println("입력 오류");
            System.exit(-1);
        }
        charIn = in.toCharArray();
        intIn = new Integer[in.length()];
        Arrays.setAll(intIn, i -> Character.getNumericValue(charIn[i]));
        Controller.checkInput(charIn, intIn);
        return intIn;
    }

}


