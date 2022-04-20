package com.example.jhpractice

fun main() {
    //3. String Template
    var name : String = "jaehong"
    var firstname : String = "Park"
    println("My name is $name I'm 27")
    println("My name is ${firstname + name}I'm 27") // 웬만하면 대괄호 쓰기

    forAndWhile()
    nullcheck()

}

// 1. 함수 사용
// return -> Unit = void
fun helloWorld() : Unit {
    println("Hello, World !")
}

fun add (a : Int, b : Int) : Int{
    return a + b;
}

// 2. val vs var
// val = value 변할수 없는 값 상수
// var =

fun hi () {
    val a : Int = 10
    var b : Int = 10
    // a = 100; error;
    b = 100

    var c = 10 // Type 생략 가능
    var name : String = "jaehong"
}

// 4. 조건식

fun maxBy(a : Int, b :Int) : Int {
    if(a > b) return a;
    else return b;
}

fun maxBy2(a : Int, b : Int) : Int = if(a>b) a else b
// Kotlin 에서는 삼항 연산자( (a>b) ? a : b ) 가 없으므로 위 처럼 표기

fun checkNum(score : Int ){
    when(score) {
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
        //else -> print("I don't know")
    }
    // when을 return 형으로 사용할 때는 else를 반드시 표기 해야한다.
    var b : Int = when(score){
        1 -> 1
        2 -> 2
        else -> 3
    }

    // 사이 값
   when(score){
        in 90..100 -> println("You are genius")
        in 10..80 -> println("Not bed")
        else -> println("okey")
    }
}

// Expresstion VS Statement
// Expresstion : 실행을 해서 값을 return (반환)
// Statement : 어떤 실행을 할지 명령 return 값이 없음

// 5. Array vs List

// List : 1. List(수정 불가능) 2. MutableList(수정 가능)

fun array(){
    val array : Array<Int> = arrayOf(1,2,3)
    val list : List<Int> = listOf(1,2,3)

    val array2 : Array<Any> = arrayOf(1,"a", 3.14f)
    val list2  = listOf(1,"a",11L)

    array[0] = 3;
    // list[0] = 3; error 수정 불
    var result = list.get(0)

    // MutableList
    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0] = 20
}

// 6. for / while 반복문

fun forAndWhile(){

    val student = arrayListOf("a","b","c","d")

    for(name in student){
        println("${name}")
    }

    var sum = 0
    for(i in 1..10){
        sum += i
    }

    // 두칸씩 증가 시켜라 1,3,5,7,9
    var sum1 = 0
    for(i in 1..10 step 2){
        sum1 += i
    }

    // 10부터 1까지
    var sum2 = 0
    for(i in 10 downTo 1){
        sum2 += i
    }

    //1 부터 99까지 100은 포함하지 않음
    var sum3 = 0
    for(i in 1 until 100){
        sum3 += i
    }
    println(sum)
    println(sum1)
    println(sum2)
    println(sum3)

    var index = 0;
    while(index <= 10){
        println("current index : ${index}")
        index++
    }

    // 인덱스와 배열 함께 사용
    for((index,name) in student.withIndex()){
        println("${index+1}번째 학생의 이름은 ${name}")
    }
}

// 7. Nullable vs NonNull

fun nullcheck(){

    var name= "jaehong"
    // var Nullname : String = null error
    var Nullname : String? = null // Type 생략 불가 (String? : Nullable type)

    var nameInUpperCase = name.toUpperCase()
    // Nullname null이 아니면 함수를 적용하고 아니면 null값을 반환
    var NullnameInUpperCase = Nullname?.toUpperCase()

    // ? : default 값을 주고 싶을 떄 사용
    val lastname : String? = null
    // lastname이 null아니면 그냥 출력 null이면 (?:"default") default 값 출력
    val fullname = name + " " + (lastname?:"NO lastName")

    println(fullname)



}

// !! : Nullable type으로 지정 되어있지만 컴파일러에세 null이 아니라는 것을 명시해주고 그냥 실행 시키라고 명령해주는것
// (단, 정말 확실할때만 사용 -> 만일 null이 들어갔을경우 런타임 에러가 발생하기때문에 오류를 해결하기 어려울수 있음)
fun ignoreNulls(str : String?){
    val mNotNull: String = str!!
    // 한번 명시하고 그 이후로는 그냥 사용 가능
    val upper = mNotNull.toUpperCase()


    val email : String? = "prk4224@naver.com"
    // email이 null이 아닌 경우 let함수를 수행
    email?.let{
        println("My email is ${email}")
    }
}

