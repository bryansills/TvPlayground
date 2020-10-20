package ninja.bryansills.tvplayground

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _cats = MutableLiveData(listOf(
        Cat("Good kitty", 13, true, "Tabby")
    ))
    val cats: LiveData<List<Cat>>
        get() = _cats

    private val _hats = MutableLiveData<List<Hat>>()
    val hats: LiveData<List<Hat>>
        get() = _hats

    fun addCat(cat: Cat) {
        val currentCats = _cats.value ?: listOf()
        _cats.postValue(currentCats + cat)
    }

    fun addHat(hat: Hat) {
        val currentHats = _hats.value ?: listOf()
        _hats.postValue(currentHats + hat)
    }
}
