package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C09Array {
    public static void main(String[] args)throws IOException {
//        배열표현식 1. 배열 선언 후 값 할당 방식
//        자바의 배열은 반드시 사전에 길이가 결정되어야 함.
//        boolean -> false로 초기화. 참조자료형 ->null로 초기화
//        int[]arr1 = new int[]; -> 허용 안됨
//        int[] arr1 = new int[5];
//        arr1[0] = 10;
//        arr1[1] = 20;
////        int 배열의 경우-> 0으로 초기화.
//        arr1[3] = 40;
//        arr1[4] = 50;
////        arr1[5]=60; index out of bounds 예외발생
//
////        배열표현식 2. 리터럴 방식
//        int[] arr2 = {10,20,30,40,50};
//
////        배열표현식 3. 명시적 배열 생성방식
//        int[] arr3 = new int[]{10,20,30,40,50}; //BFS,DFS 알고리즘 풀때 이 배열 많이 사용함
//
////        배열표현식 3. 활용예시 : 배열을 다른메서드의 매개변수로 사용할 경우.
//        List<int[]> myList = new ArrayList<>();
//        myList.add(new int[3]);
//        myList.add(new int[]{10,20,30,40,50});
////        myList.add({10,20,30,40,50});   //사용불가(배열인지 아닌지 확인불가)

////        85,65,90으로 구성된 int배열을 선언하고, 총합과 평균을 구하시오
//        int[]arr1 = new int[3];
//        arr1[0] = 85;
//        arr1[1] = 65;
//        arr1[2] = 90;
//        int sum = 0;
//
//        for(int i=0;i<arr1.length;i++){
//            sum += arr1[i];
//        }
//        double avg = (double) sum/ arr1.length;
//        System.out.println(sum);
//        System.out.println(avg);

////        배열의 최대값, 최소값
//        int[] arr = {10,20,30,12,8,17};
////        최대값을 구할때는 가장 작은값을 설정
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]>max){
//                max=arr[i];
//            }
//            if(arr[i]<min){
//                min=arr[i];
//            }
//        }
//        System.out.println(max);
//        System.out.println(min);

////        배열의 자리바꾸기
//        int[] arr = {20,10,30};
//        int temp = arr[0];
//        arr[0] = arr[1];
//        arr[1] = temp;

////        배열뒤집기 (너무 헷갈려서 자주보기)
//        int[] arr = {10,20,30,40,50};
//        int[] newArr = new int[arr.length];
//        for(int i=0;i<arr.length;i++){
//            newArr[arr.length-i-1] = arr[i];
//        }
//        System.out.println(Arrays.toString(newArr));

//        int index=0;
//        for(int i=arr.length-1;i>=0;i--){
//            newArr[index] = arr[i];
//            index++;
//        }

//        배열의 정렬
//        String[] stArr = {"abc","aaa","acd","abb"};
//        Arrays.sort(stArr); //기본이 오름차순 정렬
//        System.out.println(Arrays.toString(stArr));
//        Arrays.sort(stArr, Comparator.reverseOrder()); //내림차순 정렬
//        System.out.println(Arrays.toString(stArr));
//        int[] arr = {17,12,20,10,15};
//        Arrays.sort(arr); //오름차순 정렬
//        Arrays.sort(arr,Comparator.reverseOrder()); //원시자료형은 Comparator 사용 불가능

//        선택정렬 알고리즘 구현
//        구현로직 : 1) 2중for문을 사용하여 index마다 최소값 찾기 2) 현재위치와 자리 체인지
//        int[] arr = {17,12,20,10,15};
//        방법 1)
//        for(int i=0;i<arr.length;i++){
//            int min = Integer.MAX_VALUE;
//            int idx = i;
//            for(int j=i;j<arr.length;j++){
//                if(arr[j]<min){
//                    min = arr[j];
//                    idx = j;
//                }
//            }
////            자리 바꾸기 : i와 index 자리 change
//            int temp = arr[i];
//            arr[i] = arr[idx];
//            arr[idx] = temp;
//        }
////        방법 2)
//        for(int i=0;i<arr.length;i++){
//            for(int j=i;j<arr.length;j++){
//                if(arr[i]>arr[j]){
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
////        선택정렬의 복잡도는 O(n^2). java 기본내장 정렬함수의 복잡도는 O(n*log(n)) -> 외우기

//        조합문제 : 모두 각기 다른 숫자의 배열이 있을 때, 만들어질 수 있는 두 숫자의 조합을 출력
//        ex) (10,20),(10,30),(10,40),(10,50),(20,30),(20,40)...
//        int[] arr = {10,20,30,40,50};
//        for(int i=0;i<arr.length;i++){
//            for(int j=i+1;j<arr.length;j++){
//                System.out.println(arr[i]+", "+arr[j]);
//            }
//        }

////        배열의 중복제거 : set 자료구조(중복 X,순서 X) 활용
//        ex) 10,20,30,40만 있도록
//        int[] arr = {10,30,20,30,10,40};
//        Set<Integer>set = new HashSet<>();
//        for(int a: arr){
//            set.add(a);
//        }
//        int[]answer = new int[set.size()];
//        int index = 0;
//        for(int a : set){
//            answer[index] = a;
//            index++;
//        }
//        Arrays.sort(answer);
//        System.out.println(Arrays.toString(answer));

////     프로그래머스 - 두개 뽑아서 더하기(조합+중복제거)
//        int[] numbers = {2,1,3,4,1};    //result = {2,3,4,5,6,7} 3 5 6 3 /4 5 2/7 4 / 5
//        Set<Integer> set = new HashSet<>();
//        for(int i=0;i<numbers.length;i++){
//            for(int j=i+1;j<numbers.length;j++){
//                set.add(numbers[i]+numbers[j]);
//            }
//        }
//        int[]answer = new int[set.size()];
//        int index = 0;
//        for(int a : set){
//            answer[index] = a;
//            index++;
//        }
//        Arrays.sort(answer);
//        System.out.println(Arrays.toString(answer));

////        배열의 검색 : 복잡도 O(n)
//        int[] arr = {1,3,6,8,8,9,11,15};
//        int target = 11;
////        target이 몇번째 index에 있는지 출력
//        int index = -1;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]==target){
//                index=i;
//                break;
//            }
//        }
//        System.out.println(index);

////        이분탐색(이진검색) - binary search, 복잡도 log(n)
////        사전에 데이터가 오름차순 정렬돼 있는 경우만 이분탐색 가능!!
////        혹시라도 정렬이 안되어있는 경우에는 정렬의 복잡도는 nlog n이기 때문에 정렬+이분탐색 할 필요는 없음 -> 생각하고 문제 풀기
//        int[] arr = {1,3,6,8,8,9,11,15};
//        int target = 11;
////        찾고자 하는 값이 있으면 해당 index 리턴
////        찾고자 하는 값이 없으면 음수값 리턴
//        int index = Arrays.binarySearch(arr,target);
//        int index2 = Arrays.binarySearch(arr,13);   //-8
//        System.out.println(index);
//        System.out.println(index2);

//////        백준 - 수 찾기 1920
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        String[]inputs = br.readLine().split(" ");
//        int[]arr = new int[inputs.length];
//        for(int i=0;i<N;i++){
//            arr[i] = Integer.parseInt(inputs[i]);
//        }
//        Arrays.sort(arr);
//        StringBuilder sb = new StringBuilder();
//        int M = Integer.parseInt(br.readLine());
//        String[]arr2 = br.readLine().split(" ");
//        for(int i=0;i<M;i++){
//            int target = Integer.parseInt(arr2[i]);
//            if(Arrays.binarySearch(arr,target)>=0){
//                sb.append(1).append("\n");
//            }
//            else{
//                sb.append(0).append("\n");
//            }
//
//        }
//        System.out.println(sb);

////        배열값 비교
//        int[] arr1 = {10,20,30};
//        int[] arr2 = {10,20,30};
//        System.out.println(arr1==arr2); //false
//        System.out.println(Arrays.equals(arr1,arr2)); //true

////        배열복사
////        Arrays.copyOf(배열명, length) , Arrays.copyOfRange(배열명, start, end)
//        int[] arr = {1,4,6,7,8,1,2,4,6};
//        int[] arr1 = Arrays.copyOf(arr,4);
//        System.out.println(Arrays.toString(arr1));
//        int[] arr2 = Arrays.copyOfRange(arr,3,6);
//        System.out.println(Arrays.toString(arr2));


////        Arrays.fill : 배열의 모든값을 변경(채우기)
//        String[] arr = new String[5];
//        for(int i=0;i<arr.length;i++){
//            arr[i] = "";
//        }
//        Arrays.fill(arr,"");

//        2차원 배열의 선언과 값 할당
//        {{1,2},{1,2},{1,2}}
//        방법1. 선언 후 할당 방식
//        int[][] arr1 = new int[3][2];
//        arr1[0][0] = 1;
//        arr1[0][1] = 2;
//        arr1[1][0] = 1;
//        arr1[1][1] = 1;
//        arr1[2][0] = 1;
//        arr1[2][1] = 1;



////        방법2. 리터럴 방식
//        int[][] arr2 = {{1,2},{1,2},{1,2}};

//        [3][4]사이즈의 2차원 배열을 선언하고, 1~12까지 숫자값을 각 배열에 순차적으로 할당
//        result -> {{1,2,3,4},{5,6,7,8},{9,10,11,12}}
//        int[][]arr = new int[3][4];
//        int num=1;
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr[i].length;j++){
//                arr[i][j] = num;
//                num++;
//            }
//        }
////        2차원 배열의 출력 (deepToString 사용해야함)
//        System.out.println(arr); //2차원 배열의 heap 주소값
//        System.out.println(Arrays.toString(arr)); //각 1차원 배열의 heap 주소값
//        System.out.println(Arrays.deepToString(arr)); //각 1차원배열의 갑 출력 -> 이것이 2차원 배열의 값 출력

////        프로그래머스 - 행렬의 덧셈
////        [{1,2},{2,3} {3,4},{5,6}]	-> [[4,6],[7,9]]
//        int[][] arr1 = {{1,2},{2,3}};
//        int[][] arr2 = {{3,4},{5,6}};
//        int[][] answer = new int[arr1.length][arr1[0].length];
//        for(int i=0;i<arr1.length;i++){
//            for(int j=0;j<arr1[i].length;j++){
//                answer[i][j] = arr1[i][j]+arr2[i][j];
//            }
//        }
//        System.out.println(Arrays.deepToString(answer));


////        프로그래머스 - k번째 수(이해가 너무 오래걸려서 많이 복습하기)
//        //return [5, 6, 3]
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands ={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[]answer = new int[commands.length];

        for(int i=0;i<commands.length;i++){
            int start = commands[i][0]-1;
            int end = commands[i][1];

            int[]arr = Arrays.copyOfRange(array,start,end);
            Arrays.sort(arr);
            int k = commands[i][2]-1;
            answer[i] = arr[k];
        }
        System.out.println(Arrays.toString(answer));

//
////        가변배열: 2차원 배열에서 각 1차원의 배열의 길이가 서로 다를수 있는 배열의 구조
//        int[][] arr1 = {{1,2},{1,2,3},{1,2,3,4}};
//
////      배열 전체길이는 반드시 사전할당 되어야하지만, 1차원배열의 길이는 추후 할당가능
//        int[][] arr2 = new int[3][];
//        arr2[0] = new int[2];
//        arr2[1] = new int[3];
//        arr2[2] = new int[4];




    }

}

