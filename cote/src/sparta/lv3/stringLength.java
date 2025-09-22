package sparta.lv3;
/*
[시저 암호]
어떤 문장의 각 알파벳을 일정 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식
"AB"를 1만큼 밀면 "BC"가 됨
"z"는 1만큼 밀면 "a"가 됨

- 공백은 아무리 밀어도 공백

Sol)
ascii코드 활용
25자 넘어가면 다시 a로 돌리기
공백은 공백 
알파벳 개수 : 26개
 */
public class stringLength {
    public static String solution(String s, int n) {
        String answer = "";
        n %= 26; // n이 26보다 큰 경우 대비

        char encode;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer += " ";
            } else {
                encode = (char) (s.charAt(i) + n);
                if(Character.isLowerCase(s.charAt(i))) {
                    if(encode > 'z') encode -= 26;
                } else {
                    if(encode > 'Z') encode -= 26;
                }

                answer += String.valueOf(encode);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution("z", 1);
    }
}
