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
:toclevels: 3

= *Documentation*

++++
<span style="float:right">
	<input value="Filter..." onclick="this.value=''" title="Filter features by title" onblur="searchFeature(this.value);"/>
</span>
++++
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

++++
<span class="fa fa-minus-square fa-fw" style="cursor:pointer;float:right;margin-top:-30px" title="minimize" onclick="hideFeatureScenarios('One-passing-scenario-one-failing-scenario');document.getElementById('hidden-One-passing-scenario-one-failing-scenario').style.display = 'inline';this.style.display = 'none'">  </span>

<span id="hidden-One-passing-scenario-one-failing-scenario" class="fa fa-plus-square fa-fw" style="cursor:pointer;float:right;display:none;margin-top:-30px" title="maximize feature" onclick="showFeatureScenarios('One-passing-scenario-one-failing-scenario'); this.style.display = 'none'">  </span>
++++
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


++++
<script type="text/javascript">
	function showFeatureScenarios(featureId){
		var element = document.getElementById(featureId).parentNode;
		for (var i = 0; i < element.childNodes.length; i++) {
    		if (element.childNodes[i].className == "sect3" || element.childNodes[i].className == "fa fa-minus-square fa-fw") {
      		     element.childNodes[i].style.display = 'inline';
    			}
    		if (element.childNodes[i].className == "sidebarblock") {
      		     element.childNodes[i].style.display = 'block';
    			}
		}

 		document.getElementById(featureId).childNodes[0].click();
	}

	function hideFeatureScenarios(featureId){
		var element = document.getElementById(featureId).parentNode;
		for (var i = 0; i < element.childNodes.length; i++) {
    		if (element.childNodes[i].className == "sect3" || element.childNodes[i].className == "sidebarblock") {
      		     element.childNodes[i].style.display = 'none';
                 	}

		}
	   document.getElementById(featureId).childNodes[0].click();
 	}

</script>
++++
++++
<script type = "text/javascript" >
var allLevel2ListItens = null;

function searchFeature(criteria) {
    if (criteria != null && criteria.length >= 3) {
        var sect2List = document.getElementsByClassName("sect2");
        var firstMatch = null;
        if (sect2List != null) {
            for (var i = 0; i < sect2List.length; i++) {
                var h3 = null;
                for (var j = 0; j < sect2List[i].childNodes.length; j++) {
                    if (sect2List[i].childNodes[j].tagName && sect2List[i].childNodes[j].tagName.toUpperCase() == "H3") {
                        h3 = sect2List[i].childNodes[j];
                        break;
                    }
                }
                if (h3 != null && h3.id != null) {
                    if (!h3.id.toLowerCase().match(criteria.toLowerCase())) {
                        sect2List[i].style.display = 'none';
                    } else {//match
                        sect2List[i].style.display = 'inline';
                        if (firstMatch == null) {
                            //used to scroll to after search
                            firstMatch = h3;
                        }
                        //filter toc
                        filterToc(criteria);
                    }
                }
            }//end for

        }//sect2List != null
        if (firstMatch != null) {
            animate(document.body, "scrollTop", "", 0, firstMatch.offsetTop, 200, true);
        }


    }//end criteria.length >=3
    else {//clear search
        clearSearch();
    }
}

function clearSearch() {
    var sect2List = document.getElementsByClassName("sect2");
    if (sect2List != null) {
        for (var i = 0; i < sect2List.length; i++) {
            sect2List[i].style.display = 'inline';
        }//end for
    }//end elements != null

    if (allLevel2ListItens == null) {
        collectallLevel2IListItens();
    }
    for (var z = 0; z < allLevel2ListItens.length; z++) {
        allLevel2ListItens[z].style.display = 'inline';
    }
    if (document.getElementById('input-search')) {
        document.getElementById('input-search').value = 'Filter...';
    }
}

function filterToc(criteria) {
    if (allLevel2ListItens == null) {
        collectallLevel2IListItens();
    }
    for (var z = 0; z < allLevel2ListItens.length; z++) {
        if (allLevel2ListItens[z].childNodes[0].tagName && allLevel2ListItens[z].childNodes[0].tagName.toLowerCase() == "a") {
            if (allLevel2ListItens[z].childNodes[0].getAttribute("href").toUpperCase().substring(1).match(criteria.toUpperCase())) {
                allLevel2ListItens[z].style.display = 'inline';
            } else {
                allLevel2ListItens[z].style.display = 'none';
            }
        }
    }//end for allListItens
}

