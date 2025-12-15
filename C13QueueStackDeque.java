package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C13QueueStackDeque {
    public static void main(String[] args) throws IOException {
////        Queue인터페이스를 LinkedList를 구현한 아래와 같은 방식으로 가장 많이 사용
//        Queue<Integer> myQueue = new LinkedList<>();
//        myQueue.add(10);
//        myQueue.add(20);
//        myQueue.add(30);
////        poll은 큐에서 가장 앞의 데이터를 삭제*하면서, 동시에 return하는 메서드
//
//        int value = myQueue.poll();
//        System.out.println(value); //10
//        System.out.println(myQueue); //20,30
////        peek은 큐에서 데이터를 삭제하지 않고*, 가장 앞의 데이터를 return 하는 메서드
//        int value2 = myQueue.peek();
//        System.out.println(value2); //20
//        System.out.println(myQueue); //20,30

////        while문을 통한 queue출력방식
//        Queue<String> printerQueue = new LinkedList<>();
//        printerQueue.add("문서1");
//        printerQueue.add("문서2");
//        printerQueue.add("문서3");
//        printerQueue.add("문서4");
////        큐는 일반적으로 while문을 통해 요소를 소모
//        while(!printerQueue.isEmpty()){
//            System.out.println(printerQueue.poll());
//        }

////        LinkedList와 ArrayList 성능차이 비교
////        ArrayList 장점 : 조회성능빠름, 단점 : 중간삽입/삭제 성능 저하
////        LinkedList 장점 : 중간삽입/삭제 성능 빠름, 단점 : 조회성능저하
//
//        LinkedList<Integer> myLinkedList = new LinkedList<>();
//        long startTime = System.currentTimeMillis();
//        for(int i=0;i<1000000;i++){
//            myLinkedList.add(0,i);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("linkedlist에 중간에 값 add시에 소요시간 : " + (endTime-startTime));
//
//
//        ArrayList<Integer> myArrayList = new ArrayList<>();
//        long startTime2 = System.currentTimeMillis();
//        for(int i=0;i<1000000;i++){
//            myArrayList.add(0,i);
//        }
//        long endTime2 = System.currentTimeMillis();
//        System.out.println("arraylist에 중간에 값 add시에 소요시간 : " + (endTime2-startTime2));
//
////        백준 : 카드2, 요세푸스 문제 0
////        카드 2
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        Queue<Integer> myQueue = new LinkedList<>();
//        for(int i=1;i<=N;i++){
//            myQueue.offer(i);
//        }
//        while(myQueue.size()>1){
//            myQueue.poll();
//            myQueue.offer(myQueue.poll());
//        }
//        for(int a : myQueue){
//            System.out.println(a);
//        }
////        요세푸스 문제 0
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        Queue<Integer> myQueue = new LinkedList<>();
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        for(int i=1;i<=N;i++){
//            myQueue.add(i);
//        }
//        List<Integer> myList = new ArrayList<>();
//        while (!myQueue.isEmpty()){
//            for(int i=0;i<K-1;i++){
//                myQueue.offer(myQueue.poll());
//            }
//            myList.add(myQueue.poll());
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append("<");
//        for(int i=0;i<myList.size();i++){
//            sb.append(myList.get(i));
//            if(i!= myList.size()-1){
//                sb.append(", ");
//            }
//        }
//        sb.append(">");
//        System.out.println(sb);



////        길이제한 큐 (잘 쓰이지는 X)
//        Queue<String> blockingQueue = new ArrayBlockingQueue<>(3);
////        blockingQueue.add("문서1");
////        blockingQueue.add("문서2");
////        blockingQueue.add("문서3");
////        blockingQueue.add("문서4"); //길이 초과시 에러발생
//        blockingQueue.offer("문서1");
//        blockingQueue.offer("문서2");
//        blockingQueue.offer("문서3");
//        blockingQueue.offer("문서4"); //제한된 길이까지만 add. 에러발생 X
//        System.out.println(blockingQueue);

//        우선순위 큐 : 데이터를 poll할때 정렬된 데이터 결과값(최소값(오름차순)/최대값) 보장
//        지속적으로 데이터가 추가/제거되면서 전체 데이터가 실시간으로 변경되는 상황에 사용
//        Queue<Integer> pq = new PriorityQueue<>();
//        pq.add(30);
//        pq.add(20);
//        pq.add(10);
//        pq.add(40);
//        pq.add(50);
//        System.out.println(pq);
//        while(!pq.isEmpty()){
////            poll할때마다 최소값을 추출하게되고, 복잡도 log(n). peek은 최소값을 확인만 하고 추출은 X, 복잡도 log(n).
////            전체데이터를 모두 poll하면 복잡도 n*log(n)
//            System.out.println(pq.poll());
//        }

////        백준 : 최소힙
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        Queue<Integer> pq = new PriorityQueue<>();
//        StringBuilder sb = new StringBuilder();
//
//        for(int i=0;i<N;i++) {
//            int x = Integer.parseInt(br.readLine());
//            if(x!=0){
//                pq.offer(x);
//            }
//            else{
//                if(pq.isEmpty()){
//                    sb.append(0).append("\n");
//                }
//                else {
//                    sb.append(pq.poll()).append("\n");
//                }
//            }
//        }
//        System.out.println(sb);
////        프로그래머스 : 더 맵게 (어우 다시보자 ^^)
////        result = 2
//        int[] scoville = {1, 2, 3, 9, 10, 12};
//        int K = 7;
//        int count = 0;
//        Queue<Integer> pq = new PriorityQueue<>();
//        for(int a : scoville){
//            pq.add(a);
//        }
//        while (pq.size()>=2 && pq.peek()<K){
//           int newScore =  pq.poll();
//           int newScore2 = pq.poll();
//           pq.add(newScore+newScore2*2);
//           count++;
//        }
//        if(pq.peek()>K){
//            System.out.println(count);
//        }
//        else{
//            System.out.println(-1);
//        }



////        최대힙 : poll할때마다 최대값을 추출
//        Queue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());

////        후입선출의 자료구조
//        Stack<Integer> myStack = new Stack<>();
//        myStack.push(10);
//        myStack.push(20);
//        myStack.push(30);
//        System.out.println(myStack.pop()); //마지막에 입력한 값을 꺼내는 것
//        System.out.println(myStack.peek()); //마지막에 입력한 값을 확인만 하는 것
//        System.out.println(myStack.size());
//        System.out.println(myStack.isEmpty());

////        프로그래머스 : 올바른 괄호
//        String s = "()()";
//        boolean answer = true;
//        Stack<String> myStack = new Stack<>();
//        for(int i=0;i<s.length();i++){
//            char ch = s.charAt(i);
//            if(ch=='('){
//                myStack.push("(");
//            }
//            else if(ch==')'){
//                if(myStack.isEmpty()){
//                    answer = false;
//                    break;
//                }
//                else if(myStack.peek().equals("(")){
//                    myStack.pop();
//                }
//                else if(myStack.peek().equals(")")){
//                    answer = false;
//                    break;
//                }
//            }
//
//        }
//        if(!myStack.isEmpty()){
//            answer = false;
//        }
//
//        System.out.println(answer);

////        프로그래머스 : 같은 숫자는 싫어
//        int[] arr = {1,1,3,3,0,1,1};
//        Stack<Integer> myStack = new Stack<>();
//        for(int a : arr){
//            if(myStack.isEmpty()){
//                myStack.push(a);
//            }
//            else{
//                if(myStack.peek()!=a){
//                    myStack.push(a);
//                }
//            }
//        }
//        int[] answer = new int[myStack.size()];
//        int idx = 0;
//        for(int a : myStack){
//            answer[idx] = a;
//            idx++;
//        }
//        System.out.println(Arrays.toString(answer));


////        deque : addFirst, addLast, pollFirst, pollLast, peekFirst, peekLast
//        Deque<Integer> myDeque = new ArrayDeque<>();
//        myDeque.addLast(10);
//        myDeque.addLast(20);
//        myDeque.addFirst(30); //30,10,20
//        System.out.println(myDeque.pollLast()); //20
//        System.out.println(myDeque.pollFirst()); //30
//        System.out.println(myDeque.pollFirst()); //10


    }
}