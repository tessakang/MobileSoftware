package com.example.lab03_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lab03_1.databinding.ActivityMainBinding
import com.example.lab03_1.databinding.ItemRecyclerviewBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        toggle= ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opend, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        val adapter = MyfragmentPagerAdapter(this)
        binding.viewpager.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu?.findItem(R.id.ic_menu_search)
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}




lateinit var toggle: ActionBarDrawerToggle
class MyfragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragments: List<Fragment>
    init {
        fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
    }

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}

class MyViewHolder(val binding: ItemRecyclerviewBinding):
    RecyclerView.ViewHolder(binding.root)


class MyAdapter(val datas: MutableList<String>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int = datas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder = MyViewHolder(
        ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = datas[position]
        binding.itemImage.setImageResource(android.R.drawable.star_on)
    }
}