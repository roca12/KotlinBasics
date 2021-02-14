typealias  CadenaDeCaracteres =String
typealias  Entero32Bits =Int
typealias  Entero64Bits =Long
typealias  Flotante32Bits =Float

object AliasDeTipos {

    @JvmStatic
    fun main(args: Array<String>) {
        val num1:Entero32Bits=4
        val num2:Entero32Bits=6
        println(num1+num2)

        val cadena:CadenaDeCaracteres ="hola"

        val largo:Entero64Bits=999L

        val decimal: Flotante32Bits=3.4F

    }

}

