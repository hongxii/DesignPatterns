package io.hongxi.delegation

import java.beans.EventHandler
import kotlin.properties.Delegates

/**
 * Hongxii
 * 2018/10/29 16:54
 */

class ObserverStoker(val name:String,val sub:Subject){

    fun CloseStockMarket(){
        println("关闭股票行情，继续工作")
    }
}

class ObserverNBA(val name:String,val sub:Subject){
    fun CloseStockMarket(){
        println("关闭NBA直播，继续工作")
    }
}

interface Subject{
    fun Notify()
    var SubjectState: String
}




class Boss:Subject{

    override fun Notify() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override var SubjectState: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
}