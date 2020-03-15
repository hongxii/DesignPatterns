package test

import java.nio.file.Files
import java.nio.file.Paths

/**
 * @author :Hongxii
 * @date : 2019/2/21 09:41

 */

fun main(args: Array<String>) {

    var m = "哈哈哈\$木有数字"

    m=m.replace("$","#")
    println(m[3])

    m=m.replace("#","$")
    println(m[3])

    m=m.replace("$","#")
    println(m[3])

    val list=ArrayList<String>()
    val stream = Files.newInputStream(Paths.get("D:\\tttt.txt"))
    stream.buffered().reader().use { reader -> list.add(reader.readText()) }

    var n = list.get(0)
    println(n)

    n=n.replace("$","#")
    println(n[3])

    n=n.replace("#","$")
    println(n[3])

    n=n.replace("$","#")
    println(n[3])






}