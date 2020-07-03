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



## Tipos de dados

Esses são os tipos de dados cobertos pela biblioteca:

 - [x] String
 - [x] Integer
 - [x] Double
 - [x] Float
 - [x] LocalDate
 - [x] Enums
 - [ ] Long
 - [ ] Date
 - [ ] Char
