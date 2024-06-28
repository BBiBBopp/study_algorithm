package programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class N133502 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 1, 1}));
	}
	
	
	// 1: 빵 , 2: 야채, 3: 고기 
	
	public static int solution(int[] ingredients) {
        int answer = 0;
        
        /*
         * 시간 초과
         * 
        for(int i=0; i<ingredients.length; i++){
        	sb.append(ingredients[i]);
        }
        
        String stringI = sb.toString();
        while(stringI.contains("1231")){
        	stringI = stringI.replaceFirst("1231", "");
        	answer++;
        }
        */
        
        // 정답코드 - StringBuilder [Start]
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ingredients.length; i++){
        	sb.append(ingredients[i]);
        	
        	if(sb.length() > 3 && sb.subSequence(sb.length()-4, sb.length()).equals("1231")){
        		answer++;
        		sb.delete(sb.length()-4, sb.length());
        	}
        	
        }
        // 정답코드 - StringBuilder [End]
       
        // 정답코드 - stack [Start]
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> burger = new ArrayList<>(Arrays.asList(1, 2, 3, 1));
        for(int i=0; i<ingredients.length; i++){
       		stack.add(ingredients[i]);
       		if(stack.size() > 3 && stack.subList(stack.size()-4, stack.size()).equals(burger)){
       		// [시간초과] if(stack.size() > 3 && stack.toString().contains("1, 2, 3, 1")) {
       			stack.pop();
       			stack.pop();
       			stack.pop();
       			stack.pop();
       			answer++;
       		}
        }
        // 정답코드 - stack [End] 
        
        return answer;
    }
	
	/*
	 * < String 연산 >
	 * + , += 를 사용하는 경우, + 할 때마다 새로운 객체를 만들어서 연산을 수행함 (기존의 데이터 변경이 아닌 새로운 리터럴 추가)
	 * 시간복잡도 : O(N + K) ※ N: 기존 문자열의 길이, K: 더하려는 문자열의 길이
	 * 
	 * 예시)
	   public static void sumString(String[] args) {
	        String str = "";
	        int n = 1000000;
	        for(int i = 0; i < n; i++){
	        	s += "A"; 
 	        }
	    }
	    
	    // 소요 시간 : (s의 길이 + "A" 의 길이) * N
	      > N * (N+1) / 2 * N 
	      > N * (N+1) / 2 는 1부터 N까지의 합
	      > O(N^3)
	        
	 * 
	 *  
	 * 
	 */

}
