# imdb-csv-parser

Small library to parse *ratings.csv* files that can be downoladed from IMDb site for a user, e.g. here - https://www.imdb.com/user/{userId}/ratings/export.

### Usage

```kotlin
val parser = ImdbCsvParser()
val filepath = "/ratings/ratings_andrei.csv"
val items: List<ParsedItem> = filepath.toInputStream()
    .let { parser.parse(it) }
```
