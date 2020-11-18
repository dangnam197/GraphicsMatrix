package com.triversoft.matrix

import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val TAG = "AppDebug"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val matrix = Matrix()
        matrix.preScale(2f,3f)
        matrix.preTranslate(2f,8f)

        val listPoint :FloatArray = floatArrayOf(10f,10f)

        matrix.mapPoints(listPoint)

        Log.d(TAG, "onCreate: ${listPoint[0]} ${listPoint[1]}")

    }
}