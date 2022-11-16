package baseball.controller;

import baseball.service.Number;
import baseball.view.EndView;
import baseball.view.StartView;
import java.util.*;

public class Controller {
    final int NUM_LEN = 3;
    final int MIN_NUM = 1;
    final int MAX_NUM = 9;
    private Integer GO_STOP = 1;
    private List<Integer> userInput;
    private static Integer[] computerInput;
    private List<Integer> gameResult;  // 스트라잌, 볼
    private StartView startView = new StartView();
    private EndView endView = new EndView();

    public void run() {
        if(this.GO_STOP == 1){
            setComputerNums();
            start();
        }

        if(this.GO_STOP == 2){
            return;
        }
    }

    public void start(){
        while(true){
            userInput = startView.startGame();
            gameResult = countBaseBall(userInput, computerInput);
            endView.printGameResult(gameResult);
            if(gameResult.get(0) == 3){
                break;
            }
        }
        stop();
    }

    public void stop(){
        endView.printEndGame();
        GO_STOP = Integer.parseInt(startView.reGame());
        run();
    }

    public static List<Integer> checkInput(String input){
        char[] charIn;
        List<Integer> intIn;

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
    public void setComputerNums(){
        computerInput = Number.getRandomNum(NUM_LEN, MIN_NUM, MAX_NUM);
    }

    // 볼, 스트라이크 개수 판단
    public static List<Integer> countBaseBall(List<Integer> user, Integer[] computer){
        List<Integer> counts = Arrays.asList(0, 0);
        Set<Integer> set = new HashSet<>(Arrays.asList(computer));
        for(int i = 0; i < user.size(); i ++){
            if(user.get(i) == computer[i]){
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
