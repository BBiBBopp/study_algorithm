package sparta.lv3;

import java.util.Arrays;
import java.util.Comparator;

/*
[문자열 내 마음대로 정렬하기]
문자열로 구성된 strings와 정수 n이 주어졌을 때,
각 문자열의 인덱스 n번째 글자 기준 오름차순 정렬

strings	                n	 return
["sun", "bed", "car"]	1  : ["car", "bed", "sun"]
["abce", "abcd", "cdx"]	2  : ["abcd", "abce", "cdx"]
 */
public class StringSort {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};

        // 1) 사전순 정렬
        Arrays.sort(strings);

        // 2) n번째 문자 기준 정렬
        Arrays.sort(strings, Comparator.comparingInt(s -> s.charAt(n)));

        return strings;
    }

/*
[정렬 알고리즘]
0. 정렬 시 고려사항
- 시간 복잡도
- 메모리 사용량
- 안정성(stability)
  데이터에 동일한 키(값)을 가진 원소가 있을 때, 정렬이나 선택 과정이 끝난 후에도 그들의 상대적인 순서가 유지되는 여부
  ex)
  (값, 라벨)
  (5, A), (3, B), (5, C), (2, D)
  * 값을 기준으로 정렬한다고 할 때, (5, A), (5, C)는 같은 값
  * 안정성이 유지되는 정렬이라면 결과에서 (5, A)가 (5, C)보다 앞에 남아야 함
- 직렬 vs 병렬

| 알고리즘  | 평균 시간복잡도 | 최악 시간복잡도 | 안정성 | 특징           |
| ------- | -----------| ---------- | ------- | ------------ |
| 버블 정렬 | O(n²)      | O(n²)      | ✅ 안정 | 구현 간단        |
| 선택 정렬 | O(n²)      | O(n²)      | ❌ 불안 | 교환 횟수 적음     |
| 삽입 정렬 | O(n²)      | O(n²)      | ✅ 안정 | 거의 정렬된 경우 빠름 |
| 병합 정렬 | O(n log n) | O(n log n) | ✅ 안정 | 추가 메모리 필요    |
| 퀵 정렬   | O(n log n) | O(n²)      | ❌ 불안 | 평균적으로 가장 빠름  |
| 힙 정렬   | O(n log n) | O(n log n) | ❌ 불안 | 메모리 효율적      |

6. 힙 정렬(Heap sort)
- 힙 자료구조 사용. 최대 힙을 만들어서 루트(최대값)을 꺼내 정렬, 안정성 보장 X
- 추가 메모리 거의 필요 없음
- 시간 복잡도 : O(n log n)
 */

    /**
     * 1. 선택 정렬(Selection Sort)
     * - 선택된 값과 나머지 데이터 중 비교, 안정성 보장 X
     * - 시간복잡도 : O(n^2) , worst, average, best 모두 동일
     */
    void SelectionSort(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            // i번째 이후에서 가장 작은 원소의 인덱스 찾기
            int minIndex = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            // i번째 원소와 가장 작은 원소 교환
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

    }

    /**
     * 2. 삽입 정렬(Insertion Sort)
     * - 데이터 집합을 순회하면서 정렬이 필요한 요소를 뽑아내어 이를 다시 적당한 곳으로 삽입
     *   (이미 정렬된 데이터와 새로운 데이터 비교, 성능은 버블정렬보다 좋음)
     * - 시간복잡도 : worst, average : o(n^2) , best : O(n) (이미 정렬되어 있는 경우)
     */
    void InsertionSort(int[] arr){
        int n = arr.length;

        for(int i=1; i<n; i++){
            int key = arr[i]; // 삽입할 값
            int j = i-1;

            // key값보다 큰 값을 한 칸씩 뒤로 밀기
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }

            // 빈 자리에 key삽입
            arr[j+1] = key;
        }
    }

    /**
     * 3. 버블 정렬
     * - 거품이 수면으로 올라오듯 하여 붙여진 이름, 인접한 두 수를 비교, 안정성 보장
     *  (가장 큰 수를 가장 뒤로 밀어냄)
     * - 시간복잡도 : O(n^2) , worst, average, best 모두 동일
     */
    void BubbleSort(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            // 한 바퀴에서 swap이 일어났는지 체크
            boolean swapped = false;

            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    // 인접한 두 원소 교환
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swapped = true;
                }
            }

            // 만약 교환이 한 번도 안 일어났다면 이미 정렬된 상태 -> 종료
            if(!swapped) break;
        }
    }

    /**
     * 4. 병합 정렬(Merge Sort)
     * - 분할 정복(Divide & Conquer). 배열을 반씩 나눠서 정렬 후 합침, 안정성 보장
     * - 추가 메모리 필요
     * - 시간 복잡도 : O(n log n)
     *
     * 사용 방법 : mergeSort(arr, 0, arr.length - 1)
     */
    void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left+right)/2;

            mergeSort(arr, left, mid); // 왼쪽 분할
            mergeSort(arr, mid+1, right); // 오른쪽 분할

            merge(arr, left, mid, right);
        }
    }

    void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++){
            L[i] = arr[left+i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[mid+j+1];
        }

        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2){
            if(L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while(i < n1){
            arr[k++] = L[i++];
        }
        while(j < n2){
            arr[k++] = R[j++];
        }
    }

    /**
     * 5. 퀵 정렬(Quick sort)
     * - 분할 정복. 하나의 피벗(pivot)을 기준으로 작은 값을 왼쪽, 큰 값을 오른쪽으로 분할, 안정성 보장 X
     * - 실제로는 가장 빠른 정렬 중 하나라 많이 사용됨
     * - 시간 복잡도 : 평균 O(n log n), 최악 O(n^2)
     *
     * 사용 방법 : quickSort(arr, 0, arr.length - 1);
     */
    void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            
            quickSort(arr, low, pi-1); // 왼쪽 파티션
            quickSort(arr, pi+1, high); // 오른쪽 파티션
        }
    }

    int partition(int[] arr, int low, int high){
        int pivot = arr[high]; // 마지막 원소를 피벗으로 선택
        int i = low - 1;

        for(int j=low; j<high; j++){
            if(arr[j] <= pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


}
