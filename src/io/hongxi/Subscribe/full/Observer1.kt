package io.hongxi.Subscribe.full

class Observer1(
        private val subject: Subject1,
        private val name:String             ):Observer() {

    private var observerDo:String=""
    override fun update() {
        observerDo=subject.state
        println("观察者$name 的新状态是 $observerDo")
    }
}