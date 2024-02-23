package com.feylabs.vinansia.ui.screen.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.feylabs.vinansia.ui.components.SnipsCard
import com.feylabs.vinansia.ui.components.UnboxingCard
import com.feylabs.vinansia.ui.theme.VinansiaTheme


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier, navController: NavController,
    viewModel: SnipsHomeViewModel = hiltViewModel()
) {

    LaunchedEffect(true) {
        viewModel.getSnip()
    }

    Column {
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            UnboxingCard(
                title = "Unboxing NANO"
            )
            UnboxingCard(
                title = "Unboxing NANO"
            )
            UnboxingCard(
                title = "Unboxing NANO"
            )
            UnboxingCard(
                title = "Unboxing NANO"
            )
            UnboxingCard(
                title = "Unboxing NANO"
            )
            UnboxingCard(
                title = "Unboxing NANO"
            )
            UnboxingCard(
                title = "Unboxing NANO"
            )
            UnboxingCard(
                title = "Unboxing NANO"
            )
        }
        SnipSection(viewModel = viewModel)
    }
}


@Composable
fun SnipSection(modifier: Modifier = Modifier, viewModel: SnipsHomeViewModel) {
    viewModel.snipListValue.collectAsState().value.let { state ->
        when {
            state.isLoading -> {
                // Show loading progress
            }


            state.error.isNotBlank() -> {
                // Show error message
            }

            state.snipList.isNotEmpty() -> {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    state.snipList.forEachIndexed { index, snipsUIModel ->
                        SnipsCard(
                            modifier = modifier.padding(
                                top = 10.dp,
                                start = 10.dp,
                                end = 10.dp
                            ),
                            title = snipsUIModel.title,
                            image = snipsUIModel.imageUrl,
                            date = snipsUIModel.description
                        )
                    }
                }
//                Column {
//                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
//                        UnboxingCard(
//                            title = "Unboxing NANO"
//                        )
//                        UnboxingCard(
//                            title = "Unboxing NANO"
//                        )
//                        UnboxingCard(
//                            title = "Unboxing NANO"
//                        )
//                        UnboxingCard(
//                            title = "Unboxing NANO"
//                        )
//                        UnboxingCard(
//                            title = "Unboxing NANO"
//                        )
//                        UnboxingCard(
//                            title = "Unboxing NANO"
//                        )
//                        UnboxingCard(
//                            title = "Unboxing NANO"
//                        )
//                        UnboxingCard(
//                            title = "Unboxing NANO"
//                        )
//                    }
//
//                }
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    VinansiaTheme {
        HomeScreen(navController = rememberNavController())
    }
}