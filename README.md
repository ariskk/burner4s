### Burner4s

Look up email addresses against a burner email database of 100K+ termorary email providers (aka single-use email addresses).

The tool is based on [this list](https://github.com/wesbos/burner-email-providers)

Many of those providers allow programmatic creation which enables horrible application layer attacks.

## Usage

Add the following to `build.sbt`
```scala
libraryDependencies += "com.ariskk" %% "burner4s" % "0.1.0-SNAPSHOT"
```
And then:

```scala
import com.ariskk.burner4s.BurnerDB

val isBurner: Boolean = BurnerDB.contains("someone@gmail.com")
```

Or even

```scala
val isBurner: Boolean = BurnerDB.contains("gmail.com")
```

The implementation essentially loads the database into a `Set` and looks up the domain of the address. It uses ~20MB of memory.
