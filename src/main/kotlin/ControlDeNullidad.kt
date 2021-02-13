object ControlDeNullidad {
    @JvmStatic
    fun main(args: Array<String>) {
        smartCast()
        afirmacion()
        eliminarnulosenarray()
        operadorElvis()
    }

    fun smartCast(){
        var string :String="hola!"
        println(string.length)
        if (string!=null){
            println(string.length)
        }
    }
    fun afirmacion(){
        //si es nulo levanta nullpointer
        val message :String?="hola"
        println(message!!)
    }
    fun eliminarnulosenarray(){
        val a:List<Int?> = listOf(1,2,3,null)
        val b:List<Int> = a.filterNotNull()
        println(b)
    }
    fun operadorElvis(){
        val data: Pair<Any?, Any?>? =(null)
        var value: String = (data?.first ?: "Nothing here") as String
        println(value)

    }

}