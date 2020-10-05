package org.kubinity.worldserver.companion

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("org.kubinity.worldserver.companion")
		.start()
}
