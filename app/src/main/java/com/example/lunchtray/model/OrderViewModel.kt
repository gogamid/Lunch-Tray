package com.example.lunchtray.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.lunchtray.data.Datasource
import java.text.NumberFormat

private const val TAX_RATE = 0.084

class OrderViewModel : ViewModel() {
  val data = Datasource()
  val entrees = data.getEntrees()
  val sideDishes = data.getSideDishes()
  val accompaniments = data.getAccompaniments()

  private val _entree = MutableLiveData<Entree?>()
  val entree: MutableLiveData<Entree?> = _entree

  private val _sideDish = MutableLiveData<SideDish?>()
  val sideDish: MutableLiveData<SideDish?> = _sideDish

  private val _accompaniment = MutableLiveData<Accompaniment?>()
  val accompaniment: MutableLiveData<Accompaniment?> = _accompaniment

  private val _price = MutableLiveData<Double>()
  val price: LiveData<String> = Transformations.map(_price) {
    NumberFormat.getCurrencyInstance().format(it)
  }

  private val _tax = MutableLiveData<Double>()
  val tax: LiveData<String> = Transformations.map(_tax) {
    NumberFormat.getCurrencyInstance().format(it)
  }

  private val _total = MutableLiveData<Double>()
  val total: LiveData<String> = Transformations.map(_total) {
    NumberFormat.getCurrencyInstance().format(it)
  }

  init {
    resetOrder()
  }

  fun resetOrder() {
    _entree.value = null
    _sideDish.value = null
    _accompaniment.value = null
    updatePrice()
  }

  fun setEntree(entree: Entree) {
    _entree.value = entree
    updatePrice()
  }

  private fun updatePrice() {
    val entreePrice: Double = _entree.value?.price ?: 0.0
    val sideDishPrice: Double = _sideDish.value?.price ?: 0.0
    val accompanimentPrice: Double = _accompaniment.value?.price ?: 0.0
    _price.value = entreePrice + sideDishPrice + accompanimentPrice
    _tax.value = if (_price.value == null) 0.0 else _price.value!! * TAX_RATE
    _total.value = if (_price.value == null) 0.0 else _price.value!! + _tax.value!!
  }

  fun setSideDish(sideDish: SideDish) {
    _sideDish.value = sideDish
    updatePrice()
  }

  fun setAccompaniment(accompaniment: Accompaniment) {
    _accompaniment.value = accompaniment
    updatePrice()
  }

  fun getPriceWithCurrency(value: Double) = NumberFormat.getCurrencyInstance().format(value)
}