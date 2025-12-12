package C01Basic;

import java.util.*;

public class C10List {
    public static void main(String[] args) {
////        List선언방법1
//        ArrayList<String> myList1 = new ArrayList<String>();
//        ArrayList<String> myList2 = new ArrayList<>();
//
////        List선언방법2 : 가장일반적인 방법
//        List<String> myList3 = new ArrayList<>();
//
////        초기값 세팅방법1. 개별 data add
//        myList3.add("java");
//        myList3.add("python");
//        myList3.add("C++");
//
//
////        초기값 세팅방법2. 배열을 리스트로 변환
//        String[] arr = {"java","python","C++"};
//        List<String> myList4 = new ArrayList<>(Arrays.asList(arr));
//
////        List의 출력
////        List등의 컬렉션프레임워크 안에는 toString메서드가 구현되어있고, 자동호출됨
////        배열을 출력할때처럼 toString을 안써도 출력이 됨
//        System.out.println(myList4);
//
////        List안의 자료타입으로는 기본형타입은 쓸수 없음
//        int[] intArr = {10,20,30};
//        List<Integer> myList5 = new ArrayList<>();
//        for(int i : intArr){
//            myList5.add(i);
//        }

////         add: 리스트에 값을 하나씩 추가하는 메서드
//        List<Integer> myList = new ArrayList<>();
//        myList.add(10);
//        myList.add(20);
//        myList.add(0,30); //list는 중간위치의 데이터를 삽입/삭제하는 작업은 비효율적임
//        System.out.println(myList);
//
////        get(index) : 특정 index의 요소 반환
//        System.out.println(myList.get(2));
//
////        size() : 리스트의 개수(길이)를 반환
//        System.out.println(myList.size());
//
////        리스트의 값 출력 방법1. 일반 for문
//        for(int i=0;i<myList.size();i++){
//            System.out.println(myList.get(i));
//        }
//
////        리스트의 값 출력 방법2. 향상된 for문
//        for(int a: myList){
//            System.out.println(a);
//        }

////        remove : 값 삭제 (보통 값 삭제는 뒤에서 삭제하는게 보통이고 앞에서는 삭제 잘 안함)
//        List<Integer> myList = new ArrayList<>();
//        myList.add(10);
//        myList.add(20);
//        myList.add(30);
//        myList.remove(myList.size()-1);

//        indexOf : 특정값을 찾아 index return (가장 먼저나오는 값)
//        List<Integer> myList = new ArrayList<>();
//        myList.add(10);
//        myList.add(20);
//        myList.add(30);
//        myList.add(30);
//        System.out.println(myList.indexOf(30));
//
////        contains: 값이 있는지 없는지 여부를 리턴
//        System.out.println(myList.contains(20));

////        프로그래머스 : n의 배수 고르기
//        int n =3;
//        int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
//        List<Integer> myList = new ArrayList<>();
//        for(int i=0;i<numlist.length;i++){
//            if(numlist[i]%n==0){
//                myList.add(numlist[i]);
//            }
//        }
//        int[]answer = new int[myList.size()];
//////        향상된 for문
////        int idx = 0;
////        for(int a : myList){
////            answer[idx] = a;
////            idx++;
////        }
//////        일반 for문
//        for(int i=0;i<myList.size();i++){
//            answer[i]= myList.get(i);
//        }
//        System.out.println(Arrays.toString(answer));

////        정렬 : 방법 2가지(Collections클래스의 sort 메서드 사용, 객체의 sort 메서드 사용)
//        List<Integer> myList = new ArrayList<>();
//        myList.add(5);
//        myList.add(3);
//        myList.add(2);
//        myList.add(1);
//        myList.add(4);
//
//        Collections.sort(myList); //오름차순 정렬 , 복잡도 nlog(n)
//        Collections.sort(myList, Comparator.reverseOrder()); //내림차순
//        System.out.println(myList);
//
//        myList.sort(Comparator.naturalOrder()); //오름차순, 복잡도 nlog(n)
//        myList.sort(Comparator.reverseOrder()); //내림차순
//        System.out.println(myList);

////        이중리스트 : 리스트안의 리스트
////        [[1,2,3],[4,5,6]]
//        List<List<Integer>> myList = new ArrayList<>();
//        List<Integer> m1 = new ArrayList<>();
//        myList.add(m1);
//        myList.add(new ArrayList<>()); //[[],[]]
//        m1.add(1);
//        m1.add(2);
//        m1.add(3); //[[1,2,3],[]]
//        myList.get(1).add(4);
//        myList.get(1).add(5);
//        myList.get(1).add(6);
//        System.out.println(myList);

////        [[1,2,3],[4,5,6],[7,8,9],...,[58,59,60]] 형태의 이중리스트 생성
//        List<List<Integer>> myList = new ArrayList<>();
//        for(int i=0;i<20;i++){
//            myList.add(new ArrayList<>());
//        }
//        int num = 1;
//        for(int i=0;i<20;i++){
//            for(int j=0;j<3;j++){
//                myList.get(i).add(num);
//                num++;
//            }
//        }

//        리스트안의 배열
//        [{10,20},{1,2,3},{4,3,2,1}]
        List<int[]> myList1 = new ArrayList<>();
        int[]arr1 = new int[2];
        arr1[0] =10;
        arr1[1] =20;
        myList1.add(arr1);
        myList1.add(new int[3]);
        myList1.get(1)[0] = 1;
        myList1.get(1)[1] = 2;
        myList1.get(1)[2] = 3;
//        int[]arr2 = new int[3];
//        arr2[0] = 1;
//        arr2[1] = 2;
//        arr2[2] = 3;
//        myList1.add(arr2);
        myList1.add(new int[]{4,3,2,1});
        System.out.println(myList1); //myList에는 toString이 자동호출되었고
        // 그 myList 안에 배열 주소값이 출력됨.[x1배열주소, x2배열주소, x3배열주소]

        for(int i=0;i<myList1.size();i++){
            System.out.println(Arrays.toString(myList1.get(i)));
        }











    }
}
