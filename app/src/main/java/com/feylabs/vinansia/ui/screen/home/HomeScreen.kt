package com.feylabs.vinansia.ui.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.feylabs.core.helper.date.UtilDate.convertIsoDateStringToIndonesianDateString
import com.feylabs.snips.domain.uimodel.SnipsUIModel
import com.feylabs.vinansia.ui.components.SnipsCard
import com.feylabs.vinansia.ui.components.UnboxingCard
import com.feylabs.vinansia.ui.theme.VinansiaTheme


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier, navController: NavController,
    viewModel: SnipsHomeViewModel = hiltViewModel()
) {

    val snipList = remember {
        mutableStateOf<MutableList<SnipsUIModel>>(mutableListOf())
    }


    LaunchedEffect(true) {
        viewModel.getUnboxingStock()
        viewModel.getUnboxingSectoral()
        viewModel.getSnip()
    }

    viewModel.snipListValue.collectAsState().let {
        if (it.value.snipList.isNotEmpty()) {
            snipList.value.addAll(
                it.value.snipList
            )
        }
    }

    LazyColumn() {
        item {
            UnboxingSectoralSection(viewModel = viewModel)
        }
        items(snipList.value) { snipsUiModel ->
            SnipsCard(
                modifier = modifier.padding(
                    top = 10.dp,
                    start = 10.dp,
                    end = 10.dp
                ),
                title = snipsUiModel.title,
                image = snipsUiModel.imageUrl,
                date = snipsUiModel.description
            )
        }
        item {
            UnboxingStockSection(viewModel = viewModel)
        }
    }




}

@Composable
private fun UnboxingSectoralSection(
    viewModel: SnipsHomeViewModel,
    modifier: Modifier = Modifier
) {
    viewModel.unboxingSectoralListValue.collectAsState().value.let { state ->
        when {
            state.isLoading -> {
                // Show loading progress
            }

            state.error.isNotBlank() -> {
                // Show error message
            }

            state.unboxingList.isNotEmpty() -> {
                val idsToFilter =
                    listOf(206, 205, 34, 203, 4, 202, 199, 204) // IDs to filter by
                val unboxingList = state.unboxingList
                    .filter {
                        idsToFilter.contains(it.id)
                    }.sortedBy {
                        idsToFilter.indexOf(it.id)
                    }
                LazyRow() {
                    item {

                    }
                    items(unboxingList) { unboxingUiModel ->
                        UnboxingCard(
                            modifier = modifier.padding(
                                top = 10.dp,
                                start = 5.dp,
                                end = 5.dp
                            ),
                            title = unboxingUiModel.title,
                            image = unboxingUiModel.imageUrl,
                            date = unboxingUiModel.date.convertIsoDateStringToIndonesianDateString()
                        )
                    }
                }

            }
        }
    }
}

@Composable
private fun UnboxingStockSection(
    viewModel: SnipsHomeViewModel,
    modifier: Modifier = Modifier
) {
    viewModel.unboxingStockListValue.collectAsState().value.let { state ->
        when {
            state.unboxingList.isNotEmpty() -> {
                val unboxingList = state.unboxingList
                LazyRow() {
                    item {

                    }
                    items(unboxingList) { unboxingUiModel ->
                        UnboxingCard(
                            modifier = modifier.padding(
                                top = 10.dp,
                                start = 5.dp,
                                end = 5.dp
                            ),
                            title = unboxingUiModel.title,
                            image = unboxingUiModel.imageUrl,
                            date = unboxingUiModel.date.convertIsoDateStringToIndonesianDateString()
                        )
                    }
                }

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