package io.hongxi.abstractFactory.Abstract


/**
 * 抽象工厂模式
 * @author :Hongxii
 * @date : 2018/11/10 16:41
 */

data class User(var id: Int, var name: String)

interface IUser {

    fun Insert(user: User)

    fun GetUser(id: Int): User
}

class UserSqlserver : IUser {

    override fun Insert(user: User) {
        println("在SQL Server中给User表加一条记录")
    }

    override fun GetUser(id: Int): User {
        println("在SQL Server中根据ID得到User表一条记录")
        return User(0, "")
    }
}

class UserAccess : IUser {

    override fun Insert(user: User) {
        println("在Access Server中给User表加一条记录")
    }

    override fun GetUser(id: Int): User {
        println("在Access Server中根据ID得到User表一条记录")
        return User(0, "")
    }
}


data class Department(var id: Int, var name: String)

interface IDepartment {

    fun Insert(department: Department)

    fun GetDepartment(id: Int): Department
}

class DepartmentSqlServer : IDepartment {
    override fun Insert(department: Department) {
        println("在SQL Server中给Department表加一条记录")
    }

    override fun GetDepartment(id: Int): Department {
        println("在SQL Server中根据ID得到Department表一条记录")
        return Department(0, "")
    }
}

class DepartmentAccess : IDepartment {
    override fun Insert(department: Department) {
        println("在Access Server中给Department表加一条记录")
    }

    override fun GetDepartment(id: Int): Department {
        println("在Access Server中根据ID得到Department表一条记录")
        return Department(0, "")
    }
}

interface IFactory {
    fun CreateUser(): IUser
    fun CreateDepartment(): IDepartment
}

class FactorySqlServer : IFactory {

    override fun CreateUser(): IUser {
        return UserSqlserver()
    }

    override fun CreateDepartment(): IDepartment {
        return DepartmentSqlServer()
    }
}

class FactoryAcess : IFactory {
    override fun CreateUser(): IUser {
        return UserAccess()
    }

    override fun CreateDepartment(): IDepartment {
        return DepartmentAccess()
    }
}

fun main(args: Array<String>) {

    val user = User(0, "")
    val department = Department(0, "")

    val factory = FactoryAcess()

    //以下已与具体的数据库访问解除了依赖
    val iu = factory.CreateUser()
    iu.Insert(user)
    iu.GetUser(0)

    val id = factory.CreateDepartment()
    id.Insert(department)
    id.GetDepartment(0)

    //Output
    /**
     * 在Access Server中给User表加一条记录
     * 在Access Server中根据ID得到User表一条记录
     *
     * 在Access Server中给Department表加一条记录
     * 在Access Server中根据ID得到Department表一条记录
     */
}