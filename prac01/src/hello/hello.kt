package hello

fun main(args: Array<String>) {
//    println("hello")
    var name: String? = null
    //
    name = getName()
    println(name)

    // name2 참조를 최초로 사용하는 시점에 Hello2 로 초기화
    val name2: String by lazy { getName() }
    println(name2)
    println(name2)

    // 가변 참조에 대한 지연 초기화 - lateinit 키워드
    lateinit var name3: String
    println(name2)
    name3 = getName()
}

fun getName(): String {
    println("이름 계산 중...")
    return "Jerry Kim"
}