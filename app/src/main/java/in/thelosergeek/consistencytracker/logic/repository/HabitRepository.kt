package `in`.thelosergeek.consistencytracker.logic.repository

import `in`.thelosergeek.consistencytracker.data.models.Habit
import `in`.thelosergeek.consistencytracker.logic.dao.HabitDao
import androidx.lifecycle.LiveData

class HabitRepository (private val habitDao: HabitDao){
    val getAllHabits: LiveData<List<Habit>> = habitDao.getAllHabits()

    suspend fun addHabit(habit: Habit){
        habitDao.addHabit(habit)
    }
    suspend fun updateHabit(habit: Habit){
        habitDao.updateHabit(habit)
    }
    suspend fun DeleteHabit(habit: Habit){
        habitDao.deleteHabit(habit)
    }
    suspend fun DeleteAllHabit(){
        habitDao.deleteAll()
    }
}