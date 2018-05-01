package br.com.desdev.calculadora

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val listaDeApps = listOf("Calculadora","Cara ou Coroa", "Index 2", "Index 3", "Index 4")

        list_view.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaDeApps)

        list_view.setOnItemClickListener { adapterView, view, int, long ->

            if( int == 0 ){
                var it = Intent(this, MainActivity::class.java)
                startActivity(it)
            }
        }
    }
}
