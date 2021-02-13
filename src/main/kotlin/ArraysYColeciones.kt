import java.util.*
import kotlin.random.Random
import kotlin.random.nextUInt

object ArraysYColeciones{

    @JvmStatic
    fun main(args: Array<String>) {
        //matriz(3,6)
        //vector(10)
        //lista(7)
        //listadelistas(8,6)
        //conjunto(10)
        //mapa(20)
        //cola(15)
        //pila(10)
        //colaprioridad(10)
    }

    //Arrays
    fun vector(tamano:Int){
        var c:Char='a'
        var v =Array(tamano){ c;c++}
        for (caracter in v){
            print("$caracter ")
        }
    }
     fun matriz(filas:Int,columnas:Int){
         var m = Array(filas) { i -> Array(columnas) { j -> "$i$j"} }
         for (element in m){
             for (elementin in m[0]){
                 print("$elementin ")
             }
             println()
         }
     }
    //Colecciones
    fun lista(tamano: Int){
        var r= Random(0)
        var lista= MutableList(tamano){ Pair<Any,Any>(r.nextLong(100),r.nextBoolean())}
        for (doble in lista){
            println("${doble.first} -> ${doble.second}")
        }
    }
    fun listadelistas(filas: Int,columnas: Int){
        var r:Random= Random(0)
        var ldel= MutableList(filas) {MutableList(columnas) { r.nextBoolean()} }
        for (i in 0 until filas){
            for (j in 0 until  columnas){
                print(ldel[i][j].toString()+"\t")
            }
            println()
        }
    }
    fun conjunto(tamano: Int){
        var r= Random(0)
        val mySet: MutableSet<Any?> = mutableSetOf()
        repeat(tamano){
            if (!mySet.add(r.nextLong(10))){
                println("ya existe")
            }
        }
        for (largo in mySet){
            print("$largo ")
        }
    }
    fun mapa(tamano: Int){
        var r:Random= Random(0)
        val mymap: MutableMap<Any?,Any?> = mutableMapOf()
        repeat(tamano){
            mymap[r.nextUInt(50u)] = r.nextBoolean()
        }
        for ((key, value ) in mymap){
            println("$key -> $value ")
        }
    }
    fun cola(tamano: Int){
        var r= Random(0)
        var myqueue=LinkedList<Int>()
        println("Entrada")
        repeat(tamano){
            var aux = r.nextInt(200)
            println(aux)
            myqueue.offer(aux)
        }
        println("Salida")
        while(!myqueue.isEmpty()){
            println(myqueue.poll())
        }
    }
    fun pila(tamano: Int){
        var r= Random(0)
        var mystack=Stack<Int>()
        println("Entrada")
        repeat(tamano){
            var aux = r.nextInt(200)
            println(aux)
            mystack.push(aux)
        }
        println("Salida")
        for (entero in mystack){
            println("$entero")
        }
        while(!mystack.isEmpty()){
            println(mystack.pop())
        }
    }

    fun colaprioridad(tamano: Int){
        var r= Random(0)
        var mypriorityqueue=PriorityQueue<Int>()
        println("Entrada")
        repeat(tamano){
            var aux = r.nextInt(200)
            println(aux)
            mypriorityqueue.offer(aux)
        }
        println("Salida")
        while(!mypriorityqueue.isEmpty()){
            println(mypriorityqueue.poll())
        }
    }
    class Persona {
        var nombre:String
        var edad:Int

        constructor(nombre:String, edad:Int){
            this.nombre=nombre
            this.edad=edad
        }
        operator fun compareTo(other: Persona): Int{
            when{
                this.edad==other.edad-> return 0
                this.edad>other.edad-> return 1
                this.edad>other.edad-> return -1
            }
            return 0
        }
    }
}


