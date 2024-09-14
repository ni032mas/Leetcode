package yaalgo2023

import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter
import java.util.*

fun main1() {
    val input = BufferedReader(FileReader("input.txt"))
    val output = BufferedWriter(FileWriter("output.txt"))
    val counts = input.readLine().split(" ").map { it.toInt() }
    val waterMelons = input.readLine().split(" ").map { it.toInt() }.toMutableList()
    val countWaterMelons = counts[0]
    val maxW = counts[1]
    var w = 0
    var result = 1
    var isEmpty = false
    var sumW = 0
    var secondHand = -1
    for (i in 0 until waterMelons.size) {
        if (waterMelons[i] == 0) continue
        if (waterMelons[i] == maxW) {
            waterMelons[i] = 0
            result++
            continue
        }
        for (j in waterMelons) {
            if (waterMelons[j] == 0 || waterMelons[i] == 0) {
                continue
            }
            if (i != j) {
                sumW = waterMelons[i] + waterMelons[j]
                if (sumW == maxW) {
                    waterMelons[i] = 0
                    waterMelons[j] = 0
                    result++
                    secondHand = -1
                    continue
                }
                if (sumW < maxW && secondHand < j) {
                    secondHand = j
                }
            }
        }
        if (secondHand >= 0) {
            result++
            waterMelons[secondHand] = 0
        }
    }
    output.write(result.toString())
    output.flush()
}

fun main4() {
    val setVowels = setOf('a', 'e', 'i', 'o', 'u')
    val input = BufferedReader(FileReader("input.txt"))
    val output = BufferedWriter(FileWriter("output.txt"))
    val countWords = input.readLine().toInt()
    val result = mutableListOf<String>()
    repeat(countWords) {
        result.add(input.readLine())
    }
    result.sortWith(compareByDescending<String> {
        var res = 0
        it.forEach { char ->
            if (setVowels.contains(char)) res++
        }
        res
    }.thenBy { it.length })
    result.forEach {
        output.write(it)
        output.newLine()
    }
    output.flush()
}

fun main3() {
    val input = BufferedReader(FileReader("input.txt"))
    val output = BufferedWriter(FileWriter("output.txt"))
    val firstPosition = 0 to 0
    val map = mutableMapOf(firstPosition to 1)
    val r = 'R'
    val l = 'L'
    val d = 'D'
    val u = 'U'
    var result = 0
    val inputs = input.readLine()
    var currentPos = firstPosition
    for (s in inputs) {
        when (s) {
            l -> {
                val next = currentPos.first to currentPos.second - 1
                when (val count = map.getOrDefault(next, 0)) {
                    0 -> map[next] = 1
                    1 -> {
                        map[next] = count + 1
                        result++
                    }

                    else -> map[next] = count + 1
                }
                currentPos = next
            }

            r -> {
                val next = currentPos.first to currentPos.second + 1
                when (val count = map.getOrDefault(next, 0)) {
                    0 -> map[next] = 1
                    1 -> {
                        map[next] = count + 1
                        result++
                    }

                    else -> map[next] = count + 1
                }
                currentPos = next
            }

            d -> {
                val next = currentPos.first + 1 to currentPos.second
                when (val count = map.getOrDefault(next, 0)) {
                    0 -> map[next] = 1
                    1 -> {
                        map[next] = count + 1
                        result++
                    }

                    else -> map[next] = count + 1
                }
                currentPos = next
            }

            u -> {
                val next = currentPos.first - 1 to currentPos.second
                when (val count = map.getOrDefault(next, 0)) {
                    0 -> map[next] = 1
                    1 -> {
                        map[next] = count + 1
                        result++
                    }

                    else -> map[next] = count + 1
                }
                currentPos = next
            }
        }
    }
    println(result)
    output.write(result.toString())
    output.flush()
}


fun main2() {
    val input = BufferedReader(FileReader("input.txt"))
    val output = BufferedWriter(FileWriter("output.txt"))

    val inputs = input.readLine().split(" ").map { it.toInt() }
    val n1 = inputs[0]
    val n2 = inputs[1]
    val n3 = inputs[2]
    if (n1 + n2 == n3 || n1 + n3 == n2 || n2 + n3 == n1) {
        output.write("YES")
    } else {
        output.write("NO")
    }
    output.flush()
}

fun main1sdsdsd() {
    val (a, b) = readln().split(" ")
    println(a.toInt() + b.toInt())
}

fun main() {
    var a = 1 to "a"
    var b = 2 to "b"

    a = b.also { b = a }
    println(a)
    println(b)
}

suspend fun someFun() {
    coroutineScope {
        launch(Job()) {
            for (i in 0..10) {
                println("${coroutineContext.job.isCancelled}")
                coroutineContext.ensureActive()
                println("${i}Hello!")
            }
        }
        cancel()
    }
}