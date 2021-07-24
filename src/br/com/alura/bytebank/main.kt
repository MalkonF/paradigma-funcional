package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {

    /*Scope functions vc executa um bloco de código dentro de um contexto de um objeto. Scope functions n introduz uma nova técnica mas
    faz seu código ser mais legível e conciso.
    Cada um vai ter suas especificidades ao usar: let, apply, run, with, also
    It é um objeto de contdxto onde ele vai ser acessível a partir de uma expressão lambda.
    Com o .run ele já vai ser o objeto em si, tanto é que se vc referenciar um atributo dele vc n precisa colocar o nome da classe ou o this, somente
    o atributo. Com o let, por exemplo, vc tem que colocar o it.length
    Para saber mais: https://kotlinlang.org/docs/scope-functions.html#function-selection*/

    /*Cada função de escopo(run, apply etc) tem retornos diferentes:
    * apply e also - devolve o obj de contexto
    * let, run, with - retorna um lambda*/
    Endereco(logradouro = "rua vergueirooo", numero = 3185)
        .run {
            "${logradouro}, ${numero}".toUpperCase()  // aqui n preciso usar o endereco.logradouro
        }.let { enderecoEmMaiusculo: String ->
            println(enderecoEmMaiusculo) //agora foi transformado em maiusculo que o uso do run
        }
    //não for transformado em maisuculo pq no final o apply devolve o objeto de contexto e não a string. Se fosse usado um operador que retorna
    // expressão lambda ia retornar a string


    //val endereco = Endereco(logradouro = "rua vergueiro", numero = 3185)
    // string template
    // val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
    // println(enderecoEmMaiusculo)

    // evolve o objeto Endereco para dentro de um escopo em que se pode manipular seus atributos
    // Usando hof vc n precisa criar a variável endereco
    val enderecoEmMaiusculoComHOF = Endereco().let { endereco ->
        "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
        //aqui com let vc nao precisa criar a var enderecoEmMaiusculoComHOF, somente precisa criar a enderecoEmMaiusculoHOF2
        // }.let { enderecoEmMaiusculoHOF2 ->
    }
    println("x" + enderecoEmMaiusculoComHOF)
    //     println(enderecoEmMaiusculoHOF2)
    //}
    //.let(::println)// ou ainda vc pode usar a referencia para o println, ai n precisaria fazer o let acima com enderecoEmMaiusculoHOF2


    // chamada encadeada com HOF
    listOf(
        Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "apartamento")
    )
        .filter { endereco -> endereco.complemento.isNotEmpty() }
        .let(::println)

    soma(1, 5) {
        println(it)
    }

}

// resultado é um tipo função que recebe inteiro e retorna nada
// aqui o poder da hof é vc executar certas funções quando determinado evento ocorrer.
fun soma(a: Int, b: Int, resultado: (Int) -> Unit) {
    resultado(a + b)
}
