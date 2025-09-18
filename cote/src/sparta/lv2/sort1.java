package sparta.lv2;

import java.util.Arrays;
import java.util.Collections;
/*
  [문자열 내림차순 정렬]
  https://school.programmers.co.kr/learn/courses/30/lessons/12917
  영문 대소문자로만 구성, 대문자는 소문자보다 작은것으로 간주함
  
  [정렬]
  Arrays.sort(배열) 
  - default : 오름차순 정렬, 문자열의 경우 아스키코드순(알파벳순, 소문자~대문자 순) 오름차순
  - Sort(Array, Comparator)
    * sort(Array, Collections.reverseOrder()) : 내림차순 정렬
    
 */
public class sort1 {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        return String.join("", arr);
    }

    // sort 구현
    public String solution2(String s) {
        String answer = "";

        // 문자열을 문자 배열로 변환
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        Arrays.sort(chars, (a,b) -> {
            // 같은 알파벳이면 그냥 문자 코드 비교 (대문자가 더 작음)
            if(Character.toLowerCase(a) == Character.toLowerCase(b)) {
                return b-a;
            } else {
                // 알파벳 자체를 기준으로 내림차순
                return Character.toLowerCase(b) - Character.toLowerCase(a);
            }
        })

        return null;
    }
}

/*
    [다른 풀이]

    // StringBilder 활용
    public String reverseStr(String str){
        char[] sol = str.toCharArray();
        Arrays.sort(sol);

        return new StringBuilder(new String(sol)).reverse().toString();
    }

    ----------------
    // Stream 활용
    public String reverseStr(String str){
        return Stream.of(str.split(""))
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.joining());
    }
    ----------------


 */
