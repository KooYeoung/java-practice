package oop.stream;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;

import static oop.stream.Menu.*;

public class Filtering {

   public static void main(String[] args) {
      // 요리 메뉴 중 채식주의자가 먹을 수 있는 요리만 필터링
/*

      Stream<Dish> stream = MENU_LIST.stream();
      Stream<Dish> dishStream = stream.filter(new Predicate<Dish>() {
         @Override
         public boolean test(Dish t) {
            return t.isVegetarian();
         }
      });
      List<Dish> dishes = dishStream.toList();
      for (Dish dish : dishes) {
         System.out.println("dish = " + dish);
      }

*/
      List<Dish> vegetarianDishes = MENU_LIST
            .stream()
            .filter(Dish::isVegetarian)
            .toList();

      vegetarianDishes.forEach(d -> System.out.println(d));

      System.out.println("=======================================================================");
      // 메서드 체이닝 (method chaining): 리턴된 결과물을 변수에 할다 ㅇ없이 바로 호출 하는 문법
      MENU_LIST.stream()
            .filter(d-> d.getType().equals(Dish.Type.MEAT) && d.getCalories() <600)
            .toList()
            .forEach(d-> System.out.println(d));

      System.out.println("=======================================================================");

      MENU_LIST.stream()
            .filter(d-> d.getName().length() == 4)
            .toList()
            .forEach(System.out::println);

      System.out.println("=======================================================================");

      // 칼로리가 300칼로리보다 큰 요리 중 3개 까지만
      MENU_LIST.stream()
            .filter(d-> d.getCalories() > 300)
            .limit(3)
            .toList()
            .forEach(System.out::println);

      System.out.println("=======================================================================");

      // 칼로리가 300칼로리보다 큰 요리 중 처음 2개 제끼고 가져와
      MENU_LIST.stream()
            .filter(d-> d.getCalories() > 300)
            .skip(2)
            .toList()
            .forEach(System.out::println);

      System.out.println("=======================================================================");
      // 중복제거.
      List<Integer> numbers = List.of(1, 2, 1, 3, 3, 2, 4, 4, 5, 6);

      numbers.stream()
            .filter(n -> n % 2 == 0)
            .distinct()
            .toList()
            .forEach(System.out::println);



   }
}
