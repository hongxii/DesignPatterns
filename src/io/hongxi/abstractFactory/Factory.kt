package io.hongxi.abstractFactory

/**
 * 工厂模式
 * @author :Hongxii
 * @date : 2018/11/10 14:58
 */

data class User(var id:Int, var name:String)

interface IUser{

    fun Insert(user:User)

    fun GetUser(id:Int):User
}


class UserSqlserver:IUser{

    override fun Insert(user: User) {
        println("在SQL Server中给User表加一条记录")
    }

    override fun GetUser(id:Int):User {
        println("在SQL Server中根据ID得到User表一条记录")
        return User(0,"")
    }
}

class UserAccess:IUser{

    override fun Insert(user: User) {
        println("在Access Server中给User表加一条记录")
    }

    override fun GetUser(id:Int):User {
        println("在Access Server中根据ID得到User表一条记录")
        return User(0,"")
    }
}


interface IFactory{
    fun CreateUser():IUser
}

class FactorySqlServer:IFactory{

    override fun CreateUser(): IUser {
        return UserSqlserver()
    }
}

class FactoryAcess:IFactory{
    override fun CreateUser(): IUser {
        return UserAccess()
    }
}

fun main(args: Array<String>) {


    val user=User(0,"")

    val factory=FactorySqlServer()
    val iu=factory.CreateUser()

    iu.Insert(user)
    iu.GetUser(0)

    /**
     *  输出
     *  在SQL Server中给User表加一条记录
     *  在SQL Server中根据ID得到User表一条记录
     */

}


