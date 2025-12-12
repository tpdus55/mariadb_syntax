package C01Basic;

import java.util.regex.Pattern;

public class C08String {
    public static void main(String[] args) {
////        String 선언방법 2가지
////        객체선언방식(new 키워드 사용으로 별도의 힙공간 생성)
//        String st1 = new String("hello world");
//        String st2 = new String("hello world");
////        리터럴방식 : String pool(재활용)을 사용하는 방식(java에서 추천)
//        String st3 = "hello world";
//        String st4 = "hello world";
//        System.out.println(st1==st2);   //false
//        System.out.println(st3==st4);   //true
//        System.out.println(st1==st3);   //false
//
////        참조자료형의 비교는 ==을 지양(사용안하는게 좋음)
//        System.out.println(st1.equals(st3)); //true

////        .equals : 힙메모리의 문자열을 가져와서 equal 관계 비교
//        String st1 = "hello1";
//        String st2 = "Hello1";
//        System.out.println(st1.equals(st2)); //false
//        System.out.println(st1.equalsIgnoreCase(st2)); //true

////        length : 문자열의 길이 출력
//        String st1 = "hello1 world1 java1";
//        System.out.println(st1.length());
////        charAt(n) : 특정 index의 문자(char)값을 리턴
//        char ch1 = st1.charAt(7);
//        System.out.println(ch1);
////        a의 개수가 몇개인지 출력
//        int count = 0;
////        for(int i=0;i<st1.length();i++){
////            if(st1.charAt(i)=='a'){
////                count++;
////            }
////        }
////        toCharArray : String 문자열을 char 배열로 변환시켜주는 메소드
//        for(char ch :st1.toCharArray()){
//            if(ch=='a'){
//                 count++;
//            }
//        }
//        System.out.println(count);

////        indexOf(문자열): 특정 문자열의 위치(index)반환. 가장 먼저 나오는 문자열의 위치를 반환.
//        String st1 = "hello java java";
//        System.out.println(st1.indexOf("java"));
//        System.out.println(st1.lastIndexOf("java"));
//        System.out.println(st1.contains("hello"));  //true
//        System.out.println(st1.contains("world"));  //false

////        문자열 더하기 : +=사용. 성능 측면에서는 추후 베을 StringBuffer, StringBuilder를 사용
//        String st1 = "hello";
//        st1 += "world";
//        st1 += '1'; //String에 char를 더하면 String으로 자동변환됨
//        System.out.println(st1);

//        프로그래머스 - 특정문자제거하기
//        substring(a,b) : a이상 b미만의 index의 문자를 잘라 문자열로 반환
//        String st1 = "hello world";
//        System.out.println(st1.substring(0,5)); //hello
//        System.out.println(st1.substring(6,st1.length())); //hello
//
////        프로그래머스 - 가운데글자가져오기(이부분 한번 다시 복습하기!)
//        String s = "abde";
//        String answer = "";
//        if(s.length()%2==0){
//            answer = s.substring(s.length()/2-1,s.length()/2+1);
//        }
//        else{
//            answer = s.substring(s.length()/2,s.length()/2+1);
//        }
//        System.out.println(answer);


////        trim, strip : 문자열 양쪽 끝의 공백 제거
//        String st1 = " hello world  ";
//        String st2 = st1.trim();
//        String st3 = st1.strip();
//        System.out.println(st2);
//        System.out.println(st3);

////        toUpperCase : 모든 문자열을 대문자로 변환, toLowerCase : 소문자로 변환.
//        String st1 = "Hello";
//        String st2 = st1.toUpperCase();
//        String st3 = st1.toLowerCase();
//        System.out.println(st2);
//        System.out.println(st3);
//        System.out.println(st1);

////        replace(a,b) : a문자열을 b문자열로 대체
//        String st1 = "hello world world";
//        String st2 = st1.replace("world","java");
//        System.out.println(st2);

////        replaceAll(a,b) : replace와 사용법은 동일. 정규표현식을 쓸 수 있는점이 차이점.
//        String st1 = "01abC123   한글123";
////        한글제거의 경우
//        String answer1 = st1.replaceAll("[가-힣]","");
//        System.out.println(answer1);
//
////        알파벳소문자제거의 경우
//        String answer2 = st1.replaceAll("[a-z]","");
//        System.out.println(answer2);
//
////        알파벳제거의 경우
//        String answer3= st1.replaceAll("[A-Za-z]","");
//        System.out.println(answer3);
//
////        공백제거의 경우 ( \s : 공백)
//        String answer4= st1.replaceAll(" ","");
//        System.out.println(answer4);
////        정규표현식 공백제거
//        String answer5= st1.replaceAll("\\s+","");
//        System.out.println(answer5);

//          전화번호 검증(^$ -> 시작과 끝을 알려줌)
//        String number = "010-1234-1234";
//        boolean check = number.matches("^\\d{3}-\\d{4}-\\d{4}$");
//        System.out.println(check);
//        if(check==false){
//            System.out.println("형식이 잘못되었습니다. 다시 입력해주세요.");
//        }

////        이메일 검증
//        String email = "abc1234@naver.com";
//        boolean check = Pattern.matches("^[a-z0-9]+@[a-z]+.com$",email);
//        System.out.println(check);

////        split : 특정문자를 기준으로 잘라서 문자배열로 만드는 것.
//        String a = "a:b:c:d";
//        String[] arr = a.split(":");
//
//        String b = "a b c  d";
//        String[] arr2 = b.split(" ");
//        String[] arr3 = b.split("\\s+");
//        System.out.println(arr2.length);    //5
//        System.out.println(arr3.length);    //4

////        null과 공백의 차이
//        String st1= null; //null은 문자열 아님
//        String st2 = "";  //빈 문자열은 문자열 맞음
//        String st3 = " "; //공백
//        System.out.println(st1==st2); //false
////        System.out.println(st1.isEmpty()); //nullpointer exception발생
//        System.out.println(st2.isEmpty()); //true
//        System.out.println(st3.isEmpty()); //false
//        System.out.println(st3.isBlank()); //true
//
////        공백의 개수세기
//        int total = 0;
//        String abc = "hello    world   java";
//        for(int i=0;i<abc.length();i++){
//            if(abc.substring(i,i+1).isBlank()){
//                total++;
//            }
//        }
//        System.out.println(total);

//        문자열 조립: StringBuffer, StringBuilder
//        String[] arr = {"java","python","javascript"};
//        StringBuffer sb = new StringBuffer();
//        String result =""; // 이 방식은 프로그래머스 문제풀때 많이 사용
//        for(int i=0;i<arr.length;i++){
//            sb.append(arr[i]).append("\n"); // \n은 줄바꿈
//        }
//        sb.insert(0,"C++"); //문자열 중간에 insert하는 것은 성능저하 발생시킴.
//        sb.deleteCharAt(0); //마지막 index를 삭제하는 것 외에는 성능저하 발생.
//        result = sb.toString();
//        System.out.println(result);

//        StringBuilder는 성능이 뛰어나지만, 동시성문제 있음(Thread-safe하지 않음)
//        실전에서는 StringBuffer 쓰는게 좋다!
//        StringBuffer보다 StringBuilder가 성능이 더 빠른데 그 이유는 StringBuilder는 동시성문제를 고려하지 않고 쓰기 때문에 성능 빠름
//        예를들어) 쓰레드A가 append("hello") 쓰레드B가 append("world")
//        이 두 작업이 중간에 섞여 "heworlllo" 이런식으로 잘못된 값을 만들 수 있음.

//        StringBuilder sb2= new StringBuilder();
////        문자열 뒤집기
//        String st1 = "hello";
//        for(int i=st1.length()-1;i>=0;i--){
//            sb2.append(st1.charAt(i));
//        }
//        System.out.println(sb2);
//        StringBuilder sb3 = new StringBuilder(st1);
//        sb3.reverse();
//        System.out.println(sb3);

//        프로그래머스 - 문자열 밀기 ( 헷 갈 림)
//        A를 밀어서 B가 될 수 있다면 밀어야 하는 최소 횟수를 return하고 밀어서 B가 될 수 없으면 -1을 return
        ////        A를 StringBuilder로 변환
        ////        A에 마지막 값을 앞으로 insert, 마지막값 제거
        ////        A와 B를 비교

        String A = "hello";
        String B = "ohell";
        int count = 0;
        StringBuilder sb = new StringBuilder(A);
        if(A.equals(B)){
            System.out.println(0);
            return;
        }

        for(int i=0;i<A.length();i++){
            char last = sb.charAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            sb.insert(0,last);
            count++;

            if(sb.toString().equals(B)){
                System.out.println(count);
                return;
            }
        }
        System.out.println(-1);


////        문자열 비교
//        String st1 = "hello";
//        String st2 = "dello";
//        String st3 = "hello";
//        String st4 = "hfllo";
////        compareTo()함수는 빼는 함수
//        System.out.println(st1.compareTo(st2)); //양수
//        System.out.println(st2.compareTo(st1)); //음수
//        System.out.println(st1.compareTo(st3)); //0
//        System.out.println(st4.compareTo(st3)); //양수











    }
}
