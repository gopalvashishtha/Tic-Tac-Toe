package com.example.Tic_Tac_Toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var player = false
    var turnCount = 0
    override fun onClick(v: View) {

        when (v.id) {
            R.id.btn1 -> {
                updateValue(row = 0, col = 0)

            }
            R.id.btn2 -> {
                updateValue(row = 0, col = 1)

            }
            R.id.btn3 -> {
                updateValue(row = 0, col = 2)

            }
            R.id.btn4 -> {
                updateValue(row = 1, col = 0)

            }
            R.id.btn5 -> {
                updateValue(row = 1, col = 1)

            }
            R.id.btn6 -> {
                updateValue(row = 1, col = 2)
            }
            R.id.btn7 -> {
                updateValue(row = 2, col = 0)

            }
            R.id.btn8 -> {
                updateValue(row = 2, col = 1)

            }
            R.id.btn9 -> {
                updateValue(row = 2, col = 2)

            }


        }
        turnCount++
        player = !player
        if(player){
            updateDisplay("player X turn")
        } else{
            updateDisplay("player 0 turn")
        }

        if (turnCount > 5)
            checkWinner()

        if(turnCount == 9){ Log.i("checking","$turnCount")
            updateDisplay("Game draw")
        }

         }


    private fun checkWinner() {

        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]) {
            if (boardStatus[0][0] == 1) {
                updateText("X")
            } else if (boardStatus[0][0] == 0) {
                updateText("0")
            }
        }
        if (boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]) {
            if (boardStatus[0][2] == 1) {
                updateText("X")
            } else if (boardStatus[0][2] == 0) {
                updateText("0")
            }
        }
        for (i in 0..2) {
            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]) {
                if (boardStatus[0][i] == 1) {
                    updateText("X")
                } else if (boardStatus[0][i] == 0) {
                    updateText("0")
                }
            }
        }

        for (i in 0..2) {
            if (boardStatus[i][2] == boardStatus[i][1] && boardStatus[i][2] == boardStatus[i][0]) {
                if (boardStatus[i][2] == 1) {
                    updateText("X")
                } else if (boardStatus[i][2] == 0) {
                    updateText("0")
                }
            }
        }


    }


    private fun updateText(text: String) {
        displayText.text = "$text is Winner"
        disableButton()

    }
    private fun disableButton() {
        for (i in buttonArray) {
            for (j in i) {
                j.isEnabled = false
            }
        }
    }


    private fun updateDisplay(text: String){
        displayText.text= text
    }


    private fun updateValue(row: Int, col: Int) {
        val text: String = if (player) "X" else "0"
        val value: Int = if (player) 1 else 0

        buttonArray[row][col].text = text
        buttonArray[row][col].isEnabled = false
        boardStatus[row][col] = value
    }

    var boardStatus: Array<IntArray> = Array(size = 3) { IntArray(size = 3) }
    var buttonArray = arrayOf<Array<Button>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonArray = arrayOf(
            arrayOf(btn1, btn2, btn3),
            arrayOf(btn4, btn5, btn6),
            arrayOf(btn7, btn8, btn9)

        )
        for (i in buttonArray) {
            for (j in i) {
                j.setOnClickListener(this)
            }
        }

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)

        intialize()
        resetBtn.setOnClickListener {
            player = true
            turnCount = 0
            displayText.text = ""
            intialize()
        }

            Log.i("Lifecycle", "On Create Called")
        }


        private fun intialize() {
            for (i in buttonArray)  {
                for (j in i) {
                    j.isEnabled = true
                   j.text = ""




                }
            }
            for (i in 0..2) {
                for (j in 0..2) {
                    boardStatus [i][j] = -1
                }
            }


        }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "On Start Called")

    }




    override fun onResume() {
             super.onResume()
            Log.i("Lifecycle", "On Resume called")

        }

        override fun onPause() {
            super.onPause()
            Log.i("Lifecycle", "On Pause called")
        }

        override fun onStop() {
            super.onStop()
            Log.i("Lifecycle", "On Stop called")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.i("Lifecycle", "on Destroy called")
        }

    }


