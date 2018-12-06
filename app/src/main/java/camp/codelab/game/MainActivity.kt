package camp.codelab.game

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var playerOnePoints: Int = 0
    var playerTwoPoints: Int = 0
    var playerOneWin: Int = 0
    var playerTwoWin: Int = 0
    var numberRoundText: Int = 0

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
        buttonResett.setOnClickListener { buttonReset() }
        Finish.setOnClickListener { buttonFinish() }
    }

    fun buttonIncreamentPayerOne() {
        if (playerOnePoints == 40) {
            playerOnePoints = 0
            playerTwoPoints = 0
            playerOneWin++
            numberRoundText++

        } else if (playerOnePoints == 30) {
            playerOnePoints += 10
        } else if (playerOnePoints == 15 || playerOnePoints == 0) {
            playerOnePoints += 15
        } else {
            playerOnePoints += 0
        }
        currentPointsPlayer1.text = playerOnePoints.toString()
        currentPointsPlayer2.text = playerTwoPoints.toString()
        numberWinPlayer1.text = playerOneWin.toString()
        numberRound.text = numberRoundText.toString()

    }

    fun buttonIncreamentPayerTwo() {
        if (playerTwoPoints == 40) {
            playerOnePoints = 0
            playerTwoPoints = 0
            playerTwoWin++
            numberRoundText++

        } else if (playerTwoPoints == 30) {
            playerTwoPoints += 10
        } else if (playerTwoPoints == 15 || playerTwoPoints == 0) {
            playerTwoPoints += 15
        } else {
            playerTwoPoints += 0
        }
        currentPointsPlayer1.text = playerOnePoints.toString()
        currentPointsPlayer2.text = playerTwoPoints.toString()
        numberWinPlayer2.text = playerTwoWin.toString()
        numberRound.text = numberRoundText.toString()


    }

    fun buttonDecrementPayerOne() {
        if (playerOnePoints > 0) {
            playerOnePoints -= 15
            currentPointsPlayer1.text = playerOnePoints.toString()
        }
    }

    fun buttonDecrementPayerTwo() {
        if (playerTwoPoints > 0) {
            playerTwoPoints -= 15
            currentPointsPlayer2.text = playerTwoPoints.toString()
        }
    }

    fun buttonFinish() {
        val message: String
        if (playerOneWin == 0 && playerTwoWin == 0) {
            message = "No one Win Yet"
        } else if (playerOneWin == playerTwoWin) {
            message = "Draw"
        } else if (playerOneWin > playerTwoWin) {
            message = "Player One Win!"
        } else {
            message = "Player Two Win!"
        }
        Toast.makeText(this, message?.toString(), Toast.LENGTH_LONG).show()

    }

    fun buttonReset() {
        playerOnePoints = 0
        playerTwoPoints = 0
        playerOneWin = 0
        playerTwoWin = 0
        numberRoundText = 1
        currentPointsPlayer1.text = playerOnePoints.toString()
        currentPointsPlayer2.text = playerTwoPoints.toString()
        numberWinPlayer1.text = playerOneWin.toString()
        numberWinPlayer2.text = playerTwoWin.toString()
        numberRound.text = numberRoundText.toString()

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




