package com.arwani.ahmad.postapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun ItemInputForm(
    modifier: Modifier = Modifier,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onBodyChange: (String) -> Unit,
    name: String,
    email: String,
    body: String,
    canUpdatePosts: Boolean,
    onUpdatePosts: () -> Unit = {},
    onAddPosts: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { onNameChange(it) },
            label = {
                Text(
                    text = "Name"
                )
            },
            modifier = modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        )
        OutlinedTextField(
            value = email,
            onValueChange = { onEmailChange(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = { Text(text = "Email") },
            modifier = modifier.fillMaxWidth(),
        )
        OutlinedTextField(
            value = body,
            onValueChange = { onBodyChange(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Body") },
            modifier = modifier
                .fillMaxWidth()
                .height(150.dp),
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            if (canUpdatePosts) {
                Button(onClick = { onUpdatePosts() }) {
                    Text(text = "Update Posts")
                }
            } else {
                Button(onClick = { onAddPosts() }) {
                    Text(text = "Add Posts")
                }
            }
        }
    }
}