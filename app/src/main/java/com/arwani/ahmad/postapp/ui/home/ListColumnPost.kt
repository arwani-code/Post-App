package com.arwani.ahmad.postapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arwani.ahmad.postapp.data.local.entity.PostEntity

@Composable
fun ListColumnPosts(
    listPost: List<PostEntity>
) {
    LazyColumn {
        items(items = listPost, key = { it.id }) { posts ->
            PostsItem(posts = posts)
        }
    }
}

@Composable
fun PostsItem(
    modifier: Modifier = Modifier,
    posts: PostEntity
) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .height(90.dp)
            .background(Color.White.copy(0.7f)),
        elevation = 4.dp,
        shape = CircleShape.copy(CornerSize(10.dp))
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = posts.name,
                maxLines = 1,
                style = MaterialTheme.typography.subtitle2,
                color = Color.Black.copy(0.9f)
            )
            Divider(color = Color.Black)
            Text(
                text = posts.body.substring(endIndex = 50, startIndex = 0),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black.copy(0.4f)
            )
        }
    }
}

@Preview
@Composable
fun PostsItemPreview() {
    PostsItem(
        posts = PostEntity(
            name = "d labore ex et quam laborum",
            email = "Eliseo@gardner.biz",
            body = "Laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium\""
        )
    )
}