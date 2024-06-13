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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stage1)

        // Set up the grid layout
        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)
        gridLayout.setRowCount(GRID_SIZE)
        gridLayout.setColumnCount(GRID_SIZE)

        // Initialize grid buttons
        for (row in 0 until GRID_SIZE) {
            for (col in 0 until GRID_SIZE) {
                buttons[row][col] = Button(this)
                buttons[row][col]!!.text = " " // Initially, no pipe
                buttons[row][col]!!.setOnClickListener { v ->
                    // Handle pipe placement or interactions here
                    // For demo, let's change the text to represent a pipe
                    val button = v as Button
                    button.text = "P" // P represents a pipe
                }
                gridLayout.addView(buttons[row][col])
            }
        }

        // For demo, place a few pipes
        buttons[0][0]!!.text = "S" // Start pipe
        buttons[1][0]!!.text = "|" // Vertical pipe
        buttons[2][0]!!.text = "E" // End pipe
    } // Add methods to handle game logic as needed

    companion object {
        private const val GRID_SIZE = 3
    }
}