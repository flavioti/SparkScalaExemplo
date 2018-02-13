package com.teste.estudo

object Aprendizado {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(151); 

// VALUES are immutable constants. You can't change them once defined.
	val hello: String = "Bonjour!";System.out.println("""hello  : String = """ + $show(hello ));$skip(17); 
  println(hello);$skip(180); 
  
  // Notice how Scala defines things backwards from other languages - you declare the
  // name, then the type.
  
  // VARIABLES are mutable
  var helloThere: String = hello;System.out.println("""helloThere  : String = """ + $show(helloThere ));$skip(33); 
  helloThere = hello + " There!";$skip(22); 
  println(helloThere);$skip(304); 
  
  
  // One key objective of functional programming is to use immutable objects as often as possible.
  // Try to use operations that transform immutable objects into a new immutable object.
  // For example, we could have done the same thing like this:
  val immutableHelloThere = hello + "There!";System.out.println("""immutableHelloThere  : String = """ + $show(immutableHelloThere ));$skip(31); 
  println(immutableHelloThere);$skip(52); 
  
  // Some other types
  val numberOne : Int = 1;System.out.println("""numberOne  : Int = """ + $show(numberOne ));$skip(29); 
  val truth : Boolean = true;System.out.println("""truth  : Boolean = """ + $show(truth ));$skip(27); 
  val letterA : Char = 'a';System.out.println("""letterA  : Char = """ + $show(letterA ));$skip(31); 
  val pi : Double = 3.14159265;System.out.println("""pi  : Double = """ + $show(pi ));$skip(46); 
  val piSinglePrecision : Float = 3.14159265f;System.out.println("""piSinglePrecision  : Float = """ + $show(piSinglePrecision ));$skip(37); 
  val bigNumber : Long = 1234567890l;System.out.println("""bigNumber  : Long = """ + $show(bigNumber ));$skip(31); 
  val smallNumber : Byte = 127;System.out.println("""smallNumber  : Byte = """ + $show(smallNumber ));$skip(142); 
  
  // String printing tricks
  // Concatenating stuff with +:
  println("Here is a mess: " + numberOne + truth + letterA + pi + bigNumber);$skip(72); 
  
  // printf style:
  println(f"Pi is about $piSinglePrecision%.3f");$skip(55); 
  println(f"Zero padding on the left: $numberOne%05d");$skip(170); 
                                                  
  // Substituting in variables:
  println(s"I can use the s prefix to use variables like $numberOne $truth $letterA");$skip(150); 
  // Substituting expressions (with curly brackets):
  println(s"The s prefix isn't limited to variables; I can include any expression. Like ${1+2}");$skip(164); 
                                                 
  // Using regular expressions:
  val theUltimateAnswer: String = "To life, the universe, and everything is 42.";System.out.println("""theUltimateAnswer  : String = """ + $show(theUltimateAnswer ));$skip(37); 
  val pattern = """.* ([\d]+).*""".r;System.out.println("""pattern  : scala.util.matching.Regex = """ + $show(pattern ));$skip(48); 
  val pattern(answerString) = theUltimateAnswer;System.out.println("""answerString  : String = """ + $show(answerString ));$skip(34); 
  val answer = answerString.toInt;System.out.println("""answer  : Int = """ + $show(answer ));$skip(18); 
  println(answer);$skip(55); 
  
  // Dealing with booleans
  val isGreater = 1 > 2;System.out.println("""isGreater  : Boolean = """ + $show(isGreater ));$skip(23); 
  val isLesser = 1 < 2;System.out.println("""isLesser  : Boolean = """ + $show(isLesser ));$skip(40); 
  val impossible = isGreater & isLesser;System.out.println("""impossible  : Boolean = """ + $show(impossible ));$skip(41); 
  val anotherWay = isGreater && isLesser;System.out.println("""anotherWay  : Boolean = """ + $show(anotherWay ));$skip(36); 
  
  val picard: String = "Picard";System.out.println("""picard  : String = """ + $show(picard ));$skip(37); 
  val bestCaptain: String = "Picard";System.out.println("""bestCaptain  : String = """ + $show(bestCaptain ));$skip(46); 
  val isBest: Boolean = picard == bestCaptain;System.out.println("""isBest  : Boolean = """ + $show(isBest ));$skip(329); 
  
