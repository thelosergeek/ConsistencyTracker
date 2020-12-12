package `in`.thelosergeek.consistencytracker.ui.fragments

import `in`.thelosergeek.consistencytracker.R
import `in`.thelosergeek.consistencytracker.data.models.Habit
import `in`.thelosergeek.consistencytracker.ui.viewmodels.HabitViewModel
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_consistent.*
import kotlinx.coroutines.InternalCoroutinesApi
import androidx.lifecycle.Observer

class ConsistentFragment : Fragment(R.layout.fragment_consistent,) {
    private lateinit var habitList: List<Habit>
    @InternalCoroutinesApi
    private lateinit var habitViewModel: HabitViewModel
    private lateinit var adapter: HabitListAdapter

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


            adapter = HabitListAdapter()
            rv_habits.adapter = adapter
            rv_habits.layoutManager = LinearLayoutManager(context)

            //Instantiate and create viewmodel observers
            viewModels()

            fab_add.setOnClickListener {
                findNavController().navigate(R.id.action_consistentFragment_to_createhabit)
            }

            //Show the options menu in this fragment
            setHasOptionsMenu(true)

            swipeToRefresh.setOnRefreshListener {
                adapter.setData(habitList)
                swipeToRefresh.isRefreshing = false
            }

    }

    @InternalCoroutinesApi
    private fun viewModels() {
        habitViewModel = ViewModelProvider(this).get(HabitViewModel::class.java)

        habitViewModel.getAllHabits.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
            habitList = it

            if (it.isEmpty()) {
                rv_habits.visibility = View.GONE
                tv_emptyView.visibility = View.VISIBLE
            } else {
                rv_habits.visibility = View.VISIBLE
                tv_emptyView.visibility = View.GONE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
    }

    @InternalCoroutinesApi
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete -> habitViewModel.deleteAllHabits()
        }
        return super.onOptionsItemSelected(item)
    }

}