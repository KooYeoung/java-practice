package oop.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class HashMapExample {
   public static void main(String[] args) {
        /*
        # Map
        - Key / Value가 한 세트를 이루는 자료구조
        - Key값을 통해 Value를 참조하는 방식 (인덱스 x)
        - Key는 중복 저장을 허용하지 않는다.
         */

      // Map은 Key, Value 쌍을 이루기 때문에 멀티 제네릭을 선언.

      Map<String, String> map = new HashMap<>();

      map.put("멍멍이","홍길동");
      map.put("야옹이","김철수");
      map.put("짹짹이","빅영희");
      System.out.println("map = " + map);

      // Key를 중복 사용해서 put을 호출하면 기존 key에 맵핑된 value가 수정된다.
      map.put("멍멍이","김춘식");
      map.put("어흥이","홍길동");
      System.out.println("map = " + map);

      // key의 존재 유무를 확인
      // value 얻기: get(key)
      String nick ="메뚜기";
      if(map.containsKey(nick)) {
         System.out.printf("별명이 %s인 학생의 이름은 %s입니다.%n", nick, map.get(nick));
      }else{
         System.out.println("그런 별명은 없는데요~!");
      }

      // Map에서 Key들만 추출하는 메서드 keySet()
      for( String k :map.keySet()){
         String v = map.get(k);
         System.out.println("k = " + k);
         System.out.println("v = " + v);

         System.out.printf("key: %s, value: %s %n", k,v);
      }

      System.out.println("=========================================================");

      for(Map.Entry<String,String> entry : map.entrySet()){
         System.out.println("entry = " + entry);
         System.out.println("entry.getKey() = " + entry.getKey());
         System.out.println("entry.getValue() = " + entry.getValue());
      }

      String removeValue = map.remove("야옹이");
      System.out.println("removeResult = " + removeValue);
      System.out.println("map = " + map);

      map.clear();
      System.out.println("map = " + map);

      // Collections의 메서드는 Collection 인터페이스 타입을 전달받기 때문에
      // Map 사용이 힘들어요
//      Collections.addAll(map,"1","1","1","1","1","1");



   }
}
