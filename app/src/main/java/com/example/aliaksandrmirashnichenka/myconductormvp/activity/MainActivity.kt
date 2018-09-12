package com.example.aliaksandrmirashnichenka.myconductormvp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.Navigator
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.MyController

class MainActivity : AppCompatActivity() {

    private lateinit var router: Router;
    private lateinit var navigator: Navigator;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById(R.id.container) as ViewGroup

        router = Conductor.attachRouter(this, container, savedInstanceState)
        navigator = Navigator(router);
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }
}
