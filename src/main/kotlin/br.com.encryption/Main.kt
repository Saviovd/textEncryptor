package br.com.encryption

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    println("Write the word to be encrypted: ")
    val inputText: String = readLine().orEmpty()
    println("===============================")
    val removeSpaces = inputText.replace(" ", "")
    val textCount = removeSpaces.length
    val textSqrt = sqrt(textCount.toDouble())
    val verticalCount = ceil(textSqrt).toInt()
    var horizontalCount = floor(textSqrt).toInt()

    if (horizontalCount * verticalCount < textCount) {
        horizontalCount++
    }

    val words = mutableListOf<String>()
    for (line in 0 until horizontalCount) {
        val start = verticalCount * line
        val end = min(verticalCount * (line + 1), textCount)
        val word = removeSpaces.substring(start, end)
        words.add(word)
    }

    val encryptedText = StringBuilder()
    for (col in 0 until verticalCount) {
        for (word in words) {
            if (col < word.length) {
                encryptedText.append(word[col])
            }
        }
        encryptedText.append(" ")
    }
    println("$inputText -> ${encryptedText.toString().trim()}")
}
