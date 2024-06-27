package programmers.Lv1;


public class N147335 {

	public static void main(String[] args) {
		System.out.println(solution("10203", "15"));

	}

	// 크기가 작은 부분 문자열
	public static int solution(String t, String p) {
        int answer = 0;
        int n = p.length();
        long longP = Long.parseLong(p);
        
        Long subT;
        for(int i=0; i<=t.length()-n; i++){
        	subT = Long.parseLong(t.substring(i, (i+n)));
        	if(subT <= longP){
        		answer += 1;
        	}
        }
        
        return answer;
    }
}
