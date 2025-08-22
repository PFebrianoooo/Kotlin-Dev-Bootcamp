package com.putrapebrianonurba.kotlindevbootcamp.uidesign.cookie

import com.putrapebrianonurba.kotlindevbootcamp.R
data class CookieModel(
    val id: Int,
    val image: Int,
    val name: String,
    val normalPrice: Int,
    val price: Int,
    val description: String
)

val cookieRawData = listOf(
    CookieModel(1, R.drawable.cookie_1, "Chocolate\nRaisins", 40, 20, "Lezatnya kue cokelat dipadu kismis manis, sempurna untuk teman minum teh."),
    CookieModel(2, R.drawable.cookie_2, "Oatmeal\nwith Raisins", 80, 40, "Kue oatmeal renyah dengan kismis yang manis, sehat dan cocok untuk sarapan ringan."),
    CookieModel(3, R.drawable.cookie_3, "Chocolate\nChips", 30, 15, "Klasik dan selalu memikat! Kue dengan potongan cokelat yang meleleh di mulut."),
    CookieModel(4, R.drawable.cookie_1, "Double\nChocolate", 20, 10, "Untuk pencinta cokelat sejati, kue dengan rasa cokelat ganda yang kaya dan lembut."),
    CookieModel(5, R.drawable.cookie_2, "Chocolate\nTriple", 32, 18, "Sensasi cokelat maksimal! Kombinasi cokelat padat, chips, dan taburan serut cokelat.")
)
