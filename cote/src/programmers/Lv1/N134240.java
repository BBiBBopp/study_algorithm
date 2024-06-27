package programmers.Lv1;

public class N134240 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 3, 4, 6}));
	}
	
	// 푸드 파이트 대회
	public static String solution(int[] food) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        int temp =0;
        for(int i=1; i<food.length; i++){
        	temp = food[i]/2;
        	
        	while(temp > 0){
        		sb.append(i);
        		temp--;
        	}
        }
        
        answer = sb + "0";
        answer += sb.reverse();
        
        /*
         * 다른 사람 풀이
         * 
         * for(int i=){
        	temp = food[i]/2;
        	
        	while(temp > 0){
        		sb.append(i);
        		temp--;
        	}
        }
         */
        
        return answer;
    }
}
