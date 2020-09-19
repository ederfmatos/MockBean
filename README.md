
# MockBean
  
  
<p align="center">
 <a>
        <img src="https://github.com/ederfmatos/MockBean/workflows/Java%20CI%20with%20Gradle/badge.svg"
            alt="Stars">
   </a>
  <a>
            <img alt="GitHub stars" src="https://img.shields.io/github/stars/ederfmatos/MockBean?style=social">
   </a>
<a>
	<img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/ederfmatos/MockBean?style=social">
</a>
</p>

Essa é uma biblioteca criada com o intuito de facilitar a criação de mocks em testes escritos com Java. 

## Importação

Até o momento essa biblioteca não está publicada em nenhuma plataforma de hospedagem de dependências, portanto para uso deve ser colocado como dependência do projeto o repositório de pacotes [Jitpack.io](https://jitpack.io/docs/). 

> O JitPack é um novo repositório de pacotes para projetos JVM e Android. Ele cria projetos Git sob demanda e fornece artefatos prontos para uso (jar, aar).
> Se você deseja que sua biblioteca esteja disponível para o mundo, não  há necessidade de passar pelas etapas de criação e upload do projeto. Tudo que você precisa fazer é enviar seu projeto para o GitHub e o JitPack cuidará do resto. É isso mesmo!

Então poderá utilizar a dependência dessa biblioteca com referencia a esse repositório.

### Gradle

**Importação do jitpack.io**	
	
``` gradle
repositories {  
  maven { url "https://jitpack.io" }  
}
```

**Importação da biblioteca**

``` gradle
dependencies {
  implementation 'com.github.ederfmatos:MockBean:1.0'
}
```

### Maven

**Importação do jitpack.io**	

``` xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>
```

**Importação da biblioteca**

``` xml
<dependency>
  <groupId>com.github.ederfmatos</groupId>
  <artifactId>MockBean</artifactId>
  <version>1.0</version>
</dependency>
```

## Utilização

Para exemplificação utilizaremos a seguinte classe como bean:

``` Java

public class Cliente {
    private Long id;
    private String name;
    private LocalDate createdAt;
    private String phoneNumber;
    private String email;
    private String password;
}

```

Com essa biblioteca temos acesso à 2 métodos de manipulação afim de obter uma instância da classe.

``` Java
// Retorna uma instância da classe.
MockBean.mockBean(Class<T>);

// Idêntico ao método acima, criado para facilitar a importação estática.
MockBean.mock(Class<T>);
```

### Métodos internos

A partir do momento que temos uma instância da classe MockBean em mãos, temos acesso aos seguintes métodos:

#### with

O método "with" é utilizado para setar um valor específico para um atributo.<br>
Ele recebe 2 parâmetros: <br>
1° - String -  com o nome do atributo à ser setado <br>
2° - Object -  com o valor do atributo <br>

##### Exemplo
``` Java
MockBean.mock(Cliente.class)
	.with("name", "Bill Gates")
	.with("email", "java@java.com")
        .with("phoneNumber", "1199665522");
```

#### without

O método "without" é utilizado para não setar um valor para um atributo, ou ao menos deixar o valor padrão.<br>
Ele recebe quantos atributos você quiser passar, sendo os nomes dos atributos que você não deseja valor (varargs) <br>

##### Exemplo
``` Java
MockBean.mock(Cliente.class)
	.without("name", "phoneNumber", "password");
```

#### build

O método "build" é utilizado para uma instância da classe de acordo com as configurações passadas nos métodos anteriores.

##### Exemplo
``` Java
Cliente cliente = MockBean.mock(Cliente.class)
	.without("name", "phoneNumber", "password")
        .build();
```

Existem também uma sobrescrita do método "build" onde é possivel passar um número inteiro, esse método devolve uma lista com o número de itens passados por parâmetro
##### Exemplo
``` Java
List<Cliente> clientes = MockBean.mock(Cliente.class)
	.without("name")
        .build(8);
```

#### json

O método "json" assim como o método "build" é utilizado para uma instância da classe, porém ele devolve a instancia numa String com o formato json.

##### Exemplo
``` Java
String clienteJson = MockBean.mock(Cliente.class)
	.without("name", "phoneNumber", "password")
        .json();
```

E também existe uma sobrescrita do método "json" onde é possivel passar um número inteiro para retornar uma lista no formato json
##### Exemplo
``` Java
String clientes = MockBean.mock(Cliente.class)
	.without("name")
        .json(8);
```
 

## Tipos de dados

Esses são os tipos de dados cobertos pela biblioteca:

 - [x] String
 - [x] Integer
 - [x] Double
 - [x] Float
 - [x] LocalDate
 - [x] Enums
 - [X] Long
 - [X] Date
 - [X] Char
 - [X] List
 - [X] Set
