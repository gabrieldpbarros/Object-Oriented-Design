# Sistema de Fichas Médicas - Padrão Prototype

Este projeto é uma implementação orientada a objetos desenvolvida em Java para gerenciar fichas de atendimento médico em uma clínica. O objetivo central é permitir a criação de novas fichas a partir de modelos pré-existentes, garantindo que as alterações na ficha preenchida não afetem o modelo original.

O sistema resolve esse problema aplicando o padrão de projeto de criação **Prototype**, aliado a conceitos de **Singleton** e **Composição**.

## Arquitetura e Padrões de Projeto

O sistema foi desenhado utilizando as seguintes abordagens:

* **Prototype:** Utilizado nas classes de fichas (herdeiras de `BaseFicha`). Permite clonar um modelo existente instanciando uma cópia exata e independente na memória.
* **Singleton:** A classe `CatalogoFichas` atua como um repositório central global. Ela armazena os modelos originais e é responsável por fornecer as cópias clonadas quando solicitadas.
* **Composição sobre herança:** A entidade `Pessoa` não utiliza herança estática para definir se é um Médico ou Paciente. Em vez disso, utiliza a interface `IPapelClinico`, permitindo que uma mesma pessoa assuma múltiplos papéis no sistema simultaneamente.

## Estrutura do Sistema

O domínio do problema foi dividido da seguinte forma:

1.  **Fichas (Modelos):**
    * `PrimeiraConsulta`: Focada em queixas, histórico e conduta inicial.
    * `ConsultaRetorno`: Focada na evolução e adesão ao tratamento.
    * `Triagem`: Focada em sinais vitais básicos (pressão, temperatura).
2.  **Atores:**
    * `Pessoa`: Indivíduo físico (Nome, CPF, Data de Nascimento).
    * `IPapelClinico`: Interface para os papéis de `Medico` (CRM, Especialidade) e `Paciente` (Tipo Sanguíneo, Carteirinha).
3.  **Dados Internos:**
    * `InformacoesPaciente`: Objeto encapsulado dentro da `BaseFicha` para agrupar dados de preenchimento médico.

## 🚀 Como Funciona a Execução

A classe `Main` atua como uma suíte de testes automatizados via console para demonstrar os requisitos do sistema. Ao executar o programa, o seguinte fluxo acontece:

1.  **Setup:** Atores (médico e pacientes) são instanciados e recebem seus respectivos papéis clínicos.
2.  **Registro:** Instâncias em branco de `PrimeiraConsulta`, `ConsultaRetorno` e `Triagem` são criadas e salvas no `CatalogoFichas`.
3.  **Clonagem:** O sistema solicita ao catálogo a criação de duas fichas baseadas no modelo de "Primeira Consulta" para dois pacientes diferentes.
4.  **Isolamento:** Ambas as fichas clonadas recebem dados, medicamentos e observações distintas.
5.  **Prova de Conceito:** O console imprime os dados do modelo original e das duas fichas preenchidas, provando que a mutação de uma não afeta as demais.

## 💻 Como Executar

Para rodar a demonstração no seu ambiente local:

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) (versão 8 ou superior) instalado.
2. Clone este repositório.
3. Compile as classes do projeto.
4. Execute a classe `Main`.