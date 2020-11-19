package com.shijingfeng.rxjavamini

/**
 * Function: 观察者 接口
 * Date: 2020/11/19 16:10
 * Description:
 * @author ShiJingFeng
 */
interface SjfObserver<T> {

    /**
     * 订阅回调
     */
    fun onSubscribe()

    /**
     * 数据响应回调
     */
    fun onNext(data: T)

    /**
     * 错误回调
     *
     * @param e 错误
     */
    fun onError(e: Throwable)

    /**
     * 完成回调
     */
    fun onComplete()

}