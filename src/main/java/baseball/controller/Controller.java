package baseball.controller;

import baseball.view.StartView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controller {
    private int GO_STOP = 1;
    private Integer[] USER_INPUT;
    private List<Integer> COMPUTER_INPUT;

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
        USER_INPUT = StartView.startGame();

    }

    public void stop(){

    }

    public static void checkInput(char[] charIn, Integer[] intIn){
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

    }

}
