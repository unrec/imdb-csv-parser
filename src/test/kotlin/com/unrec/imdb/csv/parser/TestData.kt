package com.unrec.imdb.csv.parser

import java.time.LocalDate

object TestData {

    val ratedItems = listOf(
        RatedItem(
            "tt0110912",
            10F,
            LocalDate.parse("2010-01-17"),
            "Pulp Fiction",
            "https://www.imdb.com/title/tt0110912/",
            TitleType.MOVIE,
            8.9F,
            154,
            1994,
            listOf("Crime", "Drama"),
            2035797,
            LocalDate.parse("1994-05-21"),
            listOf("Quentin Tarantino")
        ),
        RatedItem(
            "tt0401792",
            10F,
            LocalDate.parse("2019-10-21"),
            "Sin City",
            "https://www.imdb.com/title/tt0401792/",
            TitleType.MOVIE,
            8.0F,
            124,
            2005,
            listOf("Crime", "Thriller"),
            768989,
            LocalDate.parse("2005-03-28"),
            listOf("Frank Miller", "Quentin Tarantino", "Robert Rodriguez")
        ),
        RatedItem(
            "tt7366338",
            9F,
            LocalDate.parse("2019-06-14"),
            "Chernobyl",
            "https://www.imdb.com/title/tt7366338/",
            TitleType.TV_MINI_SERIES,
            9.4F,
            330,
            2019,
            listOf("Drama", "History", "Thriller"),
            743411,
            LocalDate.parse("2019-05-06"),
            emptyList()
        ),
        RatedItem(
            "tt1625351",
            6F,
            LocalDate.parse("2011-03-18"),
            "The 83rd Annual Academy Awards",
            "https://www.imdb.com/title/tt1625351/",
            TitleType.TV_SPECIAL,
            6.3F,
            194,
            2011,
            listOf("News"),
            1601,
            LocalDate.parse("2011-02-27"),
            listOf("Don Mischer", "Troy Miller")
        ),
        RatedItem(
            "tt0291337",
            10F,
            LocalDate.parse("2010-02-11"),
            "Max Payne",
            "https://www.imdb.com/title/tt0291337/",
            TitleType.VIDEO_GAME,
            9.2F,
            null,
            2001,
            listOf("Action", "Crime", "Drama", "Mystery", "Thriller"),
            15162,
            LocalDate.parse("2001-07-23"),
            emptyList()
        )
    )
}
