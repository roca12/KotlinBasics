import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

object PropiedadesDelegadas {

    @JvmStatic
    fun main(args: Array<String>) {
        var foo: Int by Delegates.observable(1) { property, oldValue, newValue ->
            (println("${property.name} fue modificado de $oldValue a $newValue"))
        }
        foo = 2

        val foo2:String by MyDelegate()
        println(foo2)

        val foo3 : Int by lazy {1+1}
        println(foo3)

        val map = mapOf("Too" to 1)
        val foo4 :String by map




    }



    class MyDelegate{
        operator fun getValue(owner: Any?,property: KProperty<*>): String{
            return "Valor delegado"
        }
    }
}





