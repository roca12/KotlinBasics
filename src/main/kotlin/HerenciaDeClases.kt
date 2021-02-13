object HerenciaDeClases {
    @JvmStatic
    fun main(args: Array<String>) {
        val clasederivada=ClaseDerivada()
        clasederivada.funcion()
        val auto:Carro=CarroRoto("Renault 4")
        auto.velocidad=100
    }

    //open permite herencia entre clases, ya que por defecto son final
    open class ClaseBase{
        val x=10
    }

    class ClaseDerivada: ClaseBase(){
        fun funcion(){
            println("x es igual a $x")
        }
    }

    //overriding metodos y propíedades
    abstract class Carro{
        abstract val nombre:String
        open var velocidad :Int=0
    }
    class CarroRoto(override val nombre:String):Carro(){
        override var velocidad: Int
            get() = 0
            set(value) {
                throw UnsupportedOperationException("El auto no funciona")
            }
    }

}