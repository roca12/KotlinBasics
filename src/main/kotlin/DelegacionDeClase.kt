object DelegacionDeClase {

    interface Animal{
        fun ecosistema()
    }

    class Tiburon : Animal {
        override fun ecosistema(){
            println("Marino")
        }
    }



    @JvmStatic
    fun main(args: Array<String>) {
        class Piro(p : Tiburon) : Animal by p
        Piro(Tiburon()).ecosistema()
    }








}