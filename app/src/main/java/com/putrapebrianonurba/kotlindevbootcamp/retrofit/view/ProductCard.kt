package com.putrapebrianonurba.kotlindevbootcamp.retrofit.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.putrapebrianonurba.kotlindevbootcamp.retrofit.model.Product
import com.putrapebrianonurba.kotlindevbootcamp.retrofit.utils.PreviewProvider
import com.putrapebrianonurba.kotlindevbootcamp.R

@Composable
fun ProductCard(product: Product) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(Color.Transparent)
            .padding(vertical = 10.dp, horizontal = 15.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp, 10.dp, 50.dp, 10.dp)),
            shape = RoundedCornerShape(10.dp, 10.dp, 50.dp, 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF464545)
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ){
                // Image
                AsyncImage(
                    model = product.thumbnail,
                    contentDescription = product.title,
                    placeholder = painterResource(R.drawable.cookie_1), // 👈 tampil duluan
                    error = painterResource(R.drawable.creator_photo), // error Load
                    modifier = Modifier
                        .padding(15.dp)
                        .size(100.dp),
                    contentScale = ContentScale.Crop,
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = product.title,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 22.sp,
                        color = Color.White
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = product.category.replaceFirstChar { it.uppercase() },
                            color = Color(0xFFFF9800),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "$${product.price}",
                                color = Color.White,
                                textDecoration = TextDecoration.LineThrough,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                            )

                            Text(
                                text = "$${calculateDiscountedPrice(product.price, product.discountPercentage)}",
                                color = Color(0xFFFF9800),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

fun calculateDiscountedPrice(originalPrice: Double, discountPercentage: Double): Double {
    val discounted = originalPrice * (1 - discountPercentage / 100)
    return String.format("%.2f", discounted).toDouble()
}



@Preview(showBackground = true)
@Composable
private fun ProductCardPreview() {
    val product = PreviewProvider.singleProduct
    ProductCard(product)
}