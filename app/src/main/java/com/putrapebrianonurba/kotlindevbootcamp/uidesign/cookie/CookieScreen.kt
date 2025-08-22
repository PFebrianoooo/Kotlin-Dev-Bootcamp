package com.putrapebrianonurba.kotlindevbootcamp.uidesign.cookie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.putrapebrianonurba.kotlindevbootcamp.R

@Composable
fun CookieAppMain() {
    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = { FabButton() },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.Black)
                .verticalScroll(rememberScrollState()),
        ) {
            premiumCookieSection()

            offersCookie()
        }
    }
}

@Composable
private fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .height(85.dp)
            .background(Color.DarkGray)
            .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // User Information
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // User Image
            Image(
                painter = painterResource(R.drawable.creator_photo),
                contentDescription = "profile_photo",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(65.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.LightGray, CircleShape)
            )

            // Username
            Text(
                text = "Putra\nPebriano",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = modifier
                    .padding(start = 8.dp),
                color = Color.White,
                lineHeight = 14.sp
            )
        }

        // Cart
        Box(
            modifier = modifier
                .clickable(onClick = { /*TODO*/ })
                .size(32.dp)
                .clip(RoundedCornerShape(7.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "cart",
                tint = Color.Black,
                modifier = modifier.size(24.dp)
            )
        }
    }
}

@Composable
private fun FabButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(35.dp)
        ) {
            // Home
            Box(
                modifier = modifier
                    .clickable(onClick = { /*TODO*/ })
                    .size(50.dp)
                    .clip(RoundedCornerShape(7.dp))
                    .background(Color.DarkGray)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(7.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "home",
                    tint = Color.White,
                    modifier = modifier.size(40.dp)
                )
            }

            // Search
            Box(
                modifier = modifier
                    .clickable(onClick = { /*TODO*/ })
                    .size(50.dp)
                    .clip(RoundedCornerShape(7.dp))
                    .background(Color.DarkGray)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(7.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "search",
                    tint = Color.White,
                    modifier = modifier.size(40.dp)
                )
            }

            // Preview
            Box(
                modifier = modifier
                    .clickable(onClick = { /*TODO*/ })
                    .size(50.dp)
                    .clip(RoundedCornerShape(7.dp))
                    .background(Color.DarkGray)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(7.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "favorites",
                    tint = Color.White,
                    modifier = modifier.size(40.dp)
                )
            }
        }
    }
}

@Composable
private fun premiumCookieSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Cookies",
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            modifier = modifier
                .padding(start = 12.dp, top = 15.dp)
        )

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Premium",
                color = Color(0xFFFF9800),
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )

            Text(
                text = "See More",
                color = Color(0xFFFF9800),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            )
        }

        LazyRow(
            contentPadding = PaddingValues(vertical = 10.dp, horizontal = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            itemsIndexed(cookieRawData) { index, cookie ->
                premiumCookiesCard(cookieModel = cookie)
            }
        }
    }
}

@Composable
private fun offersCookie(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Offers",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp
            )

            Text(
                text = "See More",
                // modifier = modifier.clickable(onClick = { /*TODO*/ }),
                color = Color(0xFFFF9800),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            )
        }
        
        cookieRawData.forEachIndexed{ index, cookieModel -> 
            offersCookiesCard(cookieModel = cookieModel)
        }
    }
}

@Composable
private fun premiumCookiesCard(modifier: Modifier = Modifier, cookieModel: CookieModel) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier = modifier
                .padding(top = 120.dp)
                .width(150.dp)
                .height(140.dp)
                .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp, 10.dp, 80.dp, 10.dp)),
            shape = RoundedCornerShape(10.dp, 10.dp, 80.dp, 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF464545)
            ),
        ) {
            Column(
                modifier = modifier.padding(start = 15.dp, top = 20.dp)
            ){
                Text(
                    text = cookieModel.name,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 26.sp,
                    color = Color.White
                )

                Text(
                    text = "Premium Chips",
                    color = Color(0xFFFF9800),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )

                Text(
                    text = "$${cookieModel.price}",
                    color = Color(0xFFFF9800),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        // Image
        Image(
            painter = painterResource(cookieModel.image),
            contentDescription = cookieModel.image.toString(),
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(150.dp)
        )

        // Button
        IconButton(
            onClick = { /*TODO*/ },
            modifier = modifier
                .size(34.dp)
                .clip(CircleShape)
                .background(Color.Black)
                .border(1.dp, Color.LightGray, CircleShape)
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                contentDescription = "arrowForward",
                tint = Color.White,
                modifier = modifier.size(24.dp)
            )
        }
    }
}

@Composable
private fun offersCookiesCard(modifier: Modifier = Modifier, cookieModel: CookieModel) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .background(Color.Transparent)
            .padding(vertical = 10.dp, horizontal = 15.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Card(
            modifier = modifier
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
                Image(
                    painter = painterResource(cookieModel.image),
                    contentDescription = cookieModel.image.toString(),
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(120.dp)
                )
                Column(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = cookieModel.name,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 26.sp,
                        color = Color.White
                    )

                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Premium Chips",
                            color = Color(0xFFFF9800),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "$${cookieModel.normalPrice}",
                                color = Color.White,
                                textDecoration = TextDecoration.LineThrough,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                            )

                            Text(
                                text = "$${cookieModel.price}",
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

@Preview(showBackground = true)
@Composable
private fun CookieScreenPreview() {
    CookieAppMain()
}