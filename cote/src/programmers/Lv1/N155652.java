package programmers.Lv1;
/*
 * s�� �� ���ĺ��� index��ŭ ���� ���ĺ����� �ٲ���
 * index��ŭ ���� ���ĺ��� z�� �Ѿ ��� �ٽ� a��
 * skip�� �ִ� ���ĺ��� �����ϰ� �ǳʶٱ� 
 */
public class N155652 {
	public static void main(String[] args) {
		System.out.println(solution("ybcde", "az", 1));
		
	}
	
	// �Ѹ��� ��ȣ
	public static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        char a;
        for(int i=0; i<s.length(); i++){
        	// �ƽ�Ű�ڵ�  a~z : 97~122
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