package com.example.ppp

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity

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

        // Initialize grid buttons and states
        for (row in 0 until GRID_SIZE) {
            for (col in 0 until GRID_SIZE) {
                buttons[row][col] = Button(this)
                buttonStates[row][col] = 0 // Initial state is 0
                updateButtonImage(buttons[row][col], buttonStates[row][col])
                buttons[row][col]!!.setOnClickListener { // Update button state
                    buttonStates[row][col] = (buttonStates[row][col] + 1) % 16
                    updateButtonImage(
                        buttons[row][col],
                        buttonStates[row][col]
                    )
                }
                gridLayout.addView(buttons[row][col])
            }
        }
    }

    private fun updateButtonImage(button: Button?, state: Int) {
        when (state) {
            0 -> button!!.setBackgroundResource(R.drawable.pipefin_down)
            1 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            2 -> button!!.setBackgroundResource(R.drawable.pipefin_right)
            3 -> button!!.setBackgroundResource(R.drawable.pipefin_left)
            4 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            5 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            6 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            7 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            8 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            9 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            10 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            11 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            12 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            13 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            14 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
            15 -> button!!.setBackgroundResource(R.drawable.pipefin_up)
        }
    }

    companion object {
        private const val GRID_SIZE = 3
    }
}
