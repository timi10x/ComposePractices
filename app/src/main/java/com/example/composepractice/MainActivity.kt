package com.example.composepractice

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.LayoutDirection
import android.util.Log
import android.view.Surface
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.core.content.ContextCompat.startActivity
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.graphics.Shape
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.Size
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myAppTheme {
                Surface() {
                    ScreenContent()
                }

            }
        }
    }
}

@Composable
fun myApp(children: @Composable() () -> Unit) {
    MaterialTheme {
        Surface(color = Color.DarkGray) {
            children()
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = name, modifier = LayoutPadding(10.dp))
}


@Model
class CounterState(var count: Int = 0)

@Composable
fun Counter(state: CounterState) {
    Button(
        onClick = { state.count++ } ,backgroundColor =
        if (state.count > 5) Color.Green else Color.White
    ) {
        Text("I have been clicked ${state.count} times")
    }
}

@Composable
fun ScreenContent(
    names: List<String> = listOf("timmy", "coder", "jetpack", "compose"),
    counterState: CounterState = CounterState()
) {
    Column(modifier = LayoutHeight.Fill) {
        Column(modifier = LayoutWeight(1f)) {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
        }
        Counter(counterState)
    }
}

@Model
class FormState(var optionChecked: Boolean)

@Composable
fun form(state: FormState) {
    Checkbox(checked = state.optionChecked,
        onCheckedChange = { newState -> state.optionChecked = newState })
}


@Preview("My Screen preview")
@Composable
fun DefaultPreview() {
    myApp {
        ScreenContent()
    }
}