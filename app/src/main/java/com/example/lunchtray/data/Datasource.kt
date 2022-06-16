package com.example.lunchtray.data

import com.example.lunchtray.model.Accompaniment
import com.example.lunchtray.model.Entree
import com.example.lunchtray.model.SideDish

class Datasource {

  fun getEntree(): List<Entree> = listOf(
    Entree(
      "Cauliflower",
      "Whole cauliflour, brined, roasted, and deeo fried",
      7.0
    ),
    Entree(
      "Three Bean Chili",
      "Black beans, red beans, kidney beans, slow cooked, topped with onion",
      4.0
    ),

    Entree(
      "Mushroom Pasta",
      "sdfas",
      3.0
    ),
    Entree(
      "Spicy Black Bean Skillet",
      "sdfa",
      2.0
    )
  )

  fun getSideDish(): List<SideDish> = listOf(
    SideDish(
      "Summer Salad",
      "dasjkljflöjdslöfajöksadljöl",
      2.5
    ),
    SideDish(
      "Butternut",
      "fdsajfldja",
      3.0
    ),
    SideDish(
      "Spicy Potatoes",
      "dlkfsjalkjdf",
      2.0
    ),
    SideDish(
      "Coconut Rice",
      "lksadjflkjha",
      1.5
    )
  )

  fun getAccompaniment(): List<Accompaniment> = listOf(
    Accompaniment(
      "Lunch Roll",
      "dsahfash",
      0.5
    ),
    Accompaniment(
      "Mixed Berries",
      "dsahfash",
      1.0
    ),
    Accompaniment(
      "Pickled Veggies",
      "dsahfash",
      0.5
    )
  )
}