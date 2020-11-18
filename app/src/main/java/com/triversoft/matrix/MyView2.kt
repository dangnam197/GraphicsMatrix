package com.triversoft.matrix

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MyView2 @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    lateinit var bitmap: Bitmap
    lateinit var matrix2: Matrix
    lateinit var bitmapShader:BitmapShader
    var rect =  RectF(500f,500f,600f,600f)
    var rectDst = RectF()
    var paint = Paint()
    init {
        paint.setColor(Color.RED)

        bitmap = BitmapFactory.decodeResource(resources, R.drawable.test)
        matrix2 = Matrix()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRect(rect,paint)
        canvas?.save()
//        matrix2.postTranslate(500f,500f)
        matrix2.postRotate(30f,550f,550f)
        canvas?.setMatrix(matrix2)
//        canvas?.drawBitmap(bitmap,0f,0f,null)
        canvas?.drawRect(rect,paint)

        canvas?.restore()



//        paint.setColor(Color.BLUE)
//        canvas?.drawRect(rectDst,paint)


    }
}