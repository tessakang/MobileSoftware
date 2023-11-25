package com.example.lab11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lab11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    class MyFragmentPagerAdapter(activity: FragmentActivity):
        FragmentStateAdapter(activity) {
            val fragments: List<Fragment>
            init{
                fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
            }
        override fun createFragment(position: Int): Fragment = fragments[position]
        override fun getItemCount(): Int = fragments.size}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        // toggle 코드 작성
        toggle = ActionBarDrawerToggle(this, binding.drawer, binding.toolbar, R.string.d_open, R.string.d_close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        // viewpager2 코드 작성
        binding.viewpager.adapter = MyFragmentPagerAdapter(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)


        // searchview 입력된 검색어 처리
        val menuItem = menu?.findItem(R.id.menu_item_search)
        val searchView = menuItem?.actionView as SearchView


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // 검색어 입력 완료시 처리
                Log.d("sypark", "query: $query")
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }

        when(item.itemId) {
            R.id.menu_item_setting -> {
                Log.d("sypark", "setting")
            }
            R.id.menu_item_help -> {
                Log.d("sypark", "help")
            }
        }
        return super.onOptionsItemSelected(item)
    }


}