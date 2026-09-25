package am.hayatar.app.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

/**
 * Բոլոր դիզայն թոքենները մեկ ֆայլում։
 *
 * Սա նախագծի ՄԻԱԿ տեղն է, որտեղ hex գույն, տառաչափ կամ բացատ ուղիղ գրվում է։
 * Էկրանների կոդում երբեք մի գրիր Color(0xFF...) կամ 18.sp — վերցրու այստեղից։
 *
 * Գույների դերերը (ամեն գույն ՄԵԿ գործ ունի, սա դիտավորյալ է).
 *   primary            — ինտերակտիվ՝ կոճակ, ընտրված վիճակ, ավարտված դաս
 *   secondary          — ուշադրություն՝ ընթացիկ դաս, հուշում, շեշտադրում
 *   AppTheme.colors.success — միայն ճիշտ պատասխան
 *   AppTheme.colors.danger  — միայն սխալ պատասխան
 *   AppTheme.colors.streak  — միայն շարք և մրցանակ
 */

// ---------------------------------------------------------------- Palette

/** Հում գունային արժեքները։ Միակ տեղը, որտեղ hex-եր կան։ */
private object Palette {
    // Լապիս կապույտ — ձեռագրերի հիմնական գույնը
    val Lapis = Color(0xFF1F3C77)
    val LapisLight = Color(0xFF7D9CD6)
    val LapisDark = Color(0xFF142A57)
    val LapisSoft = Color(0xFFDCE4F2)

    // Ծիրանագույն սաթ — շեշտադրում
    val Amber = Color(0xFFE08A2E)
    val AmberSoft = Color(0xFFFBEAD3)

    // Վրդան կարմիր — միայն սխալ
    val Karmir = Color(0xFFB32B2B)
    val KarmirSoft = Color(0xFFF7DEDE)

    // Ձեռագրերի կանաչ — միայն ճիշտ
    val Verde = Color(0xFF2E7D52)
    val VerdeSoft = Color(0xFFDDEFE4)

    // Ոսկի — միայն շարք և մրցանակ
    val Gold = Color(0xFFC89B3C)
    val GoldDark = Color(0xFFA37F2E)

    // Մագաղաթ (բաց թեմա) — երբեք մաքուր սպիտակ
    val Parchment = Color(0xFFFBF7F0)
    val ParchmentRaised = Color(0xFFFFFDF9)
    val ParchmentSunken = Color(0xFFF2EBE0)

    // Թանաք (մուգ թեմա) — երբեք մաքուր սև
    val Ink = Color(0xFF14120F)
    val InkRaised = Color(0xFF1E1B17)
    val InkSunken = Color(0xFF2A2621)

    // Տեքստ
    val InkText = Color(0xFF1A1713)
    val InkTextMuted = Color(0xFF5C5348)
    val PaleText = Color(0xFFF2EDE5)
    val PaleTextMuted = Color(0xFFA89E90)

    val HairlineLight = Color(0xFFE2D9CB)
    val HairlineDark = Color(0xFF3A342C)

    val White = Color(0xFFFFFFFF)
}

// ------------------------------------------------------- Semantic colors

/** Այն գույները, որ Material3-ի ColorScheme-ը չի ծածկում։ */
@Immutable
data class AppColors(
    val success: Color,
    val onSuccess: Color,
    val successSurface: Color,
    val danger: Color,
    val onDanger: Color,
    val dangerSurface: Color,
    val streak: Color,
    val streakDeep: Color,
    val accentSurface: Color,
    val surfaceRaised: Color,
    val surfaceSunken: Color,
    val textMuted: Color,
    val hairline: Color,
)

private val LightAppColors = AppColors(
    success = Palette.Verde,
    onSuccess = Palette.White,
    successSurface = Palette.VerdeSoft,
    danger = Palette.Karmir,
    onDanger = Palette.White,
    dangerSurface = Palette.KarmirSoft,
    streak = Palette.Gold,
    streakDeep = Palette.GoldDark,
    accentSurface = Palette.AmberSoft,
    surfaceRaised = Palette.ParchmentRaised,
    surfaceSunken = Palette.ParchmentSunken,
    textMuted = Palette.InkTextMuted,
    hairline = Palette.HairlineLight,
)

private val DarkAppColors = AppColors(
    success = Color(0xFF4CAF7D),
    onSuccess = Color(0xFF0B2117),
    successSurface = Color(0xFF1B3327),
    danger = Color(0xFFE36A6A),
    onDanger = Color(0xFF2A0D0D),
    dangerSurface = Color(0xFF3A1F1F),
    // Մուգ ֆոնի վրա ոսկին շլացնում է — հագեցվածությունը իջեցված է
    streak = Color(0xFFD9B45F),
    streakDeep = Color(0xFFB8933F),
    accentSurface = Color(0xFF3A2D1A),
    surfaceRaised = Palette.InkRaised,
    surfaceSunken = Palette.InkSunken,
    textMuted = Palette.PaleTextMuted,
    hairline = Palette.HairlineDark,
)

