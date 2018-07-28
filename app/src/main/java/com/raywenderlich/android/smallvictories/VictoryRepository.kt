package com.raywenderlich.android.smallvictories

interface VictoryRepository {
  fun setVictoryTitle(title: String)
  fun getVictoryTitle(): String
  fun setVictoryCount(count: Int)
  fun getVictoryCount(): Int
}