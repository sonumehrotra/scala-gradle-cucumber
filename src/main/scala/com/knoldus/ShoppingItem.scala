package com.knoldus

sealed trait ShoppingItem {
  def price: Double
}

trait Exempt extends ShoppingItem

trait Import extends ShoppingItem

case class Book(price: Double) extends Exempt
case class Food(price: Double) extends Exempt

case class Chocolates(private val actualPrice: Double) extends Import {
  override def price: Double = (0.05 * actualPrice)  + actualPrice
}
