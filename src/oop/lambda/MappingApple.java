package oop.lambda;

import java.util.ArrayList;
import java.util.List;

public class MappingApple {

   // 사과의 색상 추출
   public static List<Color> mappingApplyByColor(List<Apple> apples){
      List<Color>colors = new ArrayList<>();

      for (Apple apple : apples) {
         colors.add(apple.getColor());
      }

      return colors;
   }

   public static <X, Y> List<Y> map(List<X> list, GenericFunction<X,Y> mapper){
      List<Y> mappedList = new ArrayList<>();

      for (X x : list) {
         mappedList.add(mapper.apply(x));
      }

      return mappedList;
   }
}
