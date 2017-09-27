# Exemplos

Esse projeto contém programas de exemplo que demonstram diferentes formas de uso do **CPqD Texto Fala**. Você pode utilizar esses programas como ponto de partida para o desenvolvimento de suas aplicações.

Note que os programas de exemplo aqui apresentados não tem o objetivo de exercitar todos os recursos oferecidos pelo produto.

Os seguintes exemplos estão disponíveis:

* **SimpleSynthesis**: executa uma síntese síncrona utilizando a instalação do **CPqD Texto Fala** e o texto de entrada especificados. Uma síntese síncrona é aquela cujo o áudio é disponibilizado apenas no final do processamento (i.e. depois da chamada da função ``SynthesisSession.textToSpeech()``).

## Compilação

A complicação pode ser feita utilizando sua IDE preferida ou via linha de comando usando o programa ``mvn``:

	# mvn clean package

Será criado o arquivo ``cpqdtts-examples-4.1.0-SNAPSHOT.jar``.

## Execução

Para executar o exemplo **SimpleSynthesis**, utilize o comando abaixo:

	# java -cp "target/cpqdtts-examples-4.1.0-SNAPSHOT.jar" br.com.cpqd.example.SimpleSynthesis <productPath> <text or file name> 
	
O primeiro argumento (``productPath``) é o caminho onde o CPqD Texto Fala está instalado. O segundo argumento é o texto UTF-8 a ser sintetizado ou o nome de um arquivo em disco contendo o texto (pode ser texto puro ou SSML).