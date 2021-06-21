package com.example.androiddevchallenge

class MainViewModel {
    fun loadData(): List<Puppy> {
        val names = listOf("Doug", "Kevin", "Pancake", "Mila", "Spot", "Bud", "Mickey")
        val breeds = listOf("Golden Retriever", "Black Lab", "Australian Shepherd", "German Shepherd", "Poodle", "Boston Terrier")
        val ageRanges = listOf("weeks", "months")

        return (1..10)
            .map { Puppy(
                name = names[(0 until names.size-1).random()],
                breed = breeds[(0 until breeds.size-1).random()],
                age = "${(1..12).random()} ${ageRanges[(0 until ageRanges.size-1).random()]}"
            ) }
    }
}