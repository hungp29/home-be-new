package services

import com.momo.family.home.base.ImplicitHttpStatus.RichErrorResult
import play.api.http.HttpErrorHandler
import play.api.mvc.{RequestHeader, Result, Results}

import javax.inject.Singleton
import scala.concurrent.Future

/** Error handle service.
  */
@Singleton
class ErrorHandleService extends HttpErrorHandler {

  /** Handle client error.
    *
    * @param request The request header
    * @param statusCode The status code
    * @param message The error message
    * @return The result as a JSON object
    */
  override def onClientError(request: RequestHeader, statusCode: Int, message: String): Future[Result] = {
    Future.successful(
      if (statusCode == 400) {
        Results.BadRequest.toJsonResult("CLIENT_BAD_REQUEST", Some(message))
      } else if (statusCode == 404) {
        Results.NotFound.toJsonResult("NOT_FOUND", Some(message))
      } else {
        Results.Status(statusCode).toJsonResult("CLIENT_ERROR", Some(message))
      }
    )
  }

  override def onServerError(request: RequestHeader, exception: Throwable): Future[Result] = ???
}
