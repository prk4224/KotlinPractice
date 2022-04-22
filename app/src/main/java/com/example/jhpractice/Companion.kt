package com.example.jhpractice

// Companion Object
// : java에서 static 대신 사용 (정적인 메소드나 정적인 변수를 선언할 때 사용)
//   private 한 클래스에서 메소드를 읽어올수 있게끔 하는 역할

class Book private constructor(val id : Int, val name : String){

    // companion object 이름도 정의 가능
    // interface 상속도 가능
    companion object BookFactory : IdProvider{

        override fun getId(): Int {
            return 777;
        }

        // property 값도 사용가능
        // property는 어떤 값을 나타냅니다. 그런데 이 값이 다른 값과 연관되어 있을 때 property라고 부릅니다.
        val myBook = "new Book"
        fun create() = Book(getId(),myBook)
    }
}

interface IdProvider{
    fun getId() : Int
}

fun main(){
    // Companion 생략 가능
    // val book = Book.Companion.create()
    // 이 때도 companion object 이름 (BookFactory) 생략 가능
    val book = Book.BookFactory.create()

    val bookId = Book.getId()

    println("${book.id} ${book.name}")
    println(bookId)
}
