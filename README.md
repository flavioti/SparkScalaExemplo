# Spark Scala

Repositorio para armazenar testes feitos com a linguagem Scala usando Spark

## Respostas

1. Qual o objetivo do comando cache​ ​em Spark?

        O objetivo do comando cache é manter em memória um arquivo após seu carregamento, contanto que haja espaço disponível em memória.

2. O mesmo código implementado em Spark é normalmente mais rápido que a implementação equivalente em MapReduce. Por quê?

        Spark roda os processos em memória enquanto Hadoop depende da gravação constante de dados nos clusters. Como acesso a memória é mais rápido que o acesso ao disco, o Spark ganha em performance.

3. Qual é a função do SparkContext​?

        Representa a conexão com o Spark cluster e torna possível a criação de RDDs.

4. Explique com suas palavras o que é Resilient​ ​Distributed​ ​Datasets​ (RDD).

        RDD é a descrição de uma serie de operações, não somente dados, usado pela plataforma para formar um "plano de execução". RDDs trabalham com processamento paralelo, ou seja, a leitura de um arquivo texto pode ser realizada por várias tarefas em conjunto para ganho de performance. O processo pode ocorrer localmente usando vários núcleos do processador ou em rede, usando vários computadores.

5. GroupByKey​ ​é menos eficiente que reduceByKey​ ​em grandes dataset. Por quê?

        reduceByKey é mais eficiente pois faz a agregação antes de agrupar os dados, então o volume fica menor, com um volume menor ocorre o ganho em performance.

6. Explique o que o código Scala abaixo faz.

```scala
val textFile = sc.textFile("hdfs://...")
val counts = textFile.flatMap(line => line.split(" "))
                    .map(word => (word, 1))
                    .reduceByKey(_ + _)
counts.saveAsTextFile("hdfs://...")
```

        > Contagem de palavras
        Na primeira linha é declarado o RDD de um arquivo localizado no HDFS.
        Na segunda é feita uma quebra de cada linha do arquivo por espaços, atribuido o valor 1 para cada palavra, contagem de palavras distintas
        Na terceira o resultado é salvo no HDFS

## Questões sobre o arquivo de log da Nasa

IMPORTANTE: O dataset de 04 de agosto não estava acessível, ao tentar fazer o download era solicitado usuário e senha que não possuo.

Arquivo usado para o processamento:

Link dataset: <ftp://ita.ee.lbl.gov/traces/NASA_access_log_Jul95.gz>

### Exercício

1. Número de hosts únicos.

        81.982

2. O total de erros 404.

        10845

3. Os 5 URLs que mais causaram erro 404.

        /pub/winvn/readme.txt                       667
        /pub/winvn/release.txt                      547
        /history/apollo/apollo-13.html              286
        /shuttle/resources/orbiters/atlantis.gif    230
        /history/apollo/a-001/a-001-patch-small.gif 230

4. Quantidade de erros 404 por dia.

        19/Jul/1995  636
        06/Jul/1995  629
        07/Jul/1995  564
        13/Jul/1995  524
        05/Jul/1995  491
        03/Jul/1995  473
        11/Jul/1995  468
        18/Jul/1995  463
        12/Jul/1995  459
        25/Jul/1995  457
        20/Jul/1995  426
        14/Jul/1995  406
        17/Jul/1995  403
        10/Jul/1995  390
        04/Jul/1995  355
        09/Jul/1995  341
        27/Jul/1995  334
        21/Jul/1995  332
        24/Jul/1995  324
        26/Jul/1995  319
        01/Jul/1995  314
        08/Jul/1995  299
        02/Jul/1995  289
        16/Jul/1995  255
        15/Jul/1995  252
        23/Jul/1995  230
        22/Jul/1995  180
        28/Jul/1995  93

5. O total de bytes retornados.

        38.695.973.491

Fontes
<https://spark.apache.org/docs/2.2.1/api/java/org/apache/spark/SparkContext.html>

Udemy: <https://www.udemy.com/apache-spark-with-scala-hands-on-with-big-data/learn/v4/overview>

Youtube: <https://www.youtube.com/channel/UCeXzeZwuFqhw_2ilpSPaXiQ>

Blog: <http://blog.thedigitalcatonline.com/blog/2015/04/07/99-scala-problems-02-find-last-nth/>

Github <https://github.com/vaquarkhan/vk-wiki-notes/wiki/reduceByKey--vs-groupBykey-vs-aggregateByKey-vs-combineByKey>