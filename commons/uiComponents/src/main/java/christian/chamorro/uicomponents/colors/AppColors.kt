package christian.chamorro.uicomponents.colors

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class AppColors {
    Primary,
    OnPrimary,
    PrimaryContainer,
    OnPrimaryContainer,
    Secondary,
    OnSecondary,
    SecondaryContainer,
    OnSecondaryContainer,
    Tertiary,
    OnTertiary,
    TertiaryContainer,
    OnTertiaryContainer,
    Error,
    Background,
    OnBackground,
    Surface,
    OnSurface,
    SurfaceVariant,
    OnSurfaceVariant,
    Outline,
    OutlineVariant,
    InverseSurface,
    InversePrimary,
    SurfaceTint,
    Scrim,
    ErrorContainer,
    InverseOnSurface,
    OnErrorContainer,
    OnError,
    ;

    @Composable
    operator fun invoke(): Color {
        return when (this) {
            Primary -> MaterialTheme.colorScheme.primary
            OnPrimary -> MaterialTheme.colorScheme.onPrimary
            PrimaryContainer -> MaterialTheme.colorScheme.primaryContainer
            OnPrimaryContainer -> MaterialTheme.colorScheme.onPrimaryContainer
            Secondary -> MaterialTheme.colorScheme.secondary
            OnSecondary -> MaterialTheme.colorScheme.onSecondary
            SecondaryContainer -> MaterialTheme.colorScheme.secondaryContainer
            OnSecondaryContainer -> MaterialTheme.colorScheme.onSecondaryContainer
            Tertiary -> MaterialTheme.colorScheme.tertiary
            OnTertiary -> MaterialTheme.colorScheme.onTertiary
            TertiaryContainer -> MaterialTheme.colorScheme.tertiaryContainer
            OnTertiaryContainer -> MaterialTheme.colorScheme.onTertiaryContainer
            Error -> MaterialTheme.colorScheme.error
            Background -> MaterialTheme.colorScheme.background
            OnBackground -> MaterialTheme.colorScheme.onBackground
            Surface -> MaterialTheme.colorScheme.surface
            OnSurface -> MaterialTheme.colorScheme.onSurface
            SurfaceVariant -> MaterialTheme.colorScheme.surfaceVariant
            OnSurfaceVariant -> MaterialTheme.colorScheme.onSurfaceVariant
            Outline -> MaterialTheme.colorScheme.outline
            OutlineVariant -> MaterialTheme.colorScheme.outlineVariant
            InversePrimary -> MaterialTheme.colorScheme.inversePrimary
            InverseSurface -> MaterialTheme.colorScheme.inverseSurface
            SurfaceTint -> MaterialTheme.colorScheme.surfaceTint
            Scrim -> MaterialTheme.colorScheme.scrim
            ErrorContainer -> MaterialTheme.colorScheme.errorContainer
            InverseOnSurface -> MaterialTheme.colorScheme.inverseOnSurface
            OnError -> MaterialTheme.colorScheme.onError
            OnErrorContainer -> MaterialTheme.colorScheme.onErrorContainer
        }
    }
}
