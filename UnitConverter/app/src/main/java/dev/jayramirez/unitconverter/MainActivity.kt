package dev.jayramirez.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jayramirez.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {

    //    States
    var inputText by remember {
        mutableStateOf("")
    }
    var outputValue by remember {
        mutableStateOf("0.0")
    }
    var inputUnit by remember {
        mutableStateOf("")
    }
    var outputUnit by remember {
        mutableStateOf("")
    }
    var inputExpanded by remember { mutableStateOf(false) }
    var outputExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember {
        mutableDoubleStateOf(1.00)
    }
    val oConversionFactor = remember {
        mutableDoubleStateOf(1.00)
    }

    fun onCalculate() {
        if(inputText != "" && inputUnit != "" && outputUnit != "") {
            val inputValueDouble = inputText.toDoubleOrNull() ?: 0.0
            val result = (inputValueDouble * conversionFactor.value * 100.0 / oConversionFactor.value).roundToInt() / 100.0
            outputValue = result.toString()
        }
    }

    Column(modifier =  Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Unit Converter", style = MaterialTheme.typography.headlineLarge)

        OutlinedTextField(
            value = inputText,
            onValueChange = {
                inputText = it
                onCalculate()
            },
            label = { Text("Enter Value")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions(onDone = { onCalculate() })
        )

        Row ( verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){

            // Input
            Box {
                Button(onClick = {
                    inputExpanded = true
                }) {
                    if(inputUnit == "") {
                        Text(text = "Select")
                    } else {
                        Text(text = inputUnit)
                    }

                    if (inputExpanded) {
                        Icon(Icons.Default.KeyboardArrowDown, "Arrow Down")
                    } else {
                        Icon(Icons.Default.KeyboardArrowUp, "Arrow Up")
                    }
                }
                DropdownMenu(expanded = inputExpanded, onDismissRequest = {
                    inputExpanded = false
                }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        inputUnit = "Centimeters"
                        inputExpanded = false
                        conversionFactor.value = 0.01
                        onCalculate()
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        inputUnit = "Meters"
                        inputExpanded = false
                        conversionFactor.value = 1.00
                        onCalculate()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        inputUnit = "Feet"
                        inputExpanded = false
                        conversionFactor.value = 0.3048
                        onCalculate()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = {
                        inputUnit = "Millimeters"
                        inputExpanded = false
                        conversionFactor.value = 0.001
                        onCalculate()
                    })
                    
                }
            }
            Spacer(modifier = Modifier.width(20.dp))

            // Output
            Box {
                Button(onClick = {
                outputExpanded = true
                }) {
                    if (outputUnit == "") {
                        Text(text = "Select")
                    } else {
                        Text(text = outputUnit)
                    }


                    if (outputExpanded) {
                        Icon(Icons.Default.KeyboardArrowDown, "Arrow Down")
                    } else {
                        Icon(Icons.Default.KeyboardArrowUp, "Arrow Up")
                    }

                }

                DropdownMenu(expanded = outputExpanded, onDismissRequest = { outputExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        outputUnit = "Centimeters"
                        outputExpanded = false
                        oConversionFactor.value = 0.01
                        onCalculate()
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        outputUnit = "Meters"
                        outputExpanded = false
                        oConversionFactor.value = 1.00
                        onCalculate()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        outputUnit = "Feet"
                        outputExpanded = false
                        oConversionFactor.value = 0.3048
                        onCalculate()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = {
                        outputUnit = "Millimeters"
                        outputExpanded = false
                        oConversionFactor.value = 0.001
                        onCalculate()
                    })

                }
            }
        }

        //Result
        Text("Result: $outputValue", style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}