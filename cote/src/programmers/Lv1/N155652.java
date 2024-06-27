package programmers.Lv1;
/*
 * s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줌
 * index만큼 뒤의 알파벳이 z를 넘어갈 경우 다시 a로
 * skip에 있는 알파벳은 제외하고 건너뛰기 
 */
public class N155652 {
	public static void main(String[] args) {
		System.out.println(solution("ybcde", "az", 1));
		
	}
	
	// 둘만의 암호
	public static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        char a;
        for(int i=0; i<s.length(); i++){
        	// 아스키코드  a~z : 97~122
        	a = s.charAt(i);
        	
        	for(int j=0; j<index; j++){
        		a += 1;
        		
        		if(a>'z') a-=26;
        		
        		if(skip.contains(String.valueOf(a))){
        			j--;
        		}
        	}

        	sb.append(a);
        }
       
        return sb.toString();
    }
}