package programmers.Lv1;

public class N133499 {

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"aya", "yee", "u", "maa"}));
	}
	
	 public static int solution(String[] babbling) {
        int answer = 0;
        
        // 내 풀이 [Start]
        String[] possible = new String[]{"aya", "ye", "woo", "ma"}; // 가능한 발음
        
        char prev; // 이전 발음
        char now;
        boolean flag;
        for(int i=0; i<babbling.length; i++){
        	for(int j=0; j<possible.length; j++){
        		// 가능한 발음의 인덱스로 대체
        		babbling[i] = babbling[i].replaceAll(possible[j], String.valueOf(j));
        	}
        	
        	prev = 'a';
        	flag = false;
        	for(int j=0; j<babbling[i].length(); j++){
        		now = babbling[i].charAt(j);
        		// now가 숫자가 아니면 false
        		
        		if('0' <= now && now <= '9' && prev != now) {
        			prev = now; 
        			flag = true;
        		} else {
        			flag = false;
        			break;
        		}
        	}
        	
        	if(flag){
    			answer++;
    		}
        }
        // 내 풀이 [End]
        
        // 다른 풀이 [Start]
        for(int i=0; i<babbling.length; i++){
        	babbling[i] = babbling[i].replaceAll("ayaaya|yeye|woowoo|mama", "1");
        	babbling[i] = babbling[i].replaceAll("aya|ye|woo|ma", "");
        	if(babbling[i].equals("")) answer++;
        }
        // 다른 풀이 [End]
        
        return answer;
    }

}
