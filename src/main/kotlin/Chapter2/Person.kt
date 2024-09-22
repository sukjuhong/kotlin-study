package Chapter2

/**
 * In java
 * ```java
 * public class Person {
 *   private final String name;
 *
 *   public Person(String name) {
 *     this.name = name;
 *   }
 *
 *   public String getName() {
 *     return name;
 *   }
 * }
 * ```
 *
 * `isMarried`는 생략했습니다.
 *
 * 정말 간결한 `value object`
 */
class Person(
    // 기본적으로 public
    val name: String, // val은 getter
    var isMarried: Boolean  // var은 getter, setter
)

fun main(args: Array<String>) {
    val person = Person("Bob", false);
    println(person.name)
    println(person.isMarried)

    person.isMarried = true
    println(person.isMarried)
}