object Aprendizado {

// VALUES are immutable constants. You can't change them once defined.
	val hello: String = "Bonjour!"            //> hello  : String = Bonjour!
  println(hello)                                  //> Bonjour!
  
  // Notice how Scala defines things backwards from other languages - you declare the
  // name, then the type.
  
  // VARIABLES are mutable
  var helloThere: String = hello                  //> helloThere  : String = Bonjour!
  helloThere = hello + " There!"
  println(helloThere)                             //> Bonjour! There!
  
  
  // One key objective of functional programming is to use immutable objects as often as possible.
  // Try to use operations that transform immutable objects into a new immutable object.
  // For example, we could have done the same thing like this:
  val immutableHelloThere = hello + "There!"      //> immutableHelloThere  : String = Bonjour!There!
  println(immutableHelloThere)                    //> Bonjour!There!
  
  // Some other types
  val numberOne : Int = 1                         //> numberOne  : Int = 1
  val truth : Boolean = true                      //> truth  : Boolean = true
  val letterA : Char = 'a'                        //> letterA  : Char = a
  val pi : Double = 3.14159265                    //> pi  : Double = 3.14159265
  val piSinglePrecision : Float = 3.14159265f     //> piSinglePrecision  : Float = 3.1415927
  val bigNumber : Long = 1234567890l              //> bigNumber  : Long = 1234567890
  val smallNumber : Byte = 127                    //> smallNumber  : Byte = 127
  
  // String printing tricks
  // Concatenating stuff with +:
  println("Here is a mess: " + numberOne + truth + letterA + pi + bigNumber)
                                                  //> Here is a mess: 1truea3.141592651234567890
  
  // printf style:
  println(f"Pi is about $piSinglePrecision%.3f")  //> Pi is about 3,142
  println(f"Zero padding on the left: $numberOne%05d")
                                                  //> Zero padding on the left: 00001
                                                  
  // Substituting in variables:
  println(s"I can use the s prefix to use variables like $numberOne $truth $letterA")
                                                  //> I can use the s prefix to use variables like 1 true a
  // Substituting expressions (with curly brackets):
  println(s"The s prefix isn't limited to variables; I can include any expression. Like ${1+2}")
                                                  //> The s prefix isn't limited to variables; I can include any expression. Like
                                                  //|  3
                                                 
  // Using regular expressions:
  val theUltimateAnswer: String = "To life, the universe, and everything is 42."
                                                  //> theUltimateAnswer  : String = To life, the universe, and everything is 42.
                                                  //| 
  val pattern = """.* ([\d]+).*""".r              //> pattern  : scala.util.matching.Regex = .* ([\d]+).*
  val pattern(answerString) = theUltimateAnswer   //> answerString  : String = 42
  val answer = answerString.toInt                 //> answer  : Int = 42
  println(answer)                                 //> 42
  
  // Dealing with booleans
  val isGreater = 1 > 2                           //> isGreater  : Boolean = false
  val isLesser = 1 < 2                            //> isLesser  : Boolean = true
  val impossible = isGreater & isLesser           //> impossible  : Boolean = false
  val anotherWay = isGreater && isLesser          //> anotherWay  : Boolean = false
  
  val picard: String = "Picard"                   //> picard  : String = Picard
  val bestCaptain: String = "Picard"              //> bestCaptain  : String = Picard
  val isBest: Boolean = picard == bestCaptain     //> isBest  : Boolean = true
  
  // EXERCISE
  // Write some code that takes the value of pi, doubles it, and then prints it within a string with
  // three decimal places of precision to the right.
  // Just write your code below here; any time you save the file it will automatically display the results!
  
  
  var vogais = ("A", "E", "I", "O", "U")          //> vogais  : (String, String, String, String, String) = (A,E,I,O,U)
  println(vogais)                                 //> (A,E,I,O,U)
  println(vogais._1)                              //> A
  println(vogais._2)                              //> E
  println(vogais._3)                              //> I
  
  
  println("TUPLA")                                //> TUPLA
	val tuplaNomeIdade = "Flavio"->34         //> tuplaNomeIdade  : (String, Int) = (Flavio,34)
	
	
	println("ARRAY")                          //> ARRAY
	val arrayVogais=("A","E","I","O","U")     //> arrayVogais  : (String, String, String, String, String) = (A,E,I,O,U)
	
