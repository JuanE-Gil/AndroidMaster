package com.juanegil.androidmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.juanegil.androidmaster.firstapp.FirstAppActivity
import com.juanegil.androidmaster.imccalculator.ImcCalculatorActivity
import com.juanegil.androidmaster.settings.SettingsActivity
import com.juanegil.androidmaster.superheroapp.SuperHeroListActivity
import com.juanegil.androidmaster.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnWelcomeApp = findViewById<Button>(R.id.btnWelcomeApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        val btnSuperhero = findViewById<Button>(R.id.btnSuperhero)
        val btnSettings = findViewById<Button>(R.id.btnSettings)

        btnWelcomeApp.setOnClickListener { navigateToWelcomeApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnTODO.setOnClickListener { navigateToTodoApp() }
        btnSuperhero.setOnClickListener { navigateToSuperheroApp() }
        btnSettings.setOnClickListener { navigateToSettings() }
    }

    private fun navigateToWelcomeApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTodoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSuperheroApp() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

}
