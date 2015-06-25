Feature: Cukedoctor Main
  As a user of CukedoctorMain
  I want to generate asciidoc files based on my cucumber test output
  So that I can generate wonderful living documentation

  Scenario: Generate documentation of a single file
    Given A Cucumber json execution file is are already generated
    When I execute CukedoctorMain with args "-o /target/test-classes/outputFile.adoc" "-p /target/test-classes/json-output/one_passing_one_failing.json" and "-t Documentation"
    Then A file named outputFile.adoc should be generated with the following content:
    """
    :toc: right
:backend: html5
:doctitle: Documentation
:doctype: book
:icons: font
:!numbered:
:!linkcss:
:sectanchors:
:sectlink:
:docinfo:
:toclevels: 3

= *Documentation*

== *Summary*
[cols="12*^m", options="header,footer"]
|===
3+|Scenarios 7+|Steps 2+|Features: 1

|[green]#*Passed*#
|[red]#*Failed*#
|Total
|[green]#*Passed*#
|[red]#*Failed*#
|[purple]#*Skipped*#
|[orange]#*Pending*#
|[yellow]#*Undefined*#
|[blue]#*Missing*#
|Total
|Duration
|Status

12+^|*<<One passing scenario, one failing scenario>>*
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
|1|1|2|1|1|0|0|0|0|2 2+|010ms
|===

== *Features*

=== One passing scenario, one failing scenario

==== Scenario: Passing
[small]#tags: @a,@b#

****
Given ::
this step passes icon:thumbs-up[role="green",title="Passed"] [small right]#(001ms)#
****

==== Scenario: Failing
[small]#tags: @a,@c#

****
Given ::
this step fails icon:thumbs-down[role="red",title="Failed"] [small right]#(008ms)#

IMPORTANT:  (RuntimeError)
./features/step_definitions/steps.rb:4:in /^this step fails$/'
features/one_passing_one_failing.feature:10:in Given this step fails'
****


    """




  Scenario: Generate documentation using multiple files
    Given Cucumber multiple json execution files are already generate
    When I execute CukedoctorMain with args "-o /target/test-classes/outputFile.adoc" "-p /target/test-classes/json-output/" and "-t Documentation"
    Then A file named outputFile.adoc should be generated with the following content:
      """
      :toc: right
:backend: html5
:doctitle: Documentation
:doctype: book
:icons: font
:!numbered:
:!linkcss:
:sectanchors:
:sectlink:
:docinfo:
:toclevels: 3

= *Documentation*

== *Summary*
[cols="12*^m", options="header,footer"]
|===
3+|Scenarios 7+|Steps 2+|Features: 4

|[green]#*Passed*#
|[red]#*Failed*#
|Total
|[green]#*Passed*#
|[red]#*Failed*#
|[purple]#*Skipped*#
|[orange]#*Pending*#
|[yellow]#*Undefined*#
|[blue]#*Missing*#
|Total
|Duration
|Status

12+^|*<<An embed data directly feature>>*
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

12+^|*<<An outline feature>>*
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

12+^|*<<One passing scenario, one failing scenario>>*
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

12+^|*<<Sample test>>*
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
|10s 104ms
|[red]#*failed*#
12+^|*Totals*
|5|4|9|7|2|0|0|0|3|12 2+|10s 114ms
|===

== *Features*

=== An embed data directly feature

==== Scenario: scenario 1
****
Given ::
I embed data directly icon:thumbs-up[role="green",title="Passed"] [small right]#(000ms)#
****

==== Scenario Outline: scenario 2
****
Given ::
I embed data directly icon:thumbs-up[role="green",title="Passed"] [small right]#(000ms)#
****

****
Given ::
I embed data directly icon:thumbs-up[role="green",title="Passed"] [small right]#(000ms)#
****

=== An outline feature

==== Scenario Outline: outline

.examples1
[cols="1*", options="header"]
|===
|status
|passes
|fails
|===

.examples2
[cols="1*", options="header"]
|===
|status
|passes
|===

****
Given ::
this step <status> icon:thumbs-down[role="blue",title="Missing"]
****

=== One passing scenario, one failing scenario

==== Scenario: Passing
[small]#tags: @a,@b#

****
Given ::
this step passes icon:thumbs-up[role="green",title="Passed"] [small right]#(001ms)#
****

==== Scenario: Failing
[small]#tags: @a,@c#

****
Given ::
this step fails icon:thumbs-down[role="red",title="Failed"] [small right]#(008ms)#

IMPORTANT:  (RuntimeError)
./features/step_definitions/steps.rb:4:in /^this step fails$/'
features/one_passing_one_failing.feature:10:in Given this step fails'
****

=== Sample test

****
As a user  +
I want to do something  +
In order to achieve another thing
****

==== Scenario Outline: Parsing scenarios with multiple examples

.Example
[cols="2*", options="header"]
|===
|a
|b
|1
|2
|===

****
Given ::
I navigate to the home page icon:thumbs-down[role="blue",title="Missing"]
Then ::
I see the text 'Home' icon:thumbs-down[role="blue",title="Missing"]
****

==== Scenario: Basic
****
Given ::
I navigate to the home page icon:thumbs-up[role="green",title="Passed"] [small right]#(044ms)#
Then ::
I see the text 'Home' icon:thumbs-up[role="green",title="Passed"] [small right]#(001ms)#
****

==== Scenario: Basic failure
****
Given ::
I navigate to the home page icon:thumbs-up[role="green",title="Passed"] [small right]#(040ms)#
Then ::
I see the text 'Hacienda' icon:thumbs-down[role="red",title="Failed"] [small right]#(10s 017ms)#

IMPORTANT: expected to find text "Hacienda" in "Home | Login Clinical Studies some engaging copy View Available Studies" (RSpec::Expectations::ExpectationNotMetError)
./features/step_definitions/study_admin_steps.rb:14:in `/^I see the text '(.+)'$/'
features/test_outline.feature:15:in `Then I see the text 'Hacienda''
****


      """