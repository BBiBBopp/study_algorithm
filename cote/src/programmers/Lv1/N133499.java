package programmers.Lv1;

public class N133499 {

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"aya", "yee", "u", "maa"}));
	}
	
	 public static int solution(String[] babbling) {
        int answer = 0;
        
        // �� Ǯ�� [Start]
        String[] possible = new String[]{"aya", "ye", "woo", "ma"}; // ������ ����
        
        char prev; // ���� ����
        char now;
        boolean flag;
        for(int i=0; i<babbling.length; i++){
        	for(int j=0; j<possible.length; j++){
        		// ������ ������ �ε����� ��ü
        		babbling[i] = babbling[i].replaceAll(possible[j], String.valueOf(j));
        	}
        	
        	prev = 'a';
        	flag = false;
        	for(int j=0; j<babbling[i].length(); j++){
        		now = babbling[i].charAt(j);
        		// now�� ���ڰ� �ƴϸ� false
        		
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
        // �� Ǯ�� [End]
        
        // �ٸ� Ǯ�� [Start]
        for(int i=0; i<babbling.length; i++){
        	babbling[i] = babbling[i].replaceAll("ayaaya|yeye|woowoo|mama", "1");
        	babbling[i] = babbling[i].replaceAll("aya|ye|woo|ma", "");
        	if(babbling[i].equals("")) answer++;
        }
        // �ٸ� Ǯ�� [End]
        
        return answer;
    }

}
