import java.io.Serializable

object Modismos {
    @JvmStatic
    fun main(args: Array<String>) {
        //filtrando una lista usando modismos
        val lista = listOf(3,4,5,6,7,8,9,0)
        //it es un iterador interno que recorrera el array
        val filtrado =lista.filter { it %2==0 }
        println(filtrado)

    }
    //serialUID de serializables
    class MySpecialCase: Serializable{
        companion object{
            private const val serialVersionUID:Long =1234
        }
    }

    //Creando DTO´s para almacenamiento de información
    // las dto automaticamente tienen getters, setters, tostring, copy, equals, hashcode y componentN
    data class Usuario(var nombre:String,var apellido:String, var edad:Int)

}