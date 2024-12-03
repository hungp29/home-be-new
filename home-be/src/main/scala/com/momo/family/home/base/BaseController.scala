package com.momo.family.home.base

import com.momo.family.home.base.ImplicitHttpStatus.RichErrorResult
import play.api.libs.json.{JsPath, JsValue, Json, JsonValidationError, Reads}
import play.api.mvc.{Action, InjectedController, Request, Result, Results}

import scala.collection.Seq

/** Base controller class.
  */
trait BaseController extends InjectedController {

  /** Validate JSON.
    *
    * @param handleValid The handle valid function
    * @tparam T The type of model that the JSON should be validated to
    * @return The action
    */
  def validateJson[T](handleValid: T => Result)(implicit reads: Reads[T]): Action[JsValue] = Action(parse.json) {
    request =>
      request.body
        .validate[T]
        .fold(
          handleJsonError,
          handleValid
        )
  }

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
