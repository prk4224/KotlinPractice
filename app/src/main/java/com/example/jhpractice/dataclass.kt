package com.example.jhpractice

// Data Class
data class Ticket(val companyName : String,val name : String, var date : String, var seatNumber : Int)
// toString(), hasCode(), equals(), copy() 컴파일할때 자동으로 생성됨

class TicketNormal(val companyName : String,val name : String, var date : String, var seatNumber : Int)

fun main(){
    val ticketA = Ticket("koreaAir","jaehongPark","2022-04-21",14)
    val ticketB = TicketNormal("koreaAir","jaehongPark","2022-04-21",14)

    println(ticketA)
    println(ticketB)
//    data class = Ticket(companyName=koreaAir, name=jaehongPark, date=2022-04-21, seatNumber=14) 보기 쉽게 변환
//    class = com.example.jhpractice.TicketNormal@1e643faf 주소값을 출력
}

