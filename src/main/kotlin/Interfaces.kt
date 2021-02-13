object Interfaces {
    @JvmStatic
    fun main(args: Array<String>) {
        val instancia1=MyClass()
        instancia1.conImplementacion()
        val a=Myclass2()
        a.notImplemented()
        a.implementedInBoth()
        a.implementedInOne()
        a.implementedOnlyInA()
        val c =Hijo()
        c.funcion()

    }

    interface  MyInterface{
        fun conImplementacion(){
            println("Se ha llamado a conImplementacion()")
        }
    }

    class MyClass:MyInterface{
        //no se necesita implementar de nuevo la funcion
    }

    interface MyInterface2{
        val holaMundo
            get()= "Hola mundo"
    }

    interface A{
        fun notImplemented()
        fun implementedOnlyInA(){ println("Solo en A")}
        fun implementedInBoth(){println("Ambos, A")}
        fun implementedInOne(){println("Implementado en A")}
    }

    interface B{
        fun implementedInBoth(){println("Ambos, B")}
        fun implementedInOne()
    }

    class Myclass2:A,B{
        override fun notImplemented() {
            println("Implementacion normal")
        }

        override fun implementedInBoth() {
            super<A>.implementedInBoth()
            super<B>.implementedInBoth()
        }

        override fun implementedInOne() {
            super<A>.implementedInOne()
            println("Implementacion de implementedInOne")
        }
    }

    //interfaz con propiedades
    interface MyFinalInterface{
        val propiedad:Int

        val propiedadconimplementacion:String
            get()="tiburon"

        fun funcion(){
            print(propiedad)
        }
    }

    class Hijo:MyFinalInterface{
        override val propiedad: Int=69
    }


}