package sparta.lv2;
/*
[최대공약수와 최소공배수]
두 수를 입력받아 두 수의 최대공약수, 최소공배수를 반환

[GCD (유클리드 호제법, 최대공약수)]
두 정수 a, b (a>b)에 대하여 a=bq + r 이라 하면,
a,b의 최대공약수는 b,r의 최대공약수와 같다

gcd(a,b) = gcd(b,r)

>> r = 0이라면 a, b의 최대공약수는 b가 된다.

[LCM (Least Common Multiple, 최소공배수)]
(증명 : 소인수분해)

LCM(a,b) = a * b / GCD(a,b)
 */
public class gcdLcm {
    public int[] solution(int a, int b) {
        int[] answer = new int[2];

        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }

        answer[0] = gcd(a, b);
        answer[1] = a*b / answer[0];

        return answer;
    }

    public int gcd(int a, int b) {
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    // 재귀함수로 gcd
    public int gcd2(int a, int b) {
        if(b == 0) return a;
        return gcd2(b, a%b);
    }
}
