package backjun.gold;
/*
 * 1. �ֻ�����带 0�� ���� �����ϰ� ���� ��忡 ���ڸ� �Ű� �Է� > ����� �Է� ������ ����� ��ȣ��, 0�� ��尡 �׻� �ֻ�����尡 �ƴ� �� ����
 * 2. ��Ʈ��尡 ��������� �� ����
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

public class B1068 {
	/*
	 * Ǯ�� 2
	 * target�� �������ִ� parent���� target ����
	 * �ֻ��������� ���̿켱Ž������ ������� ã��(Ÿ�ٳ���� ������ ����ξ����Ƿ� Ÿ�� ���� ��� ���� �Ұ�)
	 */
	static HashMap<Integer, ArrayList<Integer>> nodeMap;
	static int count;
	static int root;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		nodeMap = new HashMap<>();
		ArrayList<Integer> tempArr;

		// 1. ��� �߰�
		int parent;
		for(int i=0; i<N; i++){
			parent = sc.nextInt();
			if(parent == -1){
				root = i;
			} else {
				if(Objects.isNull(nodeMap.get(parent))) {
					tempArr = new ArrayList<>();
					tempArr.add(i);
					nodeMap.put(parent, tempArr);
				} else {
					tempArr = nodeMap.get(parent);
					tempArr.add(i);
					nodeMap.put(parent, tempArr);
				}
			}
		}
		
		int target = sc.nextInt();
		
		System.out.println("targetIndex : " + target);
		System.out.println("root : " + root);
		
		for(Entry entry : nodeMap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		count = 0;
		// 2. target�� value�� �������ִٸ� ����
		if(target != root){
			for(Entry entry : nodeMap.entrySet()){
				tempArr = nodeMap.get(entry.getKey());
				if(tempArr.contains(target)){
					tempArr.remove(tempArr.indexOf(target));
					nodeMap.put((Integer) entry.getKey(), tempArr);
					break;
				}
			}
			
			System.out.println("==");
			for(Entry entry : nodeMap.entrySet()){
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			
			// 3. �����ִ� ��� �� ������� ���� ����
			count(root);
		}
		
		System.out.println("���� : " + count);
	}
	
	public static void count(int parent){
		if(Objects.isNull(nodeMap.get(parent)) || nodeMap.get(parent).size() == 0){
			count++;
		} else {
			for(int i : nodeMap.get(parent)){
				count(i);
			}
		}
	}
	
	/* Ǯ�� 1
	 * target���, ���� ��� ����
	 * target�� �������ִ� parent���� target ����
	 * map�� ��ü ��� Ž���Ͽ� ������� ã��(target, target���� ��� �����Ͽ����Ƿ� ��ü ��� Ž�� ����)
	static HashMap<Integer, ArrayList<Integer>> nodeMap;
	static int count;
	static int root;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		nodeMap = new HashMap<>();
		ArrayList<Integer> tempArr;

		// 1. �θ���� ����Ǿ��ִ� ���� ��� �߰�
		int parent;
		for(int i=0; i<N; i++){
			parent = sc.nextInt();
			if(parent == -1){
				root = i;
			} else {
				if(Objects.isNull(nodeMap.get(parent))) {
					tempArr = new ArrayList<>();
					tempArr.add(i);
					nodeMap.put(parent, tempArr);
				} else {
					tempArr = nodeMap.get(parent);
					tempArr.add(i);
					nodeMap.put(parent, tempArr);
				}
			}
		}
		
		int target = sc.nextInt();
		
		System.out.println("targetIndex : " + target);
		System.out.println("root : " + root);
		
		for(Entry entry : nodeMap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		removeNode(target);
		// 3. target�� value�� �������ִٸ� ����
		for(Entry entry : nodeMap.entrySet()){
			tempArr = nodeMap.get(entry.getKey());
			if(tempArr.contains(target)){
				tempArr.remove(tempArr.indexOf(target));
				nodeMap.put((Integer) entry.getKey(), tempArr);
				break;
			}
		}
		
		System.out.println("==");
		for(Entry entry : nodeMap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		count = 0;
		// 4. �����ִ� ��� �� ������� ���� ����
		for(Entry entry : nodeMap.entrySet()){
			tempArr = nodeMap.get(entry.getKey());
			if(tempArr.size() == 0){ // ���� ��尡 ���� ���
				count++;
			} else {
				for(int node : tempArr){
					if(Objects.isNull(nodeMap.get(node))){
						count++;
					}
				}
			}
		}

		System.out.println("���� : " + count);
	}
	
	// 2. Ÿ�� ��� ����, Ÿ�� ��� ���� ����
	public static void removeNode(int target){
		if(!Objects.isNull(nodeMap.get(target))){
			for(int i : nodeMap.get(target)){
				removeNode(i);
			}
		}
		
		nodeMap.remove(target);
	}
	*/
}
