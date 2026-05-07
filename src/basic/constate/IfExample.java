package basic.constate;

public class IfExample {
   public static void main(String[] args) {

      int score = 65;

      if(score >= 70){
         System.out.println("점수가 70점 이상입니다. 합격입니다!");
      }else {
         System.out.println("점수가 70점 미만입니다. 불합격입니다.");
      }

      System.out.println("시험 치르느라 고생 많으셨어요.");
   }
}
