package com.example.fitnessapp

import android.content.ContentResolver
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_legsandcore.*
import kotlinx.android.synthetic.main.activity_pull_exercise.*
import kotlinx.android.synthetic.main.exercise_pop_up.*
import kotlinx.android.synthetic.main.exercise_type.view.*

class Legsandcore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_legsandcore)

        squats.setOnClickListener {
            val squatsDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val squatsBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                .setView(squatsDialogView)
            val squatsAlertDialog = squatsBuilder.show()

            squatsAlertDialog.exerciseName.setText(" ")
            //dumbbellrowsAlertDialog.image.setImageURI(Uri.parse("@drawable/dumbbell_rows"))

            val resourceId = R.drawable.squat
            val urisquats = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resourceId))
                .appendPath(resources.getResourceTypeName(resourceId))
                .appendPath(resources.getResourceEntryName(resourceId))
                .build()

            squatsAlertDialog.image.setImageURI(urisquats)
            squatsAlertDialog.reps.setText("REPS 12 | SET 3 | REST 40 s")

            squatsDialogView.backButton.setOnClickListener {
                squatsAlertDialog.dismiss()
            }
        }

        woodchop.setOnClickListener {
            val woodchopDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val woodchopBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                .setView(woodchopDialogView)
            val woodchopAlertDialog = woodchopBuilder.show()

            woodchopAlertDialog.exerciseName.setText(" ")
            //dumbbellrowsAlertDialog.image.setImageURI(Uri.parse("@drawable/dumbbell_rows"))

            val resourceId = R.drawable.woodchop
            val uriwoodchop = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resourceId))
                .appendPath(resources.getResourceTypeName(resourceId))
                .appendPath(resources.getResourceEntryName(resourceId))
                .build()

            woodchopAlertDialog.image.setImageURI(uriwoodchop)
            woodchopAlertDialog.reps.setText("REPS 12 | SET 3 | REST 40 s")

            woodchopDialogView.backButton.setOnClickListener {
                woodchopAlertDialog.dismiss()
            }
        }

        lunge.setOnClickListener {
            val lungeDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val lungeBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                .setView(lungeDialogView)
            val lungeAlertDialog = lungeBuilder.show()

            lungeAlertDialog.exerciseName.setText(" ")
            //dumbbellrowsAlertDialog.image.setImageURI(Uri.parse("@drawable/dumbbell_rows"))

            val resourceId = R.drawable.lunges
            val urilunge = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resourceId))
                .appendPath(resources.getResourceTypeName(resourceId))
                .appendPath(resources.getResourceEntryName(resourceId))
                .build()

            lungeAlertDialog.image.setImageURI(urilunge)
            lungeAlertDialog.reps.setText("REPS 12 | SET 3 | REST 40 s")

            lungeDialogView.backButton.setOnClickListener {
                lungeAlertDialog.dismiss()
            }
        }

        halo.setOnClickListener {
            val haloDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val haloBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                .setView(haloDialogView)
            val haloAlertDialog = haloBuilder.show()

            haloAlertDialog.exerciseName.setText(" ")
            //dumbbellrowsAlertDialog.image.setImageURI(Uri.parse("@drawable/dumbbell_rows"))

            val resourceId = R.drawable.halo
            val urihalo = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resourceId))
                .appendPath(resources.getResourceTypeName(resourceId))
                .appendPath(resources.getResourceEntryName(resourceId))
                .build()

            haloAlertDialog.image.setImageURI(urihalo)
            haloAlertDialog.reps.setText("REPS 12 | SET 3 | REST 40 s")

            haloDialogView.backButton.setOnClickListener {
                haloAlertDialog.dismiss()
            }
        }

        goblet.setOnClickListener {
            val gobletDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val gobletBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                .setView(gobletDialogView)
            val gobletAlertDialog = gobletBuilder.show()

            gobletAlertDialog.exerciseName.setText(" ")
            //dumbbellrowsAlertDialog.image.setImageURI(Uri.parse("@drawable/dumbbell_rows"))

            val resourceId = R.drawable.goblet
            val urigoblet = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resourceId))
                .appendPath(resources.getResourceTypeName(resourceId))
                .appendPath(resources.getResourceEntryName(resourceId))
                .build()

            gobletAlertDialog.image.setImageURI(urigoblet)
            gobletAlertDialog.reps.setText("REPS 12 | SET 3 | REST 40 s")

            gobletDialogView.backButton.setOnClickListener {
                gobletAlertDialog.dismiss()
            }
        }

        crunches.setOnClickListener {
            val crunchesDialogView = LayoutInflater.from(this).inflate(R.layout.exercise_pop_up,null);
            val crunchesBuilder = AlertDialog.Builder(this,R.style.MyDialogTheme)
                .setView(crunchesDialogView)
            val crunchesAlertDialog = crunchesBuilder.show()

            crunchesAlertDialog.exerciseName.setText(" ")
            //dumbbellrowsAlertDialog.image.setImageURI(Uri.parse("@drawable/dumbbell_rows"))

            val resourceId = R.drawable.crunch
            val uricrunches = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resourceId))
                .appendPath(resources.getResourceTypeName(resourceId))
                .appendPath(resources.getResourceEntryName(resourceId))
                .build()

            crunchesAlertDialog.image.setImageURI(uricrunches)
            crunchesAlertDialog.reps.setText("REPS 12 | SET 3 | REST 40 s")

            crunchesDialogView.backButton.setOnClickListener {
                crunchesAlertDialog.dismiss()
            }
        }
    }
}