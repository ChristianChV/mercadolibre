package christian.chamorro.uicomponents.adapters

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.text.Typography.nbsp

class CurrencyTest {
    @Test
    fun `toCurrency when it is called should return currency value `() {
        // Given
        val value = 10000.0

        // When
        val result = value.toCurrency()

        // Then
        assertEquals("$${nbsp}10.000", result)
    }
}
