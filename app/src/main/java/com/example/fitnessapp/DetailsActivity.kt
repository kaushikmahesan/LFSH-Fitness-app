package com.example.fitnessapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_details.*
import org.w3c.dom.Text
import java.lang.Double

class DetailsActivity : AppCompatActivity() {
    private val sharedPrefFile = "kotlinsharedpreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent = intent

        val title = findViewById<TextView>(R.id.foodname)
        val calamount = findViewById<TextView>(R.id.TextCalorie)
        val protamount = findViewById<TextView>(R.id.TextProt)
        val carbamount = findViewById<TextView>(R.id.TextCarb)
        val fatamount = findViewById<TextView>(R.id.TextFat)

        val amount = findViewById<EditText>(R.id.enteramount)

        val protein = intent.getIntExtra("protein",0)
        val calorie = intent.getIntExtra("calorie",0)
        val carbs = intent.getIntExtra("carbs",0)
        val fats = intent.getIntExtra("fats",0)

        title.setText(intent.getStringExtra("foodname"))
        calamount.setText("Calories : "+calorie.toString())
        protamount.setText("Protein : "+protein.toString())
        carbamount.setText("Carbs : "+carbs.toString())
        fatamount.setText("Fats : "+fats.toString())







        buttonApplyFood.setOnClickListener {
            //calculate the total and save it
            var numeric = true
            try {
                val num = Double.parseDouble(amount.text.toString())
            } catch (e: NumberFormatException) {
                numeric = false
            }
            if(numeric) {
                var addcal = calorie * amount.text.toString().toInt() / 100
                var addprot = protein * amount.text.toString().toInt() / 100
                var addcarbs = carbs * amount.text.toString().toInt() / 100
                var addfats = fats * amount.text.toString().toInt() / 100

                val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,
                    Context.MODE_PRIVATE)
                val editor:SharedPreferences.Editor =  sharedPreferences.edit()


                val sharedCal = sharedPreferences.getInt("AddCal",0)
                addcal += sharedCal
                val sharedProt = sharedPreferences.getInt("AddProt",0)
                addprot += sharedProt
                val sharedCarbs = sharedPreferences.getInt("AddCarbs",0)
                addcarbs += sharedCarbs
                val sharedFats = sharedPreferences.getInt("AddFats",0)
                addfats += sharedFats

                editor.putInt("AddCal",addcal)
                editor.putInt("AddProt",addprot)
                editor.putInt("AddCarbs",addcarbs)
                editor.putInt("AddFats",addfats)

                editor.apply()
                editor.commit()

                val intent2 = Intent(this, MainActivity::class.java)
                startActivity(intent2);
            }
            else{
                Toast.makeText(applicationContext,"Not a number", Toast.LENGTH_SHORT).show()
            }
        }
        


    }
}