package hello

import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.time.Instant // 라이브러리는 java 쓰네?
import javax.lang.model.element.Name

// 자바와 달리 공개 클래스 이름이 그 클래스가 담겨 있는 파일 이름과 같을 필요 X (그렇지만 굳이?)
class Person (val name: String){ // 생성자 블록은 클래스 이름 옆
    // 코틀린 클래스는 기본적으로 public. public 키워드 쓸 필요 X
    // 코틀린 클래스는 기본적으로 상속 불가. 즉 final 임 -> 상속 가능하게 하려면 open 변경자 사용
//    val name: String = name

    // 초기화 블록
//    init {
//        this.name = name
//    }
}

// 코틀린을 사용하면 거추장스러운 준비 코드의 대부분을 없앨 수 있음
open class Person2 (val name: String, val registered: Instant = Instant.now()) // 인자 이름 뒤에 기본값 표현 (js 비슷)

class Person3(val name: String, val registered: Instant = Instant.now()) {
    constructor(name: Name): this(name.toString()) {
        // 생성자 구현 추가 가능
        // 생성자 정의하지 않으면 인자 없는 생성자 자동으로 만들어짐
    }
}

// 외부 코드에서 생성자에 접근하지 못하게 생성자를 비공개로 만들 수 있음.
// 자바와 달리 정적 멤버만 들어 있는 유틸리티 클래스의 초기화를 막으려고 기본 생성자를 비공개로 만들 필요는 없다.
// 코틀린은 정적 멤버를 클래스 밖의 패키지 수준에 둔다.
class Person4 private constructor(val name: String)

// data class 는 컴파일 시 hashcode, equals 함수가 생성. 코드를 볼 수는 없지만 일반 함수처럼 사용 가능
// toString, copy, componentN 함수도 만들어줌
data class Person5(val name: String, val registered: Instant = Instant.now()) {
    companion object {
        fun create(xml: String): Person5 {
            TODO("blah blah") // 항상 예외를 발생
        }
    }
}

// 정적 메서드 구현
// 동반 객체

// 코틀린에서 싱글턴 사용하기 - class 대신 object
// 싱글턴: 어떤 클래스에 속한 객체를 단 하나만 만들어야 할 때 이러한 인스턴스
// 싱글턴 객체에는 생성자 x, 프로퍼티가 있다면 반드시 초기화
object MyWindowAdapter: WindowAdapter() {
    override fun windowClosed(e: WindowEvent?) {
        super.windowClosed(e)
    }
}

// 코틀린에는 원시타입이 없음 - 수나 bool 값들로 이뤄진 컬렉션을 박싱/언박싱하기 위한 별도의 함수 x

// collection - 불변, 가변 두 유형이 있음
// 기본적으로 코틀린 컬렉션은 불변(or 읽기 전용 컬렉션)
fun main(args: Array<String>) {
    var list: List<Int> = listOf(1, 2, 3) // 불변 컬렉션
    var list2: List<Int> = mutableListOf(1, 2, 3, 4) // 가변 컬렉션

}

// public, private, internal, protected -> 가시성