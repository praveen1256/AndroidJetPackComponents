package com.example.jetpackcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            counterScreen()
        }
    }
}
@Composable
@Preview(showBackground=true, showSystemUi = true)
fun counterScreen(){
    var counter by remember { mutableStateOf(1) }
    Column {
        countLabel()
        countValue(value = counter)
        counterGetButtons(onIncrement = { counter++ })
        getValueLabel(value = counter)
    }
}

@Composable
fun countLabel(){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ){
        Text(
            fontSize = 25.sp,
            text = "Here is the count value"
        )
    }
}

@Composable
fun countValue(value : Number){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ){
        Text(
            fontSize = 25.sp,
            text = "Counter Value is : $value"
        )
    }
}

@Composable
fun getValueLabel(value : Number){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ){
        Text(
            fontSize = 25.sp,
            text = "Value is $value"
        )
    }
}

@Composable
fun counterGetButtons(onIncrement: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(onClick = onIncrement) {
            Text(text = "Increment")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Get Count Value")
        }
    }
}