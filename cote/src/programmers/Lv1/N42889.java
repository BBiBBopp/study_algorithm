package programmers.Lv1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/*
 * 5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
 * ������ : ���������� �����Ͽ����� Ŭ�������� ���� �÷��̾� �� / ���������� ������ �÷��̾� ��
 * N 	: ��ü ���������� ����
 * stages : ������ �̿��ϴ� ����ڰ� ���� �����ִ� ���������� ��ȣ�� ��� �迭 
 * 
 * return : �������� ���� ������������ ������������ ���������� ��ȣ�� ����ִ� �迭
 * 			�������� ������ ���� ������������
 */
public class N42889 {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}).toString());
	}

	// ������
	public static ArrayList<Integer> solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] arr = new double[N+1];
        
        for(int i=0; i<stages.length; i++){
        	arr[stages[i]-1] += 1;
        }
        
        int clear = 0;
        for(int i=0; i<N; i++){
        	for(int j=N; j>=i; j--){
        		clear += arr[j];
        	}
        	
        	arr[i] = arr[i]/clear;
        }
        
        // ������ 
        
        
        
              
        
        HashMap<Integer, Integer> failMap = new HashMap<>();
        for(int i=0; i<N; i++){
        	failMap.put(i+1, 0);
        }
        
        for(int i=0; i<stages.length; i++){
        	if(stages[i] <= N){
        		failMap.put(stages[i], failMap.get(stages[i]) + 1);
        	} else {
        		
        	}
        }
        
        ArrayList<Integer> keySet = new ArrayList<>(failMap.keySet());
        keySet.sort(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				if(failMap.get(o1).compareTo(failMap.get(o2)) == 0){
					return o1.compareTo(o2);
				} else {
					return failMap.get(o1).compareTo(failMap.get(o2));
				}
			}
        });
        
        return keySet;
    }
}
