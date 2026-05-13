package oop.stream;

import java.util.Comparator;

import static oop.stream.Menu.MENU_LIST;

public class Sorting {
   public static void main(String[] args) {

      // 육류 요리 중 칼로리가 낮은 순으로 정렬하기
      MENU_LIST.stream()
            .filter(d-> d.getType().equals(Dish.Type.MEAT))
//            .sorted((o1, o2) -> o1.getCalories()  >o2.getCalories() ? 1 : -1)
            .sorted(Comparator.comparing(d -> d.getCalories()))
            .toList()
            .forEach(System.out::println);


      System.out.println("======================================================");
      // 전체 메뉴들을 내림차로 정렬
      //comparing(Dish::getName) 참조식으로 변경을 해야
      // Comparator.comparing(Dish::getName).reversed() 를 적용 할수 잇음.
      // 왜 참조식으로 변경을 해야하는거지?
      MENU_LIST.stream()
            .sorted(Comparator.comparing(Dish::getName).reversed())
            // 람다식만 사용할 경우 타입 추론이 Object로 잡힐 수 있으므로
            // (Dish dish) -> dish.getName() 컴파일러에게 명확하게 알려줘야함
            //.sorted(Comparator.comparing((Dish dish) -> dish.getName()).reversed())
            .toList()
            .forEach(System.out::println);


      System.out.println("======================================================");
      // 300 칼로리 이상인 요리중 칼로리가 낮은 탑3 요리를 필터링
      MENU_LIST.stream()
            .filter(d -> d.getCalories() >= 300)
            // 칼로리 오름차수, 칼로리가 같다면 이름 내림차순
            /*
            .sorted(Comparator.
                  comparing((Dish dish) -> dish.getCalories())
                  .thenComparing((Dish dish) -> dish.getName(), Comparator.reverseOrder())
            )
            */
            .sorted(Comparator.
                  comparing(Dish::getCalories)
                  .thenComparing(Dish::getName, Comparator.reverseOrder())
            )
            .limit(3)
            .forEach(System.out::println);



   }
}
