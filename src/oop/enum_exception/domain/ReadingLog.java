package oop.enum_exception.domain;

import oop.enum_exception.policy.Reviewable;
import oop.enum_exception.policy.Shareable;

public class ReadingLog extends LearningActivity implements Reviewable, Shareable {

   private String bookTitle;

   public ReadingLog(String title, int minutes, Visibility visibility, String bookTitle, ActivityCategory category) {
      super(title, minutes, visibility,category);
      this.bookTitle = bookTitle;
   }


   @Override
   public boolean needsReview() {
      return getCategory().isShortStudy(getMinutes());
   }

   @Override
   public void printReviewTarget() {
      System.out.println("[복습 권장]" + getTitle() + " ("+ bookTitle + ")");
   }

   @Override
   public boolean canShare() {
      return isPublicActivity();
   }

   @Override
   public String getShareTitle() {
      return getTitle();
   }

   @Override
   public String getActivityType() {
      return getCategory().getLabel();
   }

   @Override
   public String getDetailText() {
      return "책: " + bookTitle;
   }
}