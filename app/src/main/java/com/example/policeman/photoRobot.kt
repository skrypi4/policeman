package com.example.policeman

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.MotionEventCompat
import com.felipecsl.gifimageview.library.GifImageView
import java.io.ByteArrayInputStream
import java.lang.Exception

class photoRobot : AppCompatActivity() {

    private val mImageTop = arrayOf<Int>(R.drawable.shrek21, R.drawable.shrek, R.drawable.thinking_top, R.drawable.angel_top, R.drawable.confused1_top, R.drawable.confused2_top, R.drawable.baby_top, R.drawable.babyboy_top, R.drawable.furious_top, R.drawable.happy4_top, R.drawable.hungry_top, R.drawable.kiss1_top, R.drawable.muted4_top, R.drawable.nerd_top, R.drawable.sad_top, R.drawable.smart_top, R.drawable.sweat_top, R.drawable.zombie_top, R.drawable.thinking2_top, R.drawable.tongue2_top, R.drawable.tongue3_top, R.drawable.lol)
    private val mImageMiddle = arrayOf<Int>(R.drawable.shrek22, R.drawable.shrek2, R.drawable.thinking_middle, R.drawable.angel_middle, R.drawable.confused1_middle, R.drawable.confused2_middle, R.drawable.baby_middle, R.drawable.babyboy_middle, R.drawable.furious_middle, R.drawable.happy4_middle, R.drawable.hungry_middle, R.drawable.kiss1_middle, R.drawable.muted4_middle, R.drawable.nerd_middle, R.drawable.sad_middle, R.drawable.smart_middle, R.drawable.sweat_middle, R.drawable.zombie_middle, R.drawable.thinking2_middle, R.drawable.tongue2_middle, R.drawable.tongue3_middle, R.drawable.lol2)
    private val mImageBottom = arrayOf<Int>(R.drawable.shrek23, R.drawable.shrek3, R.drawable.thinking_bottom, R.drawable.angel_bottom, R.drawable.confused1_bottom, R.drawable.confused2_bottom, R.drawable.baby_bottom, R.drawable.babyboy_bottom, R.drawable.furious_bottom, R.drawable.happy4_bottom, R.drawable.hungry_bottom, R.drawable.kiss1_bottom, R.drawable.muted4_bottom, R.drawable.nerd_bottom, R.drawable.sad_bottom, R.drawable.smart_bottom, R.drawable.sweat_bottom, R.drawable.zombie_bottom, R.drawable.thinking2_bottom, R.drawable.tongue2_bottom, R.drawable.tongue3_bottom, R.drawable.lol3)

    var bytes: ByteArray? = null

    var imageView: ImageView? = null
    var startXValue = 1f
    var id1: Int = 0
    var id2: Int = 0
    var id3: Int = 0
    private var shruk: Boolean = false
    private var shruk2: Boolean = false
    private var shruk3: Boolean = false
    private var shrukAndSport: Boolean = false
    private var shrukAndSport2: Boolean = false
    private var shrukAndSport3: Boolean = false



    var GifkaView: GifImageView? = null

    fun loadGIF(gif:GifImageView, name: String){
        if(bytes != null){
            return
        }
        try {
            var inputStream = baseContext.assets.open(name)
            bytes =  ByteArray(inputStream.available())
            inputStream.read(bytes)
            gif.setBytes(bytes)
            gif.startAnimation()
        }
        catch (E: Exception){
            Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show()



        }
    }

   private fun shrukFull(){
        val handler = Handler().postDelayed(Runnable {
            if (shruk && shruk2 && shruk3) {
                loadGIF(GifkaView!!, "shrukg.gif")
                GifkaView?.visibility = View.VISIBLE
                var imageView1 = findViewById<ImageView>(R.id.imageViewTop)
                var imageView2 = findViewById<ImageView>(R.id.imageViewMiddle)
                var imageView3 = findViewById<ImageView>(R.id.imageViewBottom)

                imageView1.visibility = View.INVISIBLE
                imageView2.visibility = View.INVISIBLE
                imageView3.visibility = View.INVISIBLE
                Toast.makeText(this, "Вы разблокировали шрека", Toast.LENGTH_LONG).show()
            }

        }, 3000)
    }

   private fun antiShrek(){
        val handler = Handler().postDelayed(Runnable {
            GifkaView?.visibility = View.INVISIBLE
            var imageView1 = findViewById<ImageView>(R.id.imageViewTop)
            var imageView2 = findViewById<ImageView>(R.id.imageViewMiddle)
            var imageView3 = findViewById<ImageView>(R.id.imageViewBottom)
            imageView1.visibility = View.VISIBLE
            imageView2.visibility = View.VISIBLE
            imageView3.visibility = View.VISIBLE
            Toast.makeText(this, "Вы молодец", Toast.LENGTH_SHORT).show()
        }, 15000)
    }

    private fun shrekNaSporte(){
        val handler = Handler().postDelayed(Runnable {
            GifkaView?.visibility = View.VISIBLE
            loadGIF(GifkaView!!, "Shrek2.gif")
        }, 1000)
    }

    private fun shrekUstal(){
        val handler = Handler().postDelayed(Runnable {
        GifkaView?.visibility = View.INVISIBLE
        }, 1500)
    }


