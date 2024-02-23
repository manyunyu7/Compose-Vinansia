package com.feylabs.vinansia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.feylabs.vinansia.R
import com.feylabs.vinansia.ui.font.interFontFamily
import com.feylabs.vinansia.ui.font.montserratFontFamily
import com.feylabs.vinansia.ui.theme.VinansiaTheme

@Composable
fun UnboxingCard(
    modifier: Modifier = Modifier,
    date: String = "",
    title: String = "",
    link: String = "",
    image:String=""
) {
    Box(modifier) {
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .width(188.dp)
                .height(250.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
        ) {
            Column(modifier = modifier
                .padding(top = 10.dp)
                .fillMaxWidth()) {
                Text(
                    title,
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )
                Text(
                    date,
                    fontFamily = interFontFamily,
                    fontSize = 10.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )
                Box(modifier = Modifier.height(30.dp))
                Image(
                    painter = rememberAsyncImagePainter(
                        image, placeholder = painterResource(
                            id = R.drawable.ref_unboxing
                        )
                    ),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                )
            }

        }
    }
}


@Preview(
    showSystemUi = true
)
@Composable
fun UnboxingCardPreview() {
    VinansiaTheme {
        UnboxingCard(title = "Unboxing CBPE dan Tender Offer Indonesia")
    }
}