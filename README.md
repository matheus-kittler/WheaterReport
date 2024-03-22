# WheaterReport

É uma aplicação que informa a temperatura, conforme a localização do dispositivo, quando o usuário aceita a permissão de localização e/ou informa um local na barra de pesquisa, ele tem as informações: Temperatura atual da localização, previsão de temperatura com máxima e minima de 7 dias contando o dia atual, umidade relativa do ar, índice de raios UV, temperatura informada a cada hora (24H do dia) do dia atual.

## Instruções

Para conseguir rodar o aplicativo, primeiro você precisa baixar o projeto deste repositório, você clica no botão verde perto do cabeçalho desta mesma tela chamado <> Code, nele você terá 3 opções na aba Local para copiar o URL do projeto e baixar no seu prompt de comando da sua respectiva máquina ou baixar o [gitbash](https://git-scm.com/downloads) para facilitar baixar via linha de comando.

Depois de abrir seu prompt ou git bash, você precisa utilizar (git clone URL) adicionar no começo do comando git clone e colar a URL do repositório e apertar enter, assim este repositório será baixado para sua máquina, também tenha em mente qual local você está baixando o repositório na sua máquina. Após baixar o repositório você precisa ter a IDE do [Android Studio](https://developer.android.com/studio?gad_source=1&gclid=Cj0KCQjw2PSvBhDjARIsAKc2cgOHdimLtaWf13l2ovvfUBgKYhYboEwf1uLOGJ1RGluVt9h6fJrRLJAaApmXEALw_wcB&gclsrc=aw.ds) caso não tenha, é preciso baixar, também caso não tenha nenhuma experiência com a IDE, vou deixar um [vídeo para iniciantes Android Studio](https://www.youtube.com/watch?v=3_s0tkM948c).

Com todas essas preparações feitas, podemos abrir o arquivo do projeto na IDE e então conseguir navegar pelos arquivos, classes e até rodar o projeto em um device virtual ou rodar o app com um device físico, [link de como configurar](https://www.youtube.com/watch?v=qczBoyeeALc) um device físico para rodar aplicações fora da Play Store.

## Aplicativo

Weather Report é um app simples que trará as infomações do tempo, como já mencionado no começo, ele está utilizando além das dependências já atribuidas na criação do projeto automaticamente pela IDE, tem dependências de:

[x] [Koin](https://insert-koin.io/) - É um framework de injeção de dependência que facilita a configuração e a resolução de dependências em aplicativos Kotlin, usando uma abordagem declarativa e sem a necessidade de código de boilerplate.

[x] [Coroutines](https://developer.android.com/kotlin/coroutines) - É uma lib Kotlin para programação assíncrona que simplifica a execução de operações assíncronas de forma concorrente e sequencial, tornando mais fácil lidar com tarefas que envolvem operações de I/O e computação intensiva.

[x] [Retrofit](https://square.github.io/retrofit/) - É uma lib que é muito utilizada em praticamente todos os apps para facilitar o consume de API, ele permite definir e consumir serviços da web REST de forma simples, usando interfaces Java ou Kotlin.

[x] [GSON](https://github.com/google/gson/blob/main/UserGuide.md) - É uma lib Java para serialização e desserialização de objetos JSON. Ela converte objetos Java/Kotlin em JSON e vice-versa, facilitando a integração de dados JSON em aplicativos Android.

[x] [Okhttp](https://square.github.io/okhttp/) - É uma lib para cliente HTTP para Android e Java/Kotlin e oferece uma API simples e eficiente para fazer solicitações de rede HTTP, com suporte para recursos avançados como conexões seguras, interceptadores e cache de HTTP.

[x] [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-factories) - 

[x] [GeoCode](https://developer.android.com/reference/android/location/Geocoder) - Refere ao processo de converter endereços de localização em coordenadas geográficas (latitude e longitude) e vice-versa. Dependendo do contexto, GeoCode pode se referir a diferentes APIs, bibliotecas ou serviços que fornecem essa funcionalidade.

[x] [Mockito](https://site.mockito.org/) - Mockito é uma estrutura de teste para Java e Android que permite criar e configurar objetos simulados (mocks) para testes unitários. Ele facilita a criação de simulações de objetos complexos, permitindo que você se concentre no teste da lógica de negócios de suas classes.

## Testes

O teste é feito somente na viewmodel do projeto, primeiro você precisa estar utilizando a IDE Android Studios, abrir o projeto lá e acessar as pastas, app > kotlin+java > com (test) > matheuskittler > weather_report > ui > MainViewModelTest, este é o caminho. Clicando na Classe você terá um ícone perto das linhas numeradas para dar Play, após um curto tempo, a IDE irá retornar o resultado dos testes se estão funcionando e se estão cubrindo a maior porcentagem de possibilidades das funções testadas tanto para sucesso, quanto erro.
