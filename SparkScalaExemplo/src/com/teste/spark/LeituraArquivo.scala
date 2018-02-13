package com.teste.spark;

import org.apache.spark._;
import org.apache.spark.SparkContext._;
import org.apache.log4j._;
import java.sql.Date

object LeituraArquivo {

  {
    Logger.getLogger("org").setLevel(org.apache.log4j.Level.ERROR);
  }

  def main(args: Array[String]) {

    val sc = new SparkContext("local[*]", "meuProcessamento")
    val rdd = sc.textFile("file:///E:/Semantix/access_log_Jul95");

    val lines = rdd.filter(x => x.length() >= 10);

    println("\nLinhas válidas: " + lines.count());
    println("\nLinhas descartadas: " + (rdd.count() - lines.count()) + "\n");

    numeroDeHostsUnicos(lines);
    cincoUrlQueMaisCausaramErro404(lines);
    totalDeErros404(lines);
    errosPorDia(lines);
    totalBytesRetornados(lines)

    println("\nFim")
  };

  def totalBytesRetornados(lines: org.apache.spark.rdd.RDD[String]) {
    val resultado = lines.map(line => {
      val byte: Long = scala.util.Try(line.split(" ").last.toLong) getOrElse 0;
      byte
    }).reduce((x, y) => x + y);
    println("\nTotal de bytes retornados: " + resultado)
  };

  def errosPorDia(lines: org.apache.spark.rdd.RDD[String]) {
    val resultado = lines.map(interpretarDataCodigo)
      .filter((tupla) => { tupla._2 == 404 })
      .mapValues(x => (x, 1))
      .reduceByKey((x, y) => (x._1, x._2 + y._2))
      .sortBy(_._2._2, false);
    println("\nTotal de erros por dia (descendente)")
    resultado.collect().foreach(println);
  };

  def cincoUrlQueMaisCausaramErro404(lines: org.apache.spark.rdd.RDD[String]) {
    val resultado = lines.map(interpretarUrlCodigo)
      .filter((tupla) => { tupla._2 == 404 })
      .mapValues(x => (x, 1))
      .reduceByKey((x, y) => (x._1, x._2 + y._2))
      .sortBy(_._2._2, false);
    println("\nOs 5 URLs que mais causaram erro 404:");
    resultado.take(5).foreach(println);
  };

  def interpretarUrlCodigo(linha: String): (String, Int) = {
    val passo1 = linha.split(" - - ")
    var codigo: Int = 999;
    var url: String = "";
    if (passo1.length == 2) {
      val passo2 = passo1(1).split("] \"GET ");
      if (passo2.length == 2) {
        val passo3 = passo2(1).split(" ");
        url = passo3(0).trim();
        codigo = scala.util.Try(passo3(2).trim().toInt) getOrElse 999;
      };
    };
    (url, codigo)
  };

  def numeroDeHostsUnicos(lines: org.apache.spark.rdd.RDD[String]) {
    val resultado = lines.map(x => x.toString().split(" - - ")(0).trim())
      .distinct().groupBy(x => x);
    println("\nTotal de hosts unicos: " + resultado.count());
  };

  def totalDeErros404(lines: org.apache.spark.rdd.RDD[String]) {
    val colunas = lines.map(line => {
      val colunas = line.toString().split(" ");
      if (colunas.length > 1) {
        colunas.init.last;
      } else {
        println("Informação inválida");
        println(colunas(0).toString());
      };
    });
    val filtro = colunas.filter(field => field == "404");
    println("\nTotal de erros 404...: " + filtro.count());
  };

  def interpretarDataCodigo(linha: String): (String, Int) = {
    val passo1 = linha.split(" - - ");
    var codigo: Int = 999;
    var dateStr: String = "SEM_DATA";
    if (passo1.length == 2) {
      val passo2 = passo1(1).split("] \"GET ");
      if (passo2.length == 2) {
        val passo3 = passo2(1).split(" ");
        dateStr = passo2(0).trim().substring(1, 12);
        codigo = scala.util.Try(passo3(2).trim().toInt) getOrElse 999;
      };
    };
    (dateStr, codigo)
  };

};