package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * STEPS TO UNDERSTANDING THE CODE
         */
        val rollButton : Button = findViewById(R.id.button)
         //We are calling the button using findViewById  to call the button into the program

        //Below, the button is being set for the user to use
        //Once the button is clicked the the user will be able to see that the dice was rolled by toast message
        rollButton.setOnClickListener{
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()

            //The rollDice function is being called so that when the button
            // is clicked then the rollDice() class will respond as well once the button is clicked.
            rollDice()
        }
    }
// This is the function for the private class
    private fun rollDice() {

    // Create new Dice object with 6 sides and roll it
    val dice = Dice(6)
    val diceRoll = dice.roll()

    //This is to update the image as we update the the button
    val diceImage: ImageView = findViewById(R.id.Dice)

  /**
    // Update the screen with the dice roll
    // Since we are using a imageView, we will not need the textView
    val resultTextView: TextView = findViewById(R.id.textView)
    resultTextView.text = diceRoll.toString()
    */

    when (diceRoll) {
        1 -> diceImage.setImageResource(R.drawable.dice_1)
        2 -> diceImage.setImageResource(R.drawable.dice_2)
        3 -> diceImage.setImageResource(R.drawable.dice_3)
        4 -> diceImage.setImageResource(R.drawable.dice_4)
        5 -> diceImage.setImageResource(R.drawable.dice_5)
        6 -> diceImage.setImageResource(R.drawable.dice_6)
    }

    }
}
//This class is for the dice
//The numSides is being implemented into the class
class Dice(private val numSides: Int) {

    //Roll is in charge of rolling the dice
    fun roll(): Int {
        return (1..numSides).random()
    }
}