object ExpresionesRegulares {
    @JvmStatic
    fun main(args: Array<String>) {
        //Verificar si el texto contiene algo de la regex
        val regex = Regex(pattern = "c|d")
        val matched = regex.containsMatchIn(input = "abc")
        println(matched)

        //control de nulos
        val matchResult = Regex("c|d").find("efg")
        val a = matchResult?.value
        println(a)
        val b =matchResult?.value.orEmpty()
        println(b)

        //busqueda de numeros con rangos
        val numerotelefonico:String?=Regex(pattern = """\d{3}-\d{3}-\d{4}""").find(input="numero: 123-456-7890, hola")?.value
        println(numerotelefonico)

        //busqueda de todas las ocurrencias numericas
        val marchedResults= Regex(pattern = """\d+""").findAll(input = "abc123dfg456jkl890")
        val result =StringBuilder()
        for (matchedtext in marchedResults){
            result.append(matchedtext.value+" ")
        }
        println(result)

        //cotejamiento completo
        val aa =Regex("""\d+""").matchEntire("100")?.value
        println(aa)
        val bb =Regex("""\d+""").matchEntire("100 pesos")?.value
        println(bb)

        //separecion por regex
        val aaa =Regex("""\d+""").split("abc123dfg456jkl")
        for (i in aaa){
            println("$i")
        }
        val bbb =Regex("""\d+""").split("Hola mundo")
        for (i in bbb){
            println("$i")
        }

        //reemplazo
        val res =Regex("""\d+""").replace("hola999mundo","x")
        println(res)
    }

}