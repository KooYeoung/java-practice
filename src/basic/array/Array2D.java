package basic.array;

import java.util.Arrays;

public class Array2D {
   public static void main(String[] args) {

      // 배열은 선언할때 각 인덱스 자리의 값이 비어있지 않고
      // 각 타입의 기본값으로 초기화 됩니다.
      // 기본값 : 정수0, 실수 0.0, 논린  false, 문자 (공백), 기타 null
      int[][] arr = new int[3][4];
      arr[1][1] = 100;

      System.out.println(Arrays.deepToString(arr));
      for (int[] outerRow : arr){
         for (int innerValue : outerRow){
            System.out.print(innerValue + " ");
         }
         System.out.println();
      }
   }
}
