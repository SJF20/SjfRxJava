package com.shijingfeng.rxjavamini.operator

import com.shijingfeng.rxjavamini.SjfObservableOnSubscribe
import com.shijingfeng.rxjavamini.SjfObserver

/**
 * Function: map操作符 被观察者 (起到承接上游和下游的作用)
 * Date: 2020/11/20 9:20
 * Description:
 * @author ShiJingFeng
 */
class SjfMapObservable<T, R>(
    source: SjfObservableOnSubscribe<T>?,
    func: (T) -> R
) : SjfObservableOnSubscribe<R> {

    /** 上游被观察者 */
    private val mSource = source
    private val mFunc = func

    /**
     * 订阅被观察者
     *
     * @param observer 下游被观察者
     */
    override fun subscribe(observer: SjfObserver<R>) {
        val sjfMapObserver = SjfMapObserver(observer, mFunc)

        mSource?.subscribe(sjfMapObserver)
    }

}

/**
 * map操作符 观察者
 */
private class SjfMapObserver<T, R>(
    observer: SjfObserver<R>,
    func: (T) -> R
) : SjfObserver<T> {

    private val mObserver = observer
    private val mFunc = func

    /**
     * 订阅回调
     */
    override fun onSubscribe() {
        mObserver.onSubscribe()
    }

    /**
     * 数据响应回调
     */
    override fun onNext(data: T) {
        val newData = mFunc.invoke(data)

        mObserver.onNext(newData)
    }

    /**
     * 错误回调
     *
     * @param e 错误
     */
    override fun onError(e: Throwable) {
        mObserver.onError(e)
    }

    /**
     * 完成回调
     */
    override fun onComplete() {
        mObserver.onComplete()
    }

}