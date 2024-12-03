package controllers

import com.momo.family.home.base.BaseController
import com.momo.family.home.models.AuthenticationModel
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, ControllerComponents}

import javax.inject.{Inject, Singleton}

/** This controller handles authentication.
  */
@Singleton
class AuthController @Inject() (val components: ControllerComponents) extends BaseController {

  def authentication: Action[JsValue] = validateJson[AuthenticationModel] { authenticationModel =>
    Ok(Json.toJson(authenticationModel))
  }
}
