package com.example.myapplication

import android.content.Context
import android.view.View
import android.view.MotionEvent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.DITHER_FLAG
import android.graphics.Paint.Cap
import android.graphics.Paint.Join
import android.graphics.Path

class PbrushView : View {

    private var drawPath: Path = Path()
    private var drawPaint: Paint = Paint()
    private var canvasPaint:Paint
    private val paintColor = -0x1000000
    private lateinit var drawCanvas: Canvas
    private lateinit var canvasBitmap: Bitmap

    constructor(context : Context) : super(context){

        drawPaint.apply {
            color = paintColor
            isAntiAlias = true
            strokeWidth = 50f
            style = Paint.Style.STROKE
            strokeJoin = Join.ROUND
            strokeCap = Cap.ROUND
        }
        canvasPaint = Paint(DITHER_FLAG)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(canvasBitmap)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(canvasBitmap, 0f, 0f, canvasPaint)
        canvas.drawPath(drawPath, drawPaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return draw(event.x,event.y, event.action)
    }

    fun draw(touchX: Float, touchY : Float, event : Int) : Boolean{
        when (event) {
            MotionEvent.ACTION_DOWN -> drawPath.moveTo(touchX, touchY)
            MotionEvent.ACTION_MOVE -> drawPath.lineTo(touchX, touchY)
            MotionEvent.ACTION_UP -> {
                drawPath.lineTo(touchX, touchY)
                drawCanvas.drawPath(drawPath, drawPaint)
                drawPath.reset()
            }
            else -> return false
        }

        invalidate()
        return true
    }

    fun changeColor(color : Int){
        drawPaint.color = color
    }

    fun changeStrokeWidth(width : Float){
        drawPaint.strokeWidth = width
    }

}