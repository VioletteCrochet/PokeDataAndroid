package com.example.demoandroid.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.demoandroid.R
import com.example.demoandroid.article.ArticleListViewModelActivity
import com.example.demoandroid.helpers.AppViewHelper
//import com.example.demoandroid.nav.NavigationGraph
import com.example.demoandroid.ui.theme.MyButton
import com.example.demoandroid.ui.theme.MyPage
import com.example.demoandroid.ui.theme.MyTextField
import com.example.demoandroid.ui.theme.SecondaryTextInfo
import com.example.demoandroid.ui.theme.TitlewithIcon
import com.example.demoandroid.ui.theme.WrapPaddingRowWeight

@Composable
fun LoginScreen(navController: NavHostController, loginViewModel: LoginViewModel) {
    val context = LocalContext.current
    val email by loginViewModel.email.collectAsState()
    val password by loginViewModel.password.collectAsState()

    MyPage () {
        Column(modifier = Modifier.padding(20.dp)) {
            Spacer(modifier = Modifier.weight(1f))
            Row {
                WrapPaddingRowWeight {
                   TitlewithIcon(title = stringResource(R.string.app_title_login), icon = Icons.Default.AccountCircle)
                }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_email_hint),
                    value = email,
                    onValueChange = { value -> loginViewModel.email.value = value; },
                    icon = Icons.Default.Email) }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_password_hint),
                    value = password,
                    onValueChange = { value -> loginViewModel.password.value = value; },
                    icon = Icons.Default.Lock) }
            }
            Row {
                WrapPaddingRowWeight { MyButton(buttonText = stringResource(R.string.app_btn_forget_password),
                    onClick = { navController.navigate("reset-password")} ) }
            }
            Row {
                WrapPaddingRowWeight { MyButton(stringResource(R.string.app_btn_login),
                onClick = { loginViewModel.callLoginApi(onSuccess = { AppViewHelper.openActivity(context, ArticleListViewModelActivity::class)
                    })
                })
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row {
                SecondaryTextInfo(stringResource(R.string.app_msg_ask_account))
            }
            Row {
                WrapPaddingRowWeight { MyButton(
                    buttonText = stringResource(R.string.app_btn_sign_in,),
                    onClick = { navController.navigate("register") })
                }
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val viewModel = LoginViewModel()
    val navController = rememberNavController()
    LoginScreen(navController, viewModel)
}