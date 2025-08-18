package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextBootcamp() {
    // resource font
    // val courgette = FontFamily(Font(R.font.courgette))

    // Text("Text Bootcamp Example")
    /*
    Text(
        stringResource(id = R.string.text_bootcamp_example).repeat(10),
        modifier = Modifier.background(Color.Magenta).width(400.dp),
        color = Color.Blue,
        fontSize = 25.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 5.sp,
        textDecoration = TextDecoration.LineThrough,
        textAlign = TextAlign.Center,
        lineHeight = 20.sp,
        maxLines = 4,
        overflow = TextOverflow.Ellipsis
    )
    */

    /*
    Text(buildAnnotatedString {
        withStyle(style = ParagraphStyle(
            textIndent = TextIndent(firstLine = 20.sp)
        )) {
            withStyle(style = SpanStyle(
                color = Color.Magenta,
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold
            )){
                append("P")
            }

            append("utra")

            withStyle(style = SpanStyle(
                color = Color.Magenta,
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold
            )){
                append("P")
            }
            append("ebriano")
        }
        append("ebriano")
        append("ebriano")
        append("ebriano")
        }
    )
    */

    // Pixel Developer
    Text(
        text = "Text Bootcamp Example, this example from Pixel Dev",
        style = TextStyle(
            color = Color.Magenta,
            fontSize = 25.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Cursive,
            letterSpacing = 5.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            lineHeight = 18.sp,
        ),
        maxLines = 2
    )
}

@Preview(showBackground = true)
@Composable
fun TextBootcampPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        TextBootcamp()
    }
}

// Small Summary
/*
Text Bootcamp
Text merupakan sebuah fungsi yang ada pada jetpack compose yang digunakan untuk memperjelas sebuah konten
dalam konteks text bootcamp kita akan belajar bagaimana membuat sebuah teks dan styling text

Syntax Dasar
1. Text(text = value )
2. Text(StringResource())

Resource
1. Menambahkan Resource string constant
2. Menambahkan font Family
*/