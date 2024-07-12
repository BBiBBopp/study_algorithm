package programmers.Lv1;

import java.util.HashMap;

public class N77484 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]

	}
	
	/*
	 	1	6개 번호가 모두 일치
		2	5개 번호가 일치
		3	4개 번호가 일치
		4	3개 번호가 일치
		5	2개 번호가 일치
		6(낙첨)	그 외
	 */
	
	// 로또의 최고 순위와 최저 순위
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2]; // 0은 최고 등수, 1은 최저 등수
        
        int missing = 0;
        for(int i=0; i<lottos.length; i++){
        	if(lottos[i] == 0){
        		missing++;
        	} else {
        		for(int j=0; j<win_nums.length; j++){
        			if(lottos[i] == win_nums[j]){
        				answer[1] += 1;
        				break;
        			}
        		}
        	}
        	
        }
        
        answer[0] = answer[1] + missing; // 가장 많이 맞춘 경우
        
        
        answer[0] = answer[0] > 1 ? 6- answer[0] + 1 : 6;
        answer[1] = answer[1] > 1 ? 6- answer[1] + 1 : 6;
        
        System.out.println(answer[0]+ ", " + answer[1]);
         
        return answer;
    }
    
    /*
     * 다른 풀이
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		int count = 0;
		int tmp = 0;
		
		for(int i=0; i<lottos.length; i++){
			if(lottos[i] == 0) {
				count++;
			} else {
				map.put(lottos[i], true);
			}
		}
		
		for(int i=0; i<win_nums.length; i++){
			if(map.getOrDefault(win_nums[i], false)){
				tmp++;
			}
		}
		
		count + map : 최대 맞춘 갯수
		tmp : 최소 맞춘 갯수
     */

}
