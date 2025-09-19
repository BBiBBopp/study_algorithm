package sparta.lv3;

import java.util.ArrayList;
import java.util.Arrays;

/*
[삼총사]
정수 3개의 합이 0이 되는 방법의 갯수
 */
public class searchBasic {
    public static int solution(int[] number) {
        int answer = 0;

        Arrays.sort(number);
        for(int i=0; i<number.length; i++) {
            for(int j=i+1; j<number.length; j++){
                for(int k=j+1; k<number.length; k++){
                    if(number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[] {-2, 3, 0, 2, 5});
    }
}