function animate(elem, style, unit, from, to, time, prop) {
    if (!elem) return;
    var start = new Date().getTime(),
        timer = setInterval(function () {
            var step = Math.min(1, (new Date().getTime() - start) / time);
            if (prop) {
                elem[style] = (from + step * (to - from)) + unit;
            } else {
                elem.style[style] = (from + step * (to - from)) + unit;
            }
            if (step == 1) clearInterval(timer);
        }, 25);
    elem.style[style] = from + unit;
}

function collectallLevel2IListItens() {
    allLevel2ListItens = new Array();
    var uls = document.getElementsByClassName('sectlevel2');
    for (var i = 0; i < uls.length; i++) {
        for (var j = 0; j < uls[i].childNodes.length; j++) {
            if (uls[i].childNodes[j].tagName) {
                if (uls[i].childNodes[j].tagName.toLowerCase() == 'li') {
                    allLevel2ListItens.push(uls[i].childNodes[j]);
                }

            }


        } //end for uls child
    }//end for uls

}
</script>
++++
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
:toclevels: 3

= *Documentation*

++++
<span style="float:right">
	<input value="Filter..." onclick="this.value=''" title="Filter features by title" onblur="searchFeature(this.value);"/>
</span>
++++
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
|10s 104ms
|[red]#*failed*#
12+^|*Totals*
|5|4|9|7|2|0|0|0|3|12 2+|10s 114ms
|===

== *Features*

[[An-embed-data-directly-feature, An embed data directly feature]]
=== *An embed data directly feature*

++++
<span class="fa fa-minus-square fa-fw" style="cursor:pointer;float:right;margin-top:-30px" title="minimize" onclick="hideFeatureScenarios('An-embed-data-directly-feature');document.getElementById('hidden-An-embed-data-directly-feature').style.display = 'inline';this.style.display = 'none'">  </span>

<span id="hidden-An-embed-data-directly-feature" class="fa fa-plus-square fa-fw" style="cursor:pointer;float:right;display:none;margin-top:-30px" title="maximize feature" onclick="showFeatureScenarios('An-embed-data-directly-feature'); this.style.display = 'none'">  </span>
++++
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

[[An-outline-feature, An outline feature]]
=== *An outline feature*

++++
<span class="fa fa-minus-square fa-fw" style="cursor:pointer;float:right;margin-top:-30px" title="minimize" onclick="hideFeatureScenarios('An-outline-feature');document.getElementById('hidden-An-outline-feature').style.display = 'inline';this.style.display = 'none'">  </span>

<span id="hidden-An-outline-feature" class="fa fa-plus-square fa-fw" style="cursor:pointer;float:right;display:none;margin-top:-30px" title="maximize feature" onclick="showFeatureScenarios('An-outline-feature'); this.style.display = 'none'">  </span>
++++
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

[[One-passing-scenario-one-failing-scenario, One passing scenario, one failing scenario]]
=== *One passing scenario, one failing scenario*

++++
<span class="fa fa-minus-square fa-fw" style="cursor:pointer;float:right;margin-top:-30px" title="minimize" onclick="hideFeatureScenarios('One-passing-scenario-one-failing-scenario');document.getElementById('hidden-One-passing-scenario-one-failing-scenario').style.display = 'inline';this.style.display = 'none'">  </span>

<span id="hidden-One-passing-scenario-one-failing-scenario" class="fa fa-plus-square fa-fw" style="cursor:pointer;float:right;display:none;margin-top:-30px" title="maximize feature" onclick="showFeatureScenarios('One-passing-scenario-one-failing-scenario'); this.style.display = 'none'">  </span>
++++
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

[[Sample-test, Sample test]]
=== *Sample test*

++++
<span class="fa fa-minus-square fa-fw" style="cursor:pointer;float:right;margin-top:-30px" title="minimize" onclick="hideFeatureScenarios('Sample-test');document.getElementById('hidden-Sample-test').style.display = 'inline';this.style.display = 'none'">  </span>

<span id="hidden-Sample-test" class="fa fa-plus-square fa-fw" style="cursor:pointer;float:right;display:none;margin-top:-30px" title="maximize feature" onclick="showFeatureScenarios('Sample-test'); this.style.display = 'none'">  </span>
++++
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


