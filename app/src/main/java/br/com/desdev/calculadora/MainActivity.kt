package br.com.desdev.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow
import java.lang.Math.sqrt

class MainActivity : AppCompatActivity() {
    var valor1 : Double = 0.0
    var valor2 : Double = 0.0
    var total : Double = 0.0

    lateinit var operador : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        telavalor.setText("")

        limparc.setOnClickListener{
            var txttela = telavalor.text.toString()
            if(txttela.length > 0){
                telavalor.setText(txttela.substring(0,txttela.length - 1))
            }
        }

        limparce.setOnClickListener {
            telavalor.setText("")
        }

    }

    fun igual(view : View){
        //Segundo valor que foi pego da calculadora
        this.valor2 = telavalor.text.toString().toDouble()

        //Teste para conta de somar
        if(operador.equals("+")){
            this.total = this.valor1 + this.valor2 // faz a operação de soma e retorna o valor em total
            telavalor.setText(total.toString()) // atribui valor final a telavalor : TextView

            // Teste para conta de multiplicar
        }else if(operador.equals("*")){
            this.total = this.valor1 * this.valor2 // faz a operação de multiplicação e retorna o valor em total
            telavalor.setText(this.total.toString()) // atribui valor final a telavalor : TextView

            // Teste para conta de dividir
        }else if(operador.equals("/")){
            this.total = this.valor1 / this.valor2 // faz a operação de dividir e retorna o valor em total
            telavalor.setText(this.total.toString()) // atribui valor final a telavalor : TextView

            // Teste para conta de potencia
        }else if(operador.equals("p")){
            this.total = pow(this.valor1, this.valor2) // faz a operação de potencia e retorna o valor em total
            telavalor.setText(this.total.toString()) // atribui valor final a telavalor : TextView

            // Teste para conta subtração
        }else{
            this.total = this.valor1 - this.valor2  // faz a operação de subtração e retorna o valor em total
            telavalor.setText(total.toString())  // atribui valor final a telavalor : TextView
        }
    }

    fun valores(view : View){
        val button = view as Button
        var vbt = button.text.toString()
        if(!vbt.equals(soma.text.toString()) && !vbt.equals(menos.text.toString()) && !vbt.equals(vezes.text.toString())
        && !vbt.equals(dividir.text.toString()) && !vbt.equals(raiz.text.toString()) && !vbt.equals(potencia.text.toString())){
            this.telavalor.setText(telavalor.text.toString() + vbt)
        }
    }

    fun valorDois(view : View){

        val button = view as Button
        var vbt = button.text.toString()

        if(vbt.equals(soma.text.toString())){
            this.valor1 = telavalor.text.toString().toDouble()
            telavalor.setText("")
            operador = "+"
        }

        if(vbt.equals(menos.text.toString())){
            this.valor1 = telavalor.text.toString().toDouble()
            telavalor.setText("")
            operador = "-"
        }

        if(vbt.equals(vezes.text.toString())){
            this.valor1 = telavalor.text.toString().toDouble()
            telavalor.setText("")
            operador = "*"
        }

        if(vbt.equals(dividir.text.toString())){
            this.valor1 = telavalor.text.toString().toDouble()
            telavalor.setText("")
            operador = "/"
        }

        if(vbt.equals(raiz.text.toString())){
            this.valor1 = sqrt(telavalor.text.toString().toDouble())
            telavalor.setText(this.valor1.toString())
            operador = "r"
        }

        if(vbt.equals(potencia.text.toString())){
            this.valor1 = telavalor.text.toString().toDouble()
            telavalor.setText("")
            operador = "p"
        }
    }

}
