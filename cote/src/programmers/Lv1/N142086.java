package programmers.Lv1;

public class N142086 {
	public static void main(String[] args) {
		solution("foobar");
	}
	
	public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        String c;
        String substr;
        for(int i=0; i<s.length(); i++){
        	c = String.valueOf(s.charAt(i));
        	substr = s.substring(0, i); // substring(�����ε���, ������ �ε���) : ������ �ε��� ������ �߶���
        	
        	answer[i] = ((!substr.isEmpty() && substr.contains(c)) ? (substr.length() - substr.lastIndexOf(c)) : -1);
        	
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
}
