package programmers.Lv1;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class hash {
	public static void main(String[] args) {
		int[] nums = {3,3,3,2,2,2};
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		System.out.println(solution(participant, completion));
		//System.out.println(solution(nums));
	}
	
	// 폰켓몬
	public static int solution(int[] nums) {
		/*
		 * 서로 다른 숫자의 갯수만 세면 되기 때문에 Map 사용할 필요 없음
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		
		int half = nums.length/2;
		int temp=0;
		for(int i=0; i<nums.length; i++){
			if(map.containsKey(nums[i])){
				temp = map.get(nums[i]);
				map.put(nums[i], temp++);
			} else {
				map.put(nums[i], 1);
			}
		}
		
		if(map.size() >= half){
			return half;
		} else {
			return map.size();
		}
		*/
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<nums.length; i++){
			set.add(nums[i]);
		}
		
		return nums.length/2 > set.size()? set.size() : nums.length/2;
		
	}
	
	// 완주하지 못한 선수
	public static String solution(String[] participant, String[] completion) {
        // 참가자, 완주한 선수 
        // set에 전체 참가자 넣기 > 동명이인이 있는 경우에 미완주자 식별 불가
        // 지워내기 
		String answer = "";

        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

        for(int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])){
                map.put(participant[i], map.get(participant[i]) + 1);
            } else {
                map.put(participant[i], 1);
            }
        }

        for(int i = 0; i < completion.length; i++) {
            if(map.containsKey(completion[i])) {
                if (map.get(completion[i]) == 1) {
                    map.remove(completion[i]);
                } else {
                    map.replace(completion[i], map.get(completion[i]) - 1);
                }
            }
        }

        Set<String> keySet = map.keySet();

        for (String key : keySet) {
            answer =  key;
        }

        return answer;
		/*
        ArrayList<String> plist = new ArrayList<>(Arrays.asList(participant));
        int index;
        for(int i=0; i<completion.length; i++){
        	index = plist.indexOf(completion[i]);
        	if(index >= 0) {
        		plist.remove(index);
        	}
        }
        
        return plist.get(0);
        */
    }
}
