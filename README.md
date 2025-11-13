# 💸 ConversorDeMoedas_Alura (Projeto Final)

## Descrição do Projeto

Este projeto Java implementa um conversor de moedas que obtém taxas de câmbio em tempo real através da API **ExchangeRate-API**. O objetivo do projeto foi aplicar conceitos de Orientação a Objetos, consumo de API usando `HttpClient` (Java 11+) e manipulação de dados JSON com a biblioteca **Gson**.

O projeto foi construído seguindo um desafio de 10 passos para garantir a cobertura completa de requisitos, desde a configuração do ambiente até a interação com o usuário.

## ✨ Funcionalidades

O programa opera via console e oferece as seguintes opções de conversão:

* **Opções Rápidas (Filtro do Desafio):**
    1. Dólar Americano (USD) -> Real Brasileiro (BRL)
    2. Real Brasileiro (BRL) -> Dólar Americano (USD)
    3. Peso Argentino (ARS) -> Real Brasileiro (BRL)
    4. Real Brasileiro (BRL) -> Peso Chileno (CLP)
    5. Peso Colombiano (COP) -> Boliviano Boliviano (BOB)
* **Conversão Personalizada:** Permite ao usuário inserir qualquer código de moeda suportado pela API (ex: EUR, JPY, CAD).
* **Loop de Repetição:** O menu permanece ativo até que o usuário escolha a opção "Sair".

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 17+)
* **HTTP Client:** `java.net.http.HttpClient` (API nativa do Java)
* **JSON:** Google Gson (Adicionado via JAR na pasta `lib`)
* **IDE:** IntelliJ IDEA

## ⚙️ Estrutura do Projeto

A aplicação foi organizada em pacotes para melhor modularização:

| Pacote | Classe Principal | Descrição |
| :--- | :--- | :--- |
| `br.com.conversor` | `ConversorMoedas.java` | Ponto de entrada (`main`), menu e lógica de interação (`Scanner`). |
| `br.com.conversor.modelo` | `RespostaConversao.java` | POJO para mapear a resposta JSON da API (Gson). |
| `br.com.conversor.servico` | `ConversaoAPI.java` | Monta a URL e realiza a requisição/resposta HTTP. |

## ⚠️ Configuração (Importante!)

Para que o projeto funcione após o download:

1.  **Obter a API Key:** Obtenha sua chave de API gratuita no site da [ExchangeRate-API](https://www.exchangerate-api.com/).
2.  **Inserir a Chave:** Abra o arquivo `ConversaoAPI.java` e substitua a *string* **`"SUA_CHAVE_AQUI"`** pela sua chave real.

## Demonstração
Resultado de uma conversão de 100 USD para BRL:

![Resultado da Conversão de Moedas no Console] (https://raw.githubusercontent.com/DevRafaelSousa/ConversorDeMoedasAlura/main/assets/resultado.png.jpeg)
