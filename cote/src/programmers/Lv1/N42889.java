package programmers.Lv1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

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
		System.out.println(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}).toString());
	}

	// 실패율
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
        
        // 실패함 
        
        
        
              
        
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
