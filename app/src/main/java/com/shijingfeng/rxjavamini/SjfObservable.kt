package com.shijingfeng.rxjavamini

/**
 * Function: 被观察者 包装类
 * Date: 2020/11/19 15:57
 * Description:
 * @author ShiJingFeng
 */
class SjfObservable<T> constructor() {

    private var mSource: SjfObservableOnSubscribe<T>? = null

    companion object {
        fun <T> create(source: SjfObservableOnSubscribe<T>) = SjfObservable(source)
    }

    constructor(source: SjfObservableOnSubscribe<T>): this() {
        this.mSource = source
    }

    fun subscribe(observer: SjfObserver<T>) {
        observer.onSubscribe()
        mSource?.subscribe(observer)
    }

}