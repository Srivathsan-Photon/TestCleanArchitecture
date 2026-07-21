package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.domain.usecase.Resource
import com.example.myapplication.ui.viewmodel.WeatherViewModel
import com.example.testCleanArchitecture.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(
    onOpenProfile: () -> Unit,
    onOpenSettings: () -> Unit,
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val cityState = rememberTextFieldState(initialText = "Chennai")

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.app_name)) })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(state = cityState, label = { Text("City") })
            Spacer(Modifier.height(12.dp))
            Button(onClick = { viewModel.search(cityState.text.toString()) }) { Text("Search") }
            Spacer(Modifier.height(16.dp))

            when (val state = uiState) {
                is Resource.Idle -> {}
                is Resource.Loading -> CircularProgressIndicator()
                is Resource.Error -> Text("Error: ${state.message}")
                is Resource.Success -> {
                    val data = state.data
                    Text(text = "Temp: ${data.temperature}°C")
                }
            }

            Spacer(Modifier.height(24.dp))
            Button(onClick = onOpenProfile) { Text("Profile") }
            Spacer(Modifier.height(8.dp))
            Button(onClick = onOpenSettings) { Text("Settings") }
        }
    }
}
