package RefactorDojo

sealed trait PriceCode {
  val basePrice: Double
  val perDayPrice: Double
  val startsAfter: Int
  def points(daysRented: Int): Int = 1
  def price(daysRented: Int): Double = basePrice +
    (if (daysRented > startsAfter) (daysRented - startsAfter) * perDayPrice else 0)
}

object PriceCode {
  case object Regular extends PriceCode {
    override val basePrice = 2
    override val perDayPrice = 1.5
    override val startsAfter = 2
  }

  case object NewRelease extends PriceCode {
    override val basePrice = 0
    override val perDayPrice = 3
    override val startsAfter = 0

    override def points(daysRented: Int): Int = if (daysRented > 1) 2 else super.points(daysRented)
  }

  case object Childrens extends PriceCode {
    override val basePrice = 1.5
    override val perDayPrice = 1.5
    override val startsAfter = 3
  }
}
