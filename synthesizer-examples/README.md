# Exemplos

Esse módulo contém programas de exemplo que demonstram diferentes formas de uso do **CPqD Texto Fala**. Você pode utilizar esses programas como ponto de partida para o desenvolvimento de suas aplicações.

Note que os programas de exemplo aqui apresentados não tem o objetivo de exercitar todos os recursos oferecidos pelo produto.

Os seguintes exemplos estão disponíveis:

* **SimpleSynthesis**: executa uma síntese síncrona utilizando a instalação do **CPqD Texto Fala** e o texto de entrada especificados. Uma síntese síncrona é aquela cujo o áudio é disponibilizado apenas no final do processamento (i.e. depois da chamada do método ``textToSpeech()`` da classe ``SynthesisSession``).

* **StreamingSynthesis**: executa uma síntese via streaming utilizando uma instalação do **CPqD Texto Fala** e o texto de entrada especificados. Uma síntese via *streaming* entrega o áudio na medida em que a fala é sintetizada, acelerando o tempo de resposta da aplicação. Essa funcionalidade é implementada pelo método ``textToSpeechStream()`` da classe ``SynthesisSession``.

## Compilação

A compilação dos exemplos é feita seguindo os passos descritos no ``README.md`` da raiz do projeto. Os exemplos compilados estarão disponíveis no diretório ``target`` desse módulo (``synthesizer-examples/target`` a partir da raiz do projeto). Dentro do diretório ``target`` estarão os arquivos:

* synthesizer-examples-4.2-V1-simple.jar
* synthesizer-examples-4.2-V1-streaming.jar
* lib/synthesizer-4.2-V1.jar

## Execução

Para executar um exemplo, utilize um comando similar ao abaixo, escolhendo o JAR correspondente ao programa que deseja executar.

	# java -jar target/synthesizer-examples-4.2-V1-simple.jar <productPath> <text or file name> 

O primeiro argumento é o caminho onde o **CPqD Texto Fala** está instalado. O segundo argumento é o texto UTF-8 a ser sintetizado ou o nome de um arquivo em disco contendo o texto. O texto a ser sintetizado pode estar em SSML.

**Importante**: os programas de exemplo esperam que o arquivo ``synthesizer-4.2-V1.jar`` esteja dentro do diretório ``lib`` a partir de onde o JAR do exemplo encontra-se.
