package programmers.Lv1;

public class N140108 {
	public static void main(String[] args) {
		System.out.println(solution("abracadabra"));
	}
	
	public static char x;
	public static int xCount;
	public static int notXCount;
	
	public static int solution(String s) {
        int answer = 0;
        
        // �� Ǯ�� [Start]
        init(s);
        
        for(int i=0; i<s.length(); i++){
        	if(x == s.charAt(i)){
        		xCount++;
        	} else {
        		notXCount++;
        	}
        	
        	if(xCount == notXCount) {
        		answer++;
        		if(i+1 < s.length()) init(s.substring(i+1));
        	} else if(i+1 == s.length()){ // ������ ���ڿ� ó��
        		answer++;
        	}
        }
        // �� Ǯ�� [End]
        
        
        // �ٸ� Ǯ�� [Start]
        char init = '1';
        int count = 0;
        for(char c : s.toCharArray()){
        	if(init == '1'){
        		init = c;
        		count++;
        		answer++;
        	} else if(init == c){
        		count++;
        	} else {
        		count--;
        	}
        	
        	if(count == 0){
        		init = '1';
        		count = 0;
        	}
        }
        // �ٸ� Ǯ�� [End]
        
        return answer;
    }
	
	public static void init(String s){
		x = s.charAt(0);
		xCount = 0;
		notXCount = 0;
	}

}
