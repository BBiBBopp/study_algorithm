package backjun.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B17202 {
	public static final int phone = 8;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrA = br.readLine().split("");
		String[] arrB = br.readLine().split("");
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		// �޴�����ȣ ����(ABAB..)
		for(int i=0; i<phone;i++){
			arr.add(Integer.parseInt(arrA[i]));
			arr.add(Integer.parseInt(arrB[i]));
		}
		
		int i = 0;
		int arrSize = arr.size();
		while(arr.get(2) != -1){ // �� ���� ���ڸ� ���������� �ݺ�
			if(i < arrSize -1){
				arr.set(i, (arr.get(i) + arr.get(i+1)) % 10 ); // ���� �ε����� (���� + ����) % 10 �Է�
				i++;
			} else {
				arr.set(i, -1); // ��� �Ϸ��� ������ �ε����� -1 �Է�
				i = 0; // �ݺ��� �ʱ�ȭ
				arrSize--; // �迭 ������ ����
			}
		}
		
        System.out.println(arr.get(0) + "" + arr.get(1));
        
	}
}
