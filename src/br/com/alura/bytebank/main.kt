package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {
    // tipo função sendo atribuído a variável testeFuncao
    val testeFuncao: () -> Unit
    // evolve o objeto Endereco para dentro de um escopo em que se pode manipular seus atributos
    Endereco().let {

    }
    // n faz o let com expressão lambda
    //aqui chama o let como se fosse uma função e manda uma referencia de outra função testeRecebeString
    //O parametro dessa função testerecebeString tem que ser string já que o let ta sendo chamado por ""
    "".let(::testeRecebeString)

    1.let {
        it
    }

    teste({}, 1)
    //quando se tem uma função que recebe outra n somos obrigados a colocar os parenteses. Experimente colocar na função teste
    //so um parametro, pode ser uma função, aí vc pode chaamr so com os {}, mas se colocar mais de um parametro terá que colocar ()
    teste(
        {}, 1
    )

}

fun testeRecebeString(valor: String) {

}

//high order function quando uma função recebe outra
// uma função teste recebendo outro função bloco
fun teste(bloco: () -> Unit, teste: Int) {

}
