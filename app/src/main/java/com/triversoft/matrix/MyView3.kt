package com.triversoft.matrix

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class MyView3 @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    lateinit var bitmap: Bitmap
    lateinit var matrix2: Matrix
    lateinit var bitmapShader:BitmapShader
    var paint = Paint()
    var paint2 = Paint()
    var dx = 0f
    var dy = 0f
    var isDraw = false

    init {
        paint2.color = Color.RED
        paint2.textSize = 60f
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.test)
        bitmapShader = BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
        paint.shader = bitmapShader
        matrix2 = Matrix()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawBitmap(bitmap,0f,0f,null)
        canvas?.drawCircle(dx,dy,10f,paint2)
        if(isDraw) {
            matrix2.setTranslate(-dx ,-dy )
            matrix2.postTranslate(200f ,200f )
            matrix2.postScale(2f,2f,200f,200f)

            bitmapShader.setLocalMatrix(matrix2)

            canvas?.drawCircle(200f, 200f, 210f, paint2)
            canvas?.drawCircle(200f, 200f, 300f, paint)
        }

        canvas?.drawText("${dx.toInt()}   ${dy.toInt()}",500f,500f,paint2)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN ->{
                isDraw = true;
            }
            MotionEvent.ACTION_MOVE ->{
                dx = event.x
                dy = event.y
            }
            MotionEvent.ACTION_UP ->{
                isDraw = false
            }
        }
        invalidate()
        return true
    }
}