object Enumeradores {
    @JvmStatic
    fun main(args: Array<String>) {
        println(Color.VERDE.rgb)
        println(Persona.EDWIN.printEdad())
        println(Continentes.AFRICA.name)
        println(Consolas.PS.toString())
    }
    //enumaerador
    enum class Color(val rgb: Int) {
        ROJO(0xFF0000),
        VERDE(0x00FF00),
        AZUL(0x0000ff)
    }

    //enumerados con miembros abstractos
    enum class Persona {
        EDWIN {
            override val edad: Int = 19
        },CRISTIAN {
            override val edad: Int = 20
        },DIEGO {
            override val edad: Int = 23
        }
        ;
        abstract val edad:Int

        fun printEdad()="$name $edad"
    }

    //enumerador simple
    enum class Continentes{
        ASIA,EUROPA,AMERICA,OCEANIA,AFRICA
    }

    //enumaerador mutable
    enum class Consolas(val manufacturadora: String) {
        XBOX("Microsoft"),
        PS("Sony"),
        SWITCH("Nintendo")
        ;

        override fun toString(): String {
           return "$name -> $manufacturadora"
        }
    }

}
