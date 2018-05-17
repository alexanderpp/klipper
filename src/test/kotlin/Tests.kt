import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import klipper.*

class Tests {
    val subject = Path(
            IntPoint(0, 0),
            IntPoint(10, 0),
            IntPoint(5, 10)
    )
    val clip = Path(
            IntPoint(5, 0),
            IntPoint(10, 10),
            IntPoint(0, 10)
    )

    @Test
    fun testUnion() {
        val solution = Paths()
        val expected = Paths()
        val expectedPoligon0 = Path()
        expectedPoligon0.addAll(listOf(
                IntPoint(x = 3, y = 5),
                IntPoint(x = 0, y = 0),
                IntPoint(x = 10, y = 0),
                IntPoint(x = 8, y = 5),
                IntPoint(x = 10, y = 10),
                IntPoint(x = 0, y = 10)
        ))

        expected.add(expectedPoligon0)

        Clipper().apply {
            addPath(subject, PolyType.Subject, true)
            addPath(clip, PolyType.Clip, true)

        }.execute(ClipType.Union, solution, PolyFillType.EvenOdd).let { success ->
            if (!success) {
                assertTrue(false)
            } else {
                assertEquals(solution, expected)
            }
        }
    }

    @Test
    fun testDifference() {
        val solution = Paths()
        val expected = Paths()
        val expectedPoligon0 = Path()
        expectedPoligon0.addAll(listOf(
                IntPoint(x = 8, y = 5),
                IntPoint(x = 5, y = 0),
                IntPoint(x = 3, y = 5),
                IntPoint(x = 0, y = 0),
                IntPoint(x = 10, y = 0)
        ))

        expected.add(expectedPoligon0)

        Clipper().apply {
            addPath(subject, PolyType.Subject, true)
            addPath(clip, PolyType.Clip, true)
        }.execute(ClipType.Difference, solution, PolyFillType.EvenOdd).let { success ->
            if (!success) {
                assertTrue(false)
            } else {
                assertEquals(solution, expected)
            }
        }
    }

    @Test
    fun testIntersection() {
        val solution = Paths()
        val expected = Paths()
        val expectedPoligon0 = Path()
        expectedPoligon0.addAll(listOf(
                IntPoint(x = 8, y = 5),
                IntPoint(x = 5, y = 10),
                IntPoint(x = 3, y = 5),
                IntPoint(x = 5, y = 0)
        ))

        expected.add(expectedPoligon0)

        Clipper().apply {
            addPath(subject, PolyType.Subject, true)
            addPath(clip, PolyType.Clip, true)
        }.execute(ClipType.Intersection, solution, PolyFillType.EvenOdd).let { success ->
            if (!success) {
                assertTrue(false)
            } else {
                assertEquals(solution, expected)
            }
        }
    }

    @Test
    fun testXor() {
        val solution = Paths()
        val expected = Paths()
        val expectedPoligon0 = Path()
        expectedPoligon0.addAll(listOf(
                IntPoint(x = 8, y = 5),
                IntPoint(x = 10, y = 10),
                IntPoint(x = 5, y = 10),
                IntPoint(x = 8, y = 5),
                IntPoint(x = 5, y = 0),
                IntPoint(x = 3, y = 5),
                IntPoint(x = 5, y = 10),
                IntPoint(x = 0, y = 10),
                IntPoint(x = 3, y = 5),
                IntPoint(x = 0, y = 0),
                IntPoint(x = 10, y = 0)
        ))

        expected.add(expectedPoligon0)

        Clipper().apply {
            addPath(subject, PolyType.Subject, true)
            addPath(clip, PolyType.Clip, true)
        }.execute(ClipType.Xor, solution, PolyFillType.EvenOdd).let { success ->
            if (!success) {
                assertTrue(false)
            } else {
                assertEquals(solution, expected)
            }
        }
    }
}