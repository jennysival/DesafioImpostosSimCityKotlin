import kotlin.system.exitProcess

fun main() {
    var nome = "Cadastre seu nome"
    var profissao = "Cadastre sua profissão"
    var vetorSalariosMensais = DoubleArray(12)
    mensagemDeInicio()
    menuPrincipal(nome, profissao, vetorSalariosMensais)
}

fun mensagemDeInicio(){
    println("----------------------------")
    println("Seja bem-vinde ao sistema de\ncálculo de imposto de SimCity")
    println("----------------------------")
    println("\nSou Simmy, a assistente virtual de Sim City")
}

fun menuPrincipal(nome: String, profissao: String, vetorSalariosMensais: DoubleArray) {
    println("O que deseja acessar?")
    println("[1] Cadastrar dados")
    println("[2] Mostrar dados cadastrados")
    println("[3] Cadastrar salários mensais")
    println("[4] Mostrar salários cadastrados")
    println("[5] Calcular impostos mensais")
    println("[6] Sair")
    println("----------------------------------")
    print("Digite o número da opção desejada: ")
    val opcaoMenu = readln().toInt()

    when(opcaoMenu){
        1 -> cadastrarDados()
        2 -> mostrarDadosCadastrados(nome, profissao, vetorSalariosMensais)
        3 -> cadastrarSalariosMensais(nome, profissao, vetorSalariosMensais)
        4 -> mostrarSalariosCadastrados(nome, profissao, vetorSalariosMensais)
        5 -> calcularImpostosMensais(nome, profissao, vetorSalariosMensais)
        6 -> exitProcess(0)
        else -> println("Opção inválida. Tente novamente ${menuPrincipal(nome, profissao, vetorSalariosMensais)}")
    }
}

fun cadastrarDados(){
    var vetorSalariosMensais = DoubleArray(12)

    println("----------------------------")
    println("Selecionado: Cadastrar dados")
    println("----------------------------")

    print("Digite seu nome: ")
    var nome = readln()
    print("Digite sua profissao: ")
    var profissao = readln()

    println("Dados Cadastrados com Sucesso!")

    println("\n----------------------------------")
    menuPrincipal(nome, profissao, vetorSalariosMensais)
}

fun mostrarDadosCadastrados(nome: String, profissao: String, vetorSalariosMensais: DoubleArray) {
    var vetorSalariosMensais = DoubleArray(12)

    println("--------------------------------------")
    println("Selecionado: Mostrar dados cadastrados")
    println("--------------------------------------")

    println("Nome: $nome")
    println("Profissão: $profissao")

    println("\n----------------------------------")
    menuPrincipal(nome, profissao, vetorSalariosMensais)
}

fun cadastrarSalariosMensais(nome: String, profissao: String, vetorSalariosMensais: DoubleArray) {
    val vetorSalariosMensais = DoubleArray(12)

    println("---------------------------------------")
    println("Selecionado: Cadastrar salários mensais")
    println("---------------------------------------")

    for(i: Int in vetorSalariosMensais.indices){
        var mes = i+1
        print("Digite o seu salário líquido do mês $mes (Ex: 1200.00): ")
        vetorSalariosMensais[i] = readln().toDouble()
    }

    println("Salários Cadastrados com Sucesso!")
    println("\n----------------------------------")
    menuPrincipal(nome, profissao, vetorSalariosMensais)
}

fun mostrarSalariosCadastrados(nome: String, profissao: String, vetorSalariosMensais: DoubleArray) {
    println("-----------------------------------------")
    println("Selecionado: Mostrar salários cadastrados")
    println("-----------------------------------------")

    vetorSalariosMensais.forEachIndexed { index, d ->
        println("Mês ${index+1}: R$$d")
    }

    println("\n----------------------------------")
    menuPrincipal(nome, profissao, vetorSalariosMensais)
}

fun calcularImpostosMensais(nome: String, profissao: String, vetorSalariosMensais: DoubleArray) {

    println("-----------------------------------------")
    println("Selecionado: Calcular impostos mensais")
    println("-----------------------------------------")

    for(i: Int in vetorSalariosMensais.indices){
        val mes = i+1
        if(vetorSalariosMensais[i] in 0.0..2000.0){
            println("Mês $mes: Isento de imposto;")
        }
        else if(vetorSalariosMensais[i] in 2001.0..3000.0){
            val calculo8porcento = (vetorSalariosMensais[i]*8)/100
            println("Mês $mes: [8% de imposto] R$$calculo8porcento")
        }
        else if(vetorSalariosMensais[i] in 3001.0..4500.0){
            val calculo18porcento = (vetorSalariosMensais[i]*18)/100
            println("Mês $mes: [18% de imposto] R$$calculo18porcento")
        }
        else{
            val calculo28porcento = (vetorSalariosMensais[i]*18)/100
            println("Mês $mes: [28% de imposto] R$$calculo28porcento")
        }
    }
    println("\n----------------------------------")
    menuPrincipal(nome, profissao, vetorSalariosMensais)
}

