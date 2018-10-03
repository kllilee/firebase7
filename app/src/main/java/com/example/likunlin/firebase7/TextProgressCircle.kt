package com.example.likunlin.firebase7

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.activity_fingerprint2.view.*

class TextProgressCircle @JvmOverloads constructor(private val mContext: Context, attr:AttributeSet?=null):View(mContext,attr) {

    val paintBack:Paint = Paint()
    val paintFore:Paint = Paint()
    val paintText:Paint = Paint()
    var lineWidth = 50
    var lineColor = Color.GREEN
    var mTextSize = 50.0f
    lateinit var mRect: RectF
    var mProgress = 0


    init {
        paintBack.isAntiAlias = true
        paintBack.color = Color.LTGRAY
        paintBack.strokeWidth = lineWidth.toFloat()
        paintBack.style = Paint.Style.STROKE

        paintFore.isAntiAlias = true
        paintFore.color = lineColor
        paintFore.strokeWidth = lineWidth.toFloat()
        paintFore.style = Paint.Style.STROKE

        paintText.isAntiAlias = true
        paintText.color = Color.BLUE
        paintText.textSize = mTextSize

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val width = measuredWidth
        val height =measuredHeight
        if(width <=0 || height <=0){
            return
        }
        val diameter = Math.min(width,height)
        mRect = RectF(((width - diameter)/2+lineWidth).toFloat(),((height - diameter)/2+lineWidth).toFloat(),((width + diameter)/2-lineWidth).toFloat(),((height + diameter)/2-lineWidth).toFloat())
        canvas!!.drawArc(mRect,0f,360f,false,paintBack)
        canvas!!.drawArc(mRect,0f,(mProgress*360/100).toFloat(),false,paintFore)
        val text = "${mProgress.toString()}%"
        val rect = Rect()
        paintText.getTextBounds(text,0,text.length,rect)
        val x = getWidth()/2 - rect.centerX()
        val y = getHeight()/2- rect.centerY()
        canvas.drawText(text,x.toFloat(),y.toFloat(),paintText)



    }
    fun setProgress(progress:Int,textSize:Float){
        mProgress=progress
        if(textSize >0){
            mTextSize = textSize
            paintText.textSize = mTextSize
        }
        invalidate()
    }

    fun setProgressStyle(line_width:Int,line_color:Int){
        if(line_width>0){
            lineWidth=line_width
            paintFore.strokeWidth=lineWidth.toFloat()
        }
        if(line_color>0){
            lineColor = line_color
            paintFore.color = lineColor
        }
        invalidate()
    }

    fun setOnNumchange(progress:Int){


    }



}