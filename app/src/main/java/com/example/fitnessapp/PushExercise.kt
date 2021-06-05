package com.example.fitnessapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_push_exercise.*
import kotlinx.android.synthetic.main.exercise_pop_up.*
import kotlinx.android.synthetic.main.exercise_pop_up.view.*
import kotlinx.android.synthetic.main.exercise_type.view.*
import kotlinx.android.synthetic.main.exercise_type.view.backButton
import android.content.ContentResolver

class PushExercise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push_exercise)

        flatdumbellpress.setOnClickListener {
            val flatdumbellpressDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val flatdumbellpressBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                    .setView(flatdumbellpressDialogView)
            val flatdumbellpressAlertDialog = flatdumbellpressBuilder.show()

            flatdumbellpressAlertDialog.exerciseName.setText(" ")
            //flatdumbellpressAlertDialog.image.setImageURI(Uri.parse("@drawable/neutral_press"))

            val resourceId = R.drawable.flat_dumbbell
            val urineutralpress = Uri.Builder()
                    .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                    .authority(resources.getResourcePackageName(resourceId))
                    .appendPath(resources.getResourceTypeName(resourceId))
                    .appendPath(resources.getResourceEntryName(resourceId))
                    .build()

            flatdumbellpressAlertDialog.image.setImageURI(urineutralpress)
            flatdumbellpressAlertDialog.reps.setText("REPS 15 | SET 3 | REST 30 s")

            flatdumbellpressDialogView.backButton.setOnClickListener {
                flatdumbellpressAlertDialog.dismiss()
            }
        }

        dumbbellFlyes.setOnClickListener {
            val dumbbellFlyesDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val dumbbellFlyesBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                    .setView(dumbbellFlyesDialogView)
            val dumbbellFlyesAlertDialog = dumbbellFlyesBuilder.show()

            dumbbellFlyesAlertDialog.exerciseName.setText("")
            //flatdumbellpressAlertDialog.image.setImageURI(Uri.parse("@drawable/neutral_press"))

            val resourceId = R.drawable.flysandnp
            val uridumbbellFlyes = Uri.Builder()
                    .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                    .authority(resources.getResourcePackageName(resourceId))
                    .appendPath(resources.getResourceTypeName(resourceId))
                    .appendPath(resources.getResourceEntryName(resourceId))
                    .build()

            dumbbellFlyesAlertDialog.image.setImageURI(uridumbbellFlyes)
            dumbbellFlyesAlertDialog.reps.setText("REPS 12 | SET 3 | REST 50 s")

            dumbbellFlyesDialogView.backButton.setOnClickListener {
                dumbbellFlyesAlertDialog.dismiss()
            }
        }

        arnoldpress.setOnClickListener {
            val arnoldpressDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val arnoldpressBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                    .setView(arnoldpressDialogView)
            val arnoldpressAlertDialog = arnoldpressBuilder.show()

            arnoldpressAlertDialog.exerciseName.setText(" ")
            //flatdumbellpressAlertDialog.image.setImageURI(Uri.parse("@drawable/neutral_press"))

            val resourceId = R.drawable.arnoldpress
            val uriarnoldpress = Uri.Builder()
                    .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                    .authority(resources.getResourcePackageName(resourceId))
                    .appendPath(resources.getResourceTypeName(resourceId))
                    .appendPath(resources.getResourceEntryName(resourceId))
                    .build()

            arnoldpressAlertDialog.image.setImageURI(uriarnoldpress)
            arnoldpressAlertDialog.reps.setText("REPS 12 | SET 3 | REST 50 s")

            arnoldpressDialogView.backButton.setOnClickListener {
                arnoldpressAlertDialog.dismiss()
            }
        }


        lateralandfront.setOnClickListener {
            val lateralandfrontDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val lateralandfrontBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                    .setView(lateralandfrontDialogView)
            val lateralandfrontAlertDialog = lateralandfrontBuilder.show()

            lateralandfrontAlertDialog.exerciseName.setText("")
            //flatdumbellpressAlertDialog.image.setImageURI(Uri.parse("@drawable/neutral_press"))

            val resourceId = R.drawable.lrandfr
            val uridumbbellFlyes = Uri.Builder()
                    .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                    .authority(resources.getResourcePackageName(resourceId))
                    .appendPath(resources.getResourceTypeName(resourceId))
                    .appendPath(resources.getResourceEntryName(resourceId))
                    .build()

            lateralandfrontAlertDialog.image.setImageURI(uridumbbellFlyes)
            lateralandfrontAlertDialog.reps.setText("REPS 12 | SET 3 | REST 50 s")

            lateralandfrontDialogView.backButton.setOnClickListener {
                lateralandfrontAlertDialog.dismiss()
            }
        }

        tatepress.setOnClickListener {
            val tatepressDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val tatepressBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                    .setView(tatepressDialogView)
            val tatepressAlertDialog = tatepressBuilder.show()

            tatepressAlertDialog.exerciseName.setText("")
            //flatdumbellpressAlertDialog.image.setImageURI(Uri.parse("@drawable/neutral_press"))

            val resourceId = R.drawable.tatepress
            val uritatepress = Uri.Builder()
                    .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                    .authority(resources.getResourcePackageName(resourceId))
                    .appendPath(resources.getResourceTypeName(resourceId))
                    .appendPath(resources.getResourceEntryName(resourceId))
                    .build()

            tatepressAlertDialog.image.setImageURI(uritatepress)
            tatepressAlertDialog.reps.setText("REPS 15 | SET 3 | REST 50 s")

            tatepressDialogView.backButton.setOnClickListener {
                tatepressAlertDialog.dismiss()
            }
        }

        tricepextandkick.setOnClickListener {
            val tricepextandkickDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val tricepextandkickBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                    .setView(tricepextandkickDialogView)
            val tricepextandkickAlertDialog = tricepextandkickBuilder.show()

            tricepextandkickAlertDialog.exerciseName.setText("")
            //flatdumbellpressAlertDialog.image.setImageURI(Uri.parse("@drawable/neutral_press"))

            val resourceId = R.drawable.teandtk
            val uritricepextandkick = Uri.Builder()
                    .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                    .authority(resources.getResourcePackageName(resourceId))
                    .appendPath(resources.getResourceTypeName(resourceId))
                    .appendPath(resources.getResourceEntryName(resourceId))
                    .build()

            tricepextandkickAlertDialog.image.setImageURI(uritricepextandkick)
            tricepextandkickAlertDialog.reps.setText("REPS 12 | SET 3 | REST 50 s")

            tricepextandkickDialogView.backButton.setOnClickListener {
                tricepextandkickAlertDialog.dismiss()
            }
        }
    }
}