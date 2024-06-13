package com.example.ppp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
private lateinit var sharedPreferences: SharedPreferences
class Stage5Activity : AppCompatActivity() {
    private val buttons = Array(GRID_SIZE) {
        arrayOfNulls<Button>(
            GRID_SIZE
        )
    }
    private val buttonStates = Array(GRID_SIZE) {
        IntArray(
            GRID_SIZE
        )
    }
    private val answerArray = intArrayOf(4,8,8,3,12,8,5,2,7,5,7,6,1,11,8,3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stage5)

        // Set up the grid layout
        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)
        gridLayout.setRowCount(GRID_SIZE)
        gridLayout.setColumnCount(GRID_SIZE)
        val random = Random()

        // Set up buttons and their initial states
        for (row in 0 until GRID_SIZE) {
            for (col in 0 until GRID_SIZE) {
                val button = Button(this)
                buttonStates[row][col] = getInitialRandomState(answerArray[row * GRID_SIZE + col], random)
                updateButtonImage(button, buttonStates[row][col])

                button.setOnClickListener {
                    // Update button state within allowed range
                    buttonStates[row][col] = getNextState(buttonStates[row][col])
                    updateButtonImage(button, buttonStates[row][col])

                    // Check if all button states match answerArray
                    if (checkAllCorrect()) {
                        showMessage("All answers are correct!")

                        // Delay navigation to main screen after 3 seconds
                        Handler().postDelayed({
                            navigateToMainScreen()
                        }, 3000)
                    }
                }

                buttons[row][col] = button
                gridLayout.addView(button)
            }
        }
    }
    private fun getInitialRandomState(answer: Int, random: Random): Int {
        var startRange = 0
        var endRange = 0
        if (answer >= 0 && answer <= 3) {
            startRange = 0
            endRange = 3
        } else if (answer >= 4 && answer <= 7) {
            startRange = 4
            endRange = 7
        } else if (answer >= 8 && answer <= 9) {
            startRange = 8
            endRange = 9
        } else if (answer >= 10 && answer <= 13) {
            startRange = 10
            endRange = 13
        }
        return startRange + random.nextInt(endRange - startRange + 1)
    }

    private fun getNextState(currentState: Int): Int {
        if (currentState >= 0 && currentState <= 3) {
            return (currentState + 1) % 4
        } else if (currentState >= 4 && currentState <= 7) {
            return (currentState - 4 + 1) % 4 + 4
        } else if (currentState >= 8 && currentState <= 9) {
            return if (currentState == 8) 9 else 8
        } else if (currentState >= 10 && currentState <= 13) {
            return (currentState - 10 + 1) % 4 + 10
        }
        return 0 // Default case, shouldn't happen
    }

    private fun updateButtonImage(button: Button?, state: Int) {
        when (state) {
            0 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            1 -> button!!.setBackgroundResource(R.drawable.pipefin_right)
            2 -> button!!.setBackgroundResource(R.drawable.pipefin_down)
            3 -> button!!.setBackgroundResource(R.drawable.pipefin_left)

            4 -> button!!.setBackgroundResource(R.drawable.pipe_curved1)
            5 -> button!!.setBackgroundResource(R.drawable.pipe_curved2)
            6 -> button!!.setBackgroundResource(R.drawable.pipe_curved3)
            7 -> button!!.setBackgroundResource(R.drawable.pipe_curved4)

            8 -> button!!.setBackgroundResource(R.drawable.pipe_stright_lnr)
            9 -> button!!.setBackgroundResource(R.drawable.pipe_stright_und)

            10 -> button!!.setBackgroundResource(R.drawable.pipe_t_shape1)
            11 -> button!!.setBackgroundResource(R.drawable.pipe_t_shape2)
            12 -> button!!.setBackgroundResource(R.drawable.pipe_t_shape3)
            13 -> button!!.setBackgroundResource(R.drawable.pipe_t_shape4)
        }
    }
    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun checkAllCorrect(): Boolean {
        for (row in 0 until GRID_SIZE) {
            for (col in 0 until GRID_SIZE) {
                if (buttonStates[row][col] != answerArray[row * GRID_SIZE + col]) {
                    return false
                }
            }
        }
        return true
    }
    private fun navigateToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Close this activity
    }
    companion object {
        private const val GRID_SIZE = 4
    }
    private fun resetStageInfo() {
        // Clear all stage completion info
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}
