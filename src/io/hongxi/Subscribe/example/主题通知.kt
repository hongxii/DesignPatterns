package io.hongxi.Subscribe.example

/**
 * 通知者
 * */
interface 主题通知 {

    fun 增加观察者(观察主: 观察主)
    fun 移除观察者(观察主: 观察主)
    fun 通知()

    var 通知内容:String
}