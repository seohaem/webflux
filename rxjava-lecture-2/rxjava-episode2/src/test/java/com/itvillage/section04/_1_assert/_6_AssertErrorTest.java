package com.itvillage.section04._1_assert;

import com.itvillage.section03.RxJavaTest;
import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertError를 이용하여 데이터 통지 중에 에러가 발생했는지를 검증하는 예제
 *
 * - 해당 시점까지 에러 통지가 있으면 테스트에 성공한다.
 * - 단순히 에러 통지가 있었는지의 여부와 구체적으로 발생한 에러가 맞는지를 테스트할 수 있다.
 */
public class _6_AssertErrorTest extends RxJavaTest {
    // 단순히 예외가 발생했는지를 테스트하는 예제
    @Test
    public void assertErrorTest01() {
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(data -> {
                    long value;
                    if(data == 4)
                        value = data / 0;
                    else
                        value = data / 2;
                    return value;
                })
                .test()
                .awaitDone(1000L, TimeUnit.MILLISECONDS)
                .assertError(Throwable.class); // 예외가 발생함을 의미
    }

    // 구체적인 예외 클래스를 비교 테스트하는 예제
    @Test
    public void assertErrorTest02() {
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(data -> {
                    long value;
                    if(data == 4)
                        value = data / 0;
                    else
                        value = data / 2;
                    return value;
                })
                .test()
                .awaitDone(1000L, TimeUnit.MILLISECONDS)
                .assertError(error -> error.getClass() == ArithmeticException.class); // 특정 에러가 맞는지 검증
    }

}
