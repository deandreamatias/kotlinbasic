package com.slashmobility.seleccion.matias.deandrea.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.slashmobility.seleccion.matias.deandrea.R


// MAIN ACTIVITY: Main activity of application
// load and config navigation
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host = NavHostFragment.create(R.navigation.nav_graph)
        supportFragmentManager.beginTransaction().replace(R.id.container, host).setPrimaryNavigationFragment(host).commit()
    }

    override fun onSupportNavigateUp(): Boolean = Navigation.findNavController(this,
        R.id.container
    ).navigateUp()
}
