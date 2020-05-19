package RefactorDojo

case class Customer(name: String, rentals: List[Rental] = List.empty) {

  def addRental(rental: Rental): Customer = Customer(name, rentals :+ rental)

  def log: String = rentals.map(rental => s"\t${rental.movie.title}\t${rental.price}").mkString("\n")

  def priceTotal: Double = rentals.map(_.price).sum

  def frequentRenterPoints: Int = rentals.map(_.points).sum

  def statement: String =
    s"Rental Record for $name\n$log\nAmount owed is $priceTotal\nYou earned $frequentRenterPoints frequent renter points"
}
