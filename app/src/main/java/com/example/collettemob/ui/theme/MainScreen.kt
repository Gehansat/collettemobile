package com.example.collettemob.ui

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.collettemob.database.UserRepository

@Composable
fun MainScreen(context: Context) {
    val userRepository = UserRepository(context)

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.padding(8.dp),
            decorationBox = { innerTextField ->
                Box(Modifier.padding(8.dp)) {
                    innerTextField()
                }
            }
        )
        BasicTextField(
            value = age,
            onValueChange = { age = it },
            modifier = Modifier.padding(8.dp),
            decorationBox = { innerTextField ->
                Box(Modifier.padding(8.dp)) {
                    innerTextField()
                }
            }
        )
        Button(onClick = {
            if (name.isNotEmpty() && age.isNotEmpty()) {
                userRepository.addUser(name, age.toInt())
            }
        }) {
            Text(text = "Add User")
        }
    }
}
