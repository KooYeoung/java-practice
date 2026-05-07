import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class SprintLogApp {

   public static void main(String[] args) {

      String[] titles = {"Java 시작", "Git 복습", "조건문 학습", "반복문 학습"};
      int[] minutes = {40, 30, 75, 120};
      boolean[] publicFlags = {true, false, true, true};

      Scanner sc = new Scanner(System.in);

      // 메뉴 제공
      int input;
      while (true) {
         printMenu();
         input = inputData(sc);

         printDivider(input);
         if (input == 1) {
            infos(titles, minutes);
         } else if (input == 2) {
            infos(titles, minutes, publicFlags);
         } else if (input == 3) {
            int totalMinutes = calcTotalMinutes(minutes);
            System.out.println("전체 학습 시간: " + totalMinutes + "분");
         } else if (input == 4) {
            infos(titles, minutes, minute -> minute < 60);

            int totalMinutes = calcTotalMinutes(minutes);

            double avg = (double) totalMinutes / minutes.length;
            System.out.println("평균 학습 시간: " + avg + "분");

         } else if (input == 5) {
            infos(titles, minutes, minute -> minute >= 100);

         }else if (input == 0) {
            break;
         }

      }

   }

   public static void printMenu() {
      System.out.println();
      System.out.println("==== SprintLog ====");
      System.out.println("1. 전체 기록 출력");
      System.out.println("2. 공개 기록만 출력");
      System.out.println("3. 전체 학습 시간 출력");
      System.out.println("4. 복습 필요 기록 출력");
      System.out.println("5. 긴 학습 기록 출력");
      System.out.println("0. 종료");
      System.out.print("메뉴를 선택하세요: ");
   }

   public static int inputData(Scanner sc) {
      try {
         return sc.nextInt();
      } catch (InputMismatchException e) {
         // 잘못들어온 문자 반환처리
         sc.nextLine();
         System.out.println("숫자를 입력해주세요.");
         return -1;
      }

   }

   public static void info(int index, String title, int minute, boolean publicFlag) {
      if (publicFlag) {
         System.out.println(index + ". " + title + " - " + minute + "분");
      }
   }

   public static void infos(String[] titles, int[] minutes, boolean[] publicFlags) {
      for (int i = 0; i < titles.length; i++) {
         info(i + 1, titles[i], minutes[i], publicFlags == null || publicFlags[i]);
      }
   }

   public static void infos(String[] titles, int[] minutes, IntPredicate condition) {
      for (int i = 0; i < titles.length; i++) {
         info(i + 1, titles[i], minutes[i], condition.test(minutes[i]));
      }
   }

   public static void infos(String[] titles, int[] minutes) {
      infos(titles, minutes, (boolean[]) null);
   }

   public static int calcTotalMinutes(int[] minutes) {
      int totalMinutes = 0;
      for (int minute : minutes) {
         totalMinutes += minute;
      }

      return totalMinutes;
   }

   public static void printDivider(int input){
      switch (input){
         case 0:
            System.out.println("========== 종료 ===========");
               break;
         case 1:
            System.out.println("========== 전체 기록 ===========");
            break;
         case 2:
            System.out.println("========== 공개 기록만 기록===========");
            break;
         case 3:
            System.out.println("========== 전체 학습 시간 기록===========");
            break;
         case 4:
            System.out.println("========== 복습 필요 기록 ===========");
            break;
         case 5:
            System.out.println("========== 긴 학습 기록 ===========");
            break;
         default:
            break;
      }
   }
}
