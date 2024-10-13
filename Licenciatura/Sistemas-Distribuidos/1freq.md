Aqui estão as respostas para as perguntas baseadas nas informações dos PDFs anteriores:

### 1. **Como o middleware simplifica a tarefa de desenvolvimento de aplicações distribuídas?**
   O **middleware** atua como uma camada intermediária que esconde a complexidade das comunicações em sistemas distribuídos, oferecendo **abstrações** que permitem aos desenvolvedores focar no desenvolvimento da lógica de negócios, sem precisar se preocupar com detalhes técnicos de rede ou sistema operacional. Ele:
   - **Abstrai a localização**: os processos clientes não precisam saber onde os servidores estão localizados fisicamente.
   - **Independência de protocolo**: middleware como CORBA ou RMI permite que aplicações em diferentes linguagens e protocolos de comunicação interajam entre si.
   - **Gerencia a heterogeneidade**: ele oferece uma camada de compatibilidade entre diferentes sistemas operacionais e arquiteturas de hardware【7†source】【19†source】.

### 2. **Diferença entre comunicação síncrona e assíncrona**
   - **Comunicação síncrona**: O emissor e o receptor precisam estar sincronizados. O emissor bloqueia após o envio de uma mensagem até que receba uma confirmação do receptor. É usada, por exemplo, em TCP.
     - **Vantagem**: Garante que o emissor saiba que a mensagem foi recebida.
     - **Desvantagem**: Pode causar atrasos, já que o emissor precisa esperar pela resposta【13†source】.
   - **Comunicação assíncrona**: O emissor não espera pela resposta do receptor após o envio de uma mensagem. A comunicação pode continuar sem bloqueio. Exemplo típico: UDP.
     - **Vantagem**: Maior eficiência, já que o emissor não fica bloqueado.
     - **Desvantagem**: Não há garantias imediatas de que a mensagem foi recebida【13†source】.

### 3. **Interesse em usar computação externa de dados? Apontar dois pontos possíveis para tal representação indicando vantagens e desvantagens de cada um.**
   a) **CORBA CDR (Common Data Representation)**:
      - **Vantagem**: É eficiente para interoperabilidade entre diferentes linguagens de programação e sistemas heterogêneos.
      - **Desvantagem**: A complexidade de implementação é maior, e a representação não suporta estruturas com ponteiros, o que pode limitar seu uso em certos casos【19†source】.
   
   b) **JSON (JavaScript Object Notation)**:
      - **Vantagem**: Leve e fácil de usar, amplamente compatível com a maioria das linguagens e plataformas, ideal para a web.
      - **Desvantagem**: Pode ser menos eficiente em termos de performance quando comparado a outras representações binárias como Protocol Buffers【13†source】【19†source】.

### 4. **Medidas para aumentar a fiabilidade no protocolo Request-Reply sobre UDP com falhas de omissão usando a semântica "at most once"**
   - **Timeouts e retransmissão**: Se o cliente não recebe uma resposta no tempo esperado, ele pode reenviar o pedido. Isso ajuda a lidar com falhas de omissão, desde que o servidor não processe o mesmo pedido duas vezes.
   - **Histórico no servidor**: O servidor pode manter um histórico das respostas enviadas recentemente, permitindo reenviar uma resposta para pedidos duplicados sem executar novamente a operação. Isso garante que uma operação seja executada "no máximo uma vez"【13†source】【19†source】.

### 5. **Papel do skeleton de um objeto remoto**
   O **skeleton** em RMI (ou em sistemas distribuídos semelhantes) é responsável por:
   - Receber chamadas de métodos remotos no servidor.
   - Desfazer o **marshalling** dos argumentos recebidos.
   - Invocar o método no objeto remoto correspondente.
   - Executar o **marshalling** da resposta antes de enviá-la de volta ao cliente【7†source】【13†source】.

### 6. **Cuidados no Garbage Collection distribuído em RMI**
   No **Garbage Collection distribuído**, além do gerenciamento de memória local, é necessário coordenar a remoção de objetos remotos que ainda podem estar referenciados em outros processos distribuídos. Os cuidados incluem:
   - **Manter listas de referências remotas**: Cada servidor deve monitorar quais clientes ainda têm proxies para seus objetos.
   - **Uso de leases temporais**: Os servidores podem estabelecer intervalos de tempo (leases) para proxies remotos. Se o lease não for renovado, o servidor pode liberar o objeto remoto, assumindo que não há mais referências【7†source】【19†source】.

Essas respostas cobrem aspectos-chave dos tópicos abordados nos documentos enviados, relacionando os conceitos de middleware, comunicação, falhas e RMI em sistemas distribuídos.
