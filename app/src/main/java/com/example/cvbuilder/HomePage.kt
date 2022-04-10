package com.example.cvbuilder

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cvbuilder.adaptor.FragmentAdaptor
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val fragmentAdaptor = FragmentAdaptor(supportFragmentManager, lifecycle)
        viewPager.adapter = fragmentAdaptor

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            when(position){
                0 -> {
                    tab.text = "Home"
                    tab.setIcon(R.drawable.ic_baseline_home)
                }
                1-> {
                    tab.text = "About"
                    tab.setIcon(R.drawable.ic_baseline_about_me)
                }

                2-> {
                    tab.text = "Experience"
                    tab.setIcon(R.drawable.ic_baseline_experiance)
                }

                3-> {
                    tab.text = "Contact Info"
                    tab.setIcon(R.drawable.ic_baseline_contact)
                }
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.linkedIn -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(getString(R.string.linkedin_id))
                try {
                    startActivity(intent)
                }
                catch (e: Exception){
                    Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
                }
                return true;
            }
            R.id.userProfile -> {
                val intent = Intent(this, HomePage::class.java)
                try{
                    startActivity(intent)
                }
                catch (e: Exception){
                Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
                }
                return true
            }
            R.id.userNetwork -> {
                Toast.makeText(this,"currentUser network  page will be displayed", Toast.LENGTH_LONG).show()
                return true;
            }
            R.id.logOut -> { val intent = Intent(this, MainActivity::class.java)
                try{
                    startActivity(intent)
                }
                catch (e: Exception){
                    Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
                }
                return true;
            }

        }
        return super.onOptionsItemSelected(item)
    }

    fun testMethod(view: View){
        println("test")
        Toast.makeText(this, "TEST_homePage context",Toast.LENGTH_LONG).show()
    }
}