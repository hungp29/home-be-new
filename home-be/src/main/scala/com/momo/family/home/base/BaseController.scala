package com.momo.family.home.base

import com.momo.family.home.base.ImplicitHttpStatus.RichErrorResult
import play.api.libs.json.{JsPath, Json, JsonValidationError}
import play.api.mvc.{InjectedController, Result, Results}

import scala.collection.Seq

/** Base controller class.
  */
trait BaseController extends InjectedController {

  /** Handle JSON error.
    *
    * @param errors The errors
    * @return The result as a JSON object
    */
  def handleJsonError(errors: Seq[(JsPath, Seq[JsonValidationError])]): Result = {
    val errorDetails = errors.map { case (path, validationErrors) =>
      Json.obj("field" -> path.toString(), "errors" -> validationErrors.map(_.message))
    }

    Results.BadRequest.toJsonResult(
      "INVALID_JSON_PAYLOAD",
      Some("Invalid JSON payload"),
      Some(Json.obj("field_errors" -> errorDetails))
    )
  }
}
