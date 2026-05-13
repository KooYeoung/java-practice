package oop.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static oop.stream.Menu.MENU_LIST;

public class Finding {
   public static void main(String[] args) {
      // 메뉴 목록에서 500칼로리 이상 요리 중 채식주의자가 먹을 수 있는 요리가 하나라도 존재 하는가?
      boolean b = MENU_LIST.stream()
            .filter(d -> d.getCalories() >= 500)
            .anyMatch(Dish::isVegetarian);

      System.out.println("b = " + b);
      // 메뉴 목록 중 칼로리가 100 이하인 요리가 하나라도 존재 하는가?
      boolean b1 = MENU_LIST.stream()
            .anyMatch(d -> d.getCalories() < 100);
      System.out.println("b1 = " + b1);

      // 음식 메뉴 중에 모든 요리가 1000칼로리 미만 인가요?
      boolean b2 = MENU_LIST.stream()
            .allMatch(d -> d.getCalories() < 1000);
      System.out.println("b2 = " + b2);

      // 음식 메뉴 중에 모든 요리가 1000칼로리 미만이 아닌가요?
      boolean b3 = MENU_LIST.stream()
            .noneMatch(d -> d.getCalories() > 1000);
      System.out.println("b3 = " + b3);

      // 음식 중에 칼로리가 제일 낮은 애가 누구에요?
      Dish dish = MENU_LIST.stream()
            .min(Comparator.comparing(Dish::getCalories))
            .get();
      System.out.println("dish = " + dish);

   }

}
