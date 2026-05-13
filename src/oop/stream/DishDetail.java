package oop.stream;

public class DishDetail {

   private final String name;
   private final String type;


   public DishDetail(String name, String type) {
      this.name = name;
      this.type = type;
   }

   public DishDetail(Dish dish) {
      this(dish.getName(), dish.getType().getDesc());
   }


   @Override
   public String toString() {
      return "DishDetail{" +
            "name='" + name + '\'' +
            ", type='" + type + '\'' +
            '}';
   }
}