	println("LISTA")                          //> LISTA
	val listaAlfabeto = List("A","B","C","D","E","F")
                                                  //> listaAlfabeto  : List[String] = List(A, B, C, D, E, F)
	println(listaAlfabeto(0))                 //> A
	println(listaAlfabeto.head)               //> A
	println(listaAlfabeto.tail)               //> List(B, C, D, E, F)
	
	
	println("LOOP FOR")                       //> LOOP FOR
	for (ship <- listaAlfabeto ) { println(ship) }
                                                  //> A
                                                  //| B
                                                  //| C
                                                  //| D
                                                  //| E
                                                  //| F
                                                  
	println("MAP")                            //> MAP
	val reverso = listaAlfabeto.map( (ship) => {ship.reverse} )
                                                  //> reverso  : List[String] = List(A, B, C, D, E, F)
	println(reverso(2))                       //> C
	
	
	var outroMap = Map("A" -> 1,"B" -> 2,"C" -> 3)
                                                  //> outroMap  : scala.collection.immutable.Map[String,Int] = Map(A -> 1, B -> 2
                                                  //| , C -> 3)
	println(outroMap("B"))                    //> 2
	println(outroMap.contains("C"))           //> true
	
	var traterro = util.Try(outroMap("Z")) getOrElse "Nao encontrei"
                                                  //> traterro  : Any = Nao encontrei
	println(traterro)                         //> Nao encontrei
	
	
	println("REDUCE")                         //> REDUCE
	val listaNumero = List(1,2,3,4,5,6,7,8,9) //> listaNumero  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
	val soma = listaNumero.reduce( (x: Int, y: Int) => x + y )
                                                  //> soma  : Int = 45
  println("FILTER")                               //> FILTER
	val semDois = listaNumero.filter( ( x ) => x != 2 )
                                                  //> semDois  : List[Int] = List(1, 3, 4, 5, 6, 7, 8, 9)
	val semDoisTambem = listaNumero.filter( _ != 2 )
                                                  //> semDoisTambem  : List[Int] = List(1, 3, 4, 5, 6, 7, 8, 9)
  
  println("CONCATENACAO")                         //> CONCATENACAO
  val muitosNumero = listaNumero ++ listaNumero   //> muitosNumero  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 
                                                  //| 6, 7, 8, 9)
  val listaNumeroDesordenada = List(5,7,9,3,1,2,3,4,6,8,1,2,3,4,5,6,7,8,9)
                                                  //> listaNumeroDesordenada  : List[Int] = List(5, 7, 9, 3, 1, 2, 3, 4, 6, 8, 1,
                                                  //|  2, 3, 4, 5, 6, 7, 8, 9)
  val ordenado = listaNumeroDesordenada.sorted    //> ordenado  : List[Int] = List(1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8
                                                  //| , 8, 9, 9)
  val distinto = listaNumeroDesordenada.distinct.sorted
                                                  //> distinto  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  
  var maximo = listaNumeroDesordenada.max         //> maximo  : Int = 9
  var minimo = listaNumeroDesordenada.min         //> minimo  : Int = 1
  
  var contem3 = listaNumeroDesordenada.contains(3)//> contem3  : Boolean = true
  
  var somaItens = listaNumeroDesordenada.sum      //> somaItens  : Int = 93
  
  println(listaNumeroDesordenada.distinct.sorted.reverse)
                                                  //> List(9, 8, 7, 6, 5, 4, 3, 2, 1)
  
  
  
  
}