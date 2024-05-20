package christian.chamorro.uicomponents.adapters

import java.text.NumberFormat

/**
 * Map a double value to currency formatted String.
 */
fun Double.toCurrency(): String {
    val formatter = NumberFormat.getCurrencyInstance()
    formatter.maximumFractionDigits = 0
    return formatter.format(this)
}
