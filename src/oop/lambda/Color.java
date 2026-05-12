package oop.lambda;

public enum Color {
   RED("빨강"),
   GREEN("초록"),
   YELLOW("노랑");

   private final String name;

    Color(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}
