package com.example.jetpackcomposedashboardsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            dashboard()
        }
    }

    @Preview
    @Composable
    fun dashboard() {
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxSize()
                .background(colorResource(id = R.color.back_ground)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConstraintLayout {
                val (topImg, profile) = createRefs()
                // 画面上部の紫の枠
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(245.dp)
                        .constrainAs(topImg) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .background(
                            color = colorResource(id = R.color.blue_3),
                            shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
                        )
                )
                // 名前と顔写真アイコン
                Row(
                    Modifier
                        .padding(top = 48.dp, start = 24.dp, end = 24.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        Modifier
                            .height(100.dp)
                            .padding(start = 14.dp)
                            .weight(0.7f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "こんにちは",
                            color = Color.White,
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Tsunakiです",
                            color = Color.White,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 14.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.dog_icon),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .size(130.dp)
                            .clip(CircleShape)
                            .clickable { },
                    )
                }
                // ３つボタンの表示エリア
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 14.dp, end = 14.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .constrainAs(profile) {
                            top.linkTo(topImg.bottom)
                            bottom.linkTo(topImg.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {
                    // ビデオ通話ボタン
                    Column(
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp, end = 8.dp)
                            .height(90.dp)
                            .width(90.dp)
                            .background(
                                color = colorResource(id = R.color.blue_1),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.video_call
                            ),
                            contentDescription = null,
                            Modifier.padding(top = 8.dp, bottom = 4.dp)
                        )
                        Text(
                            text = "Video Call",
                            color = Color(android.graphics.Color.parseColor("#5e3bee")),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                    }
                    // お知らせボタン
                    Column(
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp, end = 8.dp, start = 8.dp)
                            .height(90.dp)
                            .width(90.dp)
                            .background(
                                color = colorResource(id = R.color.blue_1),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.notification
                            ),
                            contentDescription = null,
                            Modifier.padding(top = 8.dp, bottom = 4.dp)
                        )
                        Text(
                            text = "Notification",
                            color = Color(android.graphics.Color.parseColor("#5e3bee")),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                    }
                    // 通話ボタン
                    Column(
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp, start = 8.dp)
                            .height(90.dp)
                            .width(90.dp)
                            .background(
                                color = colorResource(id = R.color.blue_1),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.voice_call
                            ),
                            contentDescription = null,
                            Modifier.padding(top = 8.dp, bottom = 4.dp)
                        )
                        Text(
                            text = "Voice Call",
                            color = Color(android.graphics.Color.parseColor("#5e3bee")),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
            }
            var text by rememberSaveable { mutableStateOf("") }
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(text = "Searching for...") },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(43.dp)
                            .padding(6.dp)
                    )
                },
                shape = RoundedCornerShape(50.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color.White,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    textColor = Color(android.graphics.Color.parseColor("#5e5e5e")),
                    unfocusedLabelColor = Color(android.graphics.Color.parseColor("#5e5e5e"))
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, end = 24.dp, start = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(50.dp))
                    .background(Color.White, CircleShape)
            )
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, end = 24.dp, start = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(25.dp))
                    .height(100.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(id = R.color.blue_2),
                                colorResource(id = R.color.blue_1)
                            )
                        ), shape = RoundedCornerShape(25.dp)
                    )
            ) {
                val (img, text1)= createRefs()
                Image(
                    modifier = Modifier.constrainAs(img) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = ""
                )
                Text(
                    text = "To Get Unlimited",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 32.dp)
                        .constrainAs(text1) {
                            top.linkTo(parent.top)
                            end.linkTo(img.start)
                            start.linkTo(parent.start)
                        }
                )
            }

            val gridItems: List<GridItem> = listOf(
                GridItem("text1", R.drawable.ic_1),
                GridItem("text2", R.drawable.ic_2),
                GridItem("text3", R.drawable.ic_3),
                GridItem("text1", R.drawable.ic_4),
                GridItem("text2", R.drawable.ic_5),
                GridItem("text3", R.drawable.ic_6),
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues = PaddingValues(18.dp)),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                userScrollEnabled = false
            ){
                items(gridItems){ item ->
                    Column(
                        Modifier
                            .height(90.dp)
                            .background(
                                color = colorResource(id = R.color.blue_1),
                                shape = RoundedCornerShape(15.dp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = item.imageId),
                            contentDescription = "",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(10.dp)
                        )
                        Text(
                            text = item.text,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

data class GridItem(val text: String, val imageId: Int)