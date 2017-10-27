# Exemplos

Esse módulo contém programas de exemplo que demonstram diferentes formas de uso do **CPqD Texto Fala**. Você pode utilizar esses programas como ponto de partida para o desenvolvimento de suas aplicações.

Note que os programas de exemplo aqui apresentados não tem o objetivo de exercitar todos os recursos oferecidos pelo produto.

Os seguintes exemplos estão disponíveis:

* **SimpleSynthesis**: executa uma síntese síncrona utilizando a instalação do **CPqD Texto Fala** e o texto de entrada especificados. Uma síntese síncrona é aquela cujo o áudio é disponibilizado apenas no final do processamento (i.e. depois da chamada do método ``textToSpeech()`` da classe ``SynthesisSession``).

* **StreamingSynthesis**: executa uma síntese via streaming utilizando uma instalação do **CPqD Texto Fala** e o texto de entrada especificados. Uma síntese via *streaming* entrega o áudio na medida em que a fala é sintetizada, acelerando o tempo de resposta da aplicação. Essa funcionalidade é implementada pelo método ``textToSpeechStream()`` da classe ``SynthesisSession``.

## Compilação

A compilação pode ser feita utilizando sua IDE preferida ou via linha de comando usando o programa ``mvn``:

	# mvn clean package

Será criado um arquivo JAR para cada programa de exemplo. O nome do arquivo JAR é composto pelo prefixo ``synthesizer-examples-4.1.0-SNAPSHOT-`` seguido de um identificador (``simple`` para **SimpleSynthesis** e ``streaming`` para **StreamingSynthesis**).

## Execução

Para executar um exemplo, utilize um comando similar ao abaixo, escolhendo o JAR correspondente ao programa que deseja executar.

	# java -jar target/synthesizer-examples-4.1.0-SNAPSHOT-simple.jar <productPath> <text or file name> 
	
O primeiro argumento é o caminho onde o **CPqD Texto Fala** está instalado. O segundo argumento é o texto UTF-8 a ser sintetizado ou o nome de um arquivo em disco contendo o texto. O texto a ser sintetizado pode ser ser texto puro ou SSML.
