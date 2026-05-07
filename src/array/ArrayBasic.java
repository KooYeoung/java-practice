package array;

import java.util.Arrays;

public class ArrayBasic {
   public static void main(String[] args) {
      //1. 배열 변수 선언
      int[] numbers;

      //2. 배열 객체 생성
      numbers = new int[5];

      //3. 배열 내부 초기화
      // 인덱스를 지목해서 데이터를 할당
      // 인덱스는 0부터 시작해서 1씩 증가.
      numbers[0] =50;
      numbers[1] =77;
      numbers[2] =(int) 3.14;
      // 형변환 을 해야 기입 가능.
      // 이거는 다운 캐스팅 double -> int
      // 소수점은 버리게됨.
      numbers[3] = numbers[0] + 20  ;
      //numbers[4] = "numbers[0] + 20"  ;
      //숫자타입의 배열에 문자는 들어갈수 없음
      numbers[4] = 100;

      // 4. 배열의 길이
      System.out.println("배열의 길이: " +  numbers.length);


      // 5. 배열의 순회
      for (int i = 0; i < numbers.length; i++) {
         numbers[i] = (i + 1) * (i + 1) ;
         System.out.println((i+1) + "번째 값: " + numbers[i]);
      }

      System.out.println("==============================================");

      // 배열의 순회 forEach(향상된 for문)
      // 무조건 범위는 배열의 처음부터 끝까지 설정.
      // 중간에 break 나 continue 는 가능함.
      for (int value : numbers){
         System.out.println(value);
      }

      // 배열 내부를 문자열 형태로 한 번에 출력
      System.out.println(Arrays.toString(numbers));

      // 배열 쉽게 초기화 하기
      // 선언 당시에 크기가 고정되고, 그 크기는 변할 수 없습ㄴ디ㅏ.
      // 만약 혹시라도 크기를 늘리거나 줄이고 싶다면 배열을 새로 만들어서 값을 옮겨야 합니다.
      int[] pointList = {10, 20, 30, 40};
      String[] pets = {"멍멍이", "야옹이", "짹짹이", "춘식이"};
      // pets = {"멍멍이", "야옹이", "짹짹이"}; // 불가
      pets = new String[]{"멍멍이", "야옹이", "짹짹이"};

   }
}
