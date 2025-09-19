package sparta.lv3;
/*
[이상한 문자열 만들기]
각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열 반환

- 문자열 전체의 짝/홀수 인덱스가 아닌, 단어(공백 기준) 짝/홀수 인덱스
- 첫번재 글자는 0번째 인덱스이므로 짝수번째 처리

[ public String[] split(String regex, int limit) ]
- limit : 결과 배열의 길이에 영향을 주는 값
    limit > 0 : 최대 limit 개의 토큰만 리턴, 마지막 요소에는 나머지 문자열 전부가 들어감
    limit = 0 : 구분자로 잘라낸 뒤, 맨 끝 빈 문자열 제거 (default)
    limit < 0 : 제한 없이 끝까지 잘라내며, 맨 끝의 빈 문자열도 그대로 유지
 
 */
public class letters {

    public static String solution(String s) {
        String answer = "";

        String[] sArr = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<sArr.length;i++){
            for(int j=0;j<sArr[i].length();j++){
                if(j%2 == 1) {
                    sb.append(String.valueOf(sArr[i].charAt(j)).toLowerCase());
                } else {
                    sb.append(String.valueOf(sArr[i].charAt(j)).toUpperCase());
                }
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    public static void main(String[] args) {
        solution("a          a    ");
    }
    
    /* 
    // 다른 사람 풀이
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0; // 각 단어 내 인덱스 초기화

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);   // 공백은 그대로 추가
                index = 0;      // 단어 인덱스 초기화
            } else {
                // 짝수 인덱스는 대문자, 홀수는 소문자
                sb.append((index++ % 2 == 0) ? Character.toUpperCase(c) : Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }
     */

}
