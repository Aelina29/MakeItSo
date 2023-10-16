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

package com.example.makeitso.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.makeitso.R.string as AppText
import com.example.makeitso.common.composable.*
import com.example.makeitso.common.ext.fieldModifier

@Composable
fun ProfileScreen(
  openAndPopUp: (String, String) -> Unit,
  modifier: Modifier = Modifier,
  viewModel: LoginGViewModel = hiltViewModel()
) {
  val uiState by viewModel.uiState

  BasicToolbar(AppText.login_details)

  Column(
    modifier = modifier.fillMaxWidth().fillMaxHeight().verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    var name =  viewModel.getUserName()
    Text("Photo TODO",  fontSize = 18.sp)
    Text("Name:"+name,  fontSize = 18.sp)
    Text("Authentication method",  fontSize = 18.sp)

//    GmailField(uiState.email, viewModel::onEmailChange, Modifier.fieldModifier())
   // BasicField(AppText.email, userProfile.email, viewModel::onTitleChange, fieldModifier)

//    BasicButton(AppText.sign_in_g, Modifier.basicButton()) { viewModel.onSignInGClick(openAndPopUp) }

//    BasicTextButton(AppText.forgot_password, Modifier.textButton()) {
//      viewModel.onForgotPasswordClick()
//    }

//    GoogleSignInButton({
//      viewModel.onGoogleSignInCLick(it, openAndPopUp)
//    })

  }
}
