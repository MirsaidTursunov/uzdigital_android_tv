package uz.udevs.uzdigitaltv.auth.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf


import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.launch
import uz.udevs.uzdigitaltv.R
import uz.udevs.uzdigitaltv.ui.activity.SplashScreen


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AuthStoryScreen() {
    val texts = remember {
        mutableStateListOf(
            "Пытаетесь присоединиться к UzDigitalTV?",
            "Смотрите на любом устройстве",
            "Нет надоедливого контракта"
        )
    }
    val subTexts = remember {
        mutableStateListOf(
            "Вы можете зарегистрироваться бесплатно, а можете продолжить без регистрации",
            "Транслируйте на свой телефон, планшет, ноутбук и телевизор, не платя больше",
            "Отменить в любое время"
        )
    }
    val iconList = remember {
        mutableStateListOf(
            R.drawable.ic_users,
            R.drawable.ic_bulb,
            R.drawable.ic_fire
        )
    }
    val pageCount = texts.size
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HorizontalPager(
            pageCount,
            state = pagerState
        ) { index ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painterResource(id = iconList[index]),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.height(42.dp))
                Text(
                    text = texts[index],
                    color = Color.White,
                    fontSize = 34.sp,
                    maxLines = 2,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = subTexts[index],
                    color = Color.White.copy(alpha = 0.4F),
                    fontSize = 17.sp,
                    maxLines = 2,
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            Modifier
                .height(14.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
        ) {
            repeat(pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(10.dp)

                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        // scroll to page
        Button(
            shape = RoundedCornerShape(8),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = LocalConfiguration.current.screenWidthDp.dp / 6),
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }) {
            Text("Следующий", color = Color.White)
        }

        // Registration
        Button(
            shape = RoundedCornerShape(8),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = LocalConfiguration.current.screenWidthDp.dp / 6),
            onClick = {
//                Navigator {
//                    SplashScreen();
//                }
            }) {
            Text("Регистрироватся", color = Color.White)
        }
    }
}
