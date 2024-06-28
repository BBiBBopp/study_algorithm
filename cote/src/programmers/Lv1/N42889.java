package programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
 * 실패율 : 스테이지에 도달하였지만 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
 * N 	: 전체 스테이지의 개수
 * stages : 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 
 * 
 * return : 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열
 * 			실패율이 낮으면 낮은 스테이지부터
 */
public class N42889 {
	public static void main(String[] args) {
		solution(4, new int[]{4, 4, 4, 4, 4});
	}

	// 실패율
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // [0]현재 스테이지에 머물러있는 플레이어 수  [1]스테이지에 도달한 플레이어 수
        double[][] failArr = new double[N][2]; 
        
        for(int i=0; i<stages.length; i++){
        	// 모든 스테이지를 깬 사람이 아닌 경우 
        	if(stages[i] < N+1)  failArr[stages[i]-1][0] += 1; // 현재 스테이지에 남아있는 사람 + 1
        		
        	for(int j=0; j<stages[i]; j++){
        		// 모든 스테이지를 깬 사람인 경우 j가 N까지 감 > outOfBoundary 오류 발생함
        		// j < N까지만 세야됨
        		if(j < N) failArr[j][1] += 1; // 스테이지에 도달한 사람
        	}
        }
        
        // [0]실패율 [1]스테이지 번호 
        for(int i=0; i<failArr.length; i++){
        	if(failArr[i][0] != 0.0){
        		failArr[i][0] /= failArr[i][1]; // 실패율
        	}
        	failArr[i][1] = i+1; // 스테이지 번호
        }
        
        // 실패율으로 stage 정렬하기 
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
        
      for( int i : stages) {	// stages를 list로 저장함
         list.add(i);
      }
      
      for(int i = 1; i<=N; i++) {
         double count = 0;
         double stage = list.size();
         
         for(int j = list.size()-1; j>=0;j--) { // 높은 스테이지부터 세기
        	if(list.get(j)==i) {  // 현재 스테이지인 경우
               list.remove(j); // stages에서 방문한 스테이지를 뺌
               count++; 
            }
         }
            
         rate = Double.isNaN(count/stage) ? 0.0 : count/stage; // 실패율 계산
            
         failRate[i-1][0] = (double)i; // 현재 스테이지
         failRate[i-1][1] = rate; // 실패율
         
      }
        
        Arrays.sort(failRate,new Comparator<Double[]>() {
         @Override
         public int compare(Double[] o1, Double[] o2) {
            return Double.compare(o2[1], o1[1]); // 실패율로 정렬
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
