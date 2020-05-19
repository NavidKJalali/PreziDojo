package RefactorDojo

import org.specs2.mutable._

class CustomerTest extends SpecificationWithJUnit{
  "statement" should {
    val customer = Customer("Joe")
    "generate statement for children's movie" in {
      customer
        .addRental(Rental(Movie("Rambo 1", PriceCode.Childrens), 1))
        .statement === "Rental Record for Joe\n\tRambo 1	1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points"
    }

    "generate statement for two rentals for a day" in {
      customer
        .addRental(Rental(Movie("Rambo 1", PriceCode.Childrens), 1))
        .addRental(Rental(Movie("Rambo 2", PriceCode.NewRelease), 1))
        .statement === "Rental Record for Joe\n\tRambo 1	1.5\n\tRambo 2	3.0\nAmount owed is 4.5\nYou earned 2 frequent renter points"
    }

    "generate statement for two rentals with different length" in {
      customer
        .addRental(Rental(Movie("Rambo 1", PriceCode.Childrens), 1))
        .addRental(Rental(Movie("Rambo 2", PriceCode.NewRelease), 2))
        .statement === "Rental Record for Joe\n\tRambo 1	1.5\n\tRambo 2	6.0\nAmount owed is 7.5\nYou earned 3 frequent renter points"
    }

    "generate statement for three rentals with different price codes" in {
      customer
        .addRental(Rental(Movie("Rambo 1", PriceCode.Childrens), 1))
        .addRental(Rental(Movie("Rambo 2", PriceCode.NewRelease), 2))
        .addRental(Rental(Movie("Rambo 3", PriceCode.Regular), 1))
        .statement === "Rental Record for Joe\n\tRambo 1	1.5\n\tRambo 2	6.0\n\tRambo 3	2.0\nAmount owed is 9.5\nYou earned 4 frequent renter points"
    }
  }
}
