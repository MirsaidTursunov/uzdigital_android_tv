package uz.udevs.uzdigitaltv.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.Navigator
import uz.udevs.uzdigitaltv.R
import uz.udevs.uzdigitaltv.auth.presentation.AuthStoryScreen
import uz.udevs.uzdigitaltv.ui.theme.AppTheme
import uz.udevs.uzdigitaltv.utils.AppScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Navigator(screen = SplashScreen())
            }
        }
    }
}

class SplashScreen : AppScreen(){

    @Composable
    fun Greeting() {
        Column(androidx.compose.ui.Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
            Button(onClick = {  }) {

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        AppTheme {
            Greeting()
        }
    }

    @Composable
    override fun Content() {
        AuthStoryScreen()
    }
}

