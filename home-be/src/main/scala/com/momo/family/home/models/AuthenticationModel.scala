package com.momo.family.home.models

import play.api.libs.json.{Json, OFormat}

case class AuthenticationModel(username: String, password: String, rememberMe: Option[Boolean])

object AuthenticationModel {
  implicit val authenticationModelFormat: OFormat[AuthenticationModel] = Json.format[AuthenticationModel]
}
