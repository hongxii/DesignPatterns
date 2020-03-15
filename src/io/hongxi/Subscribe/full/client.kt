package io.hongxi.Subscribe.full

fun main(args: Array<String>) {

    val s=Subject1("ABC")

    s.Attach(Observer1(s,"X"))
    s.Attach(Observer1(s,"Y"))
    s.Attach(Observer1(s,"Z"))

    s.Notify()
}