package io.hongxi.Subscribe.example

class Boss:主题通知 {

    val 观察者列表=MutableList<观察主>(0,{股民同事("",Boss())})

    override fun 增加观察者(观察者: 观察主) {
        观察者列表.add(观察者)
    }

    override fun 移除观察者(观察者: 观察主) {
        观察者列表.remove(观察者)
    }

    override fun 通知(){
        for (ob in 观察者列表) ob.更新()
    }

    override var 通知内容=""
}