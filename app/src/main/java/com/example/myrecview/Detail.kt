package com.example.myrecview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataUniv = intent.getParcelableExtra<Univ>("key_univ")

        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)
        val tvDetailUkt = findViewById<TextView>(R.id.tv_detail_ukt)
        val tvDetailAlamat = findViewById<TextView>(R.id.tv_detail_alamat)

        if (dataUniv != null) {
            tvDetailName.text = dataUniv.name
            tvDetailDescription.text = dataUniv.description
            ivDetailPhoto.setImageResource(dataUniv.photo)
            tvDetailUkt.text = dataUniv.ukt
            tvDetailAlamat.text = dataUniv.alamat
        }

        val share = findViewById<Button>(R.id.btshare)
        share.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            if (dataUniv != null) {
                intent.putExtra(Intent.EXTRA_TEXT,dataUniv.description)
            }
            val chooser = Intent.createChooser(intent, "Share using...")
            startActivity(chooser)
        }
    }

}

