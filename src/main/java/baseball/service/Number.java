package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    final static int NUM_LEN = 3;

    public static Integer [] getRandomNum(final int len, final int MIN_NUM, final int MAX_NUM) {
        Integer[] num = new Integer[NUM_LEN];

        for (int i = 0; i < len; i++){
            num[i] = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
        }
        return num;
    }

}
