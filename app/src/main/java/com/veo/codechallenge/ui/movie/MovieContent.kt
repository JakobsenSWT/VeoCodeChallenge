package com.veo.codechallenge.ui.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.veo.codechallenge.R

@Composable
@OptIn(ExperimentalMaterialApi::class)
internal fun MovieContent(
    viewData: MovieViewData,
    onRefresh: () -> Unit = { },
    onDetailsClick: () -> Unit = { }
) {

    val state = rememberPullRefreshState(refreshing = viewData.isLoading, onRefresh = onRefresh)

    Box(modifier = Modifier.pullRefresh(state = state)) {

        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Blog posts",
                modifier = Modifier.padding(vertical = 24.dp),
                fontSize = 36.sp
            )

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 21.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                itemsIndexed(
                    items = emptyList<Any>(),
                    key = { _, _ ->  }
                ) { page, movie ->

                    MoviePosterContent(
                        onDetailsClick = onDetailsClick
                    )
                }
            }
        }

        PullRefreshIndicator(
            refreshing = viewData.isLoading,
            state = state,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

@Composable
private fun MoviePosterContent(
    onDetailsClick: () -> Unit = { }
) {
    Card(
        modifier = Modifier.clickable { onDetailsClick() },
        shape = RoundedCornerShape(12.dp),
    ) {
        Column {
            AsyncImage(
                model = "",
                contentDescription = null
            )

            Column(Modifier.padding(12.dp)) {

                Text(
                    text = "title",
                    fontSize = 16.sp,
                    lineHeight = 20.sp
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.height(IntrinsicSize.Min),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "overview",
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 12.sp,
                            maxLines = 1
                        )

                        Divider(modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp))

                        Text(
                            text = "release date",
                            fontSize = 12.sp,
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Details",
                            color = MaterialTheme.colors.primary,
                            fontSize = 12.sp
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = "Details about title",
                            tint = MaterialTheme.colors.primary
                        )
                    }
                }
            }
        }
    }
}