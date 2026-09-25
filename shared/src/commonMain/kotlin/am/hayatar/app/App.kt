package am.hayatar.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import am.hayatar.app.theme.HayatarTheme

/**
 * Հավելվածի արմատը։
 *
 * Առայժմ դատարկ է. էկրանները կավելանան մեկ առ մեկ դիզայնից։
 * Ամեն նոր էկրան՝ առանձին ֆայլ `screens/`-ում, հետո կանչիր այստեղից։
 */
@Composable
@Preview
fun App() {
    HayatarTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface,
        ) {
            // Էկրանները կգան այստեղ։
        }
    }
}
