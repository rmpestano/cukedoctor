Feature: Attachments
  ====
  [quote]
  ____
  In order to capture dynamically-generated content from my tests
  As a bdd developer
  I want to render attachments from my Cucumber tests in my living documentation
  ____
  ====


  Scenario: Logging a string in Cucumber-JVM 6.7.0

    Given a Step has logged a string in Cucumber-JVM 6.7.0
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
= *Features*


[[Attachments, Attachments]]
== *Attachments*

=== Scenario: Cucumber JVM 6.7.0 scenario.log(String)

==========
Given ::
a Step that performs scenario.log(String) icon:thumbs-up[role="green",title="Passed"]
----
She sells sea shells on the sea shore
----
==========


"""

  Scenario: Attaching plain text as a string with name in Cucumber-JVM 6.7.0

    Given a Step has attached plain text as a string with a title in Cucumber-JVM 6.7.0
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
= *Features*


[[Attachments, Attachments]]
== *Attachments*

=== Scenario: Cucumber JVM 6.7.0 scenario.attach(String, String, String)

==========
Given ::
a Step that performs scenario.attach(String, String, String) icon:thumbs-up[role="green",title="Passed"]

.String plain text
[%collapsible]
=====
She sells sea shells on the sea shore
=====
==========


"""


  Scenario: Attaching plain text as a byte array with name in Cucumber-JVM 6.7.0

    Given a Step has attached plain text as a byte array with a title in Cucumber-JVM 6.7.0
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
= *Features*


[[Attachments, Attachments]]
== *Attachments*

=== Scenario: Cucumber JVM 6.7.0 scenario.attach(ByteArray, String, String)

==========
Given ::
a Step that performs scenario.attach(ByteArray, String, String) icon:thumbs-up[role="green",title="Passed"]

.Byte[] plain text
[%collapsible]
=====
She sells sea shells on the sea shore
=====
==========


"""


  Scenario: Attaching a string CucumberJS 6.0.5

    Given a Step has attached a string in CucumberJS 6.0.5
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
= *Features*


[[Attachments, Attachments]]
== *Attachments*

=== Scenario: Cucumber JS 6.0.5 attach String

==========
Given ::
a Step that performs attach String icon:thumbs-up[role="green",title="Passed"]

.Attachment 1
[%collapsible]
=====
She sells sea shells on the sea shore
=====
==========


"""


  Scenario: Attaching a plain text string CucumberJS 6.0.5

    Given a Step has attached plain text as a string in CucumberJS 6.0.5
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
= *Features*


[[Attachments, Attachments]]
== *Attachments*

=== Scenario: Cucumber JS 6.0.5 attach String, String

==========
Given ::
a Step that performs attach String, String icon:thumbs-up[role="green",title="Passed"]

.Attachment 1
[%collapsible]
=====
She sells sea shells on the sea shore
=====
==========


"""


  Scenario: Attaching a plain text buffer CucumberJS 6.0.5

    Given a Step has attached plain text as a buffer in CucumberJS 6.0.5
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
= *Features*


[[Attachments, Attachments]]
== *Attachments*

=== Scenario: Cucumber JS 6.0.5 attach Buffer, String

==========
Given ::
a Step that performs attach Buffer, String icon:thumbs-up[role="green",title="Passed"]

.Attachment 1
[%collapsible]
=====
She sells sea shells on the sea shore
=====
==========


"""


  Scenario: Logged text should appear before attachments

    Given a Step has logged a string and attached a plain text string with a title
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
= *Features*


[[Attachments, Attachments]]
== *Attachments*

=== Scenario: Log and attach

==========
Given ::
a Step that logs and attaches icon:thumbs-up[role="green",title="Passed"]
----
Peter Piper picked a peck of pickled peppers
----

.String plain text
[%collapsible]
=====
She sells sea shells on the sea shore
=====
==========


"""


  Scenario: Multiple attachments

    Given a Step has three plain text attachments, two without a title
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
= *Features*


[[Attachments, Attachments]]
== *Attachments*

=== Scenario: Multiple attachments

==========
Given ::
a Step that has multiple attachments icon:thumbs-up[role="green",title="Passed"]

.Attachment 1
[%collapsible]
=====
First attachment
=====

.Second
[%collapsible]
=====
Second Attachment
=====

.Attachment 2
[%collapsible]
=====
Third attachment
=====
==========


"""


  Scenario: Do not render attachments that are not plain text

    Given a Step has logged an image/png attachment
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
= *Features*


[[Attachments, Attachments]]
== *Attachments*

=== Scenario: Attaching an image

==========
Given ::
a Step that attaches an image icon:thumbs-up[role="green",title="Passed"]
==========


"""