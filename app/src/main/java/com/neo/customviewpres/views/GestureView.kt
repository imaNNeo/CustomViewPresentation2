package com.neo.customviewpres.views

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
class GestureView : View{
    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attributes: AttributeSet) : super(ctx, attributes)
    constructor(ctx: Context, attributes: AttributeSet, defStyle: Int) : super(ctx, attributes, defStyle)

    val gestureDetector = GestureDetector(context, object: GestureDetector.OnGestureListener{
        override fun onShowPress(event: MotionEvent?) {
            Log.d("SS", "onShowPress(${event?.x}, ${event?.y})")
        }

        override fun onSingleTapUp(event: MotionEvent?): Boolean {
            Log.d("SS", "onSingleTapUp(${event?.x}, ${event?.y})")
            return true
        }

        override fun onDown(event: MotionEvent?): Boolean {
            Log.d("SS", "onDown(${event?.x}, ${event?.y})")
            return true
        }

        override fun onFling(event: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
            Log.d("SS", "onFling(${event?.x}, ${event?.y})")
            return true
        }

        override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
            Log.d("SS", "onScroll")
            return true
        }

        override fun onLongPress(event: MotionEvent?) {
            Log.d("SS", "onLongPress(${event?.x}, ${event?.y})")
        }

    })
    val scaleGestureDetector = ScaleGestureDetector(context, object: ScaleGestureDetector.OnScaleGestureListener{
        override fun onScaleBegin(p0: ScaleGestureDetector?): Boolean {
            Log.d("SS", "onScaleBegin")
            return true
        }

        override fun onScaleEnd(p0: ScaleGestureDetector?) {
            Log.d("SS", "onScaleEnd")
        }

        override fun onScale(p0: ScaleGestureDetector?): Boolean {
            Log.d("SS", "onScale")
            return true
        }
    })

    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        return gestureDetector.onTouchEvent(event)
        return scaleGestureDetector.onTouchEvent(event)
    }

}