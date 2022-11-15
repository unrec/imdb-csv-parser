package com.unrec.imdb.csv.parser

import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.equality.shouldBeEqualToIgnoringFields
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileInputStream
import kotlin.test.assertEquals

internal class ImdbCsvParserTest {

    companion object {
        private const val path = "src/test/resources/ratings.csv"
        private const val actualSize = 2199
        private const val pathToFiveItems = "src/test/resources/ratings_5_items.csv"

        private val parser = ImdbCsvParser()
    }

    @Test
    internal fun `Parse records from the InputStream`() {
        val items = parser.parse(FileInputStream(File(path)))
        assertEquals(items.size, actualSize)
    }

    @Test
    internal fun `Parse records from the File`() {
        val items = parser.parse(File(path))
        assertEquals(items.size, actualSize)
    }

    @Test
    internal fun `Parse 5 exact records from the File`() {
        // given
        val ratedItems = TestData.ratedItems

        // when
        val items = parser.parse(File(pathToFiveItems))

        // then
        items.size shouldBe 5
        items.forEach { item ->
            val ratedItem = ratedItems.find { it.id == item.id }!!
            item.shouldBeEqualToIgnoringFields(ratedItem, RatedItem::genres, RatedItem::directors)
            item.directors shouldContainExactlyInAnyOrder ratedItem.directors
            item.genres shouldContainExactlyInAnyOrder ratedItem.genres
        }
    }
}
