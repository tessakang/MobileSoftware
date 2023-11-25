package com.example.lab03

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lab03.databinding.ActivityMainBinding
import com.example.lab03.databinding.FragmentOneBinding
import com.example.lab03.databinding.FragmentThreeBinding
import com.example.lab03.databinding.FragmentTwoBinding
import com.example.lab03.databinding.ItemMainBinding
import com.example.lab03.databinding.ItemRecyclerviewBinding


lateinit var toggle: ActionBarDrawerToggle

class MyFragmentPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    val fragments : List<Fragment>
    init {
        fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
    }
    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}

class OneFragment : Fragment() {
    lateinit var binding: FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }
}

class TwoFragment : Fragment() {
    lateinit var binding: FragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }
}

class ThreeFragment : Fragment() {
    lateinit var binding: FragmentThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }
}

class MyViewHolder(val binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root)

class MyAdapter (val datas: MutableList<String>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int = datas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder =
        MyViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("blue", "onBindViewHolder:$position")
        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = datas[position]
        binding.itemMain.setOnClickListener {
        Log.d("blue", "item root click: $position")
        }
    }
    }

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val datas = mutableListOf<String>()
        for(i in 1..10) {
            datas.add("Item $i")
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(datas)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        toggle = ActionBarDrawerToggle(this, binding.drawer,R.string.drawer_opend, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        val adapter = MyFragmentPagerAdapter(this)
        binding.viewpager.adapter = adapter

        setSupportActionBar(binding.toolBar)

        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        val fragment = OneFragment()
        transaction.add(R.id.fragment_content, fragment)
        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu?.findItem(R.id.menu_search)
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        Log.d("kkang", "onSupportNavigateUp")
        return super.onSupportNavigateUp()
    }

}





