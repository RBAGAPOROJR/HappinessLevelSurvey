package com.example.happinesslevelsurvey

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import androidx.fragment.app.DialogFragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SurveyFragment : DialogFragment() {

    private var sendMessages : SendMessages? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_survey, container, false )

    }

    override fun onCreateDialog( savedInstanceState : Bundle? ) : Dialog {

        return AlertDialog.Builder( activity )
            .setTitle( R.string.survey_title )
            .setSingleChoiceItems( levels, checkedItem ) { dialog, which ->
                sendMessages!!.choiceMade( which )
                sendMessages!!.titleMade( which )
                sendMessages!!.descripMade( which )
                Log.d("radio", "DIALOG : $dialog | $which" )
            }
            .setPositiveButton( android.R.string.ok) { dialog, which ->
                Log.d("btnOK", "ok button clicked : $dialog | $which" )
            }
            .setNegativeButton( android.R.string.cancel) { dialog, which ->
                Log.d("btnCancel", "cancel button clicked : $dialog | $which" )
            }.create()
    }

    companion object {

        // ***create list of happiness levels
        var levels = arrayOf( "Level 1", "Level 2", "Level 3", "Level 4" )
        var levelTitles = arrayOf( "Immediate Gratification",
            "Comparative / Personal Achievement",
            "Contributive",
            "Ultimate Good" )
        var levelDescript = arrayOf("Pleasure and minimize pain.",
            "Ego Centeredness, better than, gain advantage.",
            "Do good beyond self, Make an optimal positive difference for others.",
            "Participate in giving and receiving ultimate meaning, goodness, ideals and love.")
        var checkedItem = -1

        @JvmStatic
        fun newInstance( lvl : Int ) : SurveyFragment {

            val fragment = SurveyFragment()
            val args = Bundle()

            args.putInt( "levels", lvl)
            fragment.arguments = args

            return fragment

        }
    }

    override fun onAttach( context : Context ) {
        super.onAttach( context )
        sendMessages = context as SendMessages
    }

    internal interface SendMessages {

        fun choiceMade( msg : Int? )
        fun titleMade( msg : Int? )
        fun descripMade( msg: Int? )

    }

}