
// Scala program to print Hello World! 
object Hello
{
    // Main Method 
    
    def exo01()={
    var var3 = 2

    if (var3 == 1)
    {
        println("True")
    } 
    else
    {
        println("False")
    }

     //prints Hello World
        println("Hello World! by ") 
    }
    def exo02()= 
    {
        for (a<-1 to 10){
        println("valeur de a : "+a)
        }
    }

    def multi10(m:Int):Int=m*10

    def exo04()=
    {
        val fruits : List[String] = List ("Bananes","Oranges","Pommes")
        val chiffres : List[Int] = List(1,3,9,7)
        val listedeListes : List[List[Int]] = List(List(1,3),List(2,5,7))
        val List2 = chiffres.filter(_>=7)
        List2.foreach(println(_))
    
    } 

    def exo05()=
    {
    val lettre : List[String] = List("AA", "BBB", "CCCC")
    lettre.map(X => (X, X.length)).foreach(println)
    }

    def main(args: Array[String]) ={
        exo05()
        }

  
}
