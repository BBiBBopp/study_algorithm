package sparta.lv3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
[최소 직사각형]
가로, 세로 길이로 이루어진 배열 (명함)
명함은 회전 가능
모든 명함을 담을 수 있는 최소 크기의 직사각형 크기 출력

Sol)
각 명함이 회전 가능하므로 각 쌍 (w, h)를 긴 변, 짧은 변으로 정규화하기
    long = max(w,h), short = min(w,h)

 */
public class squareMin {
    public static int solution(int[][] sizes) {
        int answer = 0;
        int maxw = 0;
        int maxh = 0;

        // 긴 변, 짧은 변으로 정리
        int temp;
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]) {
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            maxw = Math.max(maxw, sizes[i][0]); // 가장 긴 w
            maxh = Math.max(maxh, sizes[i][1]); // 가장 긴 h
        }

        return maxh * maxw;
    }

    public static void main(String[] args) {
        solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
    }

    // 다른 풀이
    public int solution2(int[][] sizes) {
        int length = 0;
        int height = 0;
        for(int[] card : sizes){
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }

        return length * height;
    }

}
