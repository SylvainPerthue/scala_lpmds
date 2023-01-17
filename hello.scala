
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

    def exo06()=
    {
        val suite : List[Int] = List(1,1,2,3,2,4,5)
        val Gbsuite = suite.groupBy(X => X)
        Gbsuite.map(X=> (X._1,X._2.sum)).foreach(println)
    }

 def exo07()=
    {
        val suite = List(("A", 4),("B", 5),("C", 5),("A", 5),("C", 3))
        val Gbsuite = suite.groupBy(X=>X._1).mapValues(X=>X.map(X=>X._2).sum).toList /* Tri ordre decroissant */
        Gbsuite.sortWith(_._2 > _._2).filter(_._2 > 6).foreach(println) /* Tri somme > 6 */
    }

def avg(xs: List[Int])=xs.sum.toDouble/xs.length.toDouble
    def get_studentById(p_id:Int, etudiants:List[(Int,String)]):(Int,String)={
        return etudiants.filter(_._1==p_id)(0)
    }

def exo08()=
    {
        val etudiants = List ((1,"A"),(2,"B"),(3,"C"))
        val ues = List((1,"M1"),(2,"M2"),(3,"M3"))
        val notes = List((1,1,12),(1,2,13),(1,3,14),(2,1,11),(2,2,9),(2,3,13),(3,1,12),(3,2,13))
        
        // Création de la map associant chaque étudiant à sa liste de notes
        val mapNotesEtudiant = notes.groupBy(_._1)

        // Calcul de la moyenne de chaque étudiant
        println(etudiants.map { case (id, nom) =>
            val notesEtudiant = mapNotesEtudiant(id)
            val sommeNotes = notesEtudiant.map(_._3).sum
            val nbNotes = notesEtudiant.length

            (nom, sommeNotes.toDouble / nbNotes)
            })
            println(get_studentById(1,ues)._2)
            notes.groupBy(_._1).foreach(println)
            notes.groupBy(_._1).map(x => (x._1, avg(x._2.map(y => y._3)))).foreach(println)
        }
    
    def main(args: Array[String]) ={
        exo08()
        }

}
