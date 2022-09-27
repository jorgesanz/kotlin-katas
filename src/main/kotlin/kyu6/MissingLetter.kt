package kyu6

import org.junit.Test
import kotlin.test.assertEquals

/*

Find the missing letter
Write a method that takes an array of consecutive (increasing) letters as input and that returns the missing letter in the array.

You will always get an valid array. And it will be always exactly one letter be missing. The length of the array will always be at least 2.
The array will always contain letters in only one case.

Example:

['a','b','c','d','f'] -> 'e'
['O','Q','R','S'] -> 'P'
(Use the English alphabet with 26 letters!)

Have fun coding it and please don't forget to vote and rank this kata! :-)

I have also created other katas. Take a look if you enjoyed this kata!

 */
internal class MissingLetter {

    fun findMissingLetter(letters : CharArray): Char {

        var previousLetter = letters.first();
        for (letter in letters){
            if (!letter.equals(letters.first())){
                if(previousLetter.inc().equals(letter)){
                    previousLetter = letter
                }
                else return previousLetter.inc()
            }
        }
        throw Exception()
    }

    @Test
    fun exampleTests() {
        assertEquals('e', findMissingLetter(charArrayOf('a', 'b', 'c', 'd', 'f')))
        assertEquals('P', findMissingLetter(charArrayOf('O', 'Q', 'R', 'S')))
    }
}