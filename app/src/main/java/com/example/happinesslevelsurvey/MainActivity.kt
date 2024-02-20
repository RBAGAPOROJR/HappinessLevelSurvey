package com.example.happinesslevelsurvey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() , View.OnClickListener, SurveyFragment.SendMessages {

    private lateinit var btnSurvey : Button
    private lateinit var txtVLevel : TextView
    private lateinit var txtVTitle : TextView
    private lateinit var txtVDescrip : TextView

    override fun onCreate( savedInstanceState: Bundle? ) {

        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        btnSurvey = findViewById( R.id.btnSurvey )

        txtVLevel = findViewById( R.id.txtVLevel )
        txtVTitle = findViewById( R.id.txtVTitle )
        txtVDescrip = findViewById( R.id.txtVDescrip )

        btnSurvey.setOnClickListener( this )

        val btnInstruction : Button = findViewById( R.id.btnInstructions )

        btnInstruction.setOnClickListener{

            // *navigate to second activity "Instruction"
            val  intent = Intent( this@MainActivity, Instruction::class.java )
            startActivity( intent )

        }

    }

    override fun onClick( view : View ) {

        when( view.id ) {

            R.id.btnSurvey -> {

                Log.d( "survey","SURVEY CLICKED" )

                val surveyFrag : DialogFragment = SurveyFragment
                    .newInstance( R.string.confirm )
                surveyFrag.show( supportFragmentManager, "surveys" )

            }
        }

    }

    override fun choiceMade( msg : Int? ) {

        SurveyFragment.levels[ msg!! ].also { txtVLevel.text = it }
        SurveyFragment.checkedItem = msg

        Log.d( "justLog", "My choice is: ${SurveyFragment.levels[msg]}")

    }

    override fun titleMade( msg: Int? ) {

        SurveyFragment.levelTitles[ msg!! ].also { txtVTitle.text = it }
        SurveyFragment.checkedItem = msg

        Log.d( "titleLog", "My choice is: ${SurveyFragment.levelTitles[msg]}")

    }

    override fun descripMade( msg: Int? ) {

        "\"${SurveyFragment.levelDescript[ msg!! ]}\"".also { txtVDescrip.text = it }
        SurveyFragment.checkedItem = msg

        Log.d( "titleLog", "My choice is: ${SurveyFragment.levelDescript[msg]}")

    }






}

