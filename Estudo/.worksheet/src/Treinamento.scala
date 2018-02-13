object Treinamento {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(67); 
 
 val mapa = Map(("A" -> 200), ("B" -> 304));System.out.println("""mapa  : scala.collection.immutable.Map[String,Int] = """ + $show(mapa ));$skip(27); ;
  
	mapa.foreach(println);$skip(35); val res$0 = ;
        
  mapa.mapValues(x => x);;System.out.println("""res0: scala.collection.immutable.Map[String,Int] = """ + $show(res$0))}
  
}
