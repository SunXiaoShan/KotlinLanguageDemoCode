import com.sun.xml.internal.fastinfoset.util.StringArray

// Learning: https://developer.android.com/kotlin/learn
// Learning: https://kotlinlang.org/docs/reference/basic-types.html

// playground: https://play.kotlinlang.org/

fun main(args: Array<String>) {

    VariableDemo()

    stringDemo()

    controlFlowDemo()

    classDemo()
}

fun VariableDemo() {
    // Byte 8
    // Short 16
    // Int 32
    // Long 64
    // Float 32
    // double 64

    println("========= VariableDemo ====================")
//    var _aa // error no initial
//    val _bb // error no initial
    var aa: Int = 342
    val bb: String = "hello"

    var cc: String? = null
    val dd: Int? = null

    // array
    val asc = arrayOf("array - 0", "array - 1", "array - 2")
    asc.forEach { it -> println(it) }
    val someStrings = Array<String>(5) { "it = $it" }
    val stringsOrNulls = arrayOfNulls<String>(10)

    val count = 4
    val skillsSummaryDetailLinesArray = Array(count) {
            i: Int -> "hello"
    }
    println("hhefhef : " + skillsSummaryDetailLinesArray[3])

}

fun stringDemo() {
    println("========= stringDemo ====================")

    val s = "abc"
    println("$s.length is ${s.length}")

    val price = """
        ${'$'}9.99
    """
    println("stringDemo : " + price)
}

fun controlFlowDemo() {
    println("========= controlFlowDemo ====================")

    val aa = 993
    val answer: String = if (aa == 999) {
        "answer is wrong"
    } else {
        "answer is correct"
    }
    println( "controlFlowDemo - " + answer)

    val x = 100
    when (x) {
        1, 44 -> println("x => 1 or 44")
        2 -> println("x == 2")
        in 55..100 -> println("55 ~ 100")
        else -> { // Note the block
            println("x is else")
        }
    }

    val y: String? = null
    when(val _y = y) {
        null -> println("y is not null")
        else -> println("y is null")
    }

    val asc = arrayOf("array - 0", "array - 1", "array - 2")
    for (item: String in asc) {
        // ...
    }

    for ((index, value) in asc.withIndex()) {
        println("the element at $index is $value")
    }

    // demo label
    loop@ for (i in 1..100) {
        println("i = $i")
        for (j in 1..100) {
            if (i == 1 && j == 3)  {
                println("i == 1 ** j == 3")
                break@loop
            }
            println("j = $j")
        }
    }

    fun foo() {
        listOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit // local return to the caller of the lambda, i.e. the forEach loop
            print(it)
        }
        println(" done with explicit label")

        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach // local return to the caller of the lambda, i.e. the forEach loop
            print(it)
        }
        println(" done with implicit label")

        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop // non-local return from the lambda passed to run
                print(it)
            }
        }
        println(" done with nested loop")
    }
    foo()

}

fun classDemo() {
    println("========= classDemo ====================")

    // // Lesson 2: class
    val ma: Main = Main("99999")
    ma.showHello()
    ma.showNineFunction()
    println(ma.stringLengthFunc("abcde"))
    println(ma.stringLengthFunc2("abcde", "abcde"))

    ma.testStringMapper()
}

class Main(name: String) {
    val num = 123
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }

    init {
        println("test third init function")
    }

    fun showHello() {
        println("hello world")
    }

    private fun getNine(): Int {
        return 9
    }

    fun showNineFunction() {
        println(getNine().toString())
    }

    fun generateIntToString(value: Int): String {
        return value.toString()
    }

    val stringLengthFunc: (String) -> Int = { input ->
        input.length
    }

    val stringLengthFunc2: (String, String) -> Int = { input1, intput2 ->
        input1.length + intput2.length
    }

    private fun stringMapper(str: String, mapper: (String) -> Int): Int {
        // Invoke function
        return mapper(str)
    }

    fun testStringMapper() {
        stringMapper("Android", { input ->
            input.length
        })
        println(stringMapper("Android", { input ->
            input.length
        }))
    }
}
