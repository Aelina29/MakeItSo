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
import coil.compose.AsyncImage
import com.example.makeitso.R.string as AppText
import com.example.makeitso.common.composable.*
import com.example.makeitso.common.ext.fieldModifier
import kotlin.math.log

@Composable
fun ProfileScreen(
  openAndPopUp: (String, String) -> Unit,
  modifier: Modifier = Modifier,
  viewModel: LoginGViewModel = hiltViewModel()
) {
  //val uiState by viewModel.uiState

  BasicToolbar(AppText.prof_info)

  Column(
    modifier = modifier.fillMaxWidth().fillMaxHeight().verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    var name =  viewModel.getUserName()
    var photo_url =  viewModel.getUserPhotoUrl()
    var provider_id =  viewModel.getProviderId()
    //var photo_url = "https://funik.ru/wp-content/uploads/2018/10/17478da42271207e1d86.jpg"
    if (photo_url != null){
      AsyncImage(
        model = photo_url,
        contentDescription = null,

        )
    }else{
      Text("No photo",  fontSize = 18.sp)
    }
    Text("Name: $name",  fontSize = 18.sp)
    Text("Authentication method:  $provider_id",  fontSize = 18.sp)
  }
}