package com.triversoft.matrix

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import com.almeros.android.multitouch.MoveGestureDetector
import com.almeros.android.multitouch.RotateGestureDetector
import kotlin.math.max
import kotlin.math.min

class MyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    lateinit var bitmap: Bitmap
    lateinit var matrix2: Matrix
    lateinit var bitmapShader: BitmapShader
    var paint = Paint()
    var paint2 = Paint()
    var dx = 0f
    var dy = 0f
    var isDraw = false
    var focusX = 0f
    var focusY = 0f
    var currentScale = 1f
    lateinit var moveGestureDetector: MoveGestureDetector
    lateinit var scaleGestureDetector:ScaleGestureDetector
    lateinit var rotateGestureDetector:RotateGestureDetector

    init {
        moveGestureDetector = MoveGestureDetector(context,Translate())
        scaleGestureDetector = ScaleGestureDetector(context,Scale())
        rotateGestureDetector = RotateGestureDetector(context,Rotate())
        paint2.color = Color.RED
        paint2.textSize = 60f
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.test)
        bitmapShader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.shader = bitmapShader
        matrix2 = Matrix()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.setMatrix(matrix2)
        canvas?.drawBitmap(bitmap, 0f, 0f, null)


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        moveGestureDetector.onTouchEvent(event)
        scaleGestureDetector.onTouchEvent(event)
//        rotateGestureDetector.onTouchEvent(event)
        invalidate()
        return true
    }
    inner class Translate: MoveGestureDetector.SimpleOnMoveGestureListener() {
        override fun onMove(detector: MoveGestureDetector?): Boolean {
            detector?.focusDelta?.let { focusDelta ->
                matrix2.postTranslate(focusDelta.x,focusDelta.y)
            }
            return true
        }
    }
    inner class  Scale : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector?): Boolean {
            detector?.let {
                var value = min(1.5f,currentScale*it.scaleFactor)
                value = max(value,0.7f)
                if (value < 1.5&&value > 0.7f) {
                    matrix2.postScale(it.scaleFactor, it.scaleFactor, it.focusX, it.focusY)
                    focusX = it.focusX
                    focusY = it.focusY
                    currentScale = value
                }
            }
            return true
        }
    }
    inner class Rotate : RotateGestureDetector.SimpleOnRotateGestureListener() {
        override fun onRotate(detector: RotateGestureDetector?): Boolean {
            detector?.let {
                matrix2.postRotate(-it.rotationDegreesDelta,focusX,focusY)
            }
            return true
        }
    }
}