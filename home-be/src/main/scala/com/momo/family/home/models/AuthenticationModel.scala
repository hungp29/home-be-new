package com.momo.family.home.models

import play.api.libs.json.{Json, OFormat, Reads}

case class AuthenticationModel(username: String, password: String, rememberMe: Option[Boolean])

object AuthenticationModel {
  implicit val authenticationModelFormat: OFormat[AuthenticationModel] = Json.format[AuthenticationModel]
  implicit val reads: Reads[AuthenticationModel] = Json.reads[AuthenticationModel]
}
