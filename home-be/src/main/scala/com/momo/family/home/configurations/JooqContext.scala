package com.momo.family.home.configurations

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
import org.jooq.impl.DSL
import org.jooq.{DSLContext, SQLDialect}
import play.api.Configuration

import javax.inject.{Inject, Singleton}

@Singleton
class JooqContext @Inject() (config: Configuration) {
  private val hikariConfig = new HikariConfig()
  hikariConfig.setJdbcUrl(config.get[String]("db.default.url"))
  hikariConfig.setUsername(config.get[String]("db.default.username"))
  hikariConfig.setPassword(config.get[String]("db.default.password"))
  hikariConfig.setSchema(config.get[String]("db.default.schema"))

  hikariConfig.setMaximumPoolSize(config.get[Int]("db.default.hikaricp.maximumPoolSize"))
  hikariConfig.setMinimumIdle(config.get[Int]("db.default.hikaricp.minimumIdle"))
  hikariConfig.setConnectionTimeout(config.get[Long]("db.default.hikaricp.connectionTimeout"))
  hikariConfig.setIdleTimeout(config.get[Long]("db.default.hikaricp.idleTimeout"))
  hikariConfig.setMaxLifetime(config.get[Long]("db.default.hikaricp.maxLifetime"))

  private val dataSource = new HikariDataSource(hikariConfig)
  val dslContext: DSLContext = DSL.using(dataSource, SQLDialect.POSTGRES)
}
