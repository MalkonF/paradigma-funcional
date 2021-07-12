package br.com.alura.bytebank

fun main() {
    testaTipoFuncaoReferencia()
    testaTipoFuncaoClasse()

//    val minhaFuncaoLambda: () -> Unit = {
//        println("Executa como lambda")
//
//    }
//    println(minhaFuncaoLambda())
//
//    val minhaFuncaoAnonima: () -> Unit = fun() {
//        println("Executa como função anônima")
//    }
//
//    println(minhaFuncaoAnonima())
}

fun testaTipoFuncaoClasse() {
    val minhaFuncaoClasse: (Int, Int) -> Int = Soma()//aqui n pede os argumentos, só é obrigatório na hora de chamar a função
    println(minhaFuncaoClasse(10, 10))
}

fun testaTipoFuncaoReferencia() {
    //a var minhaFuncao é do tipo função. Os parenteses significam
    //os parametros que a gente recebe(se tiver vazio é sem parametros)
    //Unit é o tipo de retorno da função
    //::teste atribui a referencia da função teste para a var. Agora a variavel
    //pode ser executada como se fosse uma função
    val minhaFuncao: (Int, Int) -> Int = ::soma
    val minhaFuncao2 = ::soma //omitindo o tipo função mas subentende que é do tipo função
    println(minhaFuncao(5, 10))
}

//a função tem que ser do mesmo tipo que a var, ex: na var minhaFuncao ela não recebe nenhum arg como aqui na função teste
fun soma(a: Int, b: Int): Int {
    return a + b
}

//tem que sobrescever o tipo invoke quando vc atribui a uma classe o tipo função
class Soma : (Int, Int) -> Int {
    override fun invoke(a: Int,b: Int): Int = a + b

}


