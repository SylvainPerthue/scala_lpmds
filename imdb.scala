class Movie (id:Int, mTitle:String, mYear:Int, mDirector: String)
{
val mid = id
var title = mTitle
var year = mYear
var director = mDirector

override def toString():String = (
    "[Mid:"+mid + "]," + "[Title :" + title + "]," + "[Year:" + year + "]," + "[Director:" + director + "]"

)
}
//Reviewer(rID, name)
class Reviewer  (p_rID:Int, p_name:String)
{
val rID= p_rID
var name = p_name
override def toString():String = {
    "[Rid:"+rID + "]," + "[Name :" + p_name + "]"
} 
}
// Rating(rID, mID, stars, ratingDate)
class Rating (p_rID:Int, id:Int, p_stars:Int, p_ratingDate:String)
val rID = p_rID
val mid = id 
var Stars = p_stars
var ratingDate = p_ratingDate

override def toString():String = (
    "[rID:"+ p_rID + "]," + "[mid :" + id + "]," + "[Stars:" + p_stars + "]," + "[ratingDatete:" + p_ratingDate + "]"
)

object Movie
object Reviewer
object Rating
{
 def main(args: Array[String]) ={
        var movie1= new Movie(1,"film1", 200,"Dir1")
        var Reviewer1 = new Reviewer (1 , "Sylvain PERTHUE")
        var Rating1 = new Rating
        println(Rating1)
        }
}