package com.shijingfeng.rxjavamini

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.e

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        SjfObservable.create(object : SjfObservableOnSubscribe<Int> {
            /**
             * 订阅被观察者
             *
             * @param observer 被观察者
             */
            override fun subscribe(observer: SjfObserver<Int>) {
                e("测试", "1")
                observer.onNext(1)
            }
        }).map {
            "数字: $it"
        }.subscribe(object : SjfObserver<String> {
            /**
             * 订阅回调
             */
            override fun onSubscribe() {

            }

            /**
             * 数据响应回调
             */
            override fun onNext(data: String) {
                e("测试", "onNext: $data")
            }

            /**
             * 错误回调
             *
             * @param e 错误
             */
            override fun onError(e: Throwable) {

            }

            /**
             * 完成回调
             */
            override fun onComplete() {

            }
        })
    }

}