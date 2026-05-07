package basic;

public class javaStarter {

   // 출력함수 main
   public static void main(String[] args) {
      // 주석(comments)은 프로그램의 실행에 영향을 주지 않습니다.

      // 출력함수 sout
      System.out.println("Hello World");

      /*
      * 여기는 문 장 주석 공간.
      *
      * */

      String title = "Java 변수와 자료형";
      int studyMinutes = 90;
      int targetMinutes = 120;
      int extraMinutes = 60;

      studyMinutes = 80;

      boolean isPublic = true;
      // true false
      char level = 'A';

      // 자바에서 int와 int의 연산 결과는 항상 int 입니다.
      // 그래서 소수점을 표현하고 싶다면 연산하고자 하는 값의 탕비을 시룻형(double)로 변경해야 함.
      double progressRate = (double) studyMinutes  / targetMinutes ;

      boolean isEnoughStudy = studyMinutes >= 60;



      System.out.println("제목: " + title);
      System.out.printf("학습 시간: %d 분\n", studyMinutes);
      System.out.println("목표 시간: " + targetMinutes + "분");
      System.out.println("추가 시간: " + extraMinutes + "분");
      System.out.println("중요도: " + level);
      System.out.println("진도율: " + progressRate + "%");
      System.out.println("충분히 학습했나요?: " + isEnoughStudy);

   }
}
