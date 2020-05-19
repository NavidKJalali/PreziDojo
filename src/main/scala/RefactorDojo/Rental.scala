package RefactorDojo

case class Rental(movie: Movie, daysRented: Int) {
  def price: Double = movie.priceCode.price(daysRented)
  def points: Int = movie.priceCode.points(daysRented)
}
