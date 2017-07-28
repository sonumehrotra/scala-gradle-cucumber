package com.knoldus

import cucumber.api.scala.{EN, ScalaDsl}

class ShoppingSteps extends ScalaDsl with EN {

  var shoppingItems: List[ShoppingItem] = Nil
  val shoppingStore: ShoppingStore = new ShoppingStore
  var salesTax: Double = _
  var grossAmount: Double = _

  Before() { _ =>
      shoppingItems = Nil
      salesTax = 0.0
      grossAmount = 0.0
  }

  Given("""^a user is registered with the store$"""){ () =>
    //will address this in future, hopefully
  }

  When("""^the user buys(?: the| another) (book|food item|chocolates) of (.+) rupees$"""){ (item: String, amount: Double) =>
    shoppingItems = shoppingItems :+ {
      item match {
      case "book" => Book(amount)
      case "food item" => Food(amount)
      case "chocolates" => Chocolates(amount)
    }
   }
  }

  When("""^the user asks for a bill$"""){() =>
    grossAmount = shoppingStore.grossAmount(shoppingItems)
  }

  Then("""^the total bill user needs to pay is (.+) rupees$"""){ (expectedResult: Double) =>
    assert(grossAmount == expectedResult, s"The actual gross amount $grossAmount did not match expected $expectedResult")
  }

}
