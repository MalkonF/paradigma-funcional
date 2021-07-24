package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {

    val endereco = Endereco(logradouro = "rua vergueirooo", numero = 3185)
    // como with vc um obj de contexto que é receiver(endereco) e retorna uma lambda
    with(endereco) {
        "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
    }.let { enderecoEmMaiusculo: String ->
        println(enderecoEmMaiusculo)
    }

    val endereco2 = Endereco()
        .also { println("Configurando qualquer coisa antes da execução do apply...") }
        .apply {
            logradouro = "Rua Vergueiro"
            numero = 3186
        }
    with(endereco2) {
        "${endereco2.logradouro}, ${endereco2.numero}".toUpperCase()
    }.let { enderecoEmMaiusculo: String ->
        println(enderecoEmMaiusculo)
    }

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
