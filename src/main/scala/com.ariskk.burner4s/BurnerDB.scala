package com.ariskk.burner4s

object BurnerDB {

  private val db =
    scala.io.Source.fromInputStream(getClass.getResourceAsStream("/emails.txt")).getLines().toSet

  def contains(email: String): Boolean =
    Option(email)
      .flatMap(
        _.split("@").lastOption.map(db.contains)
      )
      .getOrElse(false)
}
