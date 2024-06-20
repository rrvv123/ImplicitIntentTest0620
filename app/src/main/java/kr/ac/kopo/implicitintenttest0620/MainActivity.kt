package kr.ac.kopo.implicitintenttest0620

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnCall = findViewById<Button>(R.id.btn_call)
        var btnHome = findViewById<Button>(R.id.btn_home)
        var btnMap = findViewById<Button>(R.id.btn_map)
        var btnSearch = findViewById<Button>(R.id.btn_search)
        var btnSms = findViewById<Button>(R.id.btn_sms)
        var btnCamera = findViewById<Button>(R.id.btn_camera)

        btnCall.setOnClickListener (btnListener)
        btnHome.setOnClickListener (btnListener)
        btnMap.setOnClickListener (btnListener)
        btnSearch.setOnClickListener (btnListener)
        btnSms.setOnClickListener (btnListener)
        btnCamera.setOnClickListener (btnListener)

    }

    val btnListener = View.OnClickListener {
        var uri = Uri.parse("tel:/010-5555-5555")
        var intent = Intent(Intent.ACTION_DIAL, uri)

        when(it.id){
            R.id.btn_call -> {
                uri = Uri.parse("tel:/010-5555-5555")
                intent = Intent(Intent.ACTION_DIAL, uri)
            }
            R.id.btn_home -> {
                uri = Uri.parse("https://www.kopo.ac.kr")
                intent = Intent(Intent.ACTION_VIEW, uri)
            }
            R.id.btn_map -> {
                uri = Uri.parse("https://maps.google.com/map?q=" + 37.5290615 + "," + 126.996542)
                intent = Intent(Intent.ACTION_VIEW, uri)
            }
            R.id.btn_search -> {
                intent = Intent(Intent.ACTION_WEB_SEARCH)
                intent.putExtra(SearchManager.QUERY, "한국폴리텍대학 서울정수캠퍼스 인공지능소프트웨어과")
            }
            R.id.btn_sms -> {
                intent = Intent(Intent.ACTION_SENDTO)
                intent.putExtra("sms_body", "밥한끼 ㄱ?")
                intent.data = Uri.parse("smsto" + Uri.encode("010-5555-7777"))
            }
            R.id.btn_camera -> {
                intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            }
        }

        startActivity(intent)
    }
}