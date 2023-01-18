package com.arwani.ahmad.postapp.ui.add

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.arwani.ahmad.postapp.data.local.entity.PostsEntity
import com.arwani.ahmad.postapp.ui.component.ItemInputForm

@Composable
fun AddScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    addViewModel: AddViewModel = hiltViewModel()
) {
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var body by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

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
                canUpdatePosts = false,
                onAddPosts = {
                    if (name.isNotEmpty() && email.isNotEmpty() && body.isNotEmpty()) {
                        addViewModel.addPosts(PostsEntity(name = name, email = email, body = body))
                        navController.navigateUp()
                        mToast(context = context, message = "Successfully added posts")
                    }else {
                        mToast(context = context, message = "Input cannot be left blank")
                    }
                }
            )
        }
    }
}

private fun mToast(context: Context, message: String){
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}