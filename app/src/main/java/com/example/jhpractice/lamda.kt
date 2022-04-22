package com.example.jhpractice

import java.io.BufferedInputStream
import java.io.InputStreamReader

// 1. Lamda
// 람다식은 우리가 마치 value 처럼 다룰수 있는 익명 함수
// 1) 메소드에 파라미터로 남겨줄수 있다 fun maxBy(a :Int)
// 2) return 값을 함수 사용할수 있다.

// 람다의 기본 정의
// val lamdaName : Type = {argumentList -> codebody}

// (Int) -> (Int) 이 부분 때문에 type 추론이 가능 ( (inputType) -> (outputType) )
val square : (Int) -> (Int) = { number -> number*number}
// 위나 아래 둘중에 한부분을 타입을 정의해 줘야함.
val square1  = { number : Int -> number*number}

val nameAge = {name : String, age : Int ->
    "My name is ${name} I'm ${age} "
}

fun main(){


    println(square(4))
    println(nameAge("jaehong", 27))
    val a = "jaehong said"
    val b = "minju said"

    println(a.pizzeIsGrear())
    println(b.pizzeIsGrear())

    println(extendString("hong" ,27))
    println(calculateGrade(97))


    val lamda = {number : Double ->
        number === 4.1321
    }
    // lamda식의 number 값과 같으면 true 아니면 false
    println(invokeLamda(lamda))
    // lamda 식을 정의하지 않고 바로 쓰는 것도 가능
    println(invokeLamda({it > 3}))

    // 마지막 parameter가 람다식일때 소괄호를 생략하고 사용 가능 위 식과 똑같은 의미
    println(invokeLamda { it > 3 })

}
// 확장 함수

val pizzeIsGrear : String.() -> String = {
    this + "Pizza is the best"
}

fun extendString(name : String , age : Int) : String {

    //it 명령어는 받아오는 파라미터가 1개일때만 사용 가능 / this는 함수에서 가르키는 object, it은 하나들어가는 parameter
    val IntroduceMySelf : String.(Int) -> String = {"I'm ${this} and ${it} years old"}

    return name.IntroduceMySelf(age)
}

// 람다의 return

// input parameter (Int)는 여러개가 올수 있기때문에 소괄호를 써줘야 하고 return하는 값은 1개이기 때문에 소괄호를 써주지 않아도 된다.
val calculateGrade : (Int) -> String = {
    // 여기서도 input parameter가 1개이기 때문에 it을 사용 가능
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfact"
        else -> "error"
    }
}

// 람다를 표현하는 2가지 방법

// invokeLamda 함수 boolean 값을 return 하는데 input parameter가 Double로 들어와 boolean값으로 리턴되는 값을 리턴하겠다 라는 의미
fun invokeLamda(lamda : (Double) -> Boolean) : Boolean{
    return lamda(5.2341)
}

// 익명 내부 함
// 1. Kotlin interface 가 아닌 java interface 일때만 사용 가능
// 2. 그 interface는 딱 하나의 메소드만 가져야 한다.