++++
<script type="text/javascript">
	function showFeatureScenarios(featureId){
		var element = document.getElementById(featureId).parentNode;
		for (var i = 0; i < element.childNodes.length; i++) {
    		if (element.childNodes[i].className == "sect3" || element.childNodes[i].className == "fa fa-minus-square fa-fw") {
      		     element.childNodes[i].style.display = 'inline';
    			}
    		if (element.childNodes[i].className == "sidebarblock") {
      		     element.childNodes[i].style.display = 'block';
    			}
		}

 		document.getElementById(featureId).childNodes[0].click();
	}

	function hideFeatureScenarios(featureId){
		var element = document.getElementById(featureId).parentNode;
		for (var i = 0; i < element.childNodes.length; i++) {
    		if (element.childNodes[i].className == "sect3" || element.childNodes[i].className == "sidebarblock") {
      		     element.childNodes[i].style.display = 'none';
                 	}

		}
	   document.getElementById(featureId).childNodes[0].click();
 	}

</script>
++++
++++
<script type = "text/javascript" >
var allLevel2ListItens = null;

function searchFeature(criteria) {
    if (criteria != null && criteria.length >= 3) {
        var sect2List = document.getElementsByClassName("sect2");
        var firstMatch = null;
        if (sect2List != null) {
            for (var i = 0; i < sect2List.length; i++) {
                var h3 = null;
                for (var j = 0; j < sect2List[i].childNodes.length; j++) {
                    if (sect2List[i].childNodes[j].tagName && sect2List[i].childNodes[j].tagName.toUpperCase() == "H3") {
                        h3 = sect2List[i].childNodes[j];
                        break;
                    }
                }
                if (h3 != null && h3.id != null) {
                    if (!h3.id.toLowerCase().match(criteria.toLowerCase())) {
                        sect2List[i].style.display = 'none';
                    } else {//match
                        sect2List[i].style.display = 'inline';
                        if (firstMatch == null) {
                            //used to scroll to after search
                            firstMatch = h3;
                        }
                        //filter toc
                        filterToc(criteria);
                    }
                }
            }//end for

        }//sect2List != null
        if (firstMatch != null) {
            animate(document.body, "scrollTop", "", 0, firstMatch.offsetTop, 200, true);
        }


    }//end criteria.length >=3
    else {//clear search
        clearSearch();
    }
}

function clearSearch() {
    var sect2List = document.getElementsByClassName("sect2");
    if (sect2List != null) {
        for (var i = 0; i < sect2List.length; i++) {
            sect2List[i].style.display = 'inline';
        }//end for
    }//end elements != null

    if (allLevel2ListItens == null) {
        collectallLevel2IListItens();
    }
    for (var z = 0; z < allLevel2ListItens.length; z++) {
        allLevel2ListItens[z].style.display = 'inline';
    }
    if (document.getElementById('input-search')) {
        document.getElementById('input-search').value = 'Filter...';
    }
}

function filterToc(criteria) {
    if (allLevel2ListItens == null) {
        collectallLevel2IListItens();
    }
    for (var z = 0; z < allLevel2ListItens.length; z++) {
        if (allLevel2ListItens[z].childNodes[0].tagName && allLevel2ListItens[z].childNodes[0].tagName.toLowerCase() == "a") {
            if (allLevel2ListItens[z].childNodes[0].getAttribute("href").toUpperCase().substring(1).match(criteria.toUpperCase())) {
                allLevel2ListItens[z].style.display = 'inline';
            } else {
                allLevel2ListItens[z].style.display = 'none';
            }
        }
    }//end for allListItens
}

function animate(elem, style, unit, from, to, time, prop) {
    if (!elem) return;
    var start = new Date().getTime(),
        timer = setInterval(function () {
            var step = Math.min(1, (new Date().getTime() - start) / time);
            if (prop) {
                elem[style] = (from + step * (to - from)) + unit;
            } else {
                elem.style[style] = (from + step * (to - from)) + unit;
            }
            if (step == 1) clearInterval(timer);
        }, 25);
    elem.style[style] = from + unit;
}

function collectallLevel2IListItens() {
    allLevel2ListItens = new Array();
    var uls = document.getElementsByClassName('sectlevel2');
    for (var i = 0; i < uls.length; i++) {
        for (var j = 0; j < uls[i].childNodes.length; j++) {
            if (uls[i].childNodes[j].tagName) {
                if (uls[i].childNodes[j].tagName.toLowerCase() == 'li') {
                    allLevel2ListItens.push(uls[i].childNodes[j]);
                }

            }


        } //end for uls child
    }//end for uls

}
</script>
++++
      """