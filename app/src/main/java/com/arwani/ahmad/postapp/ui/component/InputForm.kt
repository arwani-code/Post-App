package com.arwani.ahmad.postapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
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
    val focusManager = LocalFocusManager.current
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
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            })
        )
        OutlinedTextField(
            value = email,
            onValueChange = { onEmailChange(it) },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }),
            label = { Text(text = "Email") },
            modifier = modifier.fillMaxWidth(),
        )
        OutlinedTextField(
            value = body,
            onValueChange = { onBodyChange(it) },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            label = { Text(text = "Body") },
            modifier = modifier
                .fillMaxWidth()
                .height(150.dp),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
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