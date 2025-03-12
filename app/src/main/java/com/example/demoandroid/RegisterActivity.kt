package com.example.demoandroid

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
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoandroid.ui.theme.MyButton
import com.example.demoandroid.ui.theme.MyPage
import com.example.demoandroid.ui.theme.MyTextField
import com.example.demoandroid.ui.theme.TitlewithIcon
import com.example.demoandroid.ui.theme.WrapPaddingRowWeight

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterForm();
        }
    }
}

@Composable
fun RegisterForm() {
    MyPage {
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
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_city_code_hint), icon = Icons.Default.LocationOn) }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_city_hint), icon = Icons.Default.Home) }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = stringResource(R.string.app_field_phone_hint), icon = Icons.Default.Call) }
            }
            Row {
                WrapPaddingRowWeight { MyButton(buttonText = stringResource(R.string.app_btn_sign_in)) }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row {
                Text(stringResource(R.string.app_msg_ask_account), fontStyle = FontStyle.Italic, color = Color.LightGray)
            }
            Row {
                WrapPaddingRowWeight { MyButton(stringResource(R.string.app_btn_login)) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    RegisterForm();
}