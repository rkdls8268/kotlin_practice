package hello

// 함수
fun add(a: Int, b: Int): Int {
    return a+b
}

// 함수 본문을 한 줄로 표현할 수 있으면 중괄호로 묶은 블록을 다음과 같이 나타낼 수 있다. -> 식 구문(expression syntax)
fun add2(a: Int, b: Int): Int = a + b

// 식 구문에서는 식에서 추론할 수 있는 반환 타입 생략 가능
fun add3(a: Int, b: Int) = a + b

// closure: 상위 함수의 영역의 변수를 접근할 수 있는 함수, 코틀린의 익명함수는 함수 밖에서 정의된 변수에 접근 가능
fun add4(x: Int): (Int) -> Int {
    return fun(y: Int): Int {
        return x + y
    }
}

fun main(args: Array<String>) {
    // closure 때문에 이렇게 쓰는게 가능함
    val func = add4(10)
    val result = func(20)
    println(result)

    val list = listOf(1, 2, 3)
    val listLen = list.length()
    println(listLen)

    println(triple(list))
}

// 함수 오버라이드 시 override 키워드 반드시 사용

// 확장 함수
fun <T> List<T>.length() = this.size

// 람다 (익명 함수) - 함수 이름 없이 구현만 있음
fun triple(list: List<Int>): List<Int> = list.map { a -> a * 3 }
