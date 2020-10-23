package com.ariskk.burner4s

import org.scalatest.matchers.should.Matchers
import org.scalatest.funspec.AnyFunSpec

class BurnerDBSpec extends AnyFunSpec with Matchers {

  it("looks up emails against an in memory burner emaill database") {
    BurnerDB.contains("aris@ariskk.com") shouldBe false
    BurnerDB.contains("aris@google.com") shouldBe false
    BurnerDB.contains("aris@000476.com") shouldBe true
    BurnerDB.contains("@maildrop.cc") shouldBe true
  }

  it("should work with plain domains") {
    BurnerDB.contains("google.com") shouldBe false
    BurnerDB.contains("maildrop.cc") shouldBe true
  }
}