private val LocalAppColors = staticCompositionLocalOf { LightAppColors }

// --------------------------------------------------------- Material scheme

private val LightColorScheme = lightColorScheme(
    primary = Palette.Lapis,
    onPrimary = Palette.White,
    primaryContainer = Palette.LapisSoft,
    onPrimaryContainer = Palette.LapisDark,
    secondary = Palette.Amber,
    onSecondary = Color(0xFF3A2208),
    secondaryContainer = Palette.AmberSoft,
    onSecondaryContainer = Color(0xFF6B3F0A),
    error = Palette.Karmir,
    onError = Palette.White,
    surface = Palette.Parchment,
    onSurface = Palette.InkText,
    surfaceVariant = Palette.ParchmentSunken,
    onSurfaceVariant = Palette.InkTextMuted,
    outline = Palette.HairlineLight,
)

private val DarkColorScheme = darkColorScheme(
    primary = Palette.LapisLight,
    onPrimary = Color(0xFF0C1A35),
    primaryContainer = Palette.LapisDark,
    onPrimaryContainer = Color(0xFFD5E0F5),
    secondary = Color(0xFFE8A85C),
    onSecondary = Color(0xFF3A2208),
    secondaryContainer = Color(0xFF4A3418),
    onSecondaryContainer = Color(0xFFF7DDBC),
    error = Color(0xFFE36A6A),
    onError = Color(0xFF2A0D0D),
    surface = Palette.Ink,
    onSurface = Palette.PaleText,
    surfaceVariant = Palette.InkSunken,
    onSurfaceVariant = Palette.PaleTextMuted,
    outline = Palette.HairlineDark,
)

// ------------------------------------------------------------- Typography

private val AppTypography = Typography(
    displayLarge = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 46.sp),
    displayMedium = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 38.sp),
    displaySmall = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold, lineHeight = 34.sp),
    headlineMedium = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, lineHeight = 31.sp),
    headlineSmall = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, lineHeight = 26.sp),
    titleLarge = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, lineHeight = 23.sp),
    titleMedium = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold, lineHeight = 21.sp),
    titleSmall = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold, lineHeight = 18.sp),
    bodyLarge = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal, lineHeight = 24.sp),
    bodyMedium = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal, lineHeight = 21.sp),
    bodySmall = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal, lineHeight = 17.sp),
    labelLarge = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold, lineHeight = 21.sp),
    labelMedium = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.SemiBold, lineHeight = 17.sp),
    labelSmall = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.SemiBold, lineHeight = 15.sp),
)

/**
 * Մեկ հայերեն տառ՝ այբուբենի էկրանների հերոսը։
 * Առայժմ համակարգային տառատեսակն է. հայերենը երևում է համակարգի fallback-ով։
 * Երբ Noto Serif Armenian-ը դնես composeResources/font/-ում, ավելացրու
 * fontFamily = ... այստեղ, և ամբողջ app-ը մեկ տեղից կփոխվի։
 */
val LetterDisplay = TextStyle(
    fontSize = 120.sp,
    fontWeight = FontWeight.Medium,
    lineHeight = 132.sp,
)

/** Հայերեն բառ կամ նախադասություն՝ մարմնի տեքստից մեծ և ծանր։ */
val ArmenianBody = TextStyle(
    fontSize = 22.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 30.sp,
)

// --------------------------------------------------------------- Metrics

/** 8pt բացատների սանդղակ։ Մի գրիր padding(13.dp)։ */
object AppSpacing {
    val xs = 4.dp
    val sm = 8.dp
    val md = 16.dp
    val lg = 24.dp
    val xl = 32.dp
    val xxl = 48.dp
}

/** Կլորացումների սանդղակ։ */
object AppRadius {
    val sm = 12.dp
    val md = 16.dp
    val lg = 20.dp
    val xl = 28.dp
    val pill = 999.dp
}

/** Դիպչելու նվազագույն չափը։ Apple-ը և Google-ը երկուսն էլ 44-48 են պահանջում։ */
object AppSize {
    val minTapTarget = 48.dp
    val buttonHeight = 56.dp
    val lessonNode = 72.dp
    val lessonNodeCurrent = 88.dp
}

// ----------------------------------------------------------------- Theme

/** Կարճ ձև՝ AppTheme.colors.success, AppTheme.spacing.md */
object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val spacing = AppSpacing
    val radius = AppRadius
    val size = AppSize
}

@Composable
fun HayatarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalAppColors provides if (darkTheme) DarkAppColors else LightAppColors
    ) {
        MaterialTheme(
            colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
            typography = AppTypography,
            content = content,
        )
    }
}
