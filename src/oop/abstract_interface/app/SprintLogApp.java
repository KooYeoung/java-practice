package oop.abstract_interface.app;

import oop.abstract_interface.domain.LearningActivity;
import oop.abstract_interface.domain.LectureLog;
import oop.abstract_interface.domain.PracticeLog;
import oop.abstract_interface.domain.ReadingLog;
import oop.abstract_interface.policy.Reviewable;
import oop.abstract_interface.policy.Shareable;
import oop.abstract_interface.printer.ActivityPrinter;
import oop.abstract_interface.printer.CompactActivityPrinter;
import oop.abstract_interface.printer.ConsoleActivityPrinter;

public class SprintLogApp {

   public static void main(String[] args) {

      LectureLog javaLecture = new LectureLog("Java 객체지향", 50, true, "박코치");
      PracticeLog gitPractice = new PracticeLog("Git 브랜치 실습", 70, true, 80);
      PracticeLog oopPractice = new PracticeLog("캡슐화 리팩터링", 40, false, 45);
      ReadingLog oopBook = new ReadingLog("객체지향의 사실과 오해", 35, true, "객체지향의 사실과 오해");

      // 추상클래스는 스스로의 객체를 생성할 수 없고, 자식에 의해서 생성될 뿐입니다.
//        LearningActivity act = new LearningActivity("test", 10);

      //LSP - 부모타입의 자리에 자식이 들어가도 기능은 동일하게 동작함.
      LearningActivity[] activities = {javaLecture, gitPractice, oopPractice, oopBook};
      ActivityPrinter printer = new ConsoleActivityPrinter();
      ActivityPrinter compactPrinter = new CompactActivityPrinter();

      System.out.println("=== 학습 활동 목록 ===");
      for (int i = 0; i < activities.length; i++) {
         // SRP - 단일 책임 원칙으로 출력에대한 기능을 분리
         // 출력방식을 변경하게 될경우 각 객체들에 대한 변경에대한 문제가 있었음
         printer.print(activities[i]);
         // OCP - 기능 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
         // 출력형식에 대한 확장으로 구현체를 하나더 생성함.
         compactPrinter.print(activities[i]);
      }

      // 다형성이란 부모 타입의 변수에 자식 타입의 객체가 들어올 수 있다는 것. 곧 상속 관계 하에서만 발생한다.
      // 인터페이스 구현 관계도 다형성 발생이 가능합니다.

      Reviewable[] reviewables = {javaLecture, gitPractice, oopPractice, oopBook};
      System.out.println();
      System.out.println("=== 복습 필요 활동 ===");
      for (Reviewable reviewable : reviewables) {
         if (reviewable.needsReview()) {
            reviewable.printReviewTarget();
         }
      }

      Shareable[] shareables = {javaLecture, gitPractice, oopPractice, oopBook};

      System.out.println();
      System.out.println("=== 공유 가능한 활동 ===");
      for (Shareable shareable : shareables) {
         if (shareable.canShare()) {
            System.out.println(shareable.getShareTitle());
         }
      }


   }

}








