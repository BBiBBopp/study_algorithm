package backjun.bronze;
/*
 * ���� N, ���� M, ���� �������ִ� ��� B
 * ��� ���� 2��, ��� �߰� 1��
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
		
		// key : ����� ����, value : ���� ������ �� ����
		HashMap<Integer, Integer> heightMap = new HashMap<Integer, Integer>();
		// 0 : Ÿ�� ����� ����, 1 : Ÿ�� ����� ����
		int[] targetArr = new int[2];
		targetArr[1] = 0;
		
		for(int i=0; i<land.length; i++){
			for(int j=0; j<land[i].length; j++){
				land[i][j] = sc.nextInt();
			}
		}
		
		// 1. ��ǥ�� �� ���� ã��
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
		
		// �ٸ� ��ϵ�� ��ǥ ������ ���� ���ϱ�
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
			
			// �ʿ��� ����� ���� �κ��丮�� �������ִ� ��Ϻ��� ���� ���, ��ǥ ���̸� ����
			if(needBlock > B) {
				targetHeight -= 1;
			}
		} while (old != targetHeight);
		
		// ��ǥ���̰� ����� ��� �ɸ��� �ð� �߰�
		if(targetHeight != targetArr[0]){
			sec = 2*targetArr[1];
		}
		
		// ���� ���ߴµ� �ɸ��� �ð� ���
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
