package uz.ruzibekov.starwars_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import uz.ruzibekov.starwars_test.ui.navigation.MainNavHost
import uz.ruzibekov.starwars_test.ui.theme.StarWars_TestTheme

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            StarWars_TestTheme {
//                MainNavHost.Default(
//                    navController = navController,
//                    state = state
//                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StarWars_TestTheme {
        Greeting("Android")
    }
}