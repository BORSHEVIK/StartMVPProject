package com.example.aliaksandrmirashnichenka.myconductormvp.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Navigator
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.setProperty

class MainActivity : AppCompatActivity(), Abs {

    private lateinit var router: Router;
    private lateinit var navigator: Navigator;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById(R.id.container) as ViewGroup

        router = Conductor.attachRouter(this, container, savedInstanceState)
        setProperty(Navigator.PROPERTY_ROUTER, router);
        navigator = get();
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }

    override fun getNavigator(): Navigator {
        return navigator; //To change body of created functions use File | Settings | File Templates.
    }

}
