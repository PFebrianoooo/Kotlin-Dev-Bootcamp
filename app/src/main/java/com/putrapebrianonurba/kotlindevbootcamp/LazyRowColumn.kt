package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.max


@Composable
fun LazyRowColumnBootcamp(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        LazyRow(contentPadding = PaddingValues(top = 25.dp, bottom = 10.dp)) {
            items(languageData) { language ->
                RowItem(
                    modifier = modifier,
                    text = language
                )
            }
        }

        LazyColumn {
            items(languageData) { language ->
                ColumnItem(
                    modifier = modifier,
                    text = language
                )
            }
        }
    }
}

@Composable
fun RowItem(modifier: Modifier, text: String) {
    Card(
        modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp)
            .aspectRatio(1.5f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(modifier.padding(10.dp).fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = text, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ColumnItem(modifier: Modifier, text: String) {
    Card(
        modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentSize()
            .aspectRatio(3f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(modifier.padding(10.dp).fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = text, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun LazyRowWithImage(modifier: Modifier = Modifier) {
    Column(modifier.statusBarsPadding()) {
        Text("Food Catalogue", modifier.padding(start = 12.dp, bottom = 8.dp), fontSize = 28.sp, fontWeight = FontWeight.Bold)

        LazyColumn(contentPadding = PaddingValues(horizontal = 12.dp)) {
            items(foodData) { food ->
                FoodRowColumn(modifier, food )
            }
        }
    }
}

@Composable
fun FoodRowColumn(modifier: Modifier, food: FoodCatalogue) {
    Card(
        modifier.padding(5.dp).wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            // Image
            Image(painterResource(id = food.image), contentDescription = food.catalogue, modifier.size(140.dp).clip(
                RoundedCornerShape(topEnd =  10.dp, bottomEnd = 10.dp)
            ), contentScale = ContentScale.FillBounds)
            // Catalogue & Ingredients
            Column(modifier.padding(12.dp),horizontalAlignment = Alignment.Start) {
                Text(food.catalogue, fontWeight = FontWeight.Bold, fontSize = 18.sp, letterSpacing = 5.sp)

                Text(food.ingredients, fontWeight = FontWeight.Light, fontSize = 16.sp, maxLines = 2, overflow = TextOverflow.Ellipsis)

            }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun LazyRowColumnPreview() {
    // LazyRowColumnBootcamp()
    LazyRowWithImage()
}

data class FoodCatalogue(
    val id: Int,
    val image: Int,
    val catalogue: String,
    val ingredients: String
)
val languageData = arrayOf(
    "Kotlin",
    "C++",
    "Java",
    "Javascript",
    "Swift",
    "Ruby",
    "Heskell",
    "C Lang",
    "C+",
    "Rust",
    "Python",
    "HTML",
    "XML",
    "Dart",
    "SwiftUI"
)
private val foodData = arrayOf(
    FoodCatalogue(
        id = 1,
        image = R.drawable.creator_photo,
        catalogue = "Vegan",
        ingredients = "Tomato sauce, oregano and peperoni"
    ),
    FoodCatalogue(
        id = 2,
        image = R.drawable.creator_photo,
        catalogue = "Pepperoni",
        ingredients = "Tomato sauce, cheese, oregano, and green paprika with baked "
    ),
    FoodCatalogue(
        id = 3,
        image = R.drawable.creator_photo,
        catalogue = "Fourcheese",
        ingredients = "Tomato sauce, oregano and peperoni with added more cheese four cheese"
    ),
    FoodCatalogue(
        id = 4,
        image = R.drawable.creator_photo,
        catalogue = "Margarita",
        ingredients = "Tomato sauce, oregano and peperoni with margarita pizza, so delicious"
    ),
    FoodCatalogue(
        id = 5,
        image = R.drawable.creator_photo,
        catalogue = "American",
        ingredients = "Tomato sauce, oregano and peperoni with american tasted"
    ),
    FoodCatalogue(
        id = 6,
        image = R.drawable.creator_photo,
        catalogue = "Australian",
        ingredients = "Tomato sauce, oregano and peperoni with australian tongue tasted, so deliciooso!"
    ),
    FoodCatalogue(
        id = 7,
        image = R.drawable.creator_photo,
        catalogue = "Australian",
        ingredients = "Tomato sauce, oregano and peperoni with australian tongue tasted, so deliciooso!"
    ),
    FoodCatalogue(
        id = 8,
        image = R.drawable.creator_photo,
        catalogue = "Australian",
        ingredients = "Tomato sauce, oregano and peperoni with australian tongue tasted, so deliciooso!"
    )
)



// Small Summary
/*
Lazy Row & Column Bootcamp
Bedanya lazy row & column dengan row biasa atau column biasa, terdapat pada rendering.
pada common row & column, walaupun gambar tidak terdapat pada layar akan di render dan memory akan boros
lazy hadir dengan penghematan lebih efisien pada manajemen memory. Lazy berteman baik dengan looping

Lazy Row
LazyRow(param) {
    Args
}

Lazy Column
LazyColumn(param) {
    Args
}

yang terdapat pada paramnya
modifier -> Settingan tata letak dan behavior dari konten
state
contentPadding -> Padding untuk konten
reverseLayout -> Scroll Konten dari kiri atau kanan awalannya
horizontalArrangement -> Arrangement konten
verticalAlignment -> Alignment konten
flingBehavior
userScrollEnabled -> Behavior apakah lazy bisa di scroll atau tidak
content -> isi dari lambda/composable element


nb:
1. Bedanya pada allignment & arrangementnya
2. Behavior, Horizontal atau vertical
*/

