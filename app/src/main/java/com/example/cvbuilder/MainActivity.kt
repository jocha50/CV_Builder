package com.example.cvbuilder

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.cvbuilder.model.User
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var users: ArrayList<User> = ArrayList(
        Arrays.asList(
            User("John", "Smith", "sjohn@mail.com", "1234"),
            User("Jack", "Mathew", "mjack@mail.com", "1234"),
            User("Amanda", "Michelson", "mamanda@mail.com", "1234"),
            User("Kate", "Williams", "wkate@mail.com", "1234"),
            User("Maria", "Rodriguez", "rmaria@mail.com", "1234"),

            )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storedSharedPreferences = getSharedPreferences("login_credentials", Context.MODE_PRIVATE)
        val storedUserName = storedSharedPreferences.getString("username","")
        val storedPassword = storedSharedPreferences.getString("password","")

        userNameId.setText(storedUserName)
        password.setText(storedPassword)

        var resultContracts =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                if (result.resultCode == Activity.RESULT_OK) {
                    users.add(result.data?.getSerializableExtra("newAccount") as User)
                    Toast.makeText(this, "Account Created!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Sorry Can't create Account!", Toast.LENGTH_LONG).show()

                }

            }

    }

    fun signInHandler(view: View) {
        var userName = userNameId?.text.toString();
        var password = password?.text.toString();
        var memberToSignIn = User(null, null, userName, password);
        var valid: Boolean = false;
        for (user in users) {
            if (user.userName.equals(userName) && user.password.equals(password)) {
                valid = true;
                println("valid true")
                break
            }
        }

        if (valid) {
            val sharedPreferences = getSharedPreferences("login_credentials", Context.MODE_PRIVATE)

            val sharedPreferencesEdit = sharedPreferences.edit()
            sharedPreferencesEdit.putString("username", memberToSignIn?.userName)
            sharedPreferencesEdit.putString("password", memberToSignIn?.password)
            sharedPreferencesEdit.apply()

            val intent = Intent(this, HomePage::class.java)
            intent.putExtra("user", memberToSignIn?.userName)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Invalid user please try again.", Toast.LENGTH_LONG).show()
        }
    }

    fun forgotPasswordHandler(view: View) {
        var userName = userNameId.text?.toString()
        var password: String = ""
        for (user in users) {
            if (user.userName.equals(userName)) {
                password = "Your password is ${user?.password.toString()}"
                break
            }
        }
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, password)
        startActivity(intent)
    }

}