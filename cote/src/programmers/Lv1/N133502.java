package programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class N133502 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 1, 1}));
	}
	
	
	// 1: �� , 2: ��ä, 3: ��� 
	
	public static int solution(int[] ingredients) {
        int answer = 0;
        
        /*
         * �ð� �ʰ�
         * 
        for(int i=0; i<ingredients.length; i++){
        	sb.append(ingredients[i]);
        }
        
        String stringI = sb.toString();
        while(stringI.contains("1231")){
        	stringI = stringI.replaceFirst("1231", "");
        	answer++;
        }
        */
        
        // �����ڵ� - StringBuilder [Start]
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ingredients.length; i++){
        	sb.append(ingredients[i]);
        	
        	if(sb.length() > 3 && sb.subSequence(sb.length()-4, sb.length()).equals("1231")){
        		answer++;
        		sb.delete(sb.length()-4, sb.length());
        	}
        	
        }
        // �����ڵ� - StringBuilder [End]
       
        // �����ڵ� - stack [Start]
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> burger = new ArrayList<>(Arrays.asList(1, 2, 3, 1));
        for(int i=0; i<ingredients.length; i++){
       		stack.add(ingredients[i]);
       		if(stack.size() > 3 && stack.subList(stack.size()-4, stack.size()).equals(burger)){
       		// [�ð��ʰ�] if(stack.size() > 3 && stack.toString().contains("1, 2, 3, 1")) {
       			stack.pop();
       			stack.pop();
       			stack.pop();
       			stack.pop();
       			answer++;
       		}
        }
        // �����ڵ� - stack [End] 
        
        return answer;
    }
	
	/*
	 * https://programmer-may.tistory.com/154
	 * 
	 * < String >
	 * 
	 * �� +, += ����
	 * + , += �� ����ϴ� ���, + �� ������ ���ο� ��ü�� ���� ������ ������ (������ ������ ������ �ƴ� ���ο� ���ͷ� �߰�)
	 * �ð����⵵ : O(���� ���ڿ��� ���� + ���Ϸ��� ���ڿ��� ����)
	 * 
	 * ����)
	   public void sumString() {
	        String str = "";
	        int n = 1000000;
	        for(int i = 0; i < n; i++){
	        	s += "A"; 
 	        }
	    }
	    
	    > �ҿ� �ð� : (s�� ���� + "A" �� ����) * N
	    > N*(N+1)/2 * N  ( N*(N+1)/2 �� 1���� N������ �� )
	    > O(N^3)
	    
	 * �� replace();
	 * �ð����⵵ : O(���ڿ��� ���� * (��ü�� ���ڿ��� ���� + ��ü�Ǵ� ���ڿ��� ����/��ü�� ���ڿ��� ����))
	 * 
	 * ����)
	   str.replace(a, b)
	   
	   > �ҿ� �ð� : O(len(str) * (len(a) + len(b)/len(a)))
	      ���ڿ� str�� ���̸�ŭ ��ü���� ���ڿ��� �ϳ��� Ž���ϰ�, ��ü�� ���ڿ��� ���̸�ŭ �������� Ž���ؼ� ��ü�ؾ��ϴ� ���ڿ����� �ƴ����� �Ǻ���
	      ��ü�ؾ� �ϴ� ���, ��ü�Ǵ� ���ڿ��� ���̿� ���� �߰� ����
	   1) ��ü�Ǵ� ���ڿ��� ���� == ��ü�� ���ڿ��� ���� 
	            ��ü�Ǵ� ���ڿ��� ���̸�ŭ ���� ���� : O(len(b)/len(a)) = O(1)
	   2) ��ü�Ǵ� ���ڿ��� ���� > ��ü�� ���ڿ��� ����
	            �ʰ��� ���̸�ŭ �� ��ġ�� ����� ��ü ���� : O(len(b)/len(a)) ��ŭ�� �߰� ���� �ҿ�

	 * < StringBuilder >
	 * �� append();
	 * �ð����⵵ : O(N)
	 * 
	 * ����)
	   public void sumString() {
	        StringBuider sb = new StringBuider();
	        int n = 1000000;
	        for(int i = 0; i < n; i++){
	        	sb.append("A"); 
 	        }
	    }
	    
	    > �ҿ� �ð� 
	    sb.append("A") �� �ð����⵵  O(1) 
	    > ��ü �ҿ�ð�  O(N) 
	 * 
	 * 
	 * 
	 */

}
