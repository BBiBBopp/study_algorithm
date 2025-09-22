package sparta.lv3;
/*
[ 크기가 작은 부분문자열 ]
숫자로 이루어진 문자열 t와 p가 주어질 때,
t에서 p와 길이가 같은 부분문자열 중에서, 부분문자열이 나타내는 수가 p보다 작거나 같은 횟수 반환

- 1 <= p의 길이 <= 18
    >> Integer.parseInt() : 최대 10자리 (2147483647)까지 표현 가능
       P는 최대 18자리까지 가능하므로 int 범위 초과

 */
public class StringSplitBasic {
    public static int solution(String t, String p) {
        int answer = 0;
        int n = p.length();

        String subT;
        for(int i=0; i<(t.length() - n+1); i++){
            subT = t.substring(i, i+n);
            if(Long.parseLong(subT)<=Long.parseLong(p)){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("answer : " + solution("10203", "15"));
    }
}
