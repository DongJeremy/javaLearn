package org.cloud.funcDemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Trade {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));
        // 找出2011年的所有交易并按交易额排序（从低到高）
        List<Transaction> tr2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(tr2011);

        // 交易员都在哪些不同的城市工作过
        List<String> cities = transactions.stream()
                .map(t -> t.getTrader().getName()).distinct()
                .collect(Collectors.toList());
        System.out.println(cities);

        // 查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> traders = transactions.stream().map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge")).distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(traders);

        // 返回所有交易员的姓名字符串，按字母顺序排序
        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct().sorted().reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);

        // 打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue).forEach(System.out::println);
    }
}
