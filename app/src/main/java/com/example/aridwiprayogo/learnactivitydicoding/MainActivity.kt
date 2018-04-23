package com.example.aridwiprayogo.learnactivitydicoding

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private val STATE_HASIL = "state_hasil"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calculate.setOnClickListener(this)
        if (savedInstanceState!=null){
            val hasil = savedInstanceState.getString(STATE_HASIL)
            tv_result.setText(hasil)
        }
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_calculate){
            val lenght = edt_lenght.text.toString().trim()
            val width = edt_widht.text.toString().trim()
            val height = edt_height.text.toString().trim()
            var isEmptyFields = false
            if (TextUtils.isEmpty(lenght)){
                isEmptyFields = true
                edt_lenght.setError("Field ini tidak boleh kosong")
            }
            if (TextUtils.isEmpty(width)){
                isEmptyFields = true
                edt_widht.setError("Field ini tidak boleh kosong")
            }
            if (TextUtils.isEmpty(height)){
                isEmptyFields = true
                edt_height.setError("Field ini tidak boleh kosong")
            }
            if (!isEmptyFields){
                val l: Double =lenght.toDouble()
                val w: Double =width.toDouble()
                val h: Double =height.toDouble()
                val volume : Double = l*w*h
                tv_result.text = volume.toString()
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        outState?.putString(STATE_HASIL, tv_result.text.toString())
        super.onSaveInstanceState(outState, outPersistentState)
    }
}
