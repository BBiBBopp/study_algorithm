package sparta.lv3;
/*
[숫자 문자열과 영단어]
숫자 일부 자릿수가 영단어인 문자열 s가 주어질 때, s가 의미하는 원래 숫자 출력

23four5six7 -> 234567
one4seveneight -> 1478

 */
import java.util.HashMap;

public class StringNumber {
    public static int solution(String s) {

        while(!s.matches("^[0-9]*$")){
            s = s.replaceAll("zero", "0");
            s = s.replaceAll("one", "1");
            s = s.replaceAll("two", "2");
            s = s.replaceAll("three", "3");
            s = s.replaceAll("four", "4");
            s = s.replaceAll("five", "5");
            s = s.replaceAll("six", "6");
            s = s.replaceAll("seven", "7");
            s = s.replaceAll("eight", "8");
            s = s.replaceAll("nine", "9");
        } 
        
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        solution("one4seveneight");
    }

    // 다른 풀이
    public int solution2(String s) {
        String[] sArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0;i<sArr.length;i++){
            s.replaceAll(sArr[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}
