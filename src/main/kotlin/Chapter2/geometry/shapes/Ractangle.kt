package Chapter2.geometry.shapes

import java.util.Random

// 자바 라이브러리 사용 가능

/**
 * 커스텀 접근자
 */
class Ractangle(private val height: Int, private val width: Int) {
    // 호출 시 getter가 프로퍼티 값을 계산
    val isSquare: Boolean
        get() {
            return height == width
        }

    // 식을 본문으로 사용해도 가능
    val isNotSquare
        get() = height != width
}

/** 최상위에 정의된 함수나 프로퍼티는 export 된다.
 * @see Chapter2.geometry.example.main
 */
fun createRandomRactangle(): Ractangle {
    val random = Random()
    return Ractangle(random.nextInt(), random.nextInt())
}

fun main() {
    val ractangle = Ractangle(4, 4)
    println(ractangle.isSquare)
    println(ractangle.isNotSquare)
}