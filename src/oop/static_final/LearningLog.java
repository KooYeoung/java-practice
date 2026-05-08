package oop.static_final;

public class LearningLog {
   // 리뷰의 임계시간.
   // 상수(constant)는 대문자로 작성하는 것이 관례
   // 상수는 고정된 불변의 값을 의미. 모든 객체가 하나의 값을 공유하며, 코드로 절대 수정하지 못하는 값.
   private static final int REVIEW_THRESHOLD_MINUTES = 60;

   // 지금까지 LearningLog 객체가 몇 개 만들어졌는지 세는 변수
   private static int totalCreateCount = 0;

   private long id;
   private String title;
   private int minutes;
   private boolean publicLog;

   void printSummary() {
      // 3항 연산식: 조건식의 결과에 따라 변수에 대입할 값을 다르게 할당.
      // 논리형 조건식 ? 좌항 : 우항
      // 논리형 조건식이 true라면 좌항의 값이, false라면 우항의 값이 도출 됩니다.

      String visibility = this.publicLog ? "공개" : "비공개";
      System.out.println("#"+ this.id+ ". " + this.title + " - " + this.minutes + "분 - " + visibility);
   }

   boolean needsReview() {
      return minutes < REVIEW_THRESHOLD_MINUTES;
   }

   // 외부로 필드값을 돌려주는 getter 메서드
   // get + 필드이름으로 지어주는 것이 관례, boolean 타입의 값을 돌려주는 getter는 is로 시작하도록 이름을 짓습니다.
   // set + 필드이름으로 짓는 것이 관례
   public String getTitle(){
      return title;
   }

   public boolean isPublicLog() {
      return publicLog;
   }

   public int getMinutes() {
      return minutes;
   }

   LearningLog() {
      System.out.println("기본 생성자 호출");
   }

   LearningLog(String title, int minutes) {

      this(title, minutes, true);
   }

   LearningLog(String title, int minutes, boolean publicLog) {
      totalCreateCount++;
      this.id = totalCreateCount;
      this.title = normalizeTitle(title);;
      this.minutes = minutes;
      this.publicLog = publicLog;
   }

   // private 접근 제한을 지정하니가, 제대로 된 값도 수정이 불가능한 것을 확인
   // 필드 값을 대신 받아서 할당하고, 값을 돌려줄수 잇는 메서드를 활용해서 값을 보호하겠습니다.
   // 이때 사용하는 메서드의 이름을 getter, setter라고 합니다.

   public void extendStudy(int additionalMinutes) {
      if(additionalMinutes < 0){
         System.out.println("잘못된 공부 시간입니다.");
         return; // void 메서드에서 return은 메서드를 강제 종료합니다.
      }

      this.minutes += additionalMinutes;
   }

   public void changeTitle(String newTitle){
      this.title = normalizeTitle(newTitle);
   }

   // 이 메서드는 굳이 외부에서 알 필요가 없음. 호출할 일도 없음.
   // 이 클래스 안에서만 사용 할수 있도록 범위 지정
   private String normalizeTitle(String newTitle) {
      if(newTitle == null || newTitle.isBlank()){
         return "제목 없음";
      }
      return newTitle;
   }

   public void openToPublic(){
      this.publicLog = true;
   }

   public void hideFromPublic(){
      this.publicLog = false;
   }

   public static int getTotalCreateCount() {
      return totalCreateCount;
   }

//    public void setId(long id) {
//        this.id = id; -> final 필드라 더이상 수정이 불가능함!
//    }

}
