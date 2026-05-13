package oop.stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static oop.stream.Menu.MENU_LIST;

public class Grouping {
   public static void main(String[] args) {

      // 채식요리와 아닌 요리로 메뉴를 나눠보자
      // 두 분류 나누어 줌.(분류 기준을 논리값으로 전달해 주어야 합니다.)

      // partitioningBy는 조건식 Predicate 기준으로 true 그룹 / false 그룹으로 딱 둘로 나누는 기능입니다.
      Map<Boolean, List<Dish>> vegetarianDishMap = MENU_LIST.stream()
            .collect(Collectors.partitioningBy(d -> d.isVegetarian()));


      System.out.println("채식 메뉴");
      vegetarianDishMap.get(true).forEach(System.out::println);

      System.out.println("일반 메뉴");
      vegetarianDishMap.get(false).forEach(System.out::println);

      System.out.println();
      System.out.println("=====================================================");


      // 요리를 종류(Type)별로 그룹화 해 줘
      // groupingBy는 특정 값을 기준으로 여러 그룹으로 나누는 기능입니다.
      Map<Dish.Type, List<Dish>> dishesGroupedByType = MENU_LIST.stream()
            .collect(Collectors.groupingBy(d -> d.getType()));

      dishesGroupedByType
            .forEach((k, v) -> {
               System.out.println("===============" + k + "===============");
               v.forEach(System.out::println);
               System.out.println("=====================================");
            });

      System.out.println();
      System.out.println("육류 메뉴");
      dishesGroupedByType
            .get(Dish.Type.MEAT)
            .forEach(System.out::println);

      System.out.println("=====================================");
      System.out.println();
      // 종류별로 나눈 메뉴를
      // 칼로리 기준(500 넘으면 고칼리로, 나머지 저칼로리)
      // 채식 까지..?
      Map<Dish.Type, Map<String, Map<Boolean, List<Dish>>>> caloricVegetarianMap = MENU_LIST.stream()
            .collect(Collectors.groupingBy((Dish d) -> d.getType()
                  , Collectors.groupingBy((Dish d2) -> d2.getCalories() > 500 ? "고칼로리" : "저칼로리"
                        , Collectors.partitioningBy((Dish d3) -> d3.isVegetarian()
                        )
                  )));

      caloricVegetarianMap.forEach((k, v) -> {
         System.out.println("===============" + k + "===============");
         v.forEach((k1, v1) -> {
            System.out.println("===============" + k1 + "===============");
            v1.forEach((k2, v2) -> {
               if (v2.isEmpty()) return;
               System.out.println("===============" + k2 + "===============");
               v2.forEach(System.out::println);
               System.out.println("=====================================");
            });
         });
      });


      System.out.println("=====================================");

      Map<Dish.Type, Long> dishCountByType = MENU_LIST.stream()
            .collect(Collectors.groupingBy(d -> d.getType()
                  , Collectors.counting()));

      System.out.println("dishCountByType = " + dishCountByType);

      System.out.println("=====================================");

      // 종류별 요리 총 칼로리
      Map<Dish.Type, Integer> calorieSummaryByType = MENU_LIST.stream()
            .collect(
                  Collectors.groupingBy(d -> d.getType(),
                        Collectors.summingInt(d -> d.getCalories())));

      System.out.println("calorieSummaryByType = " + calorieSummaryByType);
      System.out.println("=====================================");

      // 요리 종류별 그룹화 후 칼로리에 대한 통계 꾸러미가 리턴됨 (개수, 평균, 합계, 최대/최소)
      Map<Dish.Type, IntSummaryStatistics> typeCaloriesSummary = MENU_LIST.stream()
            .collect(Collectors.groupingBy(d -> d.getType()
                  , Collectors.summarizingInt(d -> d.getCalories())));

      typeCaloriesSummary.forEach((k, v) -> {
         System.out.println("===============" + k + "===============");
         System.out.println("v = " + v);
      });

   }
}
