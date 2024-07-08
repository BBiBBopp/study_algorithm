package programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class N250121 {

    // data [code, date, maximum, remain]
    // ext : ���� ���� 
    // val_ext : ���� ���ذ� (���� ���� ��)
    // sort_by : ���� ���� (��������)
    
	public static void main(String[] args) {
		int[][] data = new int[][] {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
		String ext = "date";
		int val_ext = 20300501;
		String sort_by = "remain";
		
		solution(data, ext, val_ext, sort_by);
	}
	
	static int val_index;
	public static ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<String> val_data = new ArrayList<>(Arrays.asList("code", "date", "maximum", "remain"));
        val_index = val_data.indexOf(ext);
        
        ArrayList<int[]> dataList = new ArrayList<>();
        for(int i=0; i<data.length; i++){
        	if(data[i][val_index] < val_ext){
        		dataList.add(data[i]);
        	}
        }
        
        val_index = val_data.indexOf(sort_by);
        Collections.sort(dataList, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[val_index] - o2[val_index];
			}
        });
        
        return dataList;
    }

	
	
}

/*
 * Arrays.sort (�迭), Collections.sort (����Ʈ) ���� ���� ���� �����ϱ�
  
   Collections.sort(sort_data, new Comparator<int[]>() {
  		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[val_index] - o2[val_index];
		}
   }
  
  -> return ���� 0�̳� ������ �ڸ��ٲ��� ���� �ʰ�, ����� �ڸ��ٲ��� ������
     o1�� o2���� ũ�� �ڸ��ٲ� > �������� ����
  
  -- 
  * ���� �迭�� �ƴ� ��� ���� ���� : Collections.reverseOrder
 */