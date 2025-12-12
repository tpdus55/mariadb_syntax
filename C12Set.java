package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C12Set {
    public static void main(String[] args)throws IOException {
////        set의 특성 : 중복 X, 순서보장 X, 성능 O(1)
//        Set<String> mySet = new HashSet<>();
//        mySet.add("야구");
//        mySet.add("농구");
//        mySet.add("야구");
//        mySet.add("축구");
//        System.out.println(mySet);
//        System.out.println(mySet.contains("야구")); //O(1)의 복잡도
//
////        백준 과제 수찾기(1920)다시 풀어보기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer>mySet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            mySet.add(num);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int num2 = Integer.parseInt(st.nextToken());
            if(mySet.contains(num2)){
                sb.append(1).append("\n");
            }
            else sb.append(0).append("\n");
        }
        System.out.println(sb);


////        TreeSet : 데이터를 오름차순 정렬
//        Set<String> mySet2 = new TreeSet<>();
//        mySet2.add("야구");
//        mySet2.add("농구");
//        mySet2.add("야구");
//        mySet2.add("축구");
//        System.out.println(mySet2);

////        백준 과제 : 숫자카드(10815)
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        Set<Integer> mySet = new HashSet<>();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i=0;i<N;i++){
//            int num = Integer.parseInt(st.nextToken());
//            mySet.add(num);
//        }
//
//        int M = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        st = new StringTokenizer(br.readLine());
//        for(int i=0;i<M;i++){
//            int num1 = Integer.parseInt(st.nextToken());
//            if(mySet.contains(num1)){
//                sb.append(1).append(" ");
//            }
//            else{
//                sb.append(0).append(" ");
//            }
//        }
//        System.out.println(sb);

////         프로그래머스 과제 : 폰켓몬
//        int[] nums = {3,1,2,3}; //result = 2
//        Set<Integer> mySet = new HashSet<>();
//        int cut = nums.length/2;
//        for(int a : nums){
//            mySet.add(a);
//        }
//        int answer = 0;
//        if(mySet.size()>cut){
//            answer = cut;
//        }
//        else{
//            answer = mySet.size();
//        }
//        System.out.println(answer);





    }
}
