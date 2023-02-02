package com.example.travelcost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.travelcost.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btn_calculate){
            calculate()
        }
    }

    private fun isValid(): Boolean{
        return(binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editKm.text.toString() != ""
                && binding.editKm.text.toString().toFloat() != 0f)
    }

    private fun calculate(){
if(isValid()) {
    val distance = binding.editDistance.text.toString().toFloat()
    val price = binding.editPrice.text.toString().toFloat()
    val consumption = binding.editKm.text.toString().toFloat()

    val totalValue = (distance * price) / consumption
    binding.textTotal.text = "€ ${"%.2f".format(totalValue)}"
    }else{
    Toast.makeText(this,R.string.validation_field, Toast.LENGTH_SHORT).show()
    }
}


}