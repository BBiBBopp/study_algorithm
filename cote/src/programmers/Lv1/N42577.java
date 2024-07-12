package programmers.Lv1;

import java.util.Arrays;

public class N42577 {

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));

	}
	
	// 전화번호 목록
	public static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		
        for(int i=0; i<phone_book.length-1; i++){
        	if(phone_book[i+1].startsWith(phone_book[i])) {
    			return false;
    		}
        }
        
         return true;
    }
}
