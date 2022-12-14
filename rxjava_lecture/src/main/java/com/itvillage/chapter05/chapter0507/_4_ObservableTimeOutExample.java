package com.itvillage.chapter05.chapter0507;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 각 데이터 통지 시, 지정한 시간안에 데이터가 통지 되지 않으면 에러를 발생시키는 예제
 * - 네트워크 연결 지연 등으로 인한 처리를 위해 사용하기 좋은 연산자임.
 */
public class _4_ObservableTimeOutExample {
    public static void main(String[] args) {
        Observable.range(1, 5) // 1부터 5까지 통지
                .map(num -> {
                    long time = 1000L; // 1초 지연시간

                    if (num == 4) {
                        time = 1500L; // 1.5초 지연시간
                    }

                    TimeUtil.sleep(time);

                    return num;
                })
                // 시간 초과시 에러를 통지한다.
                .timeout(1200L, TimeUnit.MILLISECONDS) // 1.2초 설정 (num == 4 일때 오류)
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        // 시간초과시 error 메서드가 수행된다.
                        // 에러 통지시 전달되는 에러 객체는 TimeoutException이다.
                        error -> Logger.log(LogType.ON_ERROR, error)
                );

        TimeUtil.sleep(4000L);
    }
}
