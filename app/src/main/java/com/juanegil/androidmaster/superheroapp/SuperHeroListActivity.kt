package com.juanegil.androidmaster.superheroapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.juanegil.androidmaster.databinding.ActivitySuperHeroListBinding
import com.juanegil.androidmaster.superheroapp.DetailSuperheroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var bindindg: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperheroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindindg = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(bindindg.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        bindindg.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })

        adapter = SuperheroAdapter { superheroId -> navigateToDetail(superheroId) }
        bindindg.rvSuperhero.setHasFixedSize(true)
        bindindg.rvSuperhero.layoutManager = LinearLayoutManager(this)
        bindindg.rvSuperhero.adapter = adapter
    }

    private fun searchByName(query: String) {
        bindindg.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperheroDataResponse> =
                retrofit.create(ApiService::class.java).getSuperheroes(query)
            if (myResponse.isSuccessful) {
                Log.i("test", "search success")
                val response: SuperheroDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("response", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.results)
                        bindindg.progressBar.isVisible = false
                    }
                }
            } else {
                Log.i("test", "search error")
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }

}