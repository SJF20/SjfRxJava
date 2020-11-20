package com.shijingfeng.rxjavamini

import com.shijingfeng.rxjavamini.operator.SjfMapObservable

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

    /**
     * 类型转换
     *
     * @param func 自定义类型转换函数
     */
    fun <R> map(func: (T) -> R): SjfObservable<R> {
        val mapObservable = SjfMapObservable(mSource, func)

        return SjfObservable(mapObservable)
    }

    fun subscribe(observer: SjfObserver<T>) {
        observer.onSubscribe()
        mSource?.subscribe(observer)
    }

}