package com.alexmumo.movies.ui.screens.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.alexmumo.domain.models.Movie
import com.alexmumo.movies.ui.components.MovieInfo
import com.alexmumo.movies.ui.components.PopularMoviesCard
import com.alexmumo.movies.ui.components.PopularMoviesUI
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.compose.getViewModel

class MovieState(
    var isLoading: Boolean = false,
    val movieList: Flow<PagingData<Movie>>? = null,
    val errorMessage: String = ""
)

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = getViewModel()
) {
    val state = viewModel.popularMovies.value
    val lazyGridState = rememberLazyGridState()
    val popular = state?.collectAsLazyPagingItems()
    popular.let { items ->
        MovieGridList(
            items = items!!,
            lazyGridState
        )
    }
}

@Composable
fun PopularMovieList(
    items: LazyPagingItems<Movie>,
    listState: LazyListState = rememberLazyListState()
) {
    LazyColumn(
        state = listState,
        modifier = Modifier
    ) {
        items(items) { movie ->
            PopularMoviesUI(
                movie = movie!!,
                modifier = Modifier.animateContentSize()
            )
        }
    }
}

@Composable
fun MovieGrid(
    movie: Movie,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PopularMoviesCard(
                movieString = movie.backdropPath!!,
                modifier = Modifier.fillMaxWidth(0.6f)
            )
            MovieInfo(
                movie = movie,
                alignment = Alignment.CenterHorizontally
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MovieGridList(
    items: LazyPagingItems<Movie>,
    gridState: LazyGridState = rememberLazyGridState(),
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        state = gridState
    ) {
        items(items.itemCount) { index ->
            items[index]?.let {
                MovieGrid(
                    movie = it,
                    modifier = Modifier.animateContentSize()
                )
            }
        }
    }
}
