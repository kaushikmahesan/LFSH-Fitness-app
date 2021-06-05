package com.example.fitnessapp


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bmi.view.*
import kotlinx.android.synthetic.main.activity_change_height.*
import kotlinx.android.synthetic.main.activity_change_height.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_trackcalorie.*
import kotlinx.android.synthetic.main.exercise_type.view.*
import kotlinx.android.synthetic.main.exercise_type.view.backButton
import kotlinx.android.synthetic.main.musclegain_exercise.view.*
import java.lang.Double
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private val sharedPrefFile = "kotlinsharedpreference"
    var caltoview = 0
    var prottoview = 0
    var fatstoview = 0
    var carbstoview = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


/*
        //to create a file for the first time
        val fileName = "name.txt"
        var file = File(fileName)
        file.createNewFile()



        //read in the name and image from file
        val filename = "name.txt"
        if(filename.toString().trim()!="") {
            var fileInputStream: FileInputStream? = null
            fileInputStream = openFileInput(filename)
            val inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
            }
            textName.setText(stringBuilder.toString()).toString()
        }

        */

        //for the time of day
        val calander = Calendar.getInstance()
        val now = calander.timeInMillis%86400000 + 19800000

        //goodmorning.setText(now.toString())

        if(now < 32400000 && now> 18000000){
            goodmorning.setText("Good Morning")
        }
        else if(now < 50400000){
            goodmorning.setText("Good Afternoon")
        }
        else if(now < 68400000){
            goodmorning.setText("Good Evening")
        }
        else{
            goodmorning.setText("Good Night")
        }


        //to change the inspirational message
        val inspiration = arrayOf<String>("The last three or four reps is what makes the muscle grow. This area of pain divides a champion from someone who is not a champion.", "Success usually comes to those who are too busy to be looking for it.", "All progress takes place outside the comfort zone.", "If you think lifting is dangerous, try being weak. Being weak is dangerous.", "The only place where success comes before work is in the dictionary.")
        val randomNumber: Int
        randomNumber = Random(now).nextInt(inspiration.size)
        TextInspiration.setText(inspiration[randomNumber])


        //set the info from the profile page using intent
        //must change to file reading later

        //button click to show the exercise_type
        cardExerciseList.setOnClickListener {

            val mDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_type, null);
            val mBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)
                .setView(mDialogView)
            val mAlertDialog = mBuilder.show()
            mDialogView.backButton.setOnClickListener {
                mAlertDialog.dismiss()
            }

            mDialogView.musclegainbutton.setOnClickListener {
                val mgDialogView = LayoutInflater.from(this).inflate(R.layout.musclegain_exercise, null);
                val mgBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)
                    .setView(mgDialogView)
                val mgAlertDialog = mgBuilder.show()
                mgDialogView.backButton.setOnClickListener {
                    mgAlertDialog.dismiss()
                }
                mgDialogView.pushbutton.setOnClickListener {
                    val intent = Intent(this, PushExercise::class.java)
                    startActivity(intent);
                }
                mgDialogView.pullbutton.setOnClickListener {
                    val intent = Intent(this, PullExercise::class.java)
                    startActivity(intent);
                }
                mgDialogView.legsandcorebutton.setOnClickListener {
                    val intent = Intent(this, Legsandcore::class.java)
                    startActivity(intent);
                }
            }

            mDialogView.warmupbutton.setOnClickListener {
                val intent = Intent(this, warmup::class.java)
                startActivity(intent);
            }

        }

        ///button click to show the height and weight page
        cardHnW.setOnClickListener {
            val hnwDialogView = LayoutInflater.from(this).inflate(R.layout.activity_change_height, null);
            val hnwBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)
                    .setView(hnwDialogView)
            val hnwAlertDialog = hnwBuilder.show()

            hnwAlertDialog.height.setText("Height : " + changableHeight.text.toString() + " cm")
            hnwAlertDialog.weight.setText("Weight : " + changableWeight.text.toString() + " Kg")

            hnwDialogView.backButton.setOnClickListener {
                hnwAlertDialog.dismiss()
            }
            hnwDialogView.enterheightbutton.setOnClickListener {
                    val newHeight = hnwDialogView.enterheight.text.toString()
                    val newWeight = changableWeight.text.toString()

                    var numeric = true
                    try {
                        val num = Double.parseDouble(newHeight)
                    } catch (e: NumberFormatException) {
                        numeric = false
                    }

                    if(numeric){
                        hnwAlertDialog.height.setText("Height : " + newHeight + " cm")
                        changableHeight.setText(newHeight)
                        val inth = newHeight.toFloat() / 100
                        val intw = newWeight.toFloat()
                        val bmicalc = (intw / (inth * inth)).toFloat()
                        val bmicalcnew = String.format("%.1f", bmicalc).toFloat()
                        changableBMI.setText(bmicalcnew.toString())
                    }
                    else
                        Toast.makeText(applicationContext, "Not a number", Toast.LENGTH_SHORT).show()

            }

            hnwDialogView.enterweightbutton.setOnClickListener {
                    val newHeight = changableHeight.text.toString()
                    val newWeight = hnwDialogView.enterweight.text.toString()

                    var numeric = true
                    try {
                        val num = Double.parseDouble(newWeight)
                    } catch (e: NumberFormatException) {
                        numeric = false
                    }

                    if(numeric) {
                        hnwAlertDialog.weight.setText("Weight : " + newWeight + " Kg")
                        changableWeight.setText(newWeight)
                        val inth = newHeight.toFloat() / 100
                        val intw = newWeight.toFloat()
                        val bmicalc = (intw / (inth * inth)).toFloat()
                        val bmicalcnew = String.format("%.1f", bmicalc).toFloat()
                        changableBMI.setText(bmicalcnew.toString())
                    }
                    else
                        Toast.makeText(applicationContext, "Not a number", Toast.LENGTH_SHORT).show()
            }
        }

        //button click to show the bmi page
        cardBMI.setOnClickListener {
            val bmiDialogView = LayoutInflater.from(this).inflate(R.layout.activity_bmi, null);
            val bmiBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)
                    .setView(bmiDialogView)
            val bmiAlertDialog = bmiBuilder.show()

            //to change the values of the bmi and the text
            bmiDialogView.BMIvalue.setText(changableBMI.text.toString())
            val bmirange = bmiDialogView.BMIvalue.text.toString().toFloat()
            if (bmirange < 18.5 )
                bmiDialogView.yourBMIintext.setText("You're underweight")
            else if (bmirange < 25 )
                bmiDialogView.yourBMIintext.setText("You're perfect weight")
            else if (bmirange < 30 )
                bmiDialogView.yourBMIintext.setText("You're overweight")
            else
                bmiDialogView.yourBMIintext.setText("You're obese")

            bmiDialogView.backButton.setOnClickListener {
                bmiAlertDialog.dismiss()
            }
        }

        buttonPP.setOnClickListener {
            val intent = Intent(this, profile_page::class.java)
            startActivity(intent);
        }

        cardCalorie.setOnClickListener {
            val calDialogView = LayoutInflater.from(this).inflate(R.layout.activity_trackcalorie, null);
            val calBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)
                .setView(calDialogView)
            val calAlertDialog = calBuilder.show()

            //get the save data over here
            calAlertDialog.changeablecalorieintake.setText(caltoview.toString())
            calAlertDialog.changeableproteinintake.setText(prottoview.toString())
            calAlertDialog.changeablefatintake.setText(fatstoview.toString())
            calAlertDialog.changeablecarbintake.setText(carbstoview.toString())

            calDialogView.backButton.setOnClickListener {
                calAlertDialog.dismiss()
            }
        }

        secretreset.setOnClickListener {
            val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
            val editor:SharedPreferences.Editor =  sharedPreferences.edit()

            editor.putInt("AddCal", 0)
            editor.putInt("AddProt", 0)
            editor.putInt("AddCarbs", 0)
            editor.putInt("AddFats", 0)

            editor.apply()
            editor.commit()


        }

        addCalorie.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent);
        }
    }
    override fun onPause() {
        super.onPause()
        val heights = findViewById<TextView>(R.id.changableHeight)
        val weights = findViewById<TextView>(R.id.changableWeight)
        val names = findViewById<TextView>(R.id.textName)
        val bmi = findViewById<TextView>(R.id.changableBMI)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

        val h:String = heights.text.toString()
        val w:String =  weights.text.toString()
        val name:String = names.text.toString()
        val b: String = bmi.text.toString()
        val p: String = "gi"
        val editor:SharedPreferences.Editor =  sharedPreferences.edit()


        editor.putString("height_key", h)
        editor.putString("weight_key", w)
        editor.putString("name_key", name)
        editor.putString("bmi_key", b)
        editor.putString("pp_key", p)

        editor.apply()
        editor.commit()
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor =  sharedPreferences.edit()
        val sharedHeightValue = sharedPreferences.getString("height_key", "180")
        val sharedWeightValue = sharedPreferences.getString("weight_key", "60")
        val sharedNameValue = sharedPreferences.getString("name_key", "User")
        val sharedBMIValue = sharedPreferences.getString("bmi_key", "24")
        val sharedCalMaxValue = sharedPreferences.getString("CalorieMax_key", "2000")


        val defuri = "android.resource://com.example.fitnessapp/" + R.drawable.pp
        val sharedppValue = sharedPreferences.getString("pp_key", defuri)

        changableHeight.setText(sharedHeightValue)
        changableWeight.setText(sharedWeightValue)
        changableBMI.setText(sharedBMIValue)

        val sharedCalValue = sharedPreferences.getInt("AddCal", 0)
        val sharedProtValue = sharedPreferences.getInt("AddProt", 0)
        val sharedFatValue = sharedPreferences.getInt("AddFats", 0)
        val sharedCarbValue = sharedPreferences.getInt("AddCarbs", 0)
        caltoview = sharedCalValue
        prottoview = sharedProtValue
        carbstoview = sharedCarbValue
        fatstoview = sharedFatValue

        currCal.setText(sharedCalValue.toString())

        val _img: Uri = Uri.parse(defuri)
        buttonPP.setImageURI(_img)

        textName.setText(sharedNameValue)
        maxCal.setText(sharedCalMaxValue)

        val calpercent = currCal.text.toString().toFloat() / maxCal.text.toString().toFloat() * 100

        if(calpercent.toInt() >=25)
            caloriePercentageText.setText("You are a quarter way there!")
        if (calpercent.toInt() >= 50)
            caloriePercentageText.setText("You are half way there!")
        if (calpercent.toInt() >= 75)
            caloriePercentageText.setText("You are almost there!")
        if (calpercent.toInt()>=100)
            caloriePercentageText.setText("You are done for the day!")

        if(calpercent.toInt() <= 100) {
            prog.setProgress(calpercent.toInt())
        }
        else
            prog.setProgress(100)


    /*
        val oldTime = sharedPreferences.getString("time", "0")
        val c = Calendar.getInstance().time.toString()
        val df = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
        val formattedDate: String = df.format(c)

        if(oldTime == formattedDate){
            editor.putString("time",formattedDate)
            editor.putInt("AddCal", 0)
            editor.putInt("AddProt", 0)
            editor.putInt("AddCarbs", 0)
            editor.putInt("AddFats", 0)

            editor.apply()
            editor.commit()
        }
 */


        //check if the day has changed
    }
}

