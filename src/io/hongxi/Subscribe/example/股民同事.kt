package io.hongxi.Subscribe.example

class 股民同事(name:String, sub: 主题通知): 观察主(name, sub) {

    override fun 更新() {
        println("${sub.通知内容} + $name 关闭股票行情,继续工作")
    }
}