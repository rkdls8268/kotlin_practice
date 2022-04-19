package hello

import java.time.Instant

fun main(args: Array<String>) {
    // 생성자를 함수로 사용 가능
    val person2 = Person2("Jerry")

    println(person2.name) // getter 호출 (컴파일러가 생성한 게터를 사용 - 생성된 게터는 필드와 같은 이름이라 괄호를 붙일 필요 없음!)
    // 게터 세터 - 프로퍼티 외부에 노출하지 않고 값 얻을 수 있음


    val persons = listOf(Person5("Jerry"), Person5("Tom"))
    show(persons)
}

fun show(persons: List<Person5>) {
    for ((name, date) in persons)
        println("$name's registration date: $date")
}