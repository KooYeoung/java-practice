package oop.stream.quiz;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

   public static void main(String[] args) {
      Trader raoul = new Trader("Raoul", "Cambridge");
      Trader mario = new Trader("Mario", "Milan");
      Trader alan = new Trader("Alan", "Cambridge");
      Trader brian = new Trader("Brian", "Cambridge");

      List<Transaction> transactions = List.of(
            new Transaction(brian, 2021, 300),
            new Transaction(raoul, 2022, 1000),
            new Transaction(raoul, 2021, 400),
            new Transaction(mario, 2021, 710),
            new Transaction(mario, 2022, 700),
            new Transaction(alan, 2022, 950)
      );

      // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).

      transactions
            .stream()
            .filter(t -> t.getYear() == 2021)
            .sorted(Comparator.comparing(t -> t.getValue()))
            .forEach(System.out::println);
      System.out.println("=============================================");


      // 연습 2: 거래자가 근무하는 모든 도시이름을 중복 없이 나열하시오.
      transactions
            .stream()
            .map(t -> t.getTrader().getCity())
            .distinct()
            .forEach(System.out::println);
      System.out.println("=============================================");


      // 연습 3: Cambridge에 근무하는 모든 거래자(Trader)를 찾아
      // 거래자 리스트로 이름순으로 오름차 정렬.
      transactions
            .stream()
            .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
            .map(t -> t.getTrader())
            .sorted(Comparator.comparing(t  -> t.getName()))
            .forEach(System.out::println);
      System.out.println("=============================================");


      // 연습 4: 모든 거래자의 이름을 리스트에 모아서
      // 알파벳순으로 오름차 정렬하여 반환
      transactions
            .stream()
            .map(t -> t.getTrader().getName())
            .distinct()
            .sorted()
            .toList()
            .forEach(System.out::println);
      System.out.println("=============================================");


      // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?
      boolean hasTransactionsInMilan = transactions
            .stream()
            .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));

      System.out.println("hasTransactionsInMilan = " + hasTransactionsInMilan);
      System.out.println("=============================================");


      // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.
      int totalValueFromCambridge = transactions
            .stream()
            .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
            .mapToInt(t -> t.getValue())
            .sum();

      System.out.println("totalValueFromCambridge = " + totalValueFromCambridge);
      System.out.println("=============================================");


      // 연습 7: 모든 거래에서 최고거래액은 얼마인가?
      Transaction maxTransaction = transactions
            .stream()
            .max(Comparator.comparing(t -> t.getValue()))
            .get();
      System.out.println("maxTransaction = " + maxTransaction);
      System.out.println("=============================================");


      // 연습 8. 가장 작은 거래액을 가진 거래정보 탐색
      Transaction minTransaction = transactions
            .stream()
            .min(Comparator.comparing(t -> t.getValue()))
            .get();
      System.out.println("minTransaction = " + minTransaction);
      System.out.println("=============================================");

      // 연습 9. 거래액이 500 이상인 거래들만 필터링하고,
      // 해당 거래의 정보를 출력하시오.
      transactions
            .stream()
            .filter(t -> t.getValue() >= 500)
            .toList()
            .forEach(System.out::println);
      System.out.println("============================X=================");

      int minTransactionValue = (transactions.stream().min(Comparator.comparing(t2 -> t2.getValue())).get()
      ).getValue();

      // 연습 10. 모든 거래에서 가장 작은 거래액보다
      // 큰 거래액을 가진 거래의 평균을 계산하시오.
      // 출력값: 752.0
      double averageTransactionValue = transactions
            .stream()
            .filter(t -> t.getValue() > minTransactionValue )
            .mapToInt(t -> t.getValue())
            .average()
            .getAsDouble();
      System.out.println("averageTransactionValue = " + averageTransactionValue);


      System.out.println("=============================================");

      // 연습 11. "Cambridge"에서 거래하는 모든 거래자의 거래 정보를 연도별로 그룹화해서
      // 출력하세요.
      transactions
            .stream()
            .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
            .collect(Collectors.groupingBy(t -> t.getYear()))
            .forEach((year, transactionsInYear) -> {
               System.out.println("Year: " + year);
               transactionsInYear.forEach(System.out::println);
            });

        /*
        Year: 2021
        {Trader: Brian in Cambridge, year: 2021, value: 300}
        {Trader: Raoul in Cambridge, year: 2021, value: 400}
        ...

        Year: 2022
        {Trader: Raoul in Cambridge, year: 2022, value: 1000}
        ...
        */

      // key: 거래연도, value: 거래내역을 담은 리스트
      HashMap<Integer, List<Transaction>> groupByYearMap = new HashMap<>();


   }

}

