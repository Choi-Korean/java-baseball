package baseball.controller;

import baseball.view.EndView;
import baseball.view.StartView;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Controller {
    private int GO_STOP = 1;
    private List<Integer> userInput;
    private List<Integer> computerInput;
    private List<Integer> gameResult;  // 스트라잌, 볼

    public void run() {
        if(this.GO_STOP == 1){
            computerInput = makeComputerNums();
            start();
            return;
        }

        if(this.GO_STOP == 2){
            stop();
            return;
        }
    }

    public void start(){
        while(true){
            userInput = StartView.startGame();
            gameResult = countBaseBall(userInput, computerInput);
            EndView.printGameResult(gameResult);
            if(gameResult.get(0) == 3){
                break;
            }
        }
        stop();
    }

    public void stop(){

    }

    public static List<Integer> checkInput(BufferedReader in){
        String input;
        char[] charIn;
        List<Integer> intIn;

        try{
            input = in.readLine();
        }catch (IOException e) {
            throw new IllegalArgumentException("입력 오류");
        }

        charIn = input.toCharArray();
        intIn = new ArrayList<>(input.length());
        for(int i = 0; i < charIn.length; i ++){
            intIn.add(Character.getNumericValue(charIn[i]));
        }

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
        Set<Integer> set = new HashSet<>(intIn);
        if(set.size() != 3){
            throw new IllegalArgumentException("Invalid Input: 중복되지 않는 3개 이상의 숫자를 입력입니다.");
        }

        return intIn;

    }

    // Computer 랜덤 수 생성
    public static List<Integer> makeComputerNums(){
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    // 볼, 스트라이크 개수 판단
    public static List<Integer> countBaseBall(List<Integer> user, List<Integer> computer){
        List<Integer> counts = Arrays.asList(0, 0);
        Set<Integer> set = new HashSet<>(computer);
        for(int i = 0; i < user.size(); i ++){
            if(user.get(i) == computer.get(i)){
                counts.set(0, counts.get(0) + 1);
                continue;
            }
            if(set.contains(user.get(i))){
                counts.set(1, counts.get(1) + 1);
                continue;
            }
        }

        return counts;
    };



}
