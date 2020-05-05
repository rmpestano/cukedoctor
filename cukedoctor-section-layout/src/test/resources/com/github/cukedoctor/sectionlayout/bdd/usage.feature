@section-usage
@order-10
Feature: Usage


  Scenario: Root


  Scenario: Maven plugin
Add cukedoctor-section-layout as a dependency in the Cukedoctor Maven Plugin configuration in your _pom.xml_:

[source, xml]
----
<plugin>
  <groupId>com.github.cukedoctor</groupId>
  <artifactId>cukedoctor-maven-plugin</artifactId>
  <version>2.0</version>
  <executions>
    <execution>
      <goals>
        <goal>execute</goal>
      </goals>
      <phase>install</phase>
    </execution>
  </executions>
  <dependencies>
    <dependency>
      <groupId>com.github.cukedoctor</groupId>
      <artifactId>cukedoctor-section-layout</artifactId>
      <version>2.0</version>
    </dependency>
  </dependencies>
</plugin>
----


  Scenario: CLI
Add cukedoctor-section-layout.jar to your classpath:

----
java -jar cukedoctor-main.jar
  -cp "path/to/cukedoctor-section-layout.jar;."
  -o "target/document-one"
  -p "target/test-classes/json-output/one_passing_one_failing.json"
  -t "Living Documentation"
  -f html
  -numbered
  -hideSummarySection
  -hideScenarioKeyword
----

NOTE: The separator used in the `-cp` argument may not be ";" on your OS.


  Scenario: SPI
  Register the Cukedoctor Section Layout renderer implementations in your https://github.com/rmpestano/cukedoctor/tree/master/cukedoctor-section-layout/src/main/resources/META-INF/services[META-INF/services] directory.