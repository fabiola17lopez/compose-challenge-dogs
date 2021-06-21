/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MainViewModel()

        setContent {
            MyTheme {
                MyApp(viewModel.loadData())
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(puppies: List<Puppy>) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Puppies") }, elevation = 4.dp, navigationIcon = { IconButton(
            onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.ArrowBack, null)
        }}) },
        content = { PuppyListContent(puppies = puppies, Modifier.padding(8.dp)) },
    )
}

@Composable
fun PuppyListContent(puppies: List<Puppy>, modifier: Modifier) {
    Surface(color = MaterialTheme.colors.background, modifier = modifier) {
        LazyColumn {
            items(puppies) {
                PuppyCell(puppy = it)
            }
        }
    }
}

@Composable
fun PuppyCell(puppy: Puppy) {
    Card(
        modifier = Modifier.fillMaxWidth(0.5f),
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 4.dp,
    ) {
        Column(modifier = Modifier.padding(8.dp)) {

            Image(
                painter = painterResource(R.drawable.ic_dogplaceholder),
                contentDescription = "Puppy image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .shadow(4.dp, shape = RoundedCornerShape(4.dp))
                    .clip(shape = RoundedCornerShape(4.dp))
                    .padding(bottom = 6.dp)
            )

            Text(text = puppy.name, style = typography.h6)
            puppy.breed?.let { breed -> Text(text = breed, style = typography.body1) }
            puppy.age?.let { age -> Text(text = "$age old", style = typography.body1) }
        }
    }
    Spacer(Modifier.height(8.dp))
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(
            listOf(
                Puppy(name = "Doug", breed = "Lab", age = "12 weeks"),
                Puppy(name = "Kevin", breed = "Terrier", age = "3 months"),
                Puppy(name = "Doug", breed = "Lab", age = "12 weeks"),
                Puppy(name = "Kevin", breed = "Terrier", age = "3 months"),
                Puppy(name = "Doug", breed = "Lab", age = "12 weeks"),
                Puppy(name = "Kevin", breed = "Terrier", age = "3 months"),
            )
        )
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(
            listOf(
                Puppy(name = "Doug", breed = "Lab", age = "12 weeks"),
                Puppy(name = "Kevin", breed = "Terrier", age = "3 months"),
                Puppy(name = "Doug", breed = "Lab", age = "12 weeks"),
                Puppy(name = "Kevin", breed = "Terrier", age = "3 months"),
                Puppy(name = "Doug", breed = "Lab", age = "12 weeks"),
                Puppy(name = "Kevin", breed = "Terrier", age = "3 months"),
            )
        )
    }
}
