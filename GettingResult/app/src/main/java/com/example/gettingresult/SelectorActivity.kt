package com.example.gettingresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_selector.*

class SelectorActivity : AppCompatActivity() , View.OnClickListener  { /*Implemented the  View.OnClickListener on class level*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_selector)



        imageViewOrange.setOnClickListener(this)  // SelectorActivity class implements View.OnClickListener
        imageViewApple.setOnClickListener(this)
        imageViewStrawberry.setOnClickListener(this)



    }


    override fun onClick(view: View?) {


        var drawableResId =
            when(view?.id) {

                R.id.imageViewApple->
                    R.drawable.apple // there is a implicit (hidden) return here which returns R.drawable.apple

                R.id.imageViewStrawberry->
                    R.drawable.strawberry

                R.id.imageViewOrange->
                    R.drawable.orange

                else-> // default return for unknown selections
                    0
        }

        //Packing the result (a drawable resource id) as key value pair using the extra map

        var resultData = Intent();
        resultData.putExtra("resId", drawableResId)


        setResult(Activity.RESULT_OK, resultData) // Result is OK and contains data intent

        this.finish()  // Finishes this activity
    }
}
