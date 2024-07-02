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
	 * https://programmer-may.tistory.com/154
	 * 
	 * < String >
	 * 
	 * ● +, += 연산
	 * + , += 를 사용하는 경우, + 할 때마다 새로운 객체를 만들어서 연산을 수행함 (기존의 데이터 변경이 아닌 새로운 리터럴 추가)
	 * 시간복잡도 : O(기존 문자열의 길이 + 더하려는 문자열의 길이)
	 * 
	 * 예시)
	   public void sumString() {
	        String str = "";
	        int n = 1000000;
	        for(int i = 0; i < n; i++){
	        	s += "A"; 
 	        }
	    }
	    
	    > 소요 시간 : (s의 길이 + "A" 의 길이) * N
	    > N*(N+1)/2 * N  ( N*(N+1)/2 는 1부터 N까지의 합 )
	    > O(N^3)
	    
	 * ● replace();
	 * 시간복잡도 : O(문자열의 길이 * (교체할 문자열의 길이 + 교체되는 문자열의 길이/교체할 문자열의 길이))
	 * 
	 * 예시)
	   str.replace(a, b)
	   
	   > 소요 시간 : O(len(str) * (len(a) + len(b)/len(a)))
	      문자열 str의 길이만큼 전체에서 문자열을 하나씩 탐색하고, 교체할 문자열의 길이만큼 이전값을 탐색해서 교체해야하는 문자열인지 아닌지를 판별함
	      교체해야 하는 경우, 교체되는 문자열의 길이에 따라 추가 연산
	   1) 교체되는 문자열의 길이 == 교체할 문자열의 길이 
	            교체되는 문자열의 길이만큼 연산 수행 : O(len(b)/len(a)) = O(1)
	   2) 교체되는 문자열의 길이 > 교체할 문자열의 길이
	            초과된 길이만큼 새 위치를 만들고 교체 수행 : O(len(b)/len(a)) 만큼의 추가 연산 소요

	 * < StringBuilder >
	 * ● append();
	 * 시간복잡도 : O(N)
	 * 
	 * 예시)
	   public void sumString() {
	        StringBuider sb = new StringBuider();
	        int n = 1000000;
	        for(int i = 0; i < n; i++){
	        	sb.append("A"); 
 	        }
	    }
	    
	    > 소요 시간 
	    sb.append("A") 의 시간복잡도  O(1) 
	    > 전체 소요시간  O(N) 
	 * 
	 * 
	 * 
	 */

}
