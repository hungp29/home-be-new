package com.momo.family.home.base

import play.api.libs.json.{JsObject, Json}
import play.api.mvc.Result
import play.api.mvc.Results.Status

object ImplicitHttpStatus {

  /** Implicit class to add toJsonResult method to Status.
    */
  implicit class RichErrorResult(result: Status) {

    /** Convert the result to a JSON object with error details.
      *
      * @param errorCode The error code
      * @param message The error message
      * @param details The error details
      * @return The result as a JSON object
      */
    def toJsonResult(errorCode: String, message: Option[String] = None, details: Option[JsObject] = None): Result = {
      result(
        Json.obj(
          "error" -> Json.obj(
            "status" -> result.header.status,
            "error_code" -> errorCode,
            "message" -> message,
            "details" -> details
          )
        )
      )
    }
  }
}
