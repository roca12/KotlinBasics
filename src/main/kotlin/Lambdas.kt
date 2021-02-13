import java.time.Duration
import java.time.Instant


object Lambdas {

    object Benchmark{
        fun realtime(body:()->Unit):Duration{
            val start=Instant.now()
            try {
                body()
            }finally {
                val end=Instant.now()
                return Duration.between(start,end)
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val time=Benchmark.realtime {
            var i = 0
            for (j in 2000000000L downTo 0 step 2) {
                i++
            }
        }
        println("Codigo ejecutado en ${time.toMillis()} milisegundos")
    }

}