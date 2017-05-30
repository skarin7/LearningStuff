import java.util.*

/**
 * Created by shankar on 30/5/17.
 */

class Sample {

    enum class Color(val x: String){
        RED("red"), BLUE("blue"), GREEN("green"), YELLOW("yellow");

        fun getName(): String {
            return x;
        }

    }

    interface Expr
    class Num(val value: Int) : Expr
    class Sum(val num1: Expr, val num2: Expr) : Expr


    fun trickyAdd(input: Expr): Int {

        if(input is Num) {
            val n = input as Num
            return n.value
        }

        if(input is Sum) {
            val sum = input as Sum
            return trickyAdd(sum.num1) + trickyAdd(sum.num2)
        }
        throw IllegalArgumentException("Unknown Expression...")

    }

    fun Custprint() {
        println(" Hello from method")
    }

    fun checkMyNull(a: Any): Boolean {

        if (a is String) {
            return true
        }
        return false
    }


    fun testLoop() {
        var i = 0
        while (i < 10) {
            println(" Hello " + i)
            i++
        }
    }


    fun usingWhen(x: String): String {

        when (x) {
            "one" -> return "One "
            "two" -> return "Two"
//            else -> throw Exception("Dirty selection !!!")
            else -> return "Dirty "
        }
    }

    fun useWhenWithExprCheck(input: Expr): Int =

            when(input) {

                is Num -> {
                    println(" Value is: ${input.value} ")
                    input.value
                }

                is Sum -> {
                    val sum1 = useWhenWithExprCheck(input.num1)
                    val sum2 = useWhenWithExprCheck(input.num2)
                    println(" Value is: ${sum1} + ${sum2} ")
                    sum1 + sum2
                }
                else -> throw IllegalArgumentException(" Unknown expression..")
            }



    fun enumTest( x : Color) = when(x) {
        Color.BLUE, Color.RED ->  "Present in Blue and Red"
        Color.GREEN -> " Green Revolution"
        else -> " Error" + 401
    }

    fun enumTest( x : Color, y: Color) = when(setOf(x, y)) {
        setOf(Color.BLUE, Color.RED) ->  "Present in Blue and Red"
        setOf(Color.GREEN) -> " Green Revolution"
        else -> " Error" + 401
    }


}


fun main(args: Array<String>) {
    println(" Hello From kotlin.. ${if (args[0].equals("shan", true)) args[0] else "Dummy"}")
    val sample = Sample()
    /*   sample.Custprint()
       if(sample.checkMyNull(12)) println(" Inside the  String check mate...")
       sample.testLoop()
   */

    println(sample.usingWhen("Fkrri"))

    println(sample.enumTest(Sample.Color.RED))
    println(sample.enumTest(Sample.Color.YELLOW, Sample.Color.GREEN))
    println(sample.trickyAdd(Sample.Sum(Sample.Sum(Sample.Num(2), Sample.Num(3)), Sample.Sum(Sample.Num(2), Sample
            .Num(3)))))

    println(sample.trickyAdd(Sample.Sum(Sample.Num(2), Sample.Num(3))))

    println(sample.useWhenWithExprCheck(Sample.Sum(Sample.Num(3), Sample.Num(9))))

}

