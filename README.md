# quarkus-gradle-avro-mcve
MCVE for issue with the Quarkus Avro extension and a Gradle multi-subproject build.

As stated by the [official guide](https://quarkus.io/guides/kafka-schema-registry-avro#avro-schema), the `avsc` schema file needs to be located in
`src/main/avro`. When working with a Gradle multi-subproject build, that would be the `src` directory of the Gradle subproject where the Quarkus
Gradle plugin is applied, if I have understood things correctly. In this project, that is the `application` subproject. When building, class files
will be automatically generated from this schema file and put into the `build` folder.

However, as displayed by this example project, it would not be an unusual requirement to have to separate this out into a specific subproject,
perhaps based on a design pattern or the desire to group different technical tools separately.

Since the `application` subproject is meant to assemble the Quarkus application, it needs to specify dependencies on all other subprojects. But,
for the `adapters` subproject to be able to use the generated classes, it would have to depend on the `application` subproject where they get
generated, causing a circular dependency. Also, it would not be far fetched to wish for the `avsc` files to be located in the `adapters`
subproject, where the resulting classes are going to be used.

In the example project, it is easy to move the `avro` directory between the `application` subproject and the `adapters` subproject, executing
`gradle clean` and then `gradle build`, and observing the effects of changing the type of the `lateinit var` field in the two example classes
`Starter` and `KafkaAdapter `from `Any` to `UserCreationRequest`.
