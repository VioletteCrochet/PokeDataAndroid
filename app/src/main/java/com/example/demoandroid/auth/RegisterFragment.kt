package com.example.demoandroid.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.demoandroid.R
import com.example.demoandroid.ui.theme.MyButton
import com.example.demoandroid.ui.theme.MyPage
import com.example.demoandroid.ui.theme.MyTextField
import com.example.demoandroid.ui.theme.TitlewithIcon
import com.example.demoandroid.ui.theme.WrapPaddingRowWeight

@Composable
fun RegisterScreen(navController: NavHostController, viewModel: RegisterViewModel) {
    val context = LocalContext.current
    val registerState by viewModel.registerData.collectAsState()
    MyPage {
        Column(modifier = Modifier.padding(20.dp).verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.weight(1f))
            Row {
                WrapPaddingRowWeight {
                    TitlewithIcon(title = stringResource(R.string.app_title_login), icon = Icons.Default.AccountCircle)
                }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_email_hint),
                    value = registerState.email,
                    onValueChange =  { value -> viewModel.registerData.value = viewModel.registerData.value.copy(email = value)},
                    icon = Icons.Default.Email) }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_password_hint),
                    value = registerState.password,
                    onValueChange =  { value -> viewModel.registerData.value = viewModel.registerData.value.copy(password = value)},
                    icon = Icons.Default.Lock) }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_password_confirm_hint),
                    value = registerState.passwordConfirm,
                    onValueChange =  { value -> viewModel.registerData.value = viewModel.registerData.value.copy(passwordConfirm = value)},
                    icon = Icons.Default.Lock) }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_city_code_hint),
                    value = registerState.cityCode,
                    onValueChange =  { value -> viewModel.registerData.value = viewModel.registerData.value.copy(cityCode = value)},
                    icon = Icons.Default.LocationOn) }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_city_hint),
                    value = registerState.city,
                    onValueChange =  { value -> viewModel.registerData.value = viewModel.registerData.value.copy(city = value)},
                    icon = Icons.Default.Home) }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_phone_hint),
                    value = registerState.phone,
                    onValueChange =  { value -> viewModel.registerData.value = viewModel.registerData.value.copy(phone = value)},
                    icon = Icons.Default.Call) }
            }
            Row {
                WrapPaddingRowWeight {
                    MyButton(
                        buttonText = stringResource(R.string.app_btn_sign_in),
                        onClick = {
                            viewModel.callRegisterApi(onSuccess = { navController.navigate("login") })
                        })
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row {
                Text(stringResource(R.string.app_msg_ask_account), fontStyle = FontStyle.Italic, color = Color.LightGray)
            }
            Row {
                WrapPaddingRowWeight { MyButton(stringResource(R.string.app_btn_login),onClick = { navController.navigate("login") }) }
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    val viewModel = RegisterViewModel()
    val navController = rememberNavController()
    RegisterScreen(navController, viewModel)
}