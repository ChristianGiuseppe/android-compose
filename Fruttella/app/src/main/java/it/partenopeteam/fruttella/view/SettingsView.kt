package it.partenopeteam.fruttella.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import it.partenopeteam.fruttella.R
import it.partenopeteam.fruttella.widgets.GroupBoxWidget
import it.partenopeteam.fruttella.widgets.SettingsRowWidget
import it.partenopeteam.fruttella.widgets.SwitchOnboarding


@Composable
fun SettingsView() {
    val context = LocalContext.current
    val versionCode: Int
    val versioneName: String
    val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
    versioneName =  packageInfo.versionName
        versionCode = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            // Da API level 28 in poi, usa longVersionCode e fai il cast a Int
            packageInfo.longVersionCode.toInt()
        } else {
            // Per API level precedenti, usa versionCode direttamente
            packageInfo.versionCode
        }
    Column(
        modifier = Modifier
            .padding(16.dp).verticalScroll(rememberScrollState())
    ) {
        Text(
            "Impostazioni",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displayMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        GroupBoxWidget(title = "Frutella", icon = Icons.Default.Info) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "La maggior parte della frutta è naturalmente povera di grassi, sodio e calorie. Nessuno ha il colesterolo. I frutti sono fonti di molti nutrienti essenziali, tra cui fibre alimentari di potassio, vitamine e molto altro.")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        GroupBoxWidget(title = "Personalizzazione", icon = Icons.Default.Edit) {
            Column {
                Text(text = "Se lo desideri, puoi riavviare l'applicazione attivando l'interruttore in questa casella. In questo modo verrà avviato il processo di onboarding e vedrai nuovamente la schermata di benvenuto.")
                Spacer(modifier = Modifier.height(16.dp))
                SwitchOnboarding()

            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        GroupBoxWidget(title = "Applicazione", icon = Icons.Default.AccountBox) {
            Column {
                SettingsRowWidget(
                    label = "Developer",
                    text = "Christian Nocerino"
                )
                Divider(color = Color.DarkGray, thickness = 1.dp)
                SettingsRowWidget(
                    label = "Design",
                    text = "Christian Nocerino"
                )
                Divider(color = Color.DarkGray, thickness = 1.dp)
                SettingsRowWidget(
                    label = "Versione",
                    text = versionCode.toString()
                )
                Divider(color = Color.DarkGray, thickness = 1.dp)
                SettingsRowWidget(
                    label = "App",
                    text = versioneName
                )
            }
        }

    }
}


