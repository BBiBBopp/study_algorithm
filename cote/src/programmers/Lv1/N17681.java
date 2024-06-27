package programmers.Lv1;

import java.util.Stack;

public class N17681 {
/*
	 n		5
	arr1	[9, 20, 28, 18, 11]
	arr2	[30, 1, 21, 17, 28]
	출력		["#####","# # #", "### #", "# ##", "#####"]
 */
	public static void main(String[] args) {
		solution(6, new int[] {46, 33, 33, 22, 31, 50}, new int[] {27, 56, 19, 14, 14, 10});
	}

	// [1차] 비밀지도
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = null;
        
        Stack<Integer> row1 = new Stack<>();
        Stack<Integer> row2 = new Stack<>();
        
        for(int i=0; i<n; i++){
        	sb = new StringBuilder();
        	row1.clear();
        	row2.clear();
        	
        	while(row1.size() < n){
        		row1.add(arr1[i] % 2);
        		arr1[i] = arr1[i] / 2;
        		
        		row2.add(arr2[i] % 2);
        		arr2[i] = arr2[i] / 2;
        	}
        	
        	while(!row1.isEmpty()){
        		if(row1.pop() == 1 | row2.pop() == 1){
            		sb.append("#");
            	} else {
            		sb.append(" ");
            	}
        	}
        	
        	answer[i] = sb.toString();
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
}
