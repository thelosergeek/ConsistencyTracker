package `in`.thelosergeek.consistencytracker.ui.fragments

import `in`.thelosergeek.consistencytracker.R
import `in`.thelosergeek.consistencytracker.data.models.Habit
import `in`.thelosergeek.consistencytracker.utils.DateCalculation
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_habit.view.*

class HabitListAdapter : RecyclerView.Adapter<HabitListAdapter.ViewHolder>(){

    var habitList = emptyList<Habit>()
    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        init {
            itemView.cv_cardView.setOnClickListener {
                val position = adapterPosition

                val action =  ConsistentFragmentDirections.actionConsistentFragmentToUpdateHbait(habitList[position])
                itemView.findNavController().navigate(action)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitListAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_habit, parent,false))
    }

    override fun onBindViewHolder(holder: HabitListAdapter.ViewHolder, position: Int) {

        val currentHabit = habitList[position]
        holder.itemView.iv_habit_icon.setImageResource(currentHabit.imageId)
        holder.itemView.tv_item_description.text = currentHabit.habit_description
        holder.itemView.tv_timeElapsed.text =
            DateCalculation.calculateTimeBetweenDates(currentHabit.habit_startTime)
        holder.itemView.tv_item_createdTimeStamp.text = "Since: ${currentHabit.habit_startTime}"
        holder.itemView.tv_item_title.text = "${currentHabit.habit_title}"
    }

    override fun getItemCount(): Int {
        return habitList.size
    }

    fun setData(habit: List<Habit>) {
        this.habitList = habit
        notifyDataSetChanged()
    }


}