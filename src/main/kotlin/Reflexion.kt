import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty
import kotlin.reflect.KVisibility
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.starProjectedType
import kotlin.reflect.jvm.isAccessible


object Reflexion {

    class Color {
        lateinit var color:String
    }

    open class BaseExample(val baseField:String)

    class Example (val field1:String, val field2:Int, baseField: String):BaseExample(baseField){
        val field3:String
            get()="Propiedad sin campo back"
        val field4 by lazy {"Valor delegado"}
        private  val privateField:String ="Valor privado"
    }

    class TestClass {
        val readOnlyProperty: String
            get() = "Read only!"

        var readWriteString = "asd"
        var readWriteInt = 23

        var readWriteBackedStringProperty: String = ""
            get() = field + '5'
            set(value) { field = value + '5' }

        var readWriteBackedIntProperty: Int = 0
            get() = field + 1
            set(value) { field = value - 1 }

        var delegatedProperty: Int by TestDelegate()

        private var privateProperty = "This should be private"

        private class TestDelegate {
            private var backingField = 3

            operator fun getValue(thisRef: Any?, prop: KProperty<*>): Int {
                return backingField
            }

            operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: Int) {
                backingField += value
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        //kt class
        val a1=String::class
        println(a1)
        var rojo=Color()
        rojo.color="Rojo"
        val a2=Color::class
        println(a2)

        //java class
        var stringKClass : Class<String> =String::class.java
        println(stringKClass)

        //funciones
        fun esPositivo(x:Int)=x>0
        val numeros = listOf(-1,-2,3,5,9,0)
        println(numeros.filter(::esPositivo))

        //Obteniendo valores de todas las propiedades de una clase
        val ejemplo=Example(field1 = "abc",field2 = 1, baseField = "Algun texto")

        for (propiedad in Example::class.memberProperties) {
            propiedad.isAccessible=true
            println("${propiedad.name} = ${propiedad.get(ejemplo)}")
        }

        for (propiedad in Example::class.memberProperties) {
            println("${propiedad.name} = ${propiedad.get(ejemplo)}")
        }

        //setting valores para todas las pripiedades de una clase
        println("--------")
        val instance = TestClass()
        TestClass::class.memberProperties
            .filter{ it.visibility == KVisibility.PUBLIC }
            .filterIsInstance<KMutableProperty<*>>()
            .forEach { prop ->
                //falla en el prop.get(instance)
                println("${prop.name} = ${prop.toString()}")
                }
        val instance2 = TestClass()
        TestClass::class.memberProperties
            .filter{ it.visibility == KVisibility.PUBLIC }
            // We only want strings
            .filter{ it.returnType.isSubtypeOf(String::class.starProjectedType) }
            .filterIsInstance<KMutableProperty<*>>()
            .forEach { prop ->
                // Instead of printing the property we set it to some value
                prop.setter.call(instance, "Our Value")
            }
    }
}
