package com.unrec.imdb.csv.parser

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvParser
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import java.io.File
import java.io.InputStream

class ImdbCsvParser {

    private val csvMapper = CsvMapper().apply {
        enable(CsvParser.Feature.TRIM_SPACES)
        enable(CsvParser.Feature.SKIP_EMPTY_LINES)
            .registerModule(JavaTimeModule())
    }

    private val schema: CsvSchema = CsvSchema.builder()
        .setSkipFirstDataRow(true)
        .setArrayElementSeparator(",")
        .addColumn("Const")
        .addNumberColumn("Your Rating")
        .addColumn("Date Rated")
        .addColumn("Title")
        .addColumn("URL")
        .addColumn("Title Type")
        .addNumberColumn("IMDb Rating")
        .addNumberColumn("Runtime (mins)")
        .addNumberColumn("Year")
        .addArrayColumn("Genres")
        .addNumberColumn("Num Votes")
        .addColumn("Release Date")
        .addArrayColumn("Directors")
        .build()

    fun parse(inputStream: InputStream): List<ParsedItem> {
        return csvMapper.readerFor(ParsedItem::class.java)
            .with(schema)
            .readValues<ParsedItem>(inputStream)
            .readAll()
    }

    fun parse(file: File): List<ParsedItem> {
        return csvMapper.readerFor(ParsedItem::class.java)
            .with(schema)
            .readValues<ParsedItem>(file)
            .readAll()
    }
}
