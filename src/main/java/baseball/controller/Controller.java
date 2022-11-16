package baseball.controller;

import baseball.view.StartView;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controller {
    private int GO_STOP = 1;
    private Integer[] userInput;
    private List<Integer> computerInput;

    public void run() {
        if(this.GO_STOP == 1){
            start();
            return;
        }

        if(this.GO_STOP == 2){
            stop();
            return;
        }
    }

    public void start(){
        userInput = StartView.startGame();
        computerInput = makeComputerNums();

    }

    public void stop(){

    }

    public static Integer[] checkInput(BufferedReader in){
        String input;
        char[] charIn;
        Integer[] intIn;

        try{
            input = in.readLine();
        }catch (IOException e) {
            throw new IllegalArgumentException("입력 오류");
        }

        charIn = input.toCharArray();
        intIn = new Integer[input.length()];
        Arrays.setAll(intIn, i -> Character.getNumericValue(charIn[i]));

        // input이 3개 이상 아닐시
        if(charIn.length != 3){
            throw new IllegalArgumentException("Invalid Input: 3개 이상의 숫자를 입력해주세요.");
        }
        
        // 숫자 아닌게 입력
        for(char c:charIn){
            if(!Character.isDigit(c)){
                throw new IllegalArgumentException("Invalid Input: 숫자만 입력해주세요.");
            }
        }
        
        // 중복수
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(intIn));
        if(set.size() != 3){
            throw new IllegalArgumentException("Invalid Input: 중복되지 않는 3개 이상의 숫자를 입력입니다.");
        }

        return intIn;

    }

    public static List<Integer> makeComputerNums(){
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

}
