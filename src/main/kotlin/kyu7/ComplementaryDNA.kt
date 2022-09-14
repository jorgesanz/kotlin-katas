/*
Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.

If you want to know more: http://en.wikipedia.org/wiki/DNA

In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". Your function receives one side of the DNA (string, except for Haskell); you need to return the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).

More similar exercise are found here: http://rosalind.info/problems/list-view/ (source)

Example: (input --> output)

"ATTGC" --> "TAACG"
"GTAT" --> "CATA"
* */
import kotlin.test.assertEquals
import org.junit.Test


class MakeComplement {

    fun firstMakeComplement(dna : String) : String {

        return dna
            .replace("T","X")
            .replace("A","T")
            .replace("X","A")
            .replace("C","X")
            .replace("G","C")
            .replace("X","G")

    }

    fun makeComplement(dna: String) = dna.map { when(it) {
        'A' -> 'T'
        'T' -> 'A'
        'C' -> 'G'
        'G' -> 'C'
        else -> it
    } }.joinToString("")

    @Test
    fun test01() {
        assertEquals("TTTT", makeComplement("AAAA"));
    }
    @Test
    fun test02() {
        assertEquals("TAACG", makeComplement("ATTGC"));
    }

}