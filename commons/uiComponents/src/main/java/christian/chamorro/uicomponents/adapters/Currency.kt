package christian.chamorro.uicomponents.adapters

import java.text.NumberFormat

fun Double.toCurrency(): String {
    val formatter = NumberFormat.getCurrencyInstance()
    formatter.maximumFractionDigits = 0
    return formatter.format(this)
}