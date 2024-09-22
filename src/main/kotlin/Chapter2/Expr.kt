package Chapter2

interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

/**
 * is 검사는 instanceof와 비슷하다.
 * 추가로 타입 캐스팅을 하지 않아도 컴파일러가 캐스팅 해준다. (스마트 캐스트)
 * IDE에서는 배경색으로 스마트 캐스트를 표시해준다.
 */
fun eval(expr: Expr): Int {
    if (expr is Num) {
        return expr.value
    }

    if (expr is Sum) {
        return eval(expr.left) + eval(expr.right)
    }

    throw IllegalArgumentException("Unknown expression")
}

fun evalUsingWhen(expr: Expr): Int =
    when (expr) {
        is Num -> {
            println("num: ${expr.value}")
            expr.value
        }

        is Sum -> {
            val left = evalUsingWhen(expr.left)
            val right = evalUsingWhen(expr.right)
            println("sum: ${eval(expr.left) + eval(expr.right)}")
            left + right
        }

        else -> throw IllegalArgumentException("Unknown expression")
    }


fun main() {
    println("eval")
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

    println("evalUsingWhen")
    println(evalUsingWhen(Sum(Sum(Num(1), Num(2)), Num(4))))
}