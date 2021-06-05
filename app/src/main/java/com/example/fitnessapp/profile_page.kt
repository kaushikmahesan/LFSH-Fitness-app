package com.example.fitnessapp

import android.content.Intent
import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_page.*
import java.io.*
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import java.lang.Double

class profile_page : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var button: Button
    private val pickImage = 100
    private var imageUri: Uri? = null
    lateinit var newName: String

    private val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        button_logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this@profile_page, LoginActivity::class.java))
            finish()
        }

        imageView = findViewById(R.id.ImageView)
        button = findViewById(R.id.buttonLoadPicture)
        button.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

        buttonApply.setOnClickListener {
            newName = enterName.text.toString()
            /*
            //store the name and picture into a file
            val fileOutputStream:FileOutputStream
            try {
                val fileOutputStream: FileOutputStream = openFileOutput("name.txt", Context.MODE_PRIVATE)
                val outputWriter = OutputStreamWriter(fileOutputStream)
                outputWriter.write(newName)
                outputWriter.close()
                Toast.makeText(baseContext, "File saved successfully!", Toast.LENGTH_SHORT).show()
            }catch (e: Exception){
                e.printStackTrace()
            }
            */
            val names = findViewById<EditText>(R.id.enterName)
            val cal = findViewById<EditText>(R.id.enterCalorie)
            val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)

            val n:String = names.text.toString()
            val c:String = cal.text.toString()
            val p:String = imageUri.toString()
            val editor:SharedPreferences.Editor =  sharedPreferences.edit()

            if(n!=""){
                editor.putString("name_key", n)
            }

            if(c!=""){
                var numeric = true
                try {
                    val num = Double.parseDouble(c)
                } catch (e: NumberFormatException) {
                    numeric = false
                }

                if (numeric)
                    editor.putString("CalorieMax_key",c)
                else
                    Toast.makeText(applicationContext,"Not a number",Toast.LENGTH_SHORT).show()
            }

            /*
            if(imageUri != null){
                editor.putString("pp_key",p)
            }

             */

            editor.apply()
            editor.commit()

            val intent = Intent(this, MainActivity::class.java)
            /*
            if (newName != ""){
                intent.putExtra("name",newName)
            */
            if(imageUri != null){
                intent.putExtra("uri",imageUri.toString())
            }




            startActivity(intent);
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            imageView.setImageURI(imageUri)
        }
    }
}