package io.hongxi.delegation

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * 委托模式-类委托&属性委托
 * Hongxii
 * 2018/10/27 16:27
 */

//region 类委托
interface Base {
    fun print()
}

class BaseImpl(val x:Int):Base {
    override fun print() {
        println("BaseImpl -> $x")
    }
}

class Printer(b:Base):Base by b
//endregion

//region 属性委托
class Example{
    var property:String by DelegateProperty()
}

class DelegateProperty( var temp:String="old"){
    operator fun getValue(ref: Any?, p: KProperty<*>): String {
        return "DelegateProperty --> ${p.name} --> $temp"
    }

    operator fun setValue(ref: Any?, p: KProperty<*>, value: String) {
        temp = value
    }
}
//endregion


//标准委托
//region 延迟属性
/**
 * 延迟属性-懒汉：
 * 定义的时候不进行初始化，
 * 延迟到第一次调用的时候。
 */

val lazyValue: String by lazy {
    println("Just run when first being used")
    "value"
}
//endregion

//region 可观察属性
/**
 * 观察者模式-类似给view加listener
 */
class User {
    var name: Int by Delegates.observable(0) {
        prop, old, new -> println("$old -> $new")
    }

    var gender: Int by Delegates.vetoable(0) {
        prop, old, new -> (old < new)
    }
}
//endregion

//region map映射

/**
 * 在解析 JSON 或者做其他"动态"事情的应用时，
 * 使用映射实例自身作为委托来实现委托属性。
 */

class Site(val map: Map<String, Any?>) {
    val name: String by map
    val url: String  by map
}

//对于var值使用MutableMap
class Site2(val map: MutableMap<String, Any?>) {
    val name: String by map
    val url: String by map
}

//endregion


fun main(args: Array<String>) {


    //类委托
    val b = BaseImpl(5)
    Printer(b).print()

    //属性委托
    val e=Example()
    println(e.property)
    e.property="new"
    println(e.property)

    //标准委托
    //  延迟属性
    println(lazyValue)
    println(lazyValue)

    //可观察属性
    val user = User()
    user.name = 2   // 输出 0 -> 2
    user.name = 1   // 输出 2 -> 1

    user.gender = 2
    println(user.gender)   // 输出 2
    user.gender = 1
    println(user.gender)   // 输出 2

    //map映射
    //构造函数接受一个映射参数
    val site = Site(mapOf(
            "name" to "虹西",
            "url"  to "gitmmp.com"
    ))
    // 读取映射值
    println(site.name)
    println(site.url)

    //map映射-var
    var map:MutableMap<String, Any?> = mutableMapOf(
            "name" to "hongxi",
            "url" to "hongxi.io"
    )

    val site2 = Site2(map)

    println(site.name)
    println(site.url)

    println("--------------")
    map.put("name", "Google")
    map.put("url", "www.google.com")

    println(site.name)
    println(site.url)



}