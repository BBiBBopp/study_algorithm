package programmers.Lv1;

import java.util.HashMap;

public class N77484 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]

	}
	
	/*
	 	1	6�� ��ȣ�� ��� ��ġ
		2	5�� ��ȣ�� ��ġ
		3	4�� ��ȣ�� ��ġ
		4	3�� ��ȣ�� ��ġ
		5	2�� ��ȣ�� ��ġ
		6(��÷)	�� ��
	 */
	
	// �ζ��� �ְ� ������ ���� ����
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2]; // 0�� �ְ� ���, 1�� ���� ���
        
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
        
        answer[0] = answer[1] + missing; // ���� ���� ���� ���
        
        
        answer[0] = answer[0] > 1 ? 6- answer[0] + 1 : 6;
        answer[1] = answer[1] > 1 ? 6- answer[1] + 1 : 6;
        
        System.out.println(answer[0]+ ", " + answer[1]);
         
        return answer;
    }
    
    /*
     * �ٸ� Ǯ��
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
		
		count + map : �ִ� ���� ����
		tmp : �ּ� ���� ����
     */

}
