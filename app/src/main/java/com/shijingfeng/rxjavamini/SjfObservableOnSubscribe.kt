package com.shijingfeng.rxjavamini

/**
 * Function: 被观察者 接口
 * Date: 2020/11/19 16:11
 * Description:
 * @author ShiJingFeng
 */
interface SjfObservableOnSubscribe<T> {

    /**
     * 订阅被观察者
     *
     * @param observer 被观察者
     */
    fun subscribe(observer: SjfObserver<T>)

}