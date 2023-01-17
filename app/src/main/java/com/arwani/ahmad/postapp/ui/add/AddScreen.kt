package com.arwani.ahmad.postapp.ui.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.arwani.ahmad.postapp.ui.component.ItemInputForm

@Composable
fun AddScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var name by remember {
        mutableStateOf( "")
    }
    var email by remember {
        mutableStateOf( "")
    }
    var body by remember {
        mutableStateOf( "")
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
                    Text(
                        modifier = modifier.padding(horizontal = 8.dp),
                        text = "Add Posts",
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
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
            ItemInputForm(
                onNameChange = { name = it },
                onEmailChange = { email = it },
                onBodyChange = { body = it },
                name = name,
                email = email,
                body = body,
                canUpdatePosts = false
            )
        }
    }
}