package com.example.movieapp.model

class Movie(
    val id: String,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val poster: String,
    val images: List<String>,
    val rating: String
)


fun getMovies(): List<Movie> {
    return listOf(
        Movie(
            "1",
            "Beetlejuice",
            "1988",
            "Comedy, Fantasy",
            "Tim Burton",
            "Alec Baldwin, Geena Davis, Annie McEnroe, Maurice Page",
            "A couple of recently deceased ghosts contract the services of a \"bio-exorcist\" in order to remove the obnoxious new owners of their house.",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwODE3MDE0MV5BMl5BanBnXkFtZTgwNTk1MjI4MzE@._V1_SX300.jpg",
            listOf(),
            "7.9"
        ),

        Movie(
            "2",
            "The Cotton Club",
            "1984",
            "Crime, Drama, Music",
            "Francis Ford Coppola",
            "Richard Gere, Gregory Hines, Diane Lane, Lonette McKee",
            "The Cotton Club was a famous night club in Harlem. The story follows the people that visited the club, those that ran it, and is peppered with the Jazz music that made it so famous.",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTU5ODAyNzA4OV5BMl5BanBnXkFtZTcwNzYwNTIzNA@@._V1_SX300.jpg",
            listOf("https://images-na.ssl-images-amazon.com/images/M/MV5BMTU5ODAyNzA4OV5BMl5BanBnXkFtZTcwNzYwNTIzNA@@._V1_SX300.jpg",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTU5ODAyNzA4OV5BMl5BanBnXkFtZTcwNzYwNTIzNA@@._V1_SX300.jpg",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTU5ODAyNzA4OV5BMl5BanBnXkFtZTcwNzYwNTIzNA@@._V1_SX300.jpg"),
            "8.9"
        ),

        Movie(
            "3",
            "The Shawshank Redemption",
            "1994",
            "Crime, Drama",
            "Frank Darabont",
            "Tim Robbins, Morgan Freeman, Bob Gunton, William Sadler",
            "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1_SX300.jpg",
            listOf(),
            "9.9"
        ),
    )
}