package com.example.fitnessapp

import android.content.ContentResolver
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_pull_exercise.*
import kotlinx.android.synthetic.main.activity_push_exercise.*
import kotlinx.android.synthetic.main.exercise_pop_up.*
import kotlinx.android.synthetic.main.exercise_type.view.*

class PullExercise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_exercise)

        dumbbellrows.setOnClickListener {
            val dumbbellrowsDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val dumbbellrowsBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                .setView(dumbbellrowsDialogView)
            val dumbbellrowsAlertDialog = dumbbellrowsBuilder.show()

            dumbbellrowsAlertDialog.exerciseName.setText(" ")
            //dumbbellrowsAlertDialog.image.setImageURI(Uri.parse("@drawable/dumbbell_rows"))

            val resourceId = R.drawable.dumbbellrows
            val uridumbbellrows = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resourceId))
                .appendPath(resources.getResourceTypeName(resourceId))
                .appendPath(resources.getResourceEntryName(resourceId))
                .build()

            dumbbellrowsAlertDialog.image.setImageURI(uridumbbellrows)
            dumbbellrowsAlertDialog.reps.setText("REPS 15 | SET 3 | REST 40 s")

            dumbbellrowsDialogView.backButton.setOnClickListener {
                dumbbellrowsAlertDialog.dismiss()
            }
        }

        shrugs.setOnClickListener {
            val shrugsDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val shrugsBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                .setView(shrugsDialogView)
            val shrugsAlertDialog = shrugsBuilder.show()

            shrugsAlertDialog.exerciseName.setText(" ")
            //dumbbellrowsAlertDialog.image.setImageURI(Uri.parse("@drawable/dumbbell_rows"))

            val resourceId = R.drawable.shrugs
            val urishrugs = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resourceId))
                .appendPath(resources.getResourceTypeName(resourceId))
                .appendPath(resources.getResourceEntryName(resourceId))
                .build()

            shrugsAlertDialog.image.setImageURI(urishrugs)
            shrugsAlertDialog.reps.setText("REPS 12 | SET 3 | REST 40 s")

            shrugsDialogView.backButton.setOnClickListener {
                shrugsAlertDialog.dismiss()
            }
        }

        curls.setOnClickListener {
            val curlsDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val curlsBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                .setView(curlsDialogView)
            val curlsAlertDialog = curlsBuilder.show()

            curlsAlertDialog.exerciseName.setText(" ")
            //dumbbellrowsAlertDialog.image.setImageURI(Uri.parse("@drawable/dumbbell_rows"))

            val resourceId = R.drawable.curls
            val uricurls = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resourceId))
                .appendPath(resources.getResourceTypeName(resourceId))
                .appendPath(resources.getResourceEntryName(resourceId))
                .build()

            curlsAlertDialog.image.setImageURI(uricurls)
            curlsAlertDialog.reps.setText("REPS 15 | SET 3 | REST 40 s")

            curlsDialogView.backButton.setOnClickListener {
                curlsAlertDialog.dismiss()
            }
        }

        hammer.setOnClickListener {
            val hammerDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val hammerBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                .setView(hammerDialogView)
            val hammerAlertDialog = hammerBuilder.show()

            hammerAlertDialog.exerciseName.setText(" ")
            //dumbbellrowsAlertDialog.image.setImageURI(Uri.parse("@drawable/dumbbell_rows"))

            val resourceId = R.drawable.hammer
            val urihammer = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resourceId))
                .appendPath(resources.getResourceTypeName(resourceId))
                .appendPath(resources.getResourceEntryName(resourceId))
                .build()

            hammerAlertDialog.image.setImageURI(urihammer)
            hammerAlertDialog.reps.setText("REPS 12 | SET 3 | REST 40 s")

            hammerDialogView.backButton.setOnClickListener {
                hammerAlertDialog.dismiss()
            }
        }

        wristcurl.setOnClickListener {
            val wristcurlDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val wristcurlBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                .setView(wristcurlDialogView)
            val wristcurlAlertDialog = wristcurlBuilder.show()

            wristcurlAlertDialog.exerciseName.setText(" ")
            //dumbbellrowsAlertDialog.image.setImageURI(Uri.parse("@drawable/dumbbell_rows"))

            val resourceId = R.drawable.wrist
            val uriwristcurl = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resourceId))
                .appendPath(resources.getResourceTypeName(resourceId))
                .appendPath(resources.getResourceEntryName(resourceId))
                .build()

            wristcurlAlertDialog.image.setImageURI(uriwristcurl)
            wristcurlAlertDialog.reps.setText("REPS 12 | SET 3 | REST 40 s")

            wristcurlDialogView.backButton.setOnClickListener {
                wristcurlAlertDialog.dismiss()
            }
        }
    }
}