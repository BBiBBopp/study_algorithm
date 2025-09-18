package sparta.lv2;

public class stringTest {
    public String solution(int n) {
        String answer = "";
        String str = "수박";

        for(int i=0; i< (n/2);i++){
            answer += str;
        }

        if(n%2 != 0) {
            answer += "수";
        }

        return answer;
    }

    public String solution2(int n) {
        String answer = "";

        for(int i=0; i<n; i++){
            answer += (i%2==0) ? "수" : "박";
        }

        return answer;
    }
}
