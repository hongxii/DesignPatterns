package io.hongxi.Subscribe.full

/**
 * 通知者
 * */
abstract class Subject {

    private val observers= MutableList<Observer>(0,{Observer1(Subject1(""),"")})

    fun Attach(ob: Observer){
        observers.add(ob)
    }
    fun Detach(ob: Observer){
        observers.remove(ob)
    }
    fun Notify(){
        for (o in observers)
            o.update()
    }
}