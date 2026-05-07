package basic.loop;

public class ContinueExample {
   public static void main(String[] args) {

      for (int i = 1; i <= 10; i++) {
         // for문에서 continue는 증감식이 실행됨.
         // while문에서 continue는 조건식이 실행됨.
         if (i == 5) continue;

         System.out.print(i + " ");
      }

      System.out.println("\n======================================================");

      int n = 1;
      while(n<=10){
         // while문에서 continue는 조건식으로 흐름 이동
         // 반복문이 끝나지 않는 문제 발생.
         if (n == 5) {
            n++;
            // 해당 구문 내용이 없으면 무한 반복
            continue;
         }
         System.out.print(n + " ");
         n++;
      }

      System.out.println("\n반복문 종료");

   }
}
