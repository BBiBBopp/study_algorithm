package sparta.lv2;
/*
[3진법 뒤집기]
자연수 n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수 출력
 */
public class numaral {

    public static int solution(int n) {
        int answer = 0;

        // 10진법 > 3진법
        while(n > 0){
            int digit = n % 3; // 3진수의 가장 낮은 자리 (뒤집힌 후 가장 높은 자리)

            answer = answer * 3 + digit; // 뒤집힌 3진수를 왼쪽에서부터 붙이는 효과

            n = n/3;
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(45);
    }
}
