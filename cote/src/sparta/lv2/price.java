package sparta.lv2;
/*
[부족한 금액 계산하기]
https://school.programmers.co.kr/learn/courses/30/lessons/82612

price + price*1 + price*2 + ... + price*n = totalPrice
등차수열 합 : n(n+1) / 2
totalPrice - n = 부족한 금액

 */
public class price {

    public static long solution(int price, int money, int count) {
        long answer = -1;
        long totalPrice = (long) price * count*(count+1) / 2;

        answer = (totalPrice - money > 0) ? totalPrice - money : 0;

        return answer;
    }

    public static void main(String[] args) {
        solution(3,20,4);
    }
}
