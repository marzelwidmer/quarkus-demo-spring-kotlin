package ch.keepcalm.quarkus

import io.quarkus.test.junit.NativeImageTest

@NativeImageTest
open class NativeGreetingResourceIT : GreetingResourceTest()