package com.arwani.ahmad.postapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.arwani.ahmad.postapp.ui.component.ListColumnPosts
import com.arwani.ahmad.postapp.ui.navigation.Screen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(color = MaterialTheme.colors.primary)
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Posts App",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                IconButton(onClick = { navController.navigate(Screen.Search.route) }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search",
                        tint = Color.White
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.Add.route) },
                modifier = modifier.navigationBarsPadding()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add",
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }
    ) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding)) {
            val posts by viewModel.getPosts.observeAsState()
            if (posts?.isEmpty() == true) viewModel.fetchPosts()
            if (posts?.isNotEmpty() == true) ListColumnPosts(
                listPost = posts!!,
                navController = navController
            )
            else {
                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}