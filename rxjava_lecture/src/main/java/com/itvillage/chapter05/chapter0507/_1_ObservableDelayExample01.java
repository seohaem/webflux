package com.itvillage.chapter05.chapter0507;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 통지된 데이터를 소비자 쪽에서 전달 받는 시간을 일정 시간동안 지연 시키는 예제
 */
public class _1_ObservableDelayExample01 {
    public static void main(String[] args) {
        Logger.log(LogType.PRINT, "# 실행 시작 시간: " + TimeUtil.getCurrentTimeFormatted());

        // 4개의 숫자 통지
        Observable.just(1, 3, 4, 6)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .delay(2000L, TimeUnit.MILLISECONDS) // 2초 지연
                // 소비자쪽에서 2초가 지난 후 데이터를 받는다.
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2500L);
    }
}
