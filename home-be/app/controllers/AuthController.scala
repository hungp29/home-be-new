package controllers

import com.momo.family.home.base.BaseController
import com.momo.family.home.models.AuthenticationModel
import play.api.libs.json.{JsSuccess, JsValue, Json}
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}

import javax.inject.{Inject, Singleton}

/** This controller handles authentication.
  */
@Singleton
class AuthController @Inject() (val components: ControllerComponents) extends BaseController {

  def authentication: Action[JsValue] = Action(parse.json) { request =>
    request.body
      .validate[AuthenticationModel]
      .fold(
        handleJsonError,
        authenticationModel => Ok(Json.toJson(authenticationModel))
      )
  }
}
