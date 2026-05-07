package oop.constructor;

public class SprintLogApp {
   public static void main(String[] args) {

     LearningLog javaLog =  new LearningLog("Java 시작", 40);
     LearningLog gitLog =  new LearningLog("Git 시작", 30,  false);
     LearningLog conditionLog =  new LearningLog("조건문 시작", 75 );
     LearningLog loopLog =  new LearningLog("반복문 시작", 120);
     javaLog.printSummary();

   }
}
