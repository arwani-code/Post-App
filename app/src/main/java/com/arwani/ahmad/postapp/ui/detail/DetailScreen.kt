package com.arwani.ahmad.postapp.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.arwani.ahmad.postapp.data.local.entity.PostsEntity
import com.arwani.ahmad.postapp.ui.component.ItemInputForm

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    detailViewModel: DetailViewModel = hiltViewModel(),
    navController: NavHostController,
    posts: PostsEntity
) {
    var name by remember {
        mutableStateOf(posts.name + "")
    }
    var email by remember {
        mutableStateOf(posts.email + "")
    }
    var body by remember {
        mutableStateOf(posts.body + "")
    }
    Scaffold(
        topBar = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.primary)
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
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
                        text = "Detail",
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "delete",
                        tint = Color.White
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
                canUpdatePosts = true
            )
        }
    }
}