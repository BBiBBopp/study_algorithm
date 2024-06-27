package language.java;

import java.util.HashMap;
import java.util.Map.Entry;

public class deepCopy {
	public static void main(String[] args) {
		HashMap<String, String> origMap = new HashMap<String, String>();
		origMap.put("TITLE", "����");
		
		System.out.println("���� Map : " + origMap.toString());
		System.out.println("=============");
		
		
		// ���� ���� (Shallow copy) : �ּҰ� ���� (�����ϰ��ִ� ���� ���� ������)
		HashMap<String, String> shallowCopy = origMap;
		origMap.put("CONTENT", "����");
		System.out.println("���� Map : " + origMap.toString());
		System.out.println("���� ���� Map : " + shallowCopy.toString());
		System.out.println("=============");
		
		// ���� ����(deep copy) : ���� ���� ���ο� �޸� ������ ����
		// 1. �����ڸ� �̿��� ����
		HashMap<String, String> copyMap = new HashMap<String, String>(origMap);
		System.out.println("���� Map : " + origMap.toString());
		System.out.println("������ ���� Map : " + copyMap.toString());
		System.out.println("=============");
		
		// 2. clone()�� �̿��� ����
		HashMap<String, String> cloneMap = (HashMap<String, String>)origMap.clone();
		System.out.println("���� Map : " + origMap.toString());
		System.out.println("clone ���� : " + cloneMap.toString());
		System.out.println("=============");
		
		// 3. putAll()�� �̿��� ����
		HashMap<String, String> putMap = new HashMap<String, String>();
		putMap.putAll(origMap);
		
		System.out.println("���� Map : " + origMap.toString());
		System.out.println("putAll ���� : " + putMap.toString());

		// Map.Entry �� �̿��� ����
		HashMap<String, String> entryMap = new HashMap<String, String>();
		
		for (Entry<String, String> entry : origMap.entrySet()) {
			entryMap.put(entry.getKey(), entry.getValue());
		}
		origMap.put("WRITER", "ȫ�浿");
		System.out.println("���� Map : " + origMap.toString());
		System.out.println("Map.Entry : " + entryMap.toString());
	}
}
