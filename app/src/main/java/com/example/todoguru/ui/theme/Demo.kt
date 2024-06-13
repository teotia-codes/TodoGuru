//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import kotlin.random.Random
//
//fun pickRandomColor(colors: List<Color>): Color {
//    if (colors.isEmpty()) {
//        throw IllegalArgumentException("The color list cannot be empty")
//    }
//    val randomIndex = Random.nextInt(colors.size)
//    return colors[randomIndex]
//}
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyApp {
//                // Passing a list of colors
//
//                RandomColorCard(colors)
//            }
//        }
//    }
//}
//
//@Composable
//fun RandomColorCard(colors: List<Color>) {
//    val selectedColor = pickRandomColor(colors)
//    Card(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .background(selectedColor),
//        shape = RoundedCornerShape(8.dp)
//    ) {
//        // Add any other composable content here if needed
//    }
//}
//
//@Composable
//fun MyApp(content: @Composable () -> Unit) {
//    MaterialTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            content()
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyApp {
//        val colors = listOf(
//            Color.Red,
//            Color.Blue,
//            Color.Green,
//            Color.Yellow,
//            Color.Magenta
//        )
//        RandomColorCard(colors)
//    }
//}