    //@SuppressLint("ClickableViewAccessibility")
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_robot)
        var imageView1 = findViewById<ImageView>(R.id.imageViewTop)
        var imageView2 = findViewById<ImageView>(R.id.imageViewMiddle)
        var imageView3 = findViewById<ImageView>(R.id.imageViewBottom)

        GifkaView = findViewById(R.id.gif1)

        imageView1?.setImageResource(mImageTop[2])
        imageView2?.setImageResource(mImageMiddle[2])
        imageView3?.setImageResource(mImageBottom[2])

        //верх
        imageView1?.setOnTouchListener { v, event ->

            var endXValue = 0f
            val x1 = event.getAxisValue(MotionEvent.AXIS_X)
            val action = MotionEventCompat.getActionMasked(event)
            return@setOnTouchListener when (action) {
                MotionEvent.ACTION_DOWN -> {
                    startXValue = event.getAxisValue(MotionEvent.AXIS_X)
                    true
                }
                MotionEvent.ACTION_UP -> {
                    endXValue = event.getAxisValue(MotionEvent.AXIS_X)
                    if (endXValue > startXValue) {
                        if (endXValue - startXValue > 250) {
                            imageView1?.setImageResource(mImageTop[id1])

                            //шрук кружится
                            if (mImageTop[id1] == R.drawable.shrek) {
                                shruk = true
                                if (shruk && shruk2 && shruk3) {
                                    shrukFull()
                                    antiShrek()
                                }
                            } else {
                                shruk = false
                            }
                            //шрук бегает
                            if (mImageTop[id1] == R.drawable.shrek21) {
                                shrukAndSport = true
                                if (shrukAndSport && shrukAndSport2 && shrukAndSport3) {
                                    shrekNaSporte()
                                    shrekUstal()
                                }
                            } else {
                                    shrukAndSport = false
                                }

                            id1++

                            if (id1 == mImageTop.size) {
                                id1 = 0
                            }

                        }
                    } else {
                        if (startXValue - endXValue > 250) {
                            imageView1?.setImageResource(mImageTop[id1])
                            id1--
                            if (id1 < 0) {
                                id1 = mImageTop.size - 1
                            }
                        }
                    }
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        //середина
        imageView2?.setOnTouchListener { v, event ->

            var endXValue = 0f
            val x1 = event.getAxisValue(MotionEvent.AXIS_X)
            val action = MotionEventCompat.getActionMasked(event)
            return@setOnTouchListener when (action) {
                MotionEvent.ACTION_DOWN -> {
                    startXValue = event.getAxisValue(MotionEvent.AXIS_X)
                    true
                }
                MotionEvent.ACTION_UP -> {
                    endXValue = event.getAxisValue(MotionEvent.AXIS_X)
                    if (endXValue > startXValue) {
                        if (endXValue - startXValue > 250)  {
                            imageView2?.setImageResource(mImageMiddle[id2])
                            if (mImageMiddle[id2] == R.drawable.shrek2) {
                                shruk2 = true
                                if (shruk && shruk2 && shruk3) {
                                    shrukFull()
                                    antiShrek()
                                }
                            } else {
                                shruk2 = false
                            }
                            //шрук бегает
                            if (mImageMiddle[id2] == R.drawable.shrek22) {
                                shrukAndSport2 = true
                                if (shrukAndSport && shrukAndSport2 && shrukAndSport3) {
                                    shrekNaSporte()
                                    shrekUstal()
                                }
                            } else {
                                    shrukAndSport2 = false
                                }

                            id2++

                            if ( id2 == mImageMiddle.size){
                                id2 = 0
                            }
                        }
                    } else {
                        if (startXValue - endXValue > 250) {
                            imageView2?.setImageResource(mImageMiddle[id2])
                            id2--
                            if (id2 < 0){
                                id2 = mImageMiddle.size - 1
                            }
                        }
                    }
                    true
                }
                else -> super.onTouchEvent(event)
            }

        }

        //Низ
        imageView3?.setOnTouchListener { v, event ->

            var endXValue = 0f
            val x1 = event.getAxisValue(MotionEvent.AXIS_X)
            val action = MotionEventCompat.getActionMasked(event)
            return@setOnTouchListener when (action) {
                MotionEvent.ACTION_DOWN -> {
                    startXValue = event.getAxisValue(MotionEvent.AXIS_X)
                    true
                }
                MotionEvent.ACTION_UP -> {
                    endXValue = event.getAxisValue(MotionEvent.AXIS_X)
                    if (endXValue > startXValue) {
                        if (endXValue - startXValue > 250)  {
                            imageView3?.setImageResource(mImageBottom[id3])
                            if (mImageBottom[id3] == R.drawable.shrek3) {
                                shruk3 = true
                                if (shruk && shruk2 && shruk3) {
                                    shrukFull()
                                    antiShrek()
                                }
                            } else {
                                shruk3 = false
                            }
                            //шрук бегает
                            if (mImageBottom[id3] == R.drawable.shrek23) {
                                shrukAndSport3 = true
                                if (shrukAndSport && shrukAndSport2 && shrukAndSport3) {
                                    shrekNaSporte()
                                    shrekUstal()
                                }
                            } else {
                                    shrukAndSport3 = false
                                }

                            id3++

                            if ( id3 == mImageBottom.size){
                                id3 = 0
                            }
                        }
                    } else {
                        if (startXValue - endXValue > 250) {
                            imageView3?.setImageResource(mImageBottom[id3])
                            id3--
                            if (id3 < 0){
                                id3 = mImageBottom.size - 1
                            }

                        }
                    }
                    true
                }
                else -> super.onTouchEvent(event)
            }

       }

        var fon = findViewById<ImageView>(R.id.imageView3)
        var textForHelp = findViewById<TextView>(R.id.textView9)
        var textToProdolzhit = findViewById<TextView>(R.id.textView10)

        fon.setOnClickListener {

            textForHelp.visibility = View.GONE
            fon.visibility = View.GONE
            textToProdolzhit.visibility = View.GONE
        }




        }
    }
