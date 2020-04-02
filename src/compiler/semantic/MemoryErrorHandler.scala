/*
 * Short version for non-lawyers:
 *
 * The ShEx Lite Project is dual-licensed under GNU 3.0 and
 * MIT terms.
 *
 * Longer version:
 *
 * Copyrights in the ShEx Lite project are retained by their contributors. No
 * copyright assignment is required to contribute to the ShEx Lite project.
 *
 * Some files include explicit copyright notices and/or license notices.
 * For full authorship information, see the version control history.
 *
 * Except as otherwise noted (below and/or in individual files), ShEx Lite is
 * licensed under the GNU, Version 3.0 <LICENSE-GNU> or
 * <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
 * <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
 *
 * The ShEx Lite Project includes packages written by third parties.
 */

package compiler.semantic

import compiler.ast.{Error, Warning}

import scala.collection.mutable.ListBuffer

object MemoryErrorHandler extends ErrorHandler {

  val errors = new ListBuffer[Error]()
  var warnings = new ListBuffer[Warning]()

  /**
   * Returns whether the error handler has errors or not.
   *
   * @return true if has errors, false otherwise.
   */
  override def hasErrors: Boolean = !errors.isEmpty

  /**
   * Returns whether the error handler has warnings or not.
   *
   * @return true if has errors, false otherwise.
   */
  override def hasWarnings: Boolean = !warnings.isEmpty

  /**
   * Adds errors to the error system.
   *
   * @param error to add to the system.
   */
  override def addError(error: Error): Unit = errors.addOne(error)

  /**
   * Adds warnings to the error system.
   *
   * @param warning to add to the system.
   */
  override def addWarning(warning: Warning): Unit = warnings.addOne(warning)

  /**
   * Shows the errors through the terminal.
   */
  override def showErrors(): Unit = errors.map(println)

  /**
   * Shows the warnings through the terminal.
   */
  override def showWarnings(): Unit = warnings.map(println)

  /**
   * For mocking this method is added. It restores the symbol table to default values.
   */
  private[compiler] def restore(): Unit = {
    errors.clear()
    warnings.clear()
  }
}
