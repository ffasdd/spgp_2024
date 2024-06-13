package com.example.ppp

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class Stage1Activity : AppCompatActivity() {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stage1)

        // Set up the grid layout
        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)
        gridLayout.setRowCount(GRID_SIZE)
        gridLayout.setColumnCount(GRID_SIZE)
        val random = Random()

        // Initialize grid buttons and states
        for (row in 0 until GRID_SIZE) {
            for (col in 0 until GRID_SIZE) {
                buttons[row][col] = Button(this)
                buttonStates[row][col] = random.nextInt(14) // Initial state between 0 and 13
                updateButtonImage(buttons[row][col], buttonStates[row][col])
                buttons[row][col]!!.setOnClickListener { // Update button state within allowed range
                    buttonStates[row][col] =
                        getNextState(buttonStates[row][col])
                    updateButtonImage(
                        buttons[row][col],
                        buttonStates[row][col]
                    )
                }
                gridLayout.addView(buttons[row][col])
            }
        }
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
            0 -> button!!.setBackgroundResource(R.drawable.pipefin_down)
            1 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            2 -> button!!.setBackgroundResource(R.drawable.pipefin_right)
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

    companion object {
        private const val GRID_SIZE = 3
    }
}
