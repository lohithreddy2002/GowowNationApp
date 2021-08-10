package com.example.wownation.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import com.example.wownation.R
import com.example.wownation.ViewFactory
import com.example.wownation.loginmanager
import com.example.wownation.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewmodel: viewModel
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        val repo = loginmanager(this)
        val factory = ViewFactory(repo)
        viewmodel = ViewModelProvider(this, factory).get(viewModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        toggle = ActionBarDrawerToggle(this,findViewById(R.id.drawer),
            R.string.open,
            R.string.close
        )
        findViewById<DrawerLayout>(R.id.drawer).addDrawerListener(toggle)
        toggle.syncState()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)

    }

}
