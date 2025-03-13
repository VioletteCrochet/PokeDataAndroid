package com.example.demoandroid

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.demoandroid.helpers.AppViewHelper
//import com.example.demoandroid.nav.NavigationGraph
import com.example.demoandroid.ui.theme.MyButton
import com.example.demoandroid.ui.theme.MyPage
import com.example.demoandroid.ui.theme.MyTextField
import com.example.demoandroid.ui.theme.SecondaryTextInfo
import com.example.demoandroid.ui.theme.TitlewithIcon
import com.example.demoandroid.ui.theme.WrapPaddingRowWeight

class LoginActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            LoginScreen(navController)
        }
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {
    val context = LocalContext.current
    MyPage () {
        Column(modifier = Modifier.padding(20.dp)) {
            Spacer(modifier = Modifier.weight(1f))
            Row {
                WrapPaddingRowWeight {
                   TitlewithIcon(title = stringResource(R.string.app_title_login), icon = Icons.Default.AccountCircle)
                }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_email_hint), icon = Icons.Default.Email) }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_password_hint), icon = Icons.Default.Lock) }
            }
            Row {
                WrapPaddingRowWeight { MyButton(buttonText = stringResource(R.string.app_btn_forget_password),
                    onClick = { AppViewHelper.openActivity(context, ResetPasswordActivity::class) }) }
            }
            Row {
                WrapPaddingRowWeight { MyButton(stringResource(R.string.app_btn_login)) }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row {
                SecondaryTextInfo(stringResource(R.string.app_msg_ask_account))
            }
            Row {
                WrapPaddingRowWeight { MyButton(
                    buttonText = stringResource(R.string.app_btn_sign_in,),
                    onClick = { AppViewHelper.openActivity(context, RegisterActivity::class) })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}