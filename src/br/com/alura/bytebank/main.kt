package br.com.alura.bytebank

fun main() {
//a var minhaFuncao é do tipo função. Os parenteses significam
    //os parametros que a gente recebe(se tiver vazio é sem parametros)
    //Unit é o tipo de retorno da função
    //::teste atribui a referencia da função teste para a var. Agora a variavel
    //pode ser executada como se fosse uma função
    val minhaFuncao: () -> Unit = ::teste
    val minhaFuncao2 = ::teste //omitindo o tipo função mas subentende que é do tipo função
    println(minhaFuncao())

    val minhaFuncaoClasse: () -> Unit = Teste()
    println(minhaFuncaoClasse())
}

//a função tem que ser do mesmo tipo que a var, ex: na var minhaFuncao ela não recebe nenhum arg como aqui na função teste
fun teste() {
    println("Executa teste")
}

//tem que sobrescever o tipo invoke quando vc atribui a uma classe o tipo função
class Teste : () -> Unit {
    override fun invoke() {
        println("Executa invoke")
    }
}


