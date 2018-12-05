package camp.codelab.game

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var playerOnePoints = 0
    var playerTwoPoints = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
//        val tip = sharedPreferences.getInt("TIP", 0)
//        tipEditText.setText(tip.toString())
//


        increamentButtonPlayer1.setOnClickListener { buttonIncreamentPayerOne() }
        increamentButtonPlayer2.setOnClickListener { buttonIncreamentPayerTwo() }
        decreamentButtonPlayer1.setOnClickListener { buttonDecrementPayerOne() }
        decreamentButtonPlayer2.setOnClickListener { buttonDecrementPayerTwo() }
        buttonResett.setOnClickListener { buttonFinish() }
        decreamentButtonPlayer2.setOnClickListener { buttonReset() }
    }

    fun buttonIncreamentPayerOne() {
        playerOnePoints++
        currentPointsPlayer1.text = playerOnePoints.toString()
    }

    fun buttonIncreamentPayerTwo() {
        playerTwoPoints++
        currentPointsPlayer2.text = playerTwoPoints.toString()
    }

    fun buttonDecrementPayerOne() {
        playerOnePoints--
        currentPointsPlayer1.text = playerOnePoints.toString()
    }

    fun buttonDecrementPayerTwo() {
        playerTwoPoints--
        currentPointsPlayer1.text = playerTwoPoints.toString()
    }

    fun buttonFinish() {
        val message: String
        if (playerOnePoints == playerTwoPoints) {
            message = "Draw"
        } else if (playerOnePoints > playerTwoPoints) {
            message = "Player One Win!"
        } else {
            message = "Player Two Win!"
        }
        Toast.makeText(this, message?.toString(), Toast.LENGTH_LONG).show()

    }

    fun buttonReset() {
        playerOnePoints = 0
        playerTwoPoints = 0
        currentPointsPlayer1.text = playerOnePoints.toString()
        currentPointsPlayer2.text = playerTwoPoints.toString()

    }

//    override fun onStop() {
//        super.onStop()
//        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this).edit()
//
//        val pointsPlayerOne = currentPointsPlayer1.text.toString()
//        if (pointsPlayerOne.isNotEmpty()) {
//            val tip = tipString.toFloat()
//            editor.putFloat("TIP", tip)
//        } else {
//            editor.putFloat("TIP", 0f)
//        }
//        editor.apply()
//    }
}




