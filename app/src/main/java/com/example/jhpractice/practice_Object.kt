package com.example.jhpractice

// Object
// : 모든 앱을 실행할 때 딱 한번 만들어진다.(Singleton Pattern)
//   불필요한 메모리 사용을 막을수 있다.


object carFactory {
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)

fun main(){
    val car = carFactory.makeCar(10)
    val car2 = carFactory.makeCar(200)

    println(car)
    println(car2)
    println(carFactory.cars.size.toString())

}