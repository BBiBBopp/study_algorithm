package sparta.lv2;
/*
[행렬의 덧셈]
https://school.programmers.co.kr/learn/courses/30/lessons/12950
행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과 반환

 */
public class arrSum {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new  int[arr1.length][arr1[0].length];

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[0].length; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }

    // 다른 풀이
    public int[][] solution2(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        answer = arr1; // 배열의 크기가 같으므로 answer을 arr1으로 설정
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[0].length; j++){
                answer[i][j] += arr2[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[][]{{1,2}, {2,3}}, new int[][]{{3,4}, {5,6}});
    }
}
