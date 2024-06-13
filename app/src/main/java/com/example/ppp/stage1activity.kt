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
                buttons[row][col]!!.text = buttonStates[row][col].toString()
                buttons[row][col]!!.setOnClickListener { // Update button state
                    buttonStates[row][col] = (buttonStates[row][col] + 1) % 16
                    buttons[row][col]!!.text =
                        buttonStates[row][col].toString()
                }
                gridLayout.addView(buttons[row][col])
            }
        }
    }

    companion object {
        private const val GRID_SIZE = 3
    }
}
