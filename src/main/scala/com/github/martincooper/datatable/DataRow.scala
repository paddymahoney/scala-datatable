/**
 * Copyright 2014 Martin Cooper
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.martincooper.datatable

/** Allows access to the underlying data in a row format. */
class DataRow(dataTable: DataTable) {

  val table = dataTable

  val columnNameMap = dataTable.columns.map(col => col.name -> col.data).toMap

  /** Returns all the values for a row at the specified index. */
  def values(index: Int): IndexedSeq[Any] = {
    dataTable.columns.map(_.data(index))
  }

  def value(columnName: String, index: Int) = {
    columnNameMap(columnName)(index)
  }

  def valueOf[T](columnName: String, index: Int): T = {
    columnNameMap(columnName)(index).asInstanceOf[T]
  }
}