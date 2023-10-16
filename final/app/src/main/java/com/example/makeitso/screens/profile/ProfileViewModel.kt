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

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import com.example.makeitso.LOGIN_SCREEN
import com.example.makeitso.R.string as AppText
import com.example.makeitso.SETTINGS_SCREEN
import com.example.makeitso.common.ext.isValidEmail
import com.example.makeitso.common.snackbar.SnackbarManager
import com.example.makeitso.model.service.AccountService
import com.example.makeitso.model.service.LogService
import com.example.makeitso.screens.MakeItSoViewModel
import com.example.makeitso.screens.login.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginGViewModel @Inject constructor(
  private val accountService: AccountService,
  logService: LogService
) : MakeItSoViewModel(logService) {

  var uiState = mutableStateOf(ProfileUiState())
    private set
  private val name
    get() = uiState.value.name
  private val photoUrl
    get() = uiState.value.photoUrl
  private val authMethod
    get() = uiState.value.authMethod

  fun getUserName():String{
    var name = "Can't get user name"
    launchCatching {
      name = accountService.getName()
    }
    return name
  }

  fun getUserPhotoUrl():Uri?{
//    var photo_url: Uri?
//    launchCatching {
//      photo_url = accountService.getPhotoUrl()
//    }
    return accountService.getPhotoUrl()
  }

  fun getProviderId():String {
    var provider_id = "TODO"
    launchCatching {
      provider_id = accountService.getProviderId()
      println("provider_id")
      println(provider_id)
    }
    return provider_id
  }
}
