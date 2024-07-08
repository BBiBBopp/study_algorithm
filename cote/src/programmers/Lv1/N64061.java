package programmers.Lv1;

import java.util.Stack;

public class N64061 {

	public static void main(String[] args) {
		int[][] board = new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = new int[] {1,5,3,5,1,2,1,4};
		
		solution(board, moves);
	}
	
	// 크레인 인형뽑기 게임
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        int idx;
        for(int move : moves){
        	idx = move-1;
        	for(int[] col : board){
        		if(col[idx] != 0){
        			if(!stack.isEmpty() && stack.peek() == col[idx]) {
        				stack.pop();
        				answer += 2;
        			} else {
        				stack.push(col[idx]);
        			}
        			col[idx] = 0;
        			break;
        		}
        	}
        }
        
        return answer;
    }
	
	

}
