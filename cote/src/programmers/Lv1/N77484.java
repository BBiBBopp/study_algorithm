package programmers.Lv1;

public class N77484 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
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

}
