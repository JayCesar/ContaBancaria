
![banner_projeto-conta](https://github.com/JayCesar/ContaBancaria/assets/44206400/d1041047-36be-42d0-8d3e-cf886b243b91)

<h1 align="center">
    <a href="[https://www.java.com/pt-BR/]/">🔗 Projeto feito em Java </a>
</h1>

<p align="center">
Este projeto foi feito durante o primeiro bloco do bootcamp da Generation. Nesta fase tive contato com o paradigma de Orientação a Objetos e pela primeria vez pude colocar em prática o CRUD (Create, Read, Update e Delete).  
</p>

<h4 align="center"> 
	<img alt="GitHub Top Language" src="https://img.shields.io/github/languages/top/JayCesar/ContaBancaria" />
  <img alt="" src="https://img.shields.io/github/repo-size/JayCesar/ContaBancaria" />
</h4>

***

### 📌 O Projeto é composto pelas seguintes Classes e Interfaces:

| Classe/Interface    | Descrição                                                    |
| ------------------- | ------------------------------------------------------------ |
| **Menu**            | Classe principal, que conterá o Método main, responsável por criar o Menu inicial da aplicação com todas as funcionalidades do sistema. |
| **Cores**           | Classe utilitária, que possui a função de aplicar cores ao Menu. |
| **Conta**           | Classe responsável por definir o Objeto Conta genérico.      |
| **ContaCorrente**   | Classe responsável por definir o Objeto Conta Corrente.      |
| **ContaPoupanca**   | Classe responsável por definir o Objeto Conta Poupanca.      |
| **ContaRepository** | Interface responsável por encapsular os Métodos que serão utilizados no Menu da aplicação |
| **ContaController** | Classe responsável por implementar a Interface ContaRepository. |

***

### 📝 Diagrama de Classes do Projeto Conta Bancária (DER) 
```mermaid
classDiagram
class Conta {
<<Abstract>>
  - numero : int
  - agencia : int
  - tipo : int
  - titular : String
  - saldo : float
  + int getNumero()
  + int getAgencia()
  + int getTipo()
  + String getTitular()
  + float getSaldo()
  + void setNumero(int numero)
  + void setAgencia(int agencia)
  + void setTipo(int tipo)
  + void setTitular(String titular)
  + void setSaldo(float saldo)
  + boolean sacar(float valor)
  + void depositar(float valor)
  + void visualizar()
}
class ContaCorrente {
  - limite : float
  + float getLimite()
  + void setLimite(float limite)
  + boolean sacar(float valor)
  + void visualizar()
}
class ContaPoupanca {
  - aniversario : int
  + int getAniversario()
  + void setAniversario(int aniversario)
  + void visualizar()
}
class ContaRepository{
<< Interface >>
+ void procurarPorNumero(int numero)
+ void listarTodas()
+ void cadastrar(Conta conta)
+ void atualizar(Conta conta)
+ void deletar(int numero)
+ void sacar(int numero, float valor)
+ void depositar(int numero, float valor)
+ void transferir(int numeroOrigem, int numeroDestino, float valor)
}
class ContaController{
+ void procurarPorNumero(int numero)
+ void listarTodas()
+ void cadastrar(Conta conta)
+ void atualizar(Conta conta)
+ void deletar(int numero)
+ void sacar(int numero, float valor)
+ void depositar(int numero, float valor)
+ void transferir(int numeroOrigem, int numeroDestino, float valor)
+ int gerarNumero()
+ Conta buscarNaCollection(int numero)
+ int retornaTipo(int numero)
}
Conta <|-- ContaCorrente
Conta <|-- ContaPoupanca
Conta <.. ContaRepository
ContaRepository <|.. ContaController
```

***

### 🔨 Características e Funcionalidades:
- [x] Classe de utilidades: com cores;
- [x] Classe abstrata;
- [x] Execptions
- [x] Métodos CRUD;
- [x] Métodos Bancários;

***

### 🎯 Como executar o sistema?
   1) Você pode baixar este repositório e exectuar na sua máquina
   2) Ou você pode executar sem baixar, basta acessar meu [**Replit:**](https://replit.com/@JayCesar/ContaBancaria?v=1) e clicar em **"Run"**;

***

### ▶️ Breve demonstração
