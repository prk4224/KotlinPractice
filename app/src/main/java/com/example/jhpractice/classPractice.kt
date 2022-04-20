package com.example.jhpractice

class classPractice {


}
// 생성자 : name :String /  constructor 도 생략가능 / "Anonymous" : default
open class Humen constructor(val name :String = "Anonymous"){

    /* java
        class Person(String name){

        }
        // overriding
        class Person(String name, int age){
            this(name)
        }

     */

    // java에서 overriding 한것처럼 부 생성자를 만들고 싶을 때,
    constructor(name : String, age : Int) : this(name){ // 주 생성자가 있을때는 반드시 this(name) 처럼 위임을 받아야 한다
        println("My name is ${name}, ${age} years old")
    }



    // 처음 인스턴스를 생성할 어떤 동작을 할지
    init{
        println("New humen has been born !! ")
    }

    // val name = "jaehong"

    // val name = name

    fun earingCake(){
        println("This is co YUMMY")
    }

    open fun singASong(){
        println("LaLaLa")
    }

}

// class 상속 ( java에서의 extends),
// Kotlin의 클래스는 기본적으로 final class이기 때문에
// 같은 파일 내에서도 접근이 불가능 그래서 부모 클래스에 접근 가능하도록
// 부모 클래스를 open 시켜준다
class Korean : Humen(){
    // overriding : class랑 마찬가지로 class 내의 함수에 접근하지 못해 부모 클래스의 함수를 open해 줘야함
    override fun singASong(){
        super.singASong()
        println("라라라")
        println("My name is ${name}") // default 값이 정의 되어있어서 사용 가능
    }
}

fun main(){
    var humen = Humen("jaehong")
    var stranger = Humen() // default 값을 줬기 때문에 param 생략 가능
    humen.earingCake()
    println("This humen's is name ${humen.name}")
    println("This humen's is name ${stranger.name}")

    val Mon = Humen("miyoung",53)

    var korean = Korean()

    korean.singASong()
}