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
import com.feylabs.vinansia.ui.theme.VinansiaTheme

@Composable
fun UnboxingCard(
    modifier: Modifier = Modifier,
    date: String = "",
    title: String = "",
    link: String = ""
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier.width(200.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
    ) {
        Column(modifier=modifier.padding(top = 10.dp)) {
            Text(
                title,
                fontFamily = montserratFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )
            Text(
                "01 December 2020",
                fontFamily = montserratFontFamily,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )
            Box(modifier = Modifier.height(20.dp))
            Image(
                painter = rememberAsyncImagePainter(
                    "https://www.example.com/image.jpg", placeholder = painterResource(
                        id = R.drawable.ref_unboxing
                    )
                ),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            )
        }

    }
}


@Preview(
    showSystemUi = true
)
@Composable
fun UnboxingCardPreview() {
    VinansiaTheme {
        UnboxingCard(title = "Unboxing CBPE")
    }
}