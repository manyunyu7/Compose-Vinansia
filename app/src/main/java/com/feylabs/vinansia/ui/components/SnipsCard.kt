package com.feylabs.vinansia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.feylabs.vinansia.R
import com.feylabs.vinansia.ui.font.montserratFontFamily
import com.feylabs.vinansia.ui.font.poppinsFontFamily
import com.feylabs.vinansia.ui.theme.VinansiaTheme

@Composable
fun SnipsCard(
    modifier: Modifier = Modifier,
    image: String = "",
    date: String = "",
    title: String = "",
    link: String = ""
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier.height(100.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        title,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 18.sp,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 20.dp)
                    )
                    Text(
                        date,
                        fontSize = 11.sp,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier
                            .padding(start = 10.dp, end = 20.dp)
                            .padding(top = 2.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        image, placeholder = painterResource(
                            id = R.drawable.ref_unboxing
                        )
                    ),
                    contentScale = ContentScale.FillHeight,
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 8.dp,
                                topEnd = 8.dp,
                                bottomEnd = 8.dp,
                                bottomStart = 8.dp
                            )
                        )
                )
            }

        }
    }
}


@Preview(
    showSystemUi = true
)
@Composable
fun SnipsCardPreview() {
    VinansiaTheme {
        Column {
            SnipsCard(
                date="23 September 2023",
                title="CBPE Private Placement ubah lini bisnis menjadi renewable energy"
            )
        }
    }
}

