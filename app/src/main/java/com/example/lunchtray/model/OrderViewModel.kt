package com.example.lunchtray.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.lunchtray.data.Datasource
import java.text.NumberFormat

class OrderViewModel : ViewModel() {
  val data = Datasource()
  val entrees = data.getEntrees()
  val sideDishes = data.getSideDishes()
  val accompaniments = data.getAccompaniments()

  private val _entree = MutableLiveData<Entree>()
  val entree: LiveData<Entree> = _entree

  private val _sideDish = MutableLiveData<SideDish>()
  val sideDish: LiveData<SideDish> = _sideDish

  private val _accompaniment = MutableLiveData<Accompaniment>()
  val accompaniment: LiveData<Accompaniment> = _accompaniment

  private val _price = MutableLiveData<Double>()
  val price: LiveData<String> = Transformations.map(_price) {
    NumberFormat.getCurrencyInstance().format(it)
  }

  init {
    resetOrder()
  }

  fun resetOrder() {
    _entree.value = entrees[0]
    _sideDish.value = sideDishes[0]
    _accompaniment.value = accompaniments[0]
//    _price.value = entrees[0].price
  }

  fun setEntree(entree: Entree) {
    _entree.value = entree
//    _price.value = entree.price
  }

  fun setSideDish(sideDish: SideDish) {
    _sideDish.value = sideDish
//    _price.value = _price.value?.plus(sideDish.price)
  }

  fun setAccompaniment(accompaniment: Accompaniment) {
    _accompaniment.value = accompaniment
  }
}