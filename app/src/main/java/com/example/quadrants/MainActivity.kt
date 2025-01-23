package com.example.quadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.graphics.Color


import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quadrants.ui.theme.QuadrantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PresentRows()
                }
            }

        }
    }
}

@Composable
fun Quadrant(title : String, desc : String, backgroundColor : Color, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            //.fillMaxWidth()
            //.fillMaxHeight()
            .fillMaxSize()
            .padding(1.dp)
            .background(backgroundColor)
    ) {
            Text(
                text = title,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(15.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = desc,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(15.dp)
                    .align(Alignment.CenterHorizontally)
            )
    }

}

@Composable
fun PresentRows(){
    Column(
//      verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
       // Modifier.fillMaxWidth() can use this as well
    ) {
        Row(Modifier.weight(1f)) {
            // passing the modifier weight as a parameter to the
            Quadrant(stringResource(R.string.text_composable), stringResource(R.string.text_desc),Color(0xFFEADDFF), modifier = Modifier.weight(1f))
            Quadrant(stringResource(R.string.text_composable), stringResource(R.string.text_desc), Color(0xFFD0BCFF),  modifier = Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)) {
            Quadrant(stringResource(R.string.text_composable), stringResource(R.string.text_desc),Color(0xFFD0BCFF),  modifier = Modifier.weight(1f))
            Quadrant(stringResource(R.string.text_composable),stringResource(R.string.text_desc),Color(0xFFEADDFF) , modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuadrantsTheme {
        //Greeting("Android")
       // Quadrant()
        PresentRows()
    }
}