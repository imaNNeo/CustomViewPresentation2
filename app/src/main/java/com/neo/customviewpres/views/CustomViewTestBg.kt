package com.neo.customviewpres.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.neo.customviewpres.utils.toPx

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
class CustomViewTestBg : View {
    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attributes: AttributeSet) : super(ctx, attributes)
    constructor(ctx: Context, attributes: AttributeSet, defStyle: Int) : super(ctx, attributes, defStyle)


    val size = 42F.toPx()
    val linePaint: Paint

    init {
        linePaint = Paint(android.graphics.Paint.ANTI_ALIAS_FLAG)
        with(linePaint) {
            color = Color.RED
            strokeCap = Paint.Cap.ROUND
            strokeWidth = 6f.toPx()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val wMode = MeasureSpec.getMode(widthMeasureSpec)
        val hMode = MeasureSpec.getMode(heightMeasureSpec)

        Toast.makeText(context, "$wMode, $hMode", Toast.LENGTH_LONG).show()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            drawLine(0F, 0F, size, size, linePaint)
            drawLine(size, 0F, 0F, size, linePaint)

            drawRect(0F, 0F, width.toFloat(), height.toFloat(), linePaint)
        }
    }

}