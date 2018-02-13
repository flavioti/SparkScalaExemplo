object TesteAgrupamentoDados {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(171); 
  
  val clientes = List(("Flavio" -> "Sao Paulo"),("Flavio" -> "Sao Joao Del Rei"),("Fernanda" ->"Santa Rita"),("Fernanda" -> "Sao Paulo"));System.out.println("""clientes  : List[(String, String)] = """ + $show(clientes ));$skip(48); 
  
  val rdd = clientes.map( x => (x._1, x._2));System.out.println("""rdd  : List[(String, String)] = """ + $show(rdd ));$skip(26); 
  
  rdd.foreach(println)}
  
}
