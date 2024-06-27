package programmers.Lv1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class N68644 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2,1,3,4,1}).toString());
	}
	
	public static int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<numbers.length; i++){
        	for(int j=i+1; j<numbers.length; j++){
        		set.add(numbers[i]+numbers[j]);
        	}
        }
        
        int[] answer = new int[set.size()];
        Iterator it = set.iterator();
        
        for(int i=0; i<set.size(); i++){
        	answer[i] = (int) it.next();
        }
        
        Arrays.sort(answer);
       
        return answer;
    }
}
