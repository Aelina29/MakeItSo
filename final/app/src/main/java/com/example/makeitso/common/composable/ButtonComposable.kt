/*
Copyright 2022 Google LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.example.makeitso.common.composable

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.rememberOneTapSignInState

@Composable
fun BasicTextButton(@StringRes text: Int, modifier: Modifier, action: () -> Unit) {
  TextButton(onClick = action, modifier = modifier) { Text(text = stringResource(text)) }
}

@Composable
fun BasicButton(@StringRes text: Int, modifier: Modifier, action: () -> Unit) {
  Button(
    onClick = action,
    modifier = modifier,
    colors =
      ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
      )
  ) {
    Text(text = stringResource(text), fontSize = 16.sp)
  }
}

@Composable
fun GoogleSignInButton(action: (s: String) -> Unit, modifier: Modifier = Modifier) {
  val state = rememberOneTapSignInState()
  OneTapSignInWithGoogle(
    state = state,
    clientId = "641739989722-ckk64346jd3duicarbth4jetjlrc8hsh.apps.googleusercontent.com",
    onTokenIdReceived = { tokenId ->
      action(tokenId)
    },
    onDialogDismissed = { message ->

    }
  )

  Button(
    onClick = { state.open() },
    modifier = Modifier
      .wrapContentSize()
      .then(modifier),
    shape = RoundedCornerShape(24.dp),
    border = BorderStroke(width = 1.dp, color = Color.White),
    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
//      Icon(
//        painter = painterResource(R.drawable.ic_google),
//        contentDescription = null,
//        tint = Color.Unspecified,
//        modifier = Modifier
//          .size(24.dp)
//
//      )
      Text(
        text = "sign_in_google_account",
        color = Color.Black
      )
    }
  }
}

@Composable
fun DialogConfirmButton(@StringRes text: Int, action: () -> Unit) {
  Button(
    onClick = action,
    colors =
      ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
      )
  ) {
    Text(text = stringResource(text))
  }
}

@Composable
fun DialogCancelButton(@StringRes text: Int, action: () -> Unit) {
  Button(
    onClick = action,
    colors =
      ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.onPrimary,
        contentColor = MaterialTheme.colors.primary
      )
  ) {
    Text(text = stringResource(text))
  }
}
