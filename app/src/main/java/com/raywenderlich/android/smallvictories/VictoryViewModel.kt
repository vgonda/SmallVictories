/*
 *
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.smallvictories

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context


class VictoryViewModel : ViewModel() {

  val viewState: MutableLiveData<VictoryUiModel> = MutableLiveData()
  private lateinit var repository: Repository

  fun initialize(context: Context) {
    this.repository = Repository(context)
    viewState.postValue(VictoryUiModel(repository.victoryTitle, 0))
  }

  fun setVictoryTitle(title: String) {
    repository.victoryTitle = title
    viewState.postValue(VictoryUiModel(title, 0))
  }

  fun incrementVictoryCount() {

  }
}

class Repository(context: Context) {
  companion object {

    const val PACKAGE_NAME = "com.raywenderlich.android.smallvictories"
    const val KEY_VICTORY_TITLE = "victory_title"
    const val KEY_VICTORY_COUNT = "victory_count"
  }

  private val sharedPreferences = context.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE)

  var victoryTitle: String
    get() = sharedPreferences.getString(KEY_VICTORY_TITLE, "Victory title")
    set(value) = sharedPreferences.edit().putString(KEY_VICTORY_TITLE, value).apply()

  var victoryCount: Int
    get() = sharedPreferences.getInt(KEY_VICTORY_COUNT, 0)
    set(value) = sharedPreferences.edit().putInt(KEY_VICTORY_COUNT, value).apply()
}
