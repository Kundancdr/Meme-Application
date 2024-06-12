package com.example.memeapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.memeapp.navigation.Routes

@Composable
fun DetailScreen(modifier: Modifier,data: Routes.DetailScreen, navController: NavHostController) {


    Column(
            modifier
                .background(Color(0xFFEFF7A5))
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 45.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (data.url != null){
                AsyncImage(
                    model = data.url, contentDescription = null,
                    modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                )

            }
            Spacer(modifier.height(20.dp))
            if (data.title != null){
                Text(text = data.title,
                    modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 45.sp

                )
            }

        }
    }

