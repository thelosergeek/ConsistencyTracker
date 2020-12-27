# Consistency Tracker

The app keeps tracks of your habits. Users can create, delete or Update habits accoirding to their choice. The app uses MVVM architecture and package structure is shown below. 
   As a part of MVVM architecture, the app uses Navigation Components, Lifecycle components, Room components.

 Package Name:
   - Data
     - Database :  Habit Database.kt
     - Model : Habit.kt
   - Logic
     - Dao : HabitDao.kt
     - Repository : Habit repository.kt
   - UI
     - Fragments 
       - Consistent Fragment.kt
       - CreateHabit.kt
       - Habit List Adapter.kt
       - UpdateHabit.kt
     - ViewModels : Habit View Model.kt
   - Utils : Date Calculation.kt
   - MainActivity.kt

