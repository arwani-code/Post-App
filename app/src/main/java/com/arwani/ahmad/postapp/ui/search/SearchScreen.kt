package com.arwani.ahmad.postapp.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var value by rememberSaveable {
        mutableStateOf("")
    }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    Scaffold(
        topBar = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.primary)
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "arrow_back",
                            tint = Color.White
                        )
                    }
                    OutlinedTextField(
                        value = value,
                        onValueChange = { value = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        modifier = modifier
                            .width(300.dp)
                            .heightIn(min = 25.dp)
                            .focusRequester(focusRequester),
                        singleLine = true,
                        shape = RoundedCornerShape(percent = 30),
                        placeholder = {
                            Text(
                                text = "Search title ...",
                                fontSize = 16.sp,
                                color = Color.White.copy(0.4f)
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            textColor = Color.White,
                            cursorColor = Color.White,
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color.White.copy(0.7f)
                            )
                        },
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus() }
                        ),
                        trailingIcon = {
                            if (value.isNotEmpty()) {
                                IconButton(onClick = { value = "" }) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = "Clear",
                                        tint = Color.White
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

        }
    }
}

