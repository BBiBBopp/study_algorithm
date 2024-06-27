package backjun.bronze;
/*
 * 세로 N, 가로 M, 현재 가지고있는 블록 B
 * 블록 제거 2초, 블록 추가 1초
 */

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class B18111 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int B = sc.nextInt();
		
		int sec = 0;
		int targetHeight = 0;
		
		int[][] land = new int[H][W];
		
		// key : 블록의 높이, value : 같은 높이의 블럭 개수
		HashMap<Integer, Integer> heightMap = new HashMap<Integer, Integer>();
		// 0 : 타겟 블록의 높이, 1 : 타겟 블록의 갯수
		int[] targetArr = new int[2];
		targetArr[1] = 0;
		
		for(int i=0; i<land.length; i++){
			for(int j=0; j<land[i].length; j++){
				land[i][j] = sc.nextInt();
			}
		}
		
		// 1. 목표가 될 높이 찾기
		for(int[] blocks : land){
			for(int block : blocks){
				if(heightMap.get(block) == null){
					heightMap.put(block, 1);
				} else {					
					heightMap.put(block, heightMap.get(block) + 1);
				}
				
				if(heightMap.get(block) > targetArr[1]) {
					targetArr[0] = block;
					targetArr[1] = heightMap.get(block);
				}
			}
		}
		
		// 다른 블록들과 목표 높이의 차이 구하기
		int needBlock;
		int old;
		targetHeight = targetArr[0];
		
		do {
			needBlock = 0;
			old = targetHeight;
			for(Entry<Integer, Integer> entry : heightMap.entrySet()){
				if(entry.getKey() != targetHeight){
					if(entry.getKey() < targetHeight){
						needBlock += entry.getValue();
					}
				}
			}
			
			// 필요한 블록의 수가 인벤토리에 가지고있는 블록보다 많은 경우, 목표 높이를 낮춤
			if(needBlock > B) {
				targetHeight -= 1;
			}
		} while (old != targetHeight);
		
		// 목표높이가 변경된 경우 걸리는 시간 추가
		if(targetHeight != targetArr[0]){
			sec = 2*targetArr[1];
		}
		
		// 높이 맞추는데 걸리는 시간 계산
		for(Entry<Integer, Integer> entry : heightMap.entrySet()) {
			if(entry.getKey() != targetArr[0]) {
				if(entry.getKey() > targetHeight) {
					sec += 2*entry.getValue();
				} else if(entry.getKey() < targetHeight){
					sec += entry.getValue();
				}
			}
		}
		
		System.out.println(sec + " " + targetHeight);
	}
}
