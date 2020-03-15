package io.hongxi.Subscribe.example

abstract class 观察主(
    protected  val name: String,
    protected  val sub: 主题通知
){
    abstract fun 更新()
}