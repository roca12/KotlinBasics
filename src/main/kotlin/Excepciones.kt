import java.lang.Exception
import kotlin.properties.Delegates

object Excepciones {
    @JvmStatic
    fun main(args: Array<String>) {
        var numero:Int =0
        try {
            numero= readLine()!!.toInt()
        }catch (e: NumberFormatException){
            println("El valor insertado no es valido como numero")
        }finally {
            println("Numero -> $numero")
        }

        // Recordar que si se lee algo que pueda ser nulo hay que colocar el control de nulos !!
        val a: Long = try{ readLine()!!.toLong()} catch (e:Exception){null}
            ?: throw  TestException(message = "excepcion de prueba (a es nulo)")
    }

    class TestException(message:String): Exception(message)

}