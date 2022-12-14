package com.itvillage.section00;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.subjects.AsyncSubject;

/**
 * 구독 시점에 상관없이 모든 소비자들이 마지막으로 통지된 데이터만 전달 받는 AsyncSubject 예제
 *
 * - 완료 전까지 아무것도 통지하지 않고 있다가 완료했을때 마지막으로 통지한 데이터와 완료만 통지한다.
 * - 모든 소비자는 구독 시점에 상관없이 마지막으로 통지된 데이터와 완료 통지만 받는다.
 * - 완료 후에 구독한 소비자라도 마지막으로 통지된 데이터와 완료 통지를 받는다.
 */
public class AsyncSubjectExample {
    public static void main(String[] args){
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.onNext(1000);

        subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 1 : " + price))
                .subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 1 : " + price));
        subject.onNext(2000);

        subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 2 : " + price))
                .subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 2 : " + price));
        subject.onNext(3000);

        subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 3 : " + price))
                .subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 3 : " + price));
        subject.onNext(4000);

        subject.onComplete();

        // 완료가 통지된 이후 구독하더라도 마지막 데이터를 보낸다.
        subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 4 : " + price))
                .subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 4 : " + price));
    }
}