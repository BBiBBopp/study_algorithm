package programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
		solution(4, new int[]{4, 4, 4, 4, 4});
	}

	// ������
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // [0]���� ���������� �ӹ����ִ� �÷��̾� ��  [1]���������� ������ �÷��̾� ��
        double[][] failArr = new double[N][2]; 
        
        for(int i=0; i<stages.length; i++){
        	// ��� ���������� �� ����� �ƴ� ��� 
        	if(stages[i] < N+1)  failArr[stages[i]-1][0] += 1; // ���� ���������� �����ִ� ��� + 1
        		
        	for(int j=0; j<stages[i]; j++){
        		// ��� ���������� �� ����� ��� j�� N���� �� > outOfBoundary ���� �߻���
        		// j < N������ ���ߵ�
        		if(j < N) failArr[j][1] += 1; // ���������� ������ ���
        	}
        }
        
        // [0]������ [1]�������� ��ȣ 
        for(int i=0; i<failArr.length; i++){
        	if(failArr[i][0] != 0.0){
        		failArr[i][0] /= failArr[i][1]; // ������
        	}
        	failArr[i][1] = i+1; // �������� ��ȣ
        }
        
        // ���������� stage �����ϱ� 
        Arrays.sort(failArr, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return o1[0] != o2[0] ? Double.compare(o2[0], o1[0]) : Double.compare(o1[1], o2[1]);
			}
        });
        
        for(int i=0; i<failArr.length; i++){
        	if(failArr[i][1] != N+1){
        		answer[i] = (int) failArr[i][1];
        		System.out.println(answer[i]);
        	}
        }
        
        return answer;
    }
	
	public int[] MYsolution(int N, int[] stages) {
      Double[][] failRate = new Double[N][2];
      List<Integer> list = new ArrayList<>();
      int[] answer = new int[N];
      Double rate = 0.0;
        
      for( int i : stages) {	// stages�� list�� ������
         list.add(i);
      }
      
      for(int i = 1; i<=N; i++) {
         double count = 0;
         double stage = list.size();
         
         for(int j = list.size()-1; j>=0;j--) { // ���� ������������ ����
        	if(list.get(j)==i) {  // ���� ���������� ���
               list.remove(j); // stages���� �湮�� ���������� ��
               count++; 
            }
         }
            
         rate = Double.isNaN(count/stage) ? 0.0 : count/stage; // ������ ���
            
         failRate[i-1][0] = (double)i; // ���� ��������
         failRate[i-1][1] = rate; // ������
         
      }
        
        Arrays.sort(failRate,new Comparator<Double[]>() {
         @Override
         public int compare(Double[] o1, Double[] o2) {
            return Double.compare(o2[1], o1[1]); // �������� ����
         }
      });
      
      double tmp;
      
      for (int i = 0; i < failRate.length; i++) {
         tmp = failRate[i][0]; 
            answer[i] = (int) tmp; 
        }
        
        return answer;
    }

}
