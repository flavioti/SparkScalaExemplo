package com.teste.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

object LeituraArquivo {
  
  def main(args: Array[String]) {
  
    processarNovo()
    
  }
  
  def processarNovo() {

    val sc = new SparkContext("local[*]", "meuProcessamento")

    val lines = sc.textFile("file:///E:/Semantix/part-00000", 4)
    
    val rdd = lines.map(interpretarLinha)
    
    var result = rdd.groupBy(identity)
                    .mapValues(_.size)
                    .sortBy((x) => { x._2 }, true, 4)
    
    result.foreach(println)
    
  }
  
  
  def interpretarLinha(linha: String) = {
    val passo1 = linha.split(" - - ")    
    val passo2 = passo1(1).split("] \"GET ")   
    val passo3 = passo2(1).split(" ")
    
    val host = passo1(0).trim()
    val data = passo2(0).substring(1).trim()
    val url = passo3(0).trim()
    val protocolo = passo3(1).trim()
    val codigo = passo3(2).trim()
    val bits = passo3(3).trim()
    
    //(host, data, url, protocolo, codigo, bits)
    List(url, codigo)
  }
  
  
  def processarTotais() {
    
        // Cria um contexto spark
    // local siginifica que o processamento ocorrerá nesse computador
    // Asterisco siginifica que usará todos os núcleos de processamento
    // meuProcessamento é o nome/identificador da sessão
    val sc = new SparkContext("local[*]", "meuProcessamento")

    //val rdd = sc.textFile("file:///E:/Semantix/access_log_Jul95", particoes)
    val rdd = sc.textFile("file:///E:/Semantix/part-00000")
       
    // Obtem a primeira coluna
    val qtdHostsUnicos = rdd.map(line => line.toString().split(" - - ")(0).distinct )
    
    // Obtem a penultima coluna
    val qtdErro400 = rdd.map( line => line.toString().split(" ").init.last )
                        .filter( field => field == "400" )    
    
    println("Total de linhas......: " + rdd.count())
    println("Total de hosts unicos: " + qtdHostsUnicos.count())
    println("Total de erros 400...: " + qtdErro400.count())
    
  }
 
}


// Last but one
// http://blog.thedigitalcatonline.com/blog/2015/04/07/99-scala-problems-02-find-last-nth/
