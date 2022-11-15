package com.unrec.imdb.csv.parser

import com.fasterxml.jackson.annotation.JsonProperty

enum class TitleType() {
    @field:JsonProperty("movie") MOVIE,
    @field:JsonProperty("tvMiniSeries") TV_MINI_SERIES,
    @field:JsonProperty("tvSeries") TV_SERIES,
    @field:JsonProperty("tvMovie") TV_MOVIE,
    @field:JsonProperty("tvEpisode") TV_EPISODE,
    @field:JsonProperty("tvSpecial") TV_SPECIAL,
    @field:JsonProperty("short") SHORT,
    @field:JsonProperty("musicVideo") MUSIC_VIDEO,
    @field:JsonProperty("videoGame") VIDEO_GAME,
    @field:JsonProperty("video") VIDEO
}
