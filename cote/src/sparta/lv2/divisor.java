package sparta.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * [ 약수의 개수와 덧셈 ]
 * https://school.programmers.co.kr/learn/courses/30/lessons/77884
 두 정수 left 와 right가 매개변수로 주어질 때,
 left 부터 right까지의 모든 수들 중에서,
 약수의 개수가 짝수인 수는 더하고,
 약수의 개수가 홀수인 수는 뺀 수 출력
 *
 * [ 약수 ]
   나머지가 0인 수
   1) 1~N까지 나누기 > 비효율적
   2) 제곱근까지만 검사하기 (약수 짝의 경계선 : 제곱근)
 * 
 * >> 약수 직접 구할 필요 없음, 완전제곱수 ? (약수의 개수) 홀수 : 짝수
 *
 * [ double -> int 형변환 ]
   1) (int) 를 붙여서 강제 형변환 가능 > 소수점 이하 버림
   2) Math 활용
   * 소수점 이하 반올림 : Math.round()
   * 소수점 이하 올림 : Math.ceil()
   * 소수점 이하 버림 : Math.floor()
 */
public class divisor {

    public static int solution(int left, int right) {
        int answer = 0;

        for(int i=left;i<=right;i++) {
            int sqrt = (int) Math.sqrt(i);
            if(sqrt * sqrt == i) {
            // if (i % Math.sqrt(i) == 0) {
                // 약수 개수 홀수 : 빼기
                answer -= i;
            } else {
                // 약수 개수 짝수 : 더하기
                answer += i;
            }
            
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(13, 17);

    }

    // 약수 구하기
    public List<Integer> divisors(int n) {
        List<Integer> divisors = new ArrayList<>();

        // 1부터 √n 까지만 검사
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);       // 작은 약수
                if (i != n / i) {      // 완전 제곱수일 때 중복 방지
                    divisors.add(n / i); // 큰 약수
                }
            }
        }

        // 정렬 (작은 수부터 출력하기 위해)
        Collections.sort(divisors);

        return divisors;
    }
}
