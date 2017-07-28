package com.knoldus

class ShoppingStore {

  def totalSalesTax(items: List[ShoppingItem]): Double =
    items.foldLeft(0.0){(st,item) =>
       st + {
         item match {
           case _: Exempt => 0
           case otherItem => otherItem.price * 0.15
         }
       }
    }

  def grossAmount(items: List[ShoppingItem]): Double =
    items.foldLeft(0.0)((total, item) => total + item.price) + totalSalesTax(items)
}
