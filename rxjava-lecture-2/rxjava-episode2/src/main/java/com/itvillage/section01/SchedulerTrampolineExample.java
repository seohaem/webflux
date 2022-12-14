package com.itvillage.section01;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Schedulers.trampoline()을 이용하여 현재 실행되고 있는 쓰레드의 대기큐에 처리 작업을 등록하는 예제
 * - 대기 큐에 등록되는 순서대로 작업을 처리한다.
 */
public class SchedulerTrampolineExample {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("1", "2", "3", "4", "5");

        // 작업들은 순차적으로 수행되어야한다. > 동일한 main 스레드
        observable.subscribeOn(Schedulers.trampoline())
                // 통지되는 데이터에 ## 붙이기
                .map(data -> "## " + data + " ##")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        observable.subscribeOn(Schedulers.trampoline())
                // 통지되는 데이터에 $$ 붙이기
                .map(data -> "$$ " + data + " $$")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
