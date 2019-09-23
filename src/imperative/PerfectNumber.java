package imperative;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class PerfectNumber {

    public enum STATE{
        ABUNDANT,
        DEFICIENT,
        PERFECT
    }

    public static Set<Integer> divisors(int n){
        Set<Integer> integerSet = new HashSet<>();

        IntStream.range(1, (int) Math.ceil(Math.sqrt(n) + 1))
                .filter(i -> n % i == 0)
                .forEach(i -> {
                    integerSet.add(i);
                    integerSet.add(n / i);
                });

        return integerSet;
    }

    public static STATE process(int n) {
        Set<Integer> divisorsN = divisors(n);

        Integer sum = divisorsN.stream()
                .filter(j -> !j.equals(n))
                .reduce(0, Integer::sum);

        return sum == n ? STATE.PERFECT : sum < n ? STATE.DEFICIENT : STATE.ABUNDANT;
    }
}
