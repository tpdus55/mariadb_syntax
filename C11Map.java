package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C11Map {
    public static void main(String[] args)throws IOException {
//        map : key, value로 이루어진 자료구조
//        Map<String,Integer> sports = new HashMap<>();
////        특징: 키는 중복이 없음. value는 중복가능
//        sports.put("농구",2);
//        sports.put("축구",3);
//        sports.put("배구",2);
//        sports.put("농구",3);

//        특징 : map key에는 순서가 없음
//        System.out.println(sports);
//
////        특징: 1) map에서 key값을 통한 검색 복잡도는 O(1).
////             2) 여유있는 배열사이즈 할당을 위한 공간의 비효율
////             3) 해시충돌 가능성
//        System.out.println(sports.get("배구"));

////        map의 전체 value 데이터 출력
////        map의 key값 접근시에는 인덱스 사용 불가능(순서가 없음)
////        keySet() : map의 전체 key목록을 반환하는 메서드
//        for(String a : sports.keySet()){
//            System.out.println("key:"+a+"Value:"+sports.get(a));
//        }
//
////        values() : map의 전체 value 목록을 반환하는 메서드 (잘 안쓰임)
//        for(int a : sports.values()){
//            System.out.println(a);
//        }

//        Map<String,Integer> sports = new HashMap<>();
//        sports.put("축구",2);
//        sports.put("농구",3);
//        sports.put("배구",2);
//
////        remove : key를 통해 map요소 삭제
//        sports.remove("축구");
//        System.out.println(sports);
//
////        putIfAbsent : key값이 없는 경우에만 put
//        sports.putIfAbsent("배구",10);
//        System.out.println(sports);
//
////        containsKey : 키가 있으면 true, 없으면 false
//        System.out.println(sports.containsKey("배구"));
//        System.out.println(sports.containsKey("탁구"));

////        map을 통한 개수 count
//        String[] arr = {"농구","축구","농구","야구","축구"}; //농구:2, 축구:2,야구:1
//        Map<String,Integer> myMap = new HashMap<>();
//
//        for(String a : arr){
////            if(myMap.containsKey(a)){
////                myMap.put(a,myMap.get(a)+1);
////            }
////            else{
////                myMap.put(a,1);
////            }
////            getOrDefault(키값, 초기값) : key값이 있으면 있는값 리턴,없을경우 초기값 리턴
//            myMap.put(a,myMap.getOrDefault(a,0)+1);
//        }
//        System.out.println(myMap);
////        담을려고 하는 key가 있으면 기존것 + 1
////        key가 없으면 (key,1)로 세팅
//
//
////        Map의 value값 감소 로직
//        String[]arr2 = {"농구","농구","농구","야구","축구"};
//        for(String a :arr2){
//            if(myMap.containsKey(a)){
//                if(myMap.get(a)==1){
//                    myMap.remove(a);
//                }
//                else{
//                    myMap.put(a,myMap.get(a)-1);
//                }
//            }
//
//        }
//        System.out.println(myMap);

////        프로그래머스 : 완주하지 못한 선수
//        //완주하지 못한 선수는 leo
//        String[] participant ={"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};
//
////        String answer를 리턴
//        Map<String,Integer> myMap = new HashMap<>();
//        for(String a : participant){
//            myMap.put(a,myMap.getOrDefault(a,0)+1);
//        }
//        for(String a : completion){
//            if(myMap.containsKey(a)){
//                if(myMap.get(a)==1){
//                    myMap.remove(a);
//                }
//                else{
//                    myMap.put(a,myMap.get(a)-1);
//                }
//            }
//        }
//        System.out.println(myMap);
//        for(String a : myMap.keySet()){
//            System.out.println(a);
//        }

////        가장 value가 큰 key값 찾기
//        Map<String, Integer> myMap = new HashMap<>();
//        myMap.put("축구",3);
//        myMap.put("농구",2);
//        myMap.put("야구",1);
//        int max = Integer.MIN_VALUE;
//        String maxKey = "";
//        for(String a : myMap.keySet()){
//            int value = myMap.get(a);
//            if(max<value){
//                max = value;
//                maxKey = a;
//            }
//        }
//        System.out.println(maxKey);

////        백준 : 베스트셀러(다시 보기)
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        Map<String, Integer> myMap = new HashMap<>();
//        int max = Integer.MIN_VALUE;
//
//        for(int i=0;i<N;i++){
//            String name = br.readLine();
//            myMap.put(name,myMap.getOrDefault(name,0)+1);
//        }
//        List<String>list = new ArrayList<>();
//        for(String a : myMap.keySet()){
//            int maxValues = myMap.get(a);
//            if(maxValues>max){
//                max = maxValues;
//            }
//        }
//        for(String a : myMap.keySet()){
//            int value = myMap.get(a);
//            if(max==value){
//                list.add(a);
//            }
//        }
//        list.sort(Comparator.naturalOrder());
//        System.out.println(list.get(0));

////        TreeMap: key를 정렬(오름차순)하여 map을 저장
//        Map<String, Integer> myMap = new TreeMap<>();
////        Map<String, Integer> myMap = new TreeMap<>(Comparator.reverseOrder()); //내림차순
//        myMap.put("hello5",1);
//        myMap.put("hello4",2);
//        myMap.put("hello3",3);
//        myMap.put("hello2",4);
//        myMap.put("hello1",5);
//        System.out.println(myMap);

//        프로그래머스: 의상


//        백준: 파일정리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> myMap = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String fileName = br.readLine();
            String[] cut = fileName.split("\\.");
            myMap.put(cut[1],myMap.getOrDefault(cut[1],0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(String s : myMap.keySet()){
            sb.append(s).append(" ").append(myMap.get(s)+"\n");
        }
        System.out.println(sb);










    }
}
