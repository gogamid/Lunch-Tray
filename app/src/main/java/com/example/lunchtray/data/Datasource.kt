package com.example.lunchtray.data

import com.example.lunchtray.model.Accompaniment
import com.example.lunchtray.model.Entree
import com.example.lunchtray.model.SideDish

class Datasource {

  fun getEntrees(): List<Entree> = listOf(
    Entree(
      "Cauliflower",
      "Whole cauliflower, brined, roasted, and deep fried",
      7.0
    ),
    Entree(
      "Three Bean Chili",
      "Black beans, red beans, kidney beans, slow cooked, topped with onion",
      4.0
    ),

    Entree(
      "Mushroom Pasta",
      "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic and olive oil",
      3.0
    ),
    Entree(
      "Spicy Black Bean Skillet",
      "Seasonal vegetables, black beans, house spice blend, served with avocado and quick pickled onions",
      2.0
    )
  )

  fun getSideDishes(): List<SideDish> = listOf(
    SideDish(
      "Summer Salad",
      "Heirloom tomatoes, butter lettuce, peaches, avocado, balsamic dressing",
      2.5
    ),
    SideDish(
      "Butternut",
      "Roasted butternut squash, roasted peppers, chili oil",
      3.0
    ),
    SideDish(
      "Spicy Potatoes",
      "Marble potatoes, roasted, and fried in house spice blend",
      2.0
    ),
    SideDish(
      "Coconut Rice",
      "Rice, coconut milk, lime, and sugar",
      1.5
    )
  )

  fun getAccompaniments(): List<Accompaniment> = listOf(
    Accompaniment(
      "Lunch Roll",
      "Fresh baked roll made in house",
      0.5
    ),
    Accompaniment(
      "Mixed Berries",
      "Strawberries, blueberries, raspberries, and huckleberries",
      1.0
    ),
    Accompaniment(
      "Pickled Veggies",
      "Pickled cucumbers and carrots, made in house",
      0.5
    )
  )
}