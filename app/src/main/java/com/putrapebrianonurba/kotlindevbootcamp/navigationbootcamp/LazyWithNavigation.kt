package com.putrapebrianonurba.kotlindevbootcamp.navigationbootcamp

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.putrapebrianonurba.kotlindevbootcamp.R

@Composable
fun LazyWithNavigationHost() {
    // Nav Controller
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "product") {
        lazyWithNavigationGraph(navController)
    }
}

private fun NavGraphBuilder.lazyWithNavigationGraph(navController: NavController) {
    composable(route = "product") {
        LazyRowWithImage(navController = navController)
    }

    composable(
        route = "product-detail/{id}",
        arguments = listOf(navArgument("id") { type = NavType.IntType })
    ) { backstackEntry ->
        val id = backstackEntry.arguments?.getInt("id")
        val food = foodData.find { it.id == id }

        FoodDetail(navController, food)
    }
}

// VIEWS
@Composable
private fun LazyRowWithImage(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier.statusBarsPadding()) {
        Text("Food Catalogue", modifier.padding(start = 12.dp, bottom = 8.dp), fontSize = 28.sp, fontWeight = FontWeight.Bold)

        LazyColumn(contentPadding = PaddingValues(horizontal = 12.dp)) {
            items(foodData) { food ->
                FoodRowColumn(
                    food = food,
                    modifier = modifier
                        .clickable(true, onClick = {
                            navController.navigate("product-detail/${food.id}")
                        })
                )
            }
        }
    }
}

@Composable
private fun FoodRowColumn(modifier: Modifier, food: FoodCatalogues) {
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

@Composable
private fun FoodDetail(navController: NavController, food: FoodCatalogues?, modifier: Modifier = Modifier) {
    if (food == null)  return
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize().padding(10.dp)) {
        Image(painterResource(id = food.image), contentDescription = food.catalogue, modifier.height(250.dp).width(200.dp).clip(RoundedCornerShape(10)), contentScale = ContentScale.FillBounds)

        Spacer(modifier = modifier.size(50.dp))

        Text(food.catalogue, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)

        Spacer(modifier = modifier.size(50.dp))

        Text("Ingredients", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        Text(food.ingredients, fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = modifier.size(50.dp))

        Text("Description", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        Text(food.descriptions, fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = modifier.size(50.dp))

        Button(onClick = { navController.popBackStack()} ) {
            Text("Back to Food Catalogue")
        }

    }
}

// PREVIEW
@Preview(showBackground = true)
@Composable
fun LazyRowNavigationPreview() {
    val navController = rememberNavController()
    LazyRowWithImage(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun LazyRowNavigationDetailPreview() {
    val navController = rememberNavController()
    FoodDetail(navController, foodData[1])
}


// DATA MANAGEMENT
private data class FoodCatalogues(
    val id: Int,
    val image: Int,
    val catalogue: String,
    val ingredients: String,
    val descriptions: String
)
private val foodData = listOf(
    FoodCatalogues(
        id = 1,
        image = R.drawable.creator_photo,
        catalogue = "Vegan",
        ingredients = "Tomato sauce, oregano and peperoni",
        descriptions = "Lorem ipsum sin dolor amet sun consictum pul amenricando abracandowillo micro sarabdu turanga abarakadabra latoingo"
    ),
    FoodCatalogues(
        id = 2,
        image = R.drawable.creator_photo,
        catalogue = "Pepperoni",
        ingredients = "Tomato sauce, cheese, oregano, and green paprika with baked ",
        descriptions = "Lorem ipsum sin dolor amet sun consictum pul amenricando abracandowillo micro sarabdu turanga abarakadabra latoingo"
    ),
    FoodCatalogues(
        id = 3,
        image = R.drawable.creator_photo,
        catalogue = "Fourcheese",
        ingredients = "Tomato sauce, oregano and peperoni with added more cheese four cheese",
        descriptions = "Lorem ipsum sin dolor amet sun consictum pul amenricando abracandowillo micro sarabdu turanga abarakadabra latoingo"
    ),
    FoodCatalogues(
        id = 4,
        image = R.drawable.creator_photo,
        catalogue = "Margarita",
        ingredients = "Tomato sauce, oregano and peperoni with margarita pizza, so delicious",
        descriptions = "Lorem ipsum sin dolor amet sun consictum pul amenricando abracandowillo micro sarabdu turanga abarakadabra latoingo"
    ),
    FoodCatalogues(
        id = 5,
        image = R.drawable.creator_photo,
        catalogue = "American",
        ingredients = "Tomato sauce, oregano and peperoni with american tasted",
        descriptions = "Lorem ipsum sin dolor amet sun consictum pul amenricando abracandowillo micro sarabdu turanga abarakadabra latoingo"
    ),
    FoodCatalogues(
        id = 6,
        image = R.drawable.creator_photo,
        catalogue = "Australian",
        ingredients = "Tomato sauce, oregano and peperoni with australian tongue tasted, so deliciooso!",
        descriptions = "Lorem ipsum sin dolor amet sun consictum pul amenricando abracandowillo micro sarabdu turanga abarakadabra latoingo"
    ),
    FoodCatalogues(
        id = 7,
        image = R.drawable.creator_photo,
        catalogue = "Australian",
        ingredients = "Tomato sauce, oregano and peperoni with australian tongue tasted, so deliciooso!",
        descriptions = "Lorem ipsum sin dolor amet sun consictum pul amenricando abracandowillo micro sarabdu turanga abarakadabra latoingo"
    ),
    FoodCatalogues(
        id = 8,
        image = R.drawable.creator_photo,
        catalogue = "Australian",
        ingredients = "Tomato sauce, oregano and peperoni with australian tongue tasted, so deliciooso!",
        descriptions = "Lorem ipsum sin dolor amet sun consictum pul amenricando abracandowillo micro sarabdu turanga abarakadabra latoingo"
    )
)