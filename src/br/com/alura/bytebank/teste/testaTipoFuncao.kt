package br.com.alura.bytebank.teste


fun testaFuncaoAnonima() {
    //a diferença entre expressão lambda e função anonima é que na última deixa mais explicita o retorno que quer
    //fazer
    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(a: Int, b: Int): Int {
        return a + b
    }
    println(minhaFuncaoAnonima(10, 30))
    //it está disponível em funções lambda com um só arg
    //aqui poderia ser só Double, mas coloca salario pra deixar o codigo mais claro

    val calculadoraBonificacaoAnonima: (salario: Double) -> Double = fun(salario): Double {
        if (salario > 1000.0)
            return salario + 50.0
        return salario + 100.0
    }
    println(calculadoraBonificacaoAnonima(1100.0))
}


fun testaTipoFuncaoClasse() {
    val minhaFuncaoClasse: (Int, Int) -> Int =
        Soma()//aqui n pede os argumentos, só é obrigatório na hora de chamar a função
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
    override fun invoke(a: Int, b: Int): Int = a + b

}

fun testaFuncaoLambda() {
    //_ diz que não vai utilizar esse valor mas tem que por para dar match na assinatura da lambda(int, int)
    val minhaFuncaoLambda: (Int, Int) -> Int = { a, _ ->
        a + 10 //a última insturção é que determina o retorno

    }
    println(minhaFuncaoLambda(10, 15))

    val calculaBonificacao: (salario: Double) -> Double =
        lambda@{//pra poder ter mais de um return tem que ter esse label
            if (it > 1000.0)
                return@lambda it + 50.0
            it + 100.0
        }
    println(calculaBonificacao(10000.0))
}



