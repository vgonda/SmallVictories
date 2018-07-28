package com.raywenderlich.android.smallvictories

import android.content.Context

open class Repository(context: Context) : VictoryRepository {
  companion object {

    const val PACKAGE_NAME = "com.raywenderlich.android.smallvictories"
    const val KEY_VICTORY_TITLE = "victory_title"
    const val KEY_VICTORY_COUNT = "victory_count"
  }

  private val sharedPreferences = context.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE)

  override fun setVictoryTitle(title: String) {
    sharedPreferences.edit().putString(KEY_VICTORY_TITLE, title).apply()
  }

  override fun getVictoryTitle(): String {
    return sharedPreferences.getString(KEY_VICTORY_TITLE, "Victory title")
  }

  override fun setVictoryCount(count: Int) {
    sharedPreferences.edit().putInt(KEY_VICTORY_COUNT, count).apply()
  }

  override fun getVictoryCount(): Int {
    return sharedPreferences.getInt(KEY_VICTORY_COUNT, 0)
  }
}