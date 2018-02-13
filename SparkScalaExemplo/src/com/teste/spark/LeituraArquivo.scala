package com.teste.spark;

import org.apache.spark._;
import org.apache.spark.SparkContext._;
import org.apache.log4j._;

object LeituraArquivo {

  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(org.apache.log4j.Level.OFF);

    val sc = new SparkContext("local[*]", "meuProcessamento");
    //val rdd = sc.textFile("file:///E:/Semantix/access_log_Jul95");
    val rdd = sc.textFile("file:///E:/Semantix/part-00000");
    println("\nTotal de linhas: " + rdd.count());

    val lines = rdd.filter(x => x.length() >= 10); // Remoção de linhas inválidas (Por algum motivo existe uma linha com somente 8 caracteres... )

    println("\nTotal de linhas válidas: " + lines.count());
    println("\nTotal de linhas inválidas: " + (rdd.count() - lines.count()) + "\n");

    numeroDeHostsUnicos(lines);
    cincoUrlQueMaisCausaramErro404(lines);
    totalDeErros404(lines);
  };

  def cincoUrlQueMaisCausaramErro404(lines: org.apache.spark.rdd.RDD[String]) {
    val rdd = lines.map(interpretarUrlCodigo);
    val filtro404 = rdd.filter((tupla) => { tupla._2 == 404 });
    val totalPorRequisicao = filtro404.mapValues(x => (x, 1));
    val totalPorRequisicaoReduc = totalPorRequisicao.reduceByKey((x, y) => (x._1, x._2 + y._2));
    val ordenado = totalPorRequisicaoReduc.sortBy(_._2._2, false);
    println("\nOs 5 URLs que mais causaram erro 404 ( URL, ( Código, Quantidade )):");
    ordenado.take(5).foreach(println);
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
    val hosts = lines.map((line) => { line.toString().split(" - - ")(0).trim() });
    println("\nTotal de hosts: " + hosts.count());
    hosts.foreach(println);
    val resultado = hosts.distinct().groupBy(x => x);
    resultado.foreach(println);
    println("\nTotal de hosts unicos: " + resultado.count());
  };

  def totalDeErros404(lines: org.apache.spark.rdd.RDD[String]) {
    val colunas = lines.map(line => {
      val colunas = line.toString().split(" ");
      if (colunas.length > 1) {
        colunas.init.last
      } else {
        println("Informação inválida");
        println(colunas(0).toString());
      }
    });
    val filtro = colunas.filter(field => field == "404");
    println("\nTotal de erros 400...: " + filtro.count());
  };  

}

// Last but one
// http://blog.thedigitalcatonline.com/blog/2015/04/07/99-scala-problems-02-find-last-nth/