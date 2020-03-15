package io.hongxi.Subscribe.example

fun main(args: Array<String>) {

    val 大BOSS=Boss()     //老板
    val 韭菜=股民同事("韭菜",大BOSS)  //股民同事
    val 林书豪=球迷同事("林书豪",大BOSS)   //NBA同事

    大BOSS.增加观察者(林书豪)
    大BOSS.增加观察者(韭菜)

    大BOSS.移除观察者(韭菜)

    //老板回来了
    大BOSS.通知内容="大BOSS回来了"
    //Notify
    大BOSS.通知()
}
