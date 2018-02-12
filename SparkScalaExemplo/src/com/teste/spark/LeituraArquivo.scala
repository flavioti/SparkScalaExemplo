package com.teste.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

object LeituraArquivo {
  
  def main(args: Array[String]) {
  
    // Cria um contexto spark
    // local siginifica que o processamento ocorrerá nesse computador
    // Asterisco siginifica que usará todos os núcleos de processamento
    // meuProcessamento é o nome/identificador da sessão
    val sc = new SparkContext("local[*]", "meuProcessamento")
    
    var particoes = 7
    
    //val rdd = sc.textFile("file:///E:/Semantix/access_log_Jul95", particoes)
    val rdd = sc.textFile("file:///E:/Semantix/part-00000", particoes)
    
    val total = rdd.count()
    val filtro = rdd.map(x => x.toString().split(" - "))
    
    //val results = lines.countByValue()
    
    println(total)
    println(filtro.toString())
    //println(results)
    
    //rdd.saveAsTextFile("file:///E:/Semantix/access_log_Jul95_menor")
    
    
  
  }
  
}