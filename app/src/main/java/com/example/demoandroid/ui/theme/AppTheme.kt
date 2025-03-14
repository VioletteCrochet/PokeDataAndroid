package com.example.demoandroid.ui.theme

//import com.example.demoandroid.nav.NavigationGraph
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.demoandroid.R
import com.example.demoandroid.nav.BottomNavBar
import com.example.demoandroid.pokemon.Pokemon


@Composable
fun MyPage( @DrawableRes backgroundId: Int = R.drawable.background_page, content: @Composable () -> Unit) {
    DemoAndroidTheme {
        //val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            //bottomBar = { BottomNavBar(navController) }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Image(
                    painter = painterResource(backgroundId),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                content()
                Box() {
//                    NavigationGraph(navController)
                }
            }
        }
    }
}

@Composable
fun Title(text: String, bottomPadding: Dp = 100.dp){
    Text(text, textAlign = TextAlign.Center, fontSize = 36.sp,
        color = Color(0xEEFFFFFF),
        fontWeight = FontWeight.Bold,
        style = TextStyle(
            shadow = Shadow(
                color = Color(0XFF98c0e3), offset = Offset(1f, 1f), blurRadius = 5f
            )
        ),
        modifier = Modifier.fillMaxWidth().padding(bottom = bottomPadding))
}

/*@Composable
fun ConditionalIcon(icon: ImageVector? ) {
    icon?.let { Icon(imageVector = icon, contentDescription = null, tint = Color(0xFFF0F0DF) ) }
}*/

@Composable
fun TitlewithIcon (title: String, icon: ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally)
    {
        Icon(
            imageVector = icon,
            modifier = Modifier.size(96.dp),
            contentDescription = null,
            tint = Color(0xDDF0F0DD)
        )
        Title(stringResource(R.string.app_title_login), bottomPadding = 50.dp)
    }
}
@Composable
fun MyTextField(hintText: String = "", modifier: Modifier = Modifier, icon: ImageVector? = null) {
    TextField(modifier = modifier
        .fillMaxWidth(),
        value = "", onValueChange = {},
        shape = RoundedCornerShape(30.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0x55EEEEEE),
            focusedContainerColor = Color(0xDDEEEEEE),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        placeholder = {
            Row {
                if (icon !=null ) {
                    Icon(imageVector = icon, contentDescription = null, tint = Color(0xFFF0F0DF) )
                }
                Text(text = hintText, color = Color(0xFFF0F0DF))
            }

        }

    )
}

@Composable
fun MyButton(buttonText: String = "", modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Button(onClick = onClick,
        contentPadding = PaddingValues(),
        border = BorderStroke(2.dp, Color(0x99FFFFFF)),
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.background(brush = Brush.linearGradient(
                listOf(Color(0xFF54668b), Color(0xFF4188b5))
            )).fillMaxWidth().padding(vertical = 14.dp)
        ){
            Text(text = buttonText)
        }

    }
}

@Composable
fun WrapPadding(content: @Composable () -> Unit) {
    Box(modifier = Modifier.padding(10.dp)){
        content()
    }

}

@Composable
fun RowScope.WrapPaddingRowWeight(weight: Float = 1f, content: @Composable () -> Unit) {
    Box(modifier = Modifier.padding(10.dp).weight(weight)){
        content()
    }

}

@Composable
fun PokemonImage(pokemon: Pokemon) {
    AsyncImage(
        model = pokemon.img,
        contentDescription = pokemon.name,
        modifier = Modifier.size(150.dp)
    )
}
@Composable
fun SecondaryTextInfo(message: String) {
    Text(
        message,
        fontStyle = FontStyle.Italic,
        color = Color.LightGray
    )
}
@Composable
fun PokemonCard(pokemon: Pokemon) {
    Box(modifier = Modifier.background(color = Color(0xAAF0F0FF), shape = RoundedCornerShape(30.dp))
        , contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = pokemon.name, modifier = Modifier.padding(top = 6.dp))
            PokemonImage(pokemon)
        }

    }
}


