package backjun.gold;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
 * ���� ä�� 100
 * 1 : �̵��Ϸ��� ä��
 * 2 : ���峭 ��ư ����
 * 3 : ���峭 ��ư ��ȣ 
 * 
 * 
 */
public class B1107 {
	public static void main(String[] args) {
		int now = 100;
		
		Scanner sc = new Scanner(System.in);
		
//		String tobe = Integer.toString(sc.nextInt());
		int toInt = sc.nextInt();
		int brokenNumber = sc.nextInt();
		Set<Integer> numberSet = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		
//		int[] numbers = new int[brokenNumber];
		
		for(int i=0; i<brokenNumber; i++){
//			numbers[i] = sc.nextInt();
			numberSet.remove(sc.nextInt());
		}
		
		StringBuilder sb = new StringBuilder();
//		if(Integer.parseInt(tobe) == 100){
		if(toInt == 100){
			System.out.println(0);
		} else {
			// ���� ���ڵ��� �������� tobe�� ���� ����� ���� �����
			int rest;
			int sum=0;
			for(int i=0; i<Integer.toString(toInt).length(); i++){
				sum++;
				if(toInt > 10) {					
					rest = toInt % 10;
					if(numberSet.contains(rest)){
						
					}
						
					toInt = toInt / 10;
				}
				
			}
			/*
			for(int i=0; i<tobe.length(); i++){
				if(numberSet.contains(Character.getNumericValue(tobe.charAt(i)))){
					sb.append(tobe.charAt(i));
				} else {
					
				}
			}
			*/
			
			
		}
		
	}
}
