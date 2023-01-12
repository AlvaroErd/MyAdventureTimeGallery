package com.example.migaleradearte

class ImageDatabase {
    val allImages = setupImages()
}

fun setupImages(): List<Scene> {
    return listOf(
        Scene(R.string.art1_title, R.string.art1_description, R.drawable.at1),
        Scene(R.string.art2_title, R.string.art2_description, R.drawable.at2),
        Scene(R.string.art3_title, R.string.art3_description, R.drawable.at3),
        Scene(R.string.art4_title, R.string.art4_description, R.drawable.at4),
        Scene(R.string.art5_title, R.string.art5_description, R.drawable.at5),
    )
}