  // EXERCISE
  // Write some code that takes the value of pi, doubles it, and then prints it within a string with
  // three decimal places of precision to the right.
  // Just write your code below here; any time you save the file it will automatically display the results!
  
  
  var vogais = ("A", "E", "I", "O", "U");System.out.println("""vogais  : (String, String, String, String, String) = """ + $show(vogais ));$skip(18); 
  println(vogais);$skip(21); 
  println(vogais._1);$skip(21); 
  println(vogais._2);$skip(21); 
  println(vogais._3);$skip(27); 
  
  
  println("TUPLA");$skip(35); 
	val tuplaNomeIdade = "Flavio"->34;System.out.println("""tuplaNomeIdade  : (String, Int) = """ + $show(tuplaNomeIdade ));$skip(24); 
	
	
	println("ARRAY");$skip(39); 
	val arrayVogais=("A","E","I","O","U");System.out.println("""arrayVogais  : (String, String, String, String, String) = """ + $show(arrayVogais ));$skip(21); 
	
	println("LISTA");$skip(51); 
	val listaAlfabeto = List("A","B","C","D","E","F");System.out.println("""listaAlfabeto  : List[String] = """ + $show(listaAlfabeto ));$skip(27); 
	println(listaAlfabeto(0));$skip(29); 
	println(listaAlfabeto.head);$skip(29); 
	println(listaAlfabeto.tail);$skip(27); 
	
	
	println("LOOP FOR");$skip(48); 
	for (ship <- listaAlfabeto ) { println(ship) };$skip(68); 
                                                  
	println("MAP");$skip(61); 
	val reverso = listaAlfabeto.map( (ship) => {ship.reverse} );System.out.println("""reverso  : List[String] = """ + $show(reverso ));$skip(21); 
	println(reverso(2));$skip(54); 
	
	
	var outroMap = Map("A" -> 1,"B" -> 2,"C" -> 3);System.out.println("""outroMap  : scala.collection.immutable.Map[String,Int] = """ + $show(outroMap ));$skip(24); 
	println(outroMap("B"));$skip(33); 
	println(outroMap.contains("C"));$skip(69); 
	
	var traterro = util.Try(outroMap("Z")) getOrElse "Nao encontrei";System.out.println("""traterro  : Any = """ + $show(traterro ));$skip(19); 
	println(traterro);$skip(25); 
	
	
	println("REDUCE");$skip(43); 
	val listaNumero = List(1,2,3,4,5,6,7,8,9);System.out.println("""listaNumero  : List[Int] = """ + $show(listaNumero ));$skip(60); 
	val soma = listaNumero.reduce( (x: Int, y: Int) => x + y );System.out.println("""soma  : Int = """ + $show(soma ));$skip(20); 
  println("FILTER");$skip(53); 
	val semDois = listaNumero.filter( ( x ) => x != 2 );System.out.println("""semDois  : List[Int] = """ + $show(semDois ));$skip(50); 
	val semDoisTambem = listaNumero.filter( _ != 2 );System.out.println("""semDoisTambem  : List[Int] = """ + $show(semDoisTambem ));$skip(30); 
  
  println("CONCATENACAO");$skip(48); 
  val muitosNumero = listaNumero ++ listaNumero;System.out.println("""muitosNumero  : List[Int] = """ + $show(muitosNumero ));$skip(75); 
  val listaNumeroDesordenada = List(5,7,9,3,1,2,3,4,6,8,1,2,3,4,5,6,7,8,9);System.out.println("""listaNumeroDesordenada  : List[Int] = """ + $show(listaNumeroDesordenada ));$skip(47); 
  val ordenado = listaNumeroDesordenada.sorted;System.out.println("""ordenado  : List[Int] = """ + $show(ordenado ));$skip(56); 
  val distinto = listaNumeroDesordenada.distinct.sorted;System.out.println("""distinto  : List[Int] = """ + $show(distinto ));$skip(46); 
  
  var maximo = listaNumeroDesordenada.max;System.out.println("""maximo  : Int = """ + $show(maximo ));$skip(42); 
  var minimo = listaNumeroDesordenada.min;System.out.println("""minimo  : Int = """ + $show(minimo ));$skip(55); 
  
  var contem3 = listaNumeroDesordenada.contains(3);System.out.println("""contem3  : Boolean = """ + $show(contem3 ));$skip(49); 
  
  var somaItens = listaNumeroDesordenada.sum;System.out.println("""somaItens  : Int = """ + $show(somaItens ));$skip(62); 
  
  println(listaNumeroDesordenada.distinct.sorted.reverse)}
  
  
  
  
}
