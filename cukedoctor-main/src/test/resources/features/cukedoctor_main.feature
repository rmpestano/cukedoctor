Feature: Cukedoctor Main
  As a user of CukedoctorMain

  I want to generate asciidoc files based on my cucumber test output

  So that I can generate wonderful living documentation

  Scenario: Generate documentation of a single file
    Given A Cucumber json execution file is are already generated
    When I execute CukedoctorMain with args "-o target/test-classes/outputFile.adoc" "-p target/test-classes/json-output/one_passing_one_failing.json" and "-t Documentation"
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
:source-highlighter: highlightjs
:toclevels: 3
:hardbreaks:
:chapter-label: Chapter
:version-label: Version

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
|1|1|2|1|1|0|0|0|0|2 2+|010ms
|===

== *Features*

[[One-passing-scenario-one-failing-scenario, One passing scenario, one failing scenario]]
=== *One passing scenario, one failing scenario*

ifndef::backend-pdf[]
minmax::One-passing-scenario-one-failing-scenario[]
endif::[]
==== Scenario: Passing
[small]#tags: @a,@b#

****
Given ::
=====
this step passes icon:thumbs-up[role="green",title="Passed"] [small right]#(001ms)#
=====
****

==== Scenario: Failing icon:thumbs-down[role="red",title="Failed"]
[small]#tags: @a,@c#

****
Given ::
=====
this step fails icon:thumbs-down[role="red",title="Failed"] [small right]#(008ms)#

IMPORTANT:  (RuntimeError)
./features/step_definitions/steps.rb:4:in /^this step fails$/'
features/one_passing_one_failing.feature:10:in Given this step fails'
=====
****
    """




  Scenario: Generate documentation using multiple files
    Given Cucumber multiple json execution files are already generate
    When I execute CukedoctorMain with args "-o target/test-classes/outputFile.adoc" "-p target/test-classes/json-output/" and "-t Documentation"
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
:source-highlighter: highlightjs
:toclevels: 3
:hardbreaks:
:chapter-label: Chapter
:version-label: Version

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
|0
|0
|0
|0
|0
|0
|0
|0
|0
|000ms
|[green]#*passed*#

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
|1
|2
|3
|1
|0
|0
|0
|0
|4
|10s 104ms
|[red]#*failed*#
12+^|*Totals*
|5|2|7|7|2|0|0|0|0|9 2+|10s 114ms
|===

== *Features*

[[An-embed-data-directly-feature, An embed data directly feature]]
=== *An embed data directly feature*

ifndef::backend-pdf[]
minmax::An-embed-data-directly-feature[]
endif::[]
==== Scenario: scenario 1
****
Given ::
=====
I embed data directly icon:thumbs-up[role="green",title="Passed"] [small right]#(000ms)#
=====
****

==== Scenario Outline: scenario 2
****
Given ::
=====
I embed data directly icon:thumbs-up[role="green",title="Passed"] [small right]#(000ms)#
=====
****

****
Given ::
=====
I embed data directly icon:thumbs-up[role="green",title="Passed"] [small right]#(000ms)#
=====
****

[[An-outline-feature, An outline feature]]
=== *An outline feature*

ifndef::backend-pdf[]
minmax::An-outline-feature[]
endif::[]
==== Scenario Outline: outline icon:thumbs-down[role="red",title="Failed"]

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

[[One-passing-scenario-one-failing-scenario, One passing scenario, one failing scenario]]
=== *One passing scenario, one failing scenario*

ifndef::backend-pdf[]
minmax::One-passing-scenario-one-failing-scenario[]
endif::[]
==== Scenario: Passing
[small]#tags: @a,@b#

****
Given ::
=====
this step passes icon:thumbs-up[role="green",title="Passed"] [small right]#(001ms)#
=====
****

==== Scenario: Failing icon:thumbs-down[role="red",title="Failed"]
[small]#tags: @a,@c#

****
Given ::
=====
this step fails icon:thumbs-down[role="red",title="Failed"] [small right]#(008ms)#

IMPORTANT:  (RuntimeError)
./features/step_definitions/steps.rb:4:in /^this step fails$/'
features/one_passing_one_failing.feature:10:in Given this step fails'
=====
****

[[Sample-test, Sample test]]
=== *Sample test*

ifndef::backend-pdf[]
minmax::Sample-test[]
endif::[]
****
As a user

I want to do something

In order to achieve another thing
****

==== Scenario Outline: Parsing scenarios with multiple examples icon:thumbs-down[role="red",title="Failed"]

.Example
[cols="2*", options="header"]
|===
|a
|b
|1
|2
|===

==== Scenario: Basic
****
Given ::
=====
I navigate to the home page icon:thumbs-up[role="green",title="Passed"] [small right]#(044ms)#
=====
Then ::
=====
I see the text 'Home' icon:thumbs-up[role="green",title="Passed"] [small right]#(001ms)#
=====
****

==== Scenario: Basic failure icon:thumbs-down[role="red",title="Failed"]
****
Given ::
=====
I navigate to the home page icon:thumbs-up[role="green",title="Passed"] [small right]#(040ms)#
=====
Then ::
=====
I see the text 'Hacienda' icon:thumbs-down[role="red",title="Failed"] [small right]#(10s 017ms)#

IMPORTANT: expected to find text "Hacienda" in "Home | Login Clinical Studies some engaging copy View Available Studies" (RSpec::Expectations::ExpectationNotMetError)
./features/step_definitions/study_admin_steps.rb:14:in `/^I see the text '(.+)'$/'
features/test_outline.feature:15:in `Then I see the text 'Hacienda''
=====
****
      """