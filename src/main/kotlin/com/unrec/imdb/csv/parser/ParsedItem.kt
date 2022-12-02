package com.unrec.imdb.csv.parser

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class ParsedItem(
    @field:JsonProperty("Const")
    val id: String? = null,

    @field:JsonProperty("Your Rating")
    val userRating: Byte? = null,

    @field:JsonProperty("Date Rated")
    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val dateRated: LocalDate? = null,

    @field:JsonProperty("Title")
    val title: String? = null,

    @field:JsonProperty("URL")
    val url: String? = null,

    @field:JsonProperty("Title Type")
    val titleType: TitleType? = null,

    @field:JsonProperty("IMDb Rating")
    val imdbRating: Float? = null,

    @field:JsonProperty("Runtime (mins)")
    val runtime: Int? = null,

    @field:JsonProperty("Year")
    val year: Short? = null,

    @field:JsonProperty("Genres")
    val genres: List<String>? = null,

    @field:JsonProperty("Num Votes")
    val votes: Int? = null,

    @field:JsonProperty("Release Date")
    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val releaseDate: LocalDate? = null,

    @field:JsonProperty("Directors")
    val directors: List<String>? = null
)
