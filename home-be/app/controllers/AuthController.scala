package controllers

import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}

import javax.inject.{Inject, Singleton}

/** This controller handles authentication.
  */
@Singleton
class AuthController @Inject() (val components: ControllerComponents) extends AbstractController(components) {

  def authentication: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok
  }
}
