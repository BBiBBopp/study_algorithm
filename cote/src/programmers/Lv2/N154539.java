package programmers.Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class N154539 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {8, 1, 2, 9}));
	}
	
	/*
	 * [2, 3, 3, 5]			[3, 5, 5, -1]
	   [9, 1, 5, 3, 6, 2]	[-1, 5, 6, 6, -1, -1]
	   [8, 1, 2, 9] 		[9, 2, 9, -1]
	 */
	public static int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
        	answer[i] = -1;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++){
        	if(stack.isEmpty()){
        		stack.add(numbers[i]);
        	} else {
        		int count=0;

        		while(stack.peek() < numbers[i]){
        			stack.pop();
        			count++;
        			
        			while(answer[i-count] != -1) {
        				count++;
        			}
        			
        			answer[i-count] = numbers[i];
        			
        			if(stack.isEmpty()) break;
        		}
        		stack.add(numbers[i]);
        	}
        }
        
        return answer;
    }
}
