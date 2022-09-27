package kyu6

import junit.framework.TestCase.assertEquals
import org.junit.Test

/*
You are given an array (which will have a length of at least 3, but could be very large) containing integers.
The array is either entirely comprised of odd integers or entirely comprised of even integers except
for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.

Examples
[2, 4, 0, 100, 4, 11, 2602, 36]
Should return: 11 (the only odd number)

[160, 3, 1719, 19, 11, 13, -21]
Should return: 160 (the only even number)


 */
class FindTheParityOurlier {


    private fun areEvens(integers: Array<Int>): Boolean {

        var anyOdd = false
        var anyEven = false
        for (number in integers) {
            if (isOdd(number)) {
                if (anyOdd) return false;
                anyOdd = true
            } else {
                if (anyEven) return true;
                anyEven = true;
            }
        }
        return false
    }

    fun find(integers: Array<Int>): Int {
        if (areEvens(integers)) {
            return findNotEven(integers)
        } else {
            return findNotOdd(integers)
        }
        return 0
    }

    private fun findNotOdd(integers: Array<Int>): Int {
        for (number in integers) {
            if (!isOdd(number))
                return number
        }
        return 0
    }

    private fun findNotEven(integers: Array<Int>): Int {
        for (number in integers) {
            if (isOdd(number))
                return number
        }
        return 0
    }

    private fun isOdd(number: Int): Boolean {
        return number.mod(2) == 1
    }


    @Test
    fun testExample() {
        val exampleTest1 = arrayOf(2, 6, 8, -10, 3)
        val exampleTest2 = arrayOf(206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781)
        val exampleTest3 = arrayOf(Integer.MAX_VALUE, 0, 1)
        assertEquals(3, find(exampleTest1))
        assertEquals(206847684, find(exampleTest2))
        assertEquals(0, find(exampleTest3))
    }


}