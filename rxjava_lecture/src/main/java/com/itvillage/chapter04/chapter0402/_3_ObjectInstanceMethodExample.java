package com.itvillage.chapter04.chapter0402;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * Object::instance method 예
 */
public class _3_ObjectInstanceMethodExample {
    public static void main(String[] args) {
        final CarInventory carInventory = new CarInventory(10);

        // 람다 내부에 참조할 메서드가 있는 경우
        Function<Integer, Integer> f1 = count -> carInventory.getExpectedTotalCount(count);
        int totalCount1 = f1.apply(10);
        System.out.println(totalCount1);

        // 이렇게 파라미터, 리턴 타입이 같을 경우 UnaryOperator 를 사용할 수 있다.
        Function<Integer, Integer> f2 = carInventory::getExpectedTotalCount;
        int totalCount2 = f2.apply(20);
        System.out.println(totalCount2);

        // T -> T
        UnaryOperator<Integer> f3 = carInventory::getExpectedTotalCount;
        int totalCount3 = f3.apply(30);
        System.out.println(totalCount3);

        // Integer -> Integer
        IntUnaryOperator f4 = carInventory::getExpectedTotalCount;
        int totalCount4 = f4.applyAsInt(40);
        System.out.println(totalCount4);
    }
}
