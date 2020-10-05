package trinity.core.rest.layer

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("trinity.core.rest.layer")
		.start()
}
