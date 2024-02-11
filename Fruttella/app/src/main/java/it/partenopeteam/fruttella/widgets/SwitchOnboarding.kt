package it.partenopeteam.fruttella.widgets

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.partenopeteam.fruttella.AppConstants
import it.partenopeteam.fruttella.data.persistence.PreferencesManager
import it.partenopeteam.fruttella.ui.theme.semiTransparentColor


@Composable
fun SwitchOnboarding() {
    val context = LocalContext.current
    val isOnboardingCompleted = PreferencesManager.exists(AppConstants.ONBOARDING)
    var checked by remember { mutableStateOf(!isOnboardingCompleted) }

    Row(

        modifier =
        Modifier
            .background(
                color = semiTransparentColor,
                shape = RoundedCornerShape(8.dp),


                )

            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isOnboardingCompleted) {
            Text(
                "Disattiva".uppercase(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,

                    fontSize = 18.sp
                )
            )
        } else {
            Text("Attiva".uppercase())
        }
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = checked,
            onCheckedChange = {

                checked = it
                if(it){
                    PreferencesManager.delete(AppConstants.ONBOARDING)
                    val packageManager: PackageManager = context.packageManager
                    val intent: Intent = packageManager.getLaunchIntentForPackage(context.packageName)!!
                    val componentName: ComponentName = intent.component!!
                    val restartIntent: Intent = Intent.makeRestartActivityTask(componentName)
                    context.startActivity(restartIntent)
                    Runtime.getRuntime().exit(0)
                }

            }
        )
    }

}