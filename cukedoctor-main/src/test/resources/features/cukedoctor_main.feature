Feature: Cukedoctor Main
  As a user of CukedoctorMain
  I want to generate asciidoc files based on my cucumber test output
  So that I can generate wonderful living documentation

  Scenario: Generate documentation of a single file
    Given A Cucumber json execution file is are already generated
    When I execute CukedoctorMain with args "-o target/test-classes/outputFile.adoc" "-p target/test-classes/json-output/one_passing_one_failing.json" and "-t Documentation"
    Then A file named outputFile.adoc should be generated with the following content:
    """
     :toc:right
:backend:html5
:doctitle:Documentation
:doctype:book
:icons:font
:!numbered:
:!linkcss:
:sectanchors:
:sectlink:
:docinfo:
:toclevels:3

=*Documentation*

==*Summary*
[cols="12*^m",options="header,footer"]
|===
3+|Scenarios7+|Steps2+|Features:1

|[green]#*Passed*#
|[red]#*Failed*#
|Total
|[green]#*Passed*#
|[red]#*Failed*#
|[purple]#*Skipped*#
|[maroon]#*Pending*#
|[yellow]#*Undefined*#
|[blue]#*Missing*#
|Total
|Duration
|Status

12+^|*<<One-passing-scenario-one-failing-scenario>>*
|1
|1
|2
|1
|1
|0
|0
|0
|0
|2
|010ms
|[red]#*failed*#
12+^|*Totals*
|1|1|2|1|1|0|0|0|0|22+|010ms
|===

==*Features*

[[One-passing-scenario-one-failing-scenario,Onepassingscenario,onefailingscenario]]
===*Onepassingscenario,onefailingscenario*

minmax::One-passing-scenario-one-failing-scenario[]
====Scenario:Passing
[small]#tags:@a,@b#

****
Given::
thissteppassesicon:thumbs-up[role="green",title="Passed"][smallright]#(001ms)#
****

====Scenario:Failing
[small]#tags:@a,@c#

****
Given::
thisstepfailsicon:thumbs-down[role="red",title="Failed"][smallright]#(008ms)#

IMPORTANT:(RuntimeError)
./features/step_definitions/steps.rb:4:in/^thisstepfails$/'
features/one_passing_one_failing.feature:10:inGiventhisstepfails'
****

    """




  Scenario: Generate documentation using multiple files
    Given Cucumber multiple json execution files are already generate
    When I execute CukedoctorMain with args "-o target/test-classes/outputFile.adoc" "-p target/test-classes/json-output/" and "-t Documentation"
    Then A file named outputFile.adoc should be generated with the following content:
      """
       :toc:right
:backend:html5
:doctitle:Documentation
:doctype:book
:icons:font
:!numbered:
:!linkcss:
:sectanchors:
:sectlink:
:docinfo:
:toclevels:3

=*Documentation*

==*Summary*
[cols="12*^m",options="header,footer"]
|===
3+|Scenarios7+|Steps2+|Features:4

|[green]#*Passed*#
|[red]#*Failed*#
|Total
|[green]#*Passed*#
|[red]#*Failed*#
|[purple]#*Skipped*#
|[maroon]#*Pending*#
|[yellow]#*Undefined*#
|[blue]#*Missing*#
|Total
|Duration
|Status

12+^|*<<An-embed-data-directly-feature>>*
|3
|0
|3
|3
|0
|0
|0
|0
|0
|3
|000ms
|[green]#*passed*#

12+^|*<<An-outline-feature>>*
|0
|1
|1
|0
|0
|0
|0
|0
|1
|1
|000ms
|[red]#*failed*#

12+^|*<<One-passing-scenario-one-failing-scenario>>*
|1
|1
|2
|1
|1
|0
|0
|0
|0
|2
|010ms
|[red]#*failed*#

12+^|*<<Sample-test>>*
|1
|2
|3
|3
|1
|0
|0
|0
|2
|6
|10s104ms
|[red]#*failed*#
12+^|*Totals*
|5|4|9|7|2|0|0|0|3|122+|10s114ms
|===

==*Features*

[[An-embed-data-directly-feature,Anembeddatadirectlyfeature]]
===*Anembeddatadirectlyfeature*

minmax::An-embed-data-directly-feature[]
====Scenario:scenario1
****
Given::
Iembeddatadirectlyicon:thumbs-up[role="green",title="Passed"][smallright]#(000ms)#
****

====ScenarioOutline:scenario2
****
Given::
Iembeddatadirectlyicon:thumbs-up[role="green",title="Passed"][smallright]#(000ms)#
****

****
Given::
Iembeddatadirectlyicon:thumbs-up[role="green",title="Passed"][smallright]#(000ms)#
****

[[An-outline-feature,Anoutlinefeature]]
===*Anoutlinefeature*

minmax::An-outline-feature[]
====ScenarioOutline:outline

.examples1
[cols="1*",options="header"]
|===
|status
|passes
|fails
|===

.examples2
[cols="1*",options="header"]
|===
|status
|passes
|===

[[One-passing-scenario-one-failing-scenario,Onepassingscenario,onefailingscenario]]
===*Onepassingscenario,onefailingscenario*

minmax::One-passing-scenario-one-failing-scenario[]
====Scenario:Passing
[small]#tags:@a,@b#

****
Given::
thissteppassesicon:thumbs-up[role="green",title="Passed"][smallright]#(001ms)#
****

====Scenario:Failing
[small]#tags:@a,@c#

****
Given::
thisstepfailsicon:thumbs-down[role="red",title="Failed"][smallright]#(008ms)#

IMPORTANT:(RuntimeError)
./features/step_definitions/steps.rb:4:in/^thisstepfails$/'
features/one_passing_one_failing.feature:10:inGiventhisstepfails'
****

[[Sample-test,Sampletest]]
===*Sampletest*

minmax::Sample-test[]
****
Asauser+
Iwanttodosomething+
Inordertoachieveanotherthing
****

====ScenarioOutline:Parsingscenarioswithmultipleexamples

.Example
[cols="2*",options="header"]
|===
|a
|b
|1
|2
|===

====Scenario:Basic
****
Given::
Inavigatetothehomepageicon:thumbs-up[role="green",title="Passed"][smallright]#(044ms)#
Then::
Iseethetext'Home'icon:thumbs-up[role="green",title="Passed"][smallright]#(001ms)#
****

====Scenario:Basicfailure
****
Given::
Inavigatetothehomepageicon:thumbs-up[role="green",title="Passed"][smallright]#(040ms)#
Then::
Iseethetext'Hacienda'icon:thumbs-down[role="red",title="Failed"][smallright]#(10s017ms)#

IMPORTANT:expectedtofindtext"Hacienda"in"Home|LoginClinicalStudiessomeengagingcopyViewAvailableStudies"(RSpec::Expectations::ExpectationNotMetError)
./features/step_definitions/study_admin_steps.rb:14:in`/^Iseethetext'(.+)'$/'
features/test_outline.feature:15:in`ThenIseethetext'Hacienda''
****
      """