package com.shijingfeng.rxjavamini

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.e
import com.shijingfeng.rxjavamini.SjfObservable.Companion.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        create(object : SjfObservableOnSubscribe<String> {
            /**
             * 订阅被观察者
             *
             * @param observer 被观察者
             */
            override fun subscribe(observer: SjfObserver<String>) {
                e("测试", "1")
                observer.onNext("你好")
            }
        }).subscribe(object : SjfObserver<String> {

            /**
             * 订阅回调
             */
            override fun onSubscribe() {

            }

            /**
             * 数据响应回调
             */
            override fun onNext(data: String) {
                e("测试", data)
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