package com.neo.customviewpres.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.support.v7.widget.AppCompatDrawableManager
import android.util.AttributeSet
import android.view.View
import com.neo.customviewpres.R
import com.neo.customviewpres.utils.toPx

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
class DrawableView : View {

    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attributes: AttributeSet) : super(ctx, attributes)
    constructor(ctx: Context, attributes: AttributeSet, defStyle: Int) : super(ctx, attributes, defStyle)


    val letterDrawable = LetterDrawable(context, "S")
    @SuppressLint("RestrictedApi")
    val vectorDrawable = AppCompatDrawableManager.get().getDrawable(context, R.drawable.ic_android_black_24dp)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        letterDrawable.setBounds(50,50,250,250)
        letterDrawable.draw(canvas)

        vectorDrawable.setBounds(200,200, 800,800)
        vectorDrawable.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN)
        vectorDrawable.draw(canvas)
    }


    class LetterDrawable(val ctx: Context, val letter : String) : Drawable(){
        val mCirclePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        val mLetterPaint = Paint(Paint.ANTI_ALIAS_FLAG)

        val mLetterTop : Float

        init {
            mCirclePaint.color = Color.MAGENTA

            mLetterPaint.color = Color.WHITE
            mLetterPaint.textSize = 14.toPx().toFloat()
            mLetterPaint.textAlign = Paint.Align.CENTER

            val textMathRect = Rect()
            mLetterPaint.getTextBounds(letter, 0, 1, textMathRect)
            mLetterTop = textMathRect.height() / 2f
        }
        override fun draw(canvas: Canvas?) {
            canvas?.drawCircle(
                    bounds.exactCenterX(), bounds.exactCenterY(),
                    bounds.width() / 2f, mCirclePaint)

            canvas?.drawText(letter,
                    bounds.exactCenterX(), mLetterTop + bounds.exactCenterY(),
                    mLetterPaint)
        }

        override fun setAlpha(p0: Int) {
        }

        override fun getOpacity(): Int {
            return PixelFormat.OPAQUE
        }

        override fun setColorFilter(p0: ColorFilter?) {
        }

    }

}