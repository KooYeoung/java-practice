package oop.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static oop.stream.Menu.MENU_LIST;

public class Mapping {
   public static void main(String[] args) {
      // map : 리스트에서 원하는 데이터만 추출
      // original : [ {}, {}, {}, {}, {} ]
      // filter   : [ {}, {}, {} ]
      // map      : [ "", "", "", "", "" ]


      // toList(): 자바 16부터 쓸 수 있음. 불변 리스트 -> 수정 안됨!
      // collect(Collectors.toList()): 자바 8부터 존재하던 방식 -> 수정 자유로움
      List<String> dishNames = MENU_LIST.stream()
            .map(d -> d.getName())
            .collect(Collectors.toList());

      System.out.println("dishNames = " + dishNames);

      System.out.println("==========================================================");
      List<String> browsers = List.of("safari", "chrome", "ms edge", "firefox", "opera");

      // 문자열 길이만 추출
      List<Integer> list = browsers.stream()
            .map(b -> b.length())
            .toList();
      System.out.println("list = " + list);

      List<Character> characters = browsers.stream().map(b -> b.toUpperCase().charAt(0))
            .toList();
      System.out.println("characters = " + characters);

      System.out.println("==========================================================");

      List<SimpleDish> simpleDishes = MENU_LIST.stream()
            .map(d -> new SimpleDish(d.getName(), d.getCalories()))
            .toList();
      System.out.println("simpleDishes = " + simpleDishes);

      System.out.println("==========================================================");
      /*
            메뉴 목록에서 칼로리가 500칼로리보다 큰
            음식들을 필터링한 다음에

            음식의 이름과 타입만 추출해서 출력해주세요. -> DishDetail이라는 객체로 맵핑

            단, 타입은 MEAT의 경우 육류라고 저장
            , FISH는 어류라고 저장
            , OTHER는 기타라고 저장
      */

      List<DishDetail> dishDetails = MENU_LIST.stream()
            .filter(d -> d.getCalories() > 500)
            .map(d -> new DishDetail(d.getName(), d.getType().getDesc()))
            .toList();

      System.out.println("dishDetails = " + dishDetails);
      System.out.println("==========================================================");

      //메뉴 목록에 있는 요리들의 총 칼로리 구하기
      int totalCalories = MENU_LIST.stream()
            .mapToInt(d -> d.getCalories())
            .sum();
      System.out.println("totalCalories = " + totalCalories);

      double averageMeatCalories = MENU_LIST.stream()
            .filter(d -> d.getType().equals(Dish.Type.MEAT))
            .mapToInt(d -> d.getCalories())
            .average()
            .getAsDouble();

      System.out.println("averageMeatCalories = " + averageMeatCalories);
      System.out.printf("averageMeatCalories = %.2f%n", averageMeatCalories);
      System.out.println("==========================================================");

      // 모든 요리 이름에 포함된 알파벳을 중복 없이 추출.
      // flatMap: map처럼 변환을 하긴 하는데, 그 결과는 반드시 stream 이어야 한다.
      // 여러개의 스트림을 단일 스트림으로 합쳐줍니다.

      List<String> distinctIngredients = MENU_LIST.stream()
            .map(d -> d.getName().trim().split(""))
            .flatMap(d -> Arrays.stream(d))
            .filter(s -> !s.isBlank())
            .distinct()
            .toList();

      System.out.println("list1 = " + distinctIngredients);


      //메뉴 목록에 있는 요리들의 총 칼로리 구하기

      Map<Dish.Type, List<Dish>> collect = MENU_LIST.stream()
            .collect(Collectors.groupingBy(d -> d.getType()));

      System.out.println("collect = " + collect);


   }
}
