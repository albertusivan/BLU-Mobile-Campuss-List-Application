package com.example.myrecview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUniv: RecyclerView
    private val list = ArrayList<Univ>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUniv = findViewById(R.id.rv_univ)
        rvUniv.setHasFixedSize(true)

        list.addAll(GetListUniv())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this@MainActivity,about_page::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun GetListUniv(): ArrayList<Univ> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataukt = resources.getStringArray(R.array.data_ukt)
        val dataalamat = resources.getStringArray(R.array.data_alamat)
        val listUnivs = ArrayList<Univ>()
        for (i in dataName.indices) {
            val univ = Univ(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1),dataukt[i], dataalamat[i])
            listUnivs.add(univ)
        }
        return listUnivs
    }

    private fun showRecyclerList() {
        rvUniv.layoutManager = LinearLayoutManager(this)
        val listUnivAdapter = ListUnivAdapter(list)
        rvUniv.adapter = listUnivAdapter

        listUnivAdapter.setOnItemClickCallback(object : ListUnivAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Univ) {
                showSelectedUniv(data)
            }
        })
    }

    private fun showSelectedUniv(univ: Univ) {
        Toast.makeText(this, "Kamu memilih " + univ.name, Toast.LENGTH_SHORT).show()
    }
}