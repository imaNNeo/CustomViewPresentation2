package com.neo.customviewpres.viewgroups

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.neo.customviewpres.utils.toPx

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
class ObliqueViewGroup : ViewGroup {

    constructor(ctx: Context) : super(ctx)
    constructor(
            ctx: Context,
            attributes: AttributeSet
    ) : super(ctx, attributes)

    constructor(
            ctx: Context,
            attributes: AttributeSet,
            defStyle: Int
    ) : super(ctx, attributes, defStyle)


    val p: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        p.strokeWidth = 1.5f.toPx()
        p.color = Color.RED
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        var x = 0
        var y = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            if (child.visibility == View.VISIBLE) {
                val lp = child.layoutParams as MarginLayoutParams

                x += lp.leftMargin
                y += lp.topMargin
                child.layout(x, y,
                        x + child.measuredWidth, y + child.measuredHeight)
                x += child.measuredWidth + lp.rightMargin
                y += child.measuredHeight + lp.bottomMargin
            }
        }
    }

    override fun onMeasure(
            widthMeasureSpec: Int,
            heightMeasureSpec: Int
    ) {
        measureChildren(widthMeasureSpec, heightMeasureSpec)

        var maxWidth = 0
        var maxHeight = 0
        for (i in 0 until childCount) {
            var child = getChildAt(i)
            val lp = child.layoutParams as MarginLayoutParams

            maxWidth += MeasureSpec.getSize(child.measuredWidth) + lp.leftMargin + lp.rightMargin
            maxHeight += MeasureSpec.getSize(child.measuredHeight) + lp.topMargin + lp.bottomMargin
        }

        maxWidth += paddingLeft + paddingRight
        maxHeight += paddingTop + paddingBottom

        //Uses max(minimumWidth, and background minimum)
        maxWidth = Math.max(suggestedMinimumWidth, maxWidth)
        maxHeight = Math.max(suggestedMinimumHeight, maxHeight)

        setMeasuredDimension(
                View.resolveSize(maxWidth, widthMeasureSpec),
                View.resolveSize(maxHeight, heightMeasureSpec)
        )
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return MarginLayoutParams(MarginLayoutParams.WRAP_CONTENT, MarginLayoutParams.WRAP_CONTENT)
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    override fun generateLayoutParams(p: LayoutParams?): LayoutParams {
        return MarginLayoutParams(p)
    }

    override fun checkLayoutParams(p: LayoutParams?): Boolean {
        return p is MarginLayoutParams
    }

    override fun willNotDraw(): Boolean {
        return false
    }

//    override fun onDraw(canvas: Canvas?) {
//        for (i in 0 until childCount) {
//            val child = getChildAt(i)
//
//            //Left Lines
//            canvas?.drawLine(child.left.toFloat(), 0f, child.left.toFloat(), height.toFloat(), p)
//
//            //Top Lines
//            canvas?.drawLine(0f, child.top.toFloat(), width.toFloat(), child.top.toFloat(), p)
//        }
//    }

//    override fun dispatchDraw(canvas: Canvas?) {
//        super.dispatchDraw(canvas)
//
//        p.color = Color.BLUE
//        for (i in 0 until childCount) {
//            val child = getChildAt(i)
//
//            canvas?.drawCircle(
//                    (child.right - (child.width / 2)).toFloat(),
//                    (child.bottom - child.height / 2).toFloat(),
//                    8.toPx().toFloat(),
//                    p)
//        }
//    }

}