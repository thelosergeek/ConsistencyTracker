package `in`.thelosergeek.consistencytracker.ui.viewmodels

import `in`.thelosergeek.consistencytracker.data.database.HabitDatabase
import `in`.thelosergeek.consistencytracker.data.models.Habit
import `in`.thelosergeek.consistencytracker.logic.repository.HabitRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class HabitViewModel (application: Application): AndroidViewModel(application){
    private val repository: HabitRepository
    val getAllHabits: LiveData<List<Habit>>


    init {
        val habitDao = HabitDatabase.getDatabase(application).habitDao()
        repository = HabitRepository(habitDao)
        getAllHabits = repository.getAllHabits
    }
    fun addHabit(habit: Habit){
        viewModelScope.launch (Dispatchers.IO){
            repository.addHabit(habit)
        }
    }
    fun updateHabit(habit: Habit){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateHabit(habit)
        }
    }
    fun deleteHabit(habit: Habit){
        viewModelScope.launch (Dispatchers.IO){
            repository.DeleteHabit(habit)
        }
    }
    fun deleteAllHabits(){
        viewModelScope.launch (Dispatchers.IO){
            repository.DeleteAllHabit()
        }
    }

}