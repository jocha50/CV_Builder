package com.example.cvbuilder

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment(R.layout.fragment_contact){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phone.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:"+getString(R.string.phone_number))
            startActivity(intent)

        }

        email.setOnClickListener{

            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("mailto:")
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.email_address)))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Job Position Open")

            try {
                startActivity(Intent.createChooser(intent,"Choose Email"))
            }
            catch (e: Exception){
                Toast.makeText(context?.applicationContext,e.message,Toast.LENGTH_LONG).show()
            }
        }
        linkedIn.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(getString(R.string.linkedin_id))
            try {
                startActivity(intent)
            }
            catch (e: Exception){
                Toast.makeText(context?.applicationContext,e.message,Toast.LENGTH_LONG).show()
            }
        }
        github.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(getString(R.string.github_id))
            try {
                startActivity(Intent.createChooser(intent,"Choose Email"))
            }
            catch (e: Exception){
                Toast.makeText(context?.applicationContext,e.message,Toast.LENGTH_LONG).show()
            }
        }
    }
}