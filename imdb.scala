class Movie (id:Int, mTitle:String, mYear:Int, mDirector:String){
    val mid = id
    var Title = mTitle
    var Year = mYear
    var Director = mDirector
    override def toString():String={
        "[Mid: " +mid + "], " + "[Title: "+Title + "], "+"[Year: "+Year +"], "+"[Director: "+Director +"]"
    }
}

class Reviewer(p_rId:Int, p_name:String){
    val rID = p_rId
    var name = p_name
    override def toString():String={
        "[rID: " +rID + "], " + "[Name: "+name + "]"
    }
}

class Rating(p_rId:Int, id:Int, p_stars:Int, p_ratingDate:String){
    val rID = p_rId
    val mid = id
    var Stars = p_stars
    var ratingDate = p_ratingDate
    override def toString():String={
        "[rID: " +p_rId + "], " + "[mid: "+id + "]" + "[Stars: "+p_stars + "]" + "[ratingDate: "+p_ratingDate + "]"
    }
}



object Movie 
object Reviewer
object Rating
{
    def loadMovieData(path:String):Array[Movie]=
    {
        var movies:Array[Movie] = Array.empty
        val bufferedSource = io.Source.fromFile(path)
        for (line <- bufferedSource.getLines){
            val values = line.split(",").map(_.trim)
            val movie = new Movie(values(0).toInt, values(1).substring(1, values(1).length()-1), values(2).toInt, values(3).substring(1,values(3).length()-1))

            movies = movies :+ movie
        }
        bufferedSource.close
        return movies
        }

    def loadRatingData(path:String):Array[Rating]=
    {
        var ratings:Array[Rating] = Array.empty
        val bufferedSource = io.Source.fromFile(path)
        for (line <- bufferedSource.getLines){
            val values = line.split(",").map(_.trim)
            val rating = new Rating(values(0).toInt, values(1).toInt, values(2).toInt, values(3).substring(1,values(3).length()-1))

            ratings = ratings :+ rating
        }
        bufferedSource.close
        return ratings
        }

    def loadReviewerData(path:String):Array[Reviewer]=
    {
        var reviewers:Array[Reviewer] = Array.empty
        val bufferedSource = io.Source.fromFile(path)
        for (line <- bufferedSource.getLines){
            val values = line.split(",").map(_.trim)
            val reviewer = new Reviewer(values(0).toInt, values(1).substring(1, values(1).length()-1))

            reviewers = reviewers :+ reviewer
        }
        bufferedSource.close
        return reviewers
        }
    
    def exo1(movies: Array[Movie]) = {
        movies.filter(_.Director == "Steven Spielberg").foreach(println)
    }

    def exo2(movie: Array[Movie], rating: Array[Rating]) = {
        rating.filter(_.Stars >= 4).map(r => movie.find(_.mid == r.mid).get.Year).distinct.sorted.foreach(println)
    }

    def exo3(movie: Array[Movie], rating: Array[Rating], reviewer: Array[Reviewer]) = {
        val goneWithTheWind = movie.find(m => m.Title == "Gone with the Wind").get
        val goneWithTheWindRatings = rating.filter(r => r.mid == goneWithTheWind.mid)
        val goneWithTheWindReviewerIds = goneWithTheWindRatings.map(r => r.rID)
        goneWithTheWindReviewerIds.foreach(id => {
        val reviewers = reviewer.find(r => r.rID == id).get
        println(reviewers.name)
        })
    }
    
    def main(args: Array[String]){
        var movie:Array[Movie] = loadMovieData("data/movie.csv")
        
        //movie.foreach(println)
        //println("\n")

        var rating:Array[Rating] = loadRatingData("data/rating.csv")
        //rating.foreach(println)
        //println("\n")

        var reviewer:Array[Reviewer] = loadReviewerData("data/reviewer.csv")
        //movie.foreach(println)
        //println("\n")
        exo1(movie)
        exo2(movie, rating)
        exo3(movie, rating, reviewer)
    }
}