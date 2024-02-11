package it.partenopeteam.fruttella.data.persistence

import android.content.Context
import android.content.SharedPreferences
import it.partenopeteam.fruttella.AppConstants

object PreferencesManager{
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context){
      sharedPreferences =  context.getSharedPreferences(AppConstants.PREFS_FILE_NAME, Context.MODE_PRIVATE)
    }
    fun setValue(value:String, completed: Boolean) {
        with(sharedPreferences.edit()) {
            putBoolean(value, completed)
            apply()
        }
    }

    fun exists(value:String): Boolean {
        return sharedPreferences.getBoolean(value, false)
    }

    fun delete(value: String){
         sharedPreferences.edit().remove(value).commit()
    }
}