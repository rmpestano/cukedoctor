$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("broadcast.feature");
formatter.feature({
  "line": 1,
  "name": "Broadcast",
  "description": "",
  "id": "broadcast",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5456185,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 315964153,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 7865760,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 102549021,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "A command is issued with no prior Broadcast received",
  "description": "",
  "id": "broadcast;a-command-is-issued-with-no-prior-broadcast-received",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "no prior Broadcast was received",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "a new Broadcast \"This is a LIVE Broadcast!\" with id \"12345\" is available",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I enter \"sdk version\"",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I see \"This is a LIVE Broadcast!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "broadcast_steps.groovy:6"
});
formatter.result({
  "duration": 950326,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is a LIVE Broadcast!",
      "offset": 17
    },
    {
      "val": "12345",
      "offset": 53
    }
  ],
  "location": "broadcast_steps.groovy:11"
});
formatter.result({
  "duration": 22721491,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk version",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 101824887,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is a LIVE Broadcast!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 1439865,
  "status": "passed"
});
formatter.write("\nOutput: \n\nThis is a LIVE Broadcast!\nSDKMAN x.y.z\n\n\n");
formatter.after({
  "duration": 3199472,
  "status": "passed"
});
formatter.before({
  "duration": 3739620,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 33083452,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 5781522,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101658442,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "A command is issued where the prior Broadcast was different to the Live one",
  "description": "",
  "id": "broadcast;a-command-is-issued-where-the-prior-broadcast-was-different-to-the-live-one",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "a prior Broadcast \"This is an OLD Broadcast!\" with id \"12344\" was issued",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "a new Broadcast \"This is a LIVE Broadcast!\" with id \"12345\" is available",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I enter \"sdk version\"",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I see \"This is a LIVE Broadcast!\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "This is an OLD Broadcast!",
      "offset": 19
    },
    {
      "val": "12344",
      "offset": 55
    }
  ],
  "location": "broadcast_steps.groovy:16"
});
formatter.result({
  "duration": 661207,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is a LIVE Broadcast!",
      "offset": 17
    },
    {
      "val": "12345",
      "offset": 53
    }
  ],
  "location": "broadcast_steps.groovy:11"
});
formatter.result({
  "duration": 18760454,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk version",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100445381,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is a LIVE Broadcast!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 106425,
  "status": "passed"
});
formatter.write("\nOutput: \n\nThis is a LIVE Broadcast!\nSDKMAN x.y.z\n\n\n");
formatter.after({
  "duration": 1717541,
  "status": "passed"
});
formatter.before({
  "duration": 3835267,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 29371342,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4362469,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 104542787,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "A command is issued where the prior Broadcast was the same as the Live one",
  "description": "",
  "id": "broadcast;a-command-is-issued-where-the-prior-broadcast-was-the-same-as-the-live-one",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "a prior Broadcast \"This is a LIVE Broadcast!\" with id \"12345\" was issued",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "a new Broadcast \"This is a LIVE Broadcast!\" with id \"12345\" is available",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I enter \"sdk version\"",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I do not see \"This is a LIVE Broadcast!\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "This is a LIVE Broadcast!",
      "offset": 19
    },
    {
      "val": "12345",
      "offset": 55
    }
  ],
  "location": "broadcast_steps.groovy:16"
});
formatter.result({
  "duration": 384557,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is a LIVE Broadcast!",
      "offset": 17
    },
    {
      "val": "12345",
      "offset": 53
    }
  ],
  "location": "broadcast_steps.groovy:11"
});
formatter.result({
  "duration": 13603635,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk version",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100434350,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is a LIVE Broadcast!",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 270020,
  "status": "passed"
});
formatter.write("\nOutput: \n\nSDKMAN x.y.z\n\n\n");
formatter.after({
  "duration": 1352828,
  "status": "passed"
});
formatter.before({
  "duration": 3725198,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 31233702,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 5846010,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101594962,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "A Broadcast command recalls a prior Broadcast",
  "description": "",
  "id": "broadcast;a-broadcast-command-recalls-a-prior-broadcast",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 27,
  "name": "a prior Broadcast \"This is an OLD Broadcast!\" with id \"12344\" was issued",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "a new Broadcast \"This is an OLD Broadcast!\" with id \"12344\" is available",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I enter \"sdk broadcast\"",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "I see \"This is an OLD Broadcast!\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "This is an OLD Broadcast!",
      "offset": 19
    },
    {
      "val": "12344",
      "offset": 55
    }
  ],
  "location": "broadcast_steps.groovy:16"
});
formatter.result({
  "duration": 308386,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is an OLD Broadcast!",
      "offset": 17
    },
    {
      "val": "12344",
      "offset": 53
    }
  ],
  "location": "broadcast_steps.groovy:11"
});
formatter.result({
  "duration": 17739127,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk broadcast",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100608325,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is an OLD Broadcast!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 98423,
  "status": "passed"
});
formatter.write("\nOutput: \n\nThis is an OLD Broadcast!\n\n\n");
formatter.after({
  "duration": 1349667,
  "status": "passed"
});
formatter.before({
  "duration": 3553328,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 31238167,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3932100,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101697887,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "A Broadcast command is issued with no prior Broadcast received",
  "description": "",
  "id": "broadcast;a-broadcast-command-is-issued-with-no-prior-broadcast-received",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "no prior Broadcast was received",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "a new Broadcast \"This is a LIVE Broadcast!\" with id \"12345\" is available",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I enter \"sdk broadcast\"",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "I see \"This is a LIVE Broadcast!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "broadcast_steps.groovy:6"
});
formatter.result({
  "duration": 156087,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is a LIVE Broadcast!",
      "offset": 17
    },
    {
      "val": "12345",
      "offset": 53
    }
  ],
  "location": "broadcast_steps.groovy:11"
});
formatter.result({
  "duration": 14096316,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk broadcast",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100513866,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is a LIVE Broadcast!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 79926,
  "status": "passed"
});
formatter.write("\nOutput: \n\nThis is a LIVE Broadcast!\n\n\n");
formatter.after({
  "duration": 1464674,
  "status": "passed"
});
formatter.uri("command_line_interop.feature");
formatter.feature({
  "line": 1,
  "name": "Command Line Interop",
  "description": "",
  "id": "command-line-interop",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3795707,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 25356002,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3632402,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101575885,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Enter sdk",
  "description": "",
  "id": "command-line-interop;enter-sdk",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I enter \"sdk\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I see \"Usage: sdk \u003ccommand\u003e [candidate] [version]\"",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I see \"sdk offline \u003cenable|disable\u003e\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "sdk",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100509140,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Usage: sdk \u003ccommand\u003e [candidate] [version]",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 79601,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk offline \u003cenable|disable\u003e",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 50527,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\n");
formatter.after({
  "duration": 1327436,
  "status": "passed"
});
formatter.before({
  "duration": 3565396,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 28395479,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3689905,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101358381,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Ask for help",
  "description": "",
  "id": "command-line-interop;ask-for-help",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "I enter \"sdk help\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I see \"Usage: sdk \u003ccommand\u003e [candidate] [version]\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "sdk help",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100410762,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Usage: sdk \u003ccommand\u003e [candidate] [version]",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 81160,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\n");
formatter.after({
  "duration": 4243193,
  "status": "passed"
});
formatter.before({
  "duration": 5459316,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 28746445,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 5139744,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101459636,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Enter an invalid Command",
  "description": "",
  "id": "command-line-interop;enter-an-invalid-command",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "I enter \"sdk goopoo grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "I see \"Invalid command: goopoo\"",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "I see \"Usage: sdk \u003ccommand\u003e [candidate] [version]\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "sdk goopoo grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100497052,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Invalid command: goopoo",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 89777,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Usage: sdk \u003ccommand\u003e [candidate] [version]",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 60858,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nInvalid command: goopoo\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\n");
formatter.after({
  "duration": 1605663,
  "status": "passed"
});
formatter.before({
  "duration": 3685487,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 26292318,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4259509,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101560284,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Enter an invalid Candidate",
  "description": "",
  "id": "command-line-interop;enter-an-invalid-candidate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 23,
  "name": "I enter \"sdk install groffle\"",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I see \"Stop! groffle is not a valid candidate.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install groffle",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100578660,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! groffle is not a valid candidate.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 87841,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nStop! groffle is not a valid candidate.\n\n\n");
formatter.after({
  "duration": 1447796,
  "status": "passed"
});
formatter.uri("current_candidate.feature");
formatter.feature({
  "line": 1,
  "name": "Current Candidate",
  "description": "",
  "id": "current-candidate",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3677625,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 24681316,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3641857,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Display current candidate version in use",
  "description": "",
  "id": "current-candidate;display-current-candidate-version-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I enter \"sdk current grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I see \"Using grails version 1.3.9\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 7242041,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101463908,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk current grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100580541,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 1.3.9",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 90079,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nUsing grails version 1.3.9\n\n\n");
formatter.after({
  "duration": 1501211,
  "status": "passed"
});
formatter.before({
  "duration": 3672696,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 23135718,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3488399,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Display current candidate version when none is in use",
  "description": "",
  "id": "current-candidate;display-current-candidate-version-when-none-is-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed but not default",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I enter \"sdk current grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I see \"Not using any version of grails\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 879388,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 103749374,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk current grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100534831,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not using any version of grails",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 105277,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nNot using any version of grails\n\n\n");
formatter.after({
  "duration": 1196001,
  "status": "passed"
});
formatter.before({
  "duration": 3522658,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 26646358,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3511583,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Display current candidate versions when none is specified and none is in use",
  "description": "",
  "id": "current-candidate;display-current-candidate-versions-when-none-is-specified-and-none-is-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed but not default",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I enter \"sdk current\"",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I see \"No candidates are in use\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 756964,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101500532,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk current",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100422438,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "No candidates are in use",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 97891,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nNo candidates are in use\n\n\n");
formatter.after({
  "duration": 1338166,
  "status": "passed"
});
formatter.before({
  "duration": 3672068,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 25877639,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3627085,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Display current candidate versions when none is specified and one is in use",
  "description": "",
  "id": "current-candidate;display-current-candidate-versions-when-none-is-specified-and-one-is-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I enter \"sdk current\"",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "I see \"Using:\"",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "I see \"grails: 2.1.0\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 1355114,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101664391,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk current",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100580172,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using:",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 110669,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails: 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 67340,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nUsing:\ngrails: 2.1.0\n\n\n");
formatter.after({
  "duration": 1202490,
  "status": "passed"
});
formatter.before({
  "duration": 3598279,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 22626984,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 29584215,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Display current candidate versions when none is specified and multiple are in use",
  "description": "",
  "id": "current-candidate;display-current-candidate-versions-when-none-is-specified-and-multiple-are-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "the candidate \"groovy\" version \"2.0.5\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I enter \"sdk current\"",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "I see \"Using:\"",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "I see \"grails: 2.1.0\"",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "I see \"groovy: 2.0.5\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 1241593,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 1675528,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101697925,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk current",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100436143,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using:",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 431965,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails: 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 64341,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy: 2.0.5",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 43684,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nUsing:\ngroovy: 2.0.5\ngrails: 2.1.0\n\n\n");
formatter.after({
  "duration": 1056056,
  "status": "passed"
});
formatter.uri("default_version.feature");
formatter.feature({
  "line": 1,
  "name": "Default Version",
  "description": "",
  "id": "default-version",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3686115,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 22536580,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3711698,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Default a candidate version that is not installed",
  "description": "",
  "id": "default-version;default-a-candidate-version-that-is-not-installed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "the candidate \"groovy\" version \"2.0.5\" is a valid candidate version",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I enter \"sdk default groovy 2.0.5\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I see \"Stop! groovy 2.0.5 is not installed.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:30"
});
formatter.result({
  "duration": 5928238,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101667709,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk default groovy 2.0.5",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100664787,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! groovy 2.0.5 is not installed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 110533,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nStop! groovy 2.0.5 is not installed.\n\n\n");
formatter.after({
  "duration": 1227896,
  "status": "passed"
});
formatter.before({
  "duration": 4372102,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 23150166,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4242086,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Default a candidate version that is installed and not default",
  "description": "",
  "id": "default-version;default-a-candidate-version-that-is-installed-and-not-default",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "the candidate \"groovy\" version \"2.0.5\" is a valid candidate version",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "the candidate \"groovy\" version \"2.0.5\" is already installed but not default",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I enter \"sdk default groovy 2.0.5\"",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I see \"Default groovy version set to 2.0.5\"",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "the candidate \"groovy\" version \"2.0.5\" should be the default",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:30"
});
formatter.result({
  "duration": 6068296,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 801084,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101640992,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk default groovy 2.0.5",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100722341,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Default groovy version set to 2.0.5",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 93563,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:30"
});
formatter.result({
  "duration": 1429468,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nDefault groovy version set to 2.0.5\n\n\n");
formatter.after({
  "duration": 1895698,
  "status": "passed"
});
formatter.before({
  "duration": 3603877,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 23416695,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4035798,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Default a candidate version that is installed and already default",
  "description": "",
  "id": "default-version;default-a-candidate-version-that-is-installed-and-already-default",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "the candidate \"groovy\" version \"2.0.5\" is a valid candidate version",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "the candidate \"groovy\" version \"2.0.5\" is already installed and default",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I enter \"sdk default groovy 2.0.5\"",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I see \"Default groovy version set to 2.0.5\"",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "the candidate \"groovy\" version \"2.0.5\" should be the default",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:30"
});
formatter.result({
  "duration": 6309476,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 820214,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101662687,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk default groovy 2.0.5",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100379975,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Default groovy version set to 2.0.5",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 74663,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:30"
});
formatter.result({
  "duration": 578612,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nDefault groovy version set to 2.0.5\n\n\n");
formatter.after({
  "duration": 1082577,
  "status": "passed"
});
formatter.before({
  "duration": 3666763,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 25480729,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3432540,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Default a candidate version that does not exist",
  "description": "",
  "id": "default-version;default-a-candidate-version-that-does-not-exist",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 30,
  "name": "the candidate \"groovy\" version \"2.9.9\" is not available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I enter \"sdk default groovy 2.9.9\"",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "I see \"Stop! 2.9.9 is not a valid groovy version.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.9.9",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:22"
});
formatter.result({
  "duration": 5773446,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101395253,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk default groovy 2.9.9",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100372758,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! 2.9.9 is not a valid groovy version.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 80255,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nStop! 2.9.9 is not a valid groovy version.\n\n\n");
formatter.after({
  "duration": 1243008,
  "status": "passed"
});
formatter.uri("flush.feature");
formatter.feature({
  "line": 1,
  "name": "Flush",
  "description": "",
  "id": "flush",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3550947,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 21212268,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3359147,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 103474097,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Flush omitting the Qualifier",
  "description": "",
  "id": "flush;flush-omitting-the-qualifier",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I enter \"sdk flush\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I see \"Stop! Please specify what you want to flush.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "sdk flush",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100523836,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! Please specify what you want to flush.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 117549,
  "status": "passed"
});
formatter.write("\nOutput: \n\nStop! Please specify what you want to flush.\n\n\n");
formatter.after({
  "duration": 1092732,
  "status": "passed"
});
formatter.before({
  "duration": 3522754,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 19918020,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3933093,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101421396,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Clear out the Candidate List",
  "description": "",
  "id": "flush;clear-out-the-candidate-list",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "the candidate \"grails\" is known locally",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I enter \"sdk flush candidates\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "no candidates are know locally",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "I see \"Candidates have been flushed.\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    }
  ],
  "location": "flush_steps.groovy:5"
});
formatter.result({
  "duration": 1173615,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk flush candidates",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100359944,
  "status": "passed"
});
formatter.match({
  "location": "flush_steps.groovy:9"
});
formatter.result({
  "duration": 316604,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Candidates have been flushed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 100554,
  "status": "passed"
});
formatter.write("\nOutput: \n\nCandidates have been flushed.\n\n\n");
formatter.after({
  "duration": 1058114,
  "status": "passed"
});
formatter.before({
  "duration": 3387591,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 19930254,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3578394,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101642137,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Clear out an uninitialised Candidate List",
  "description": "",
  "id": "flush;clear-out-an-uninitialised-candidate-list",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "I enter \"sdk flush candidates\"",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "I enter \"sdk flush candidates\"",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I see \"No candidate list found so not flushed.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "sdk flush candidates",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100446938,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk flush candidates",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100438875,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "No candidate list found so not flushed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 85758,
  "status": "passed"
});
formatter.write("\nOutput: \n\nNo candidate list found so not flushed.\n\n\n");
formatter.after({
  "duration": 1119107,
  "status": "passed"
});
formatter.before({
  "duration": 3452425,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 24975404,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4892791,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101525188,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Clean up the current Broadcast",
  "description": "",
  "id": "flush;clean-up-the-current-broadcast",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "a prior Broadcast \"This is an old broadcast\" with id \"12344\" was issued",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I enter \"sdk flush broadcast\"",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "no broadcast message can be found",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "I see \"Broadcast has been flushed.\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "This is an old broadcast",
      "offset": 19
    },
    {
      "val": "12344",
      "offset": 54
    }
  ],
  "location": "broadcast_steps.groovy:16"
});
formatter.result({
  "duration": 288177,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk flush broadcast",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100476385,
  "status": "passed"
});
formatter.match({
  "location": "flush_steps.groovy:13"
});
formatter.result({
  "duration": 218545,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Broadcast has been flushed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 68052,
  "status": "passed"
});
formatter.write("\nOutput: \n\nBroadcast has been flushed.\n\n\n");
formatter.after({
  "duration": 1032422,
  "status": "passed"
});
formatter.before({
  "duration": 3353581,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 20637264,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3465345,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101450943,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Clean up an uninitialised Broadcast",
  "description": "",
  "id": "flush;clean-up-an-uninitialised-broadcast",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 30,
  "name": "the broadcast has been flushed",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "I enter \"sdk flush broadcast\"",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "I see \"No prior broadcast found so not flushed.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "flush_steps.groovy:33"
});
formatter.result({
  "duration": 253765,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk flush broadcast",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100478962,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "No prior broadcast found so not flushed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 71424,
  "status": "passed"
});
formatter.write("\nOutput: \n\nNo prior broadcast found so not flushed.\n\n\n");
formatter.after({
  "duration": 1087665,
  "status": "passed"
});
formatter.before({
  "duration": 3404133,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 23818742,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4616001,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101588010,
  "status": "passed"
});
formatter.scenario({
  "line": 34,
  "name": "Clean up the last known Remote Version",
  "description": "",
  "id": "flush;clean-up-the-last-known-remote-version",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 35,
  "name": "a prior version \"x.y.z\" was detected",
  "keyword": "Given "
});
formatter.step({
  "line": 36,
  "name": "I enter \"sdk flush version\"",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "no version token can be found",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "I see \"Version Token has been flushed.\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "x.y.z",
      "offset": 17
    }
  ],
  "location": "flush_steps.groovy:38"
});
formatter.result({
  "duration": 402813,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk flush version",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100483708,
  "status": "passed"
});
formatter.match({
  "location": "flush_steps.groovy:43"
});
formatter.result({
  "duration": 204802,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Version Token has been flushed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 63320,
  "status": "passed"
});
formatter.write("\nOutput: \n\nVersion Token has been flushed.\n\n\n");
formatter.after({
  "duration": 1203380,
  "status": "passed"
});
formatter.before({
  "duration": 3380602,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 20060116,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3494094,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101425209,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Clean up an uninitialised last known Remote Version",
  "description": "",
  "id": "flush;clean-up-an-uninitialised-last-known-remote-version",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 41,
  "name": "the Remote Version has been flushed",
  "keyword": "Given "
});
formatter.step({
  "line": 42,
  "name": "I enter \"sdk flush version\"",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "I see \"No prior Remote Version found so not flushed.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "flush_steps.groovy:47"
});
formatter.result({
  "duration": 300821,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk flush version",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100459484,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "No prior Remote Version found so not flushed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 67542,
  "status": "passed"
});
formatter.write("\nOutput: \n\nNo prior Remote Version found so not flushed.\n\n\n");
formatter.after({
  "duration": 1071294,
  "status": "passed"
});
formatter.before({
  "duration": 3416759,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 21629197,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3753666,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101468412,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "Clear out the cached Archives",
  "description": "",
  "id": "flush;clear-out-the-cached-archives",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 46,
  "name": "the archive \"grails-1.3.9.zip\" has been cached",
  "keyword": "Given "
});
formatter.step({
  "line": 47,
  "name": "I enter \"sdk flush archives\"",
  "keyword": "When "
});
formatter.step({
  "line": 48,
  "name": "no archives are cached",
  "keyword": "Then "
});
formatter.step({
  "line": 49,
  "name": "I see \"1 archive(s) flushed\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails-1.3.9.zip",
      "offset": 13
    }
  ],
  "location": "flush_steps.groovy:17"
});
formatter.result({
  "duration": 343389,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk flush archives",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 200748199,
  "status": "passed"
});
formatter.match({
  "location": "flush_steps.groovy:21"
});
formatter.result({
  "duration": 894804,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1 archive(s) flushed",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 70411,
  "status": "passed"
});
formatter.write("\nOutput: \n\n1 archive(s) flushed, freeing 4.0K\t/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/archives.\n\n\n");
formatter.after({
  "duration": 1089660,
  "status": "passed"
});
formatter.before({
  "duration": 3432902,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 21205635,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3738916,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101688097,
  "status": "passed"
});
formatter.scenario({
  "line": 51,
  "name": "Clear out the temporary space",
  "description": "",
  "id": "flush;clear-out-the-temporary-space",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 52,
  "name": "the file \"res-1.2.0.zip\" in temporary storage",
  "keyword": "Given "
});
formatter.step({
  "line": 53,
  "name": "I enter \"sdk flush temp\"",
  "keyword": "When "
});
formatter.step({
  "line": 54,
  "name": "no \"res-1.2.0.zip\" file is present in temporary storage",
  "keyword": "Then "
});
formatter.step({
  "line": 55,
  "name": "I see \"1 archive(s) flushed\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "res-1.2.0.zip",
      "offset": 10
    }
  ],
  "location": "flush_steps.groovy:25"
});
formatter.result({
  "duration": 282310,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk flush temp",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100534401,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "res-1.2.0.zip",
      "offset": 4
    }
  ],
  "location": "flush_steps.groovy:29"
});
formatter.result({
  "duration": 340769,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1 archive(s) flushed",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 44007,
  "status": "passed"
});
formatter.write("\nOutput: \n\n1 archive(s) flushed, freeing 4.0K\t/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/tmp.\n\n\n");
formatter.after({
  "duration": 1094281,
  "status": "passed"
});
formatter.uri("idempotent_self_update.feature");
formatter.feature({
  "line": 1,
  "name": "Idempotent Self Update",
  "description": "",
  "id": "idempotent-self-update",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3368972,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "an available selfupdate",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 19984808,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3508225,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101486032,
  "status": "passed"
});
formatter.match({
  "location": "stub_steps.groovy:13"
});
formatter.result({
  "duration": 5357593,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Attempt Self Update on an up to date system",
  "description": "",
  "id": "idempotent-self-update;attempt-self-update-on-an-up-to-date-system",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "I enter \"sdk selfupdate\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I see \"No update available at this time.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "sdk selfupdate",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100482499,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "No update available at this time.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 78102,
  "status": "passed"
});
formatter.write("\nOutput: \n\nNo update available at this time.\n\n\n");
formatter.after({
  "duration": 1049274,
  "status": "passed"
});
formatter.before({
  "duration": 3385148,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "an available selfupdate",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 20797596,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3577257,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101443494,
  "status": "passed"
});
formatter.match({
  "location": "stub_steps.groovy:13"
});
formatter.result({
  "duration": 6236413,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Force Self Update on an up to date system",
  "description": "",
  "id": "idempotent-self-update;force-self-update-on-an-up-to-date-system",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "I enter \"sdk selfupdate force\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I see \"Successfully upgraded SDKMAN.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "sdk selfupdate force",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100398144,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Successfully upgraded SDKMAN.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 74883,
  "status": "passed"
});
formatter.write("\nOutput: \n\nSuccessfully upgraded SDKMAN.\n\n\n");
formatter.after({
  "duration": 1101328,
  "status": "passed"
});
formatter.uri("install_candidate.feature");
formatter.feature({
  "line": 1,
  "name": "Install Candidate",
  "description": "",
  "id": "install-candidate",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3334602,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 23005542,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3632516,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101442303,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Install a default Candidate",
  "description": "",
  "id": "install-candidate;install-a-default-candidate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "the default \"grails\" candidate is \"2.1.0\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I enter \"sdk install grails\" and answer \"Y\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I see \"Done installing!\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "the candidate \"grails\" version \"2.1.0\" is installed",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 13
    },
    {
      "val": "2.1.0",
      "offset": 35
    }
  ],
  "location": "stub_steps.groovy:8"
});
formatter.result({
  "duration": 17101217,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 41
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 101631061,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Done installing!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 102113,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:10"
});
formatter.result({
  "duration": 550007,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nDownloading: grails 2.1.0\n\n  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n\r100   541  100   541    0     0  73019      0 --:--:-- --:--:-- --:--:-- 73019\n\nInstalling: grails 2.1.0\nDone installing!\n\nDo you want grails 2.1.0 to be set as default? (Y/n): \nSetting grails 2.1.0 as default.\n\n\n");
formatter.after({
  "duration": 2020339,
  "status": "passed"
});
formatter.before({
  "duration": 3793788,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 25327202,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4816482,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 105719650,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Install a specific Candidate",
  "description": "",
  "id": "install-candidate;install-a-specific-candidate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "the candidate \"grails\" version \"1.3.9\" is available for download",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I enter \"sdk install grails 1.3.9\" and answer \"Y\"",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I see \"Done installing!\"",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the candidate \"grails\" version \"1.3.9\" is installed",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 20127202,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 1.3.9",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 47
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 101254200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Done installing!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 86806,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:10"
});
formatter.result({
  "duration": 207349,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nDownloading: grails 1.3.9\n\n  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n\r100   541  100   541    0     0   273k      0 --:--:-- --:--:-- --:--:--  273k\n\nInstalling: grails 1.3.9\nDone installing!\n\nDo you want grails 1.3.9 to be set as default? (Y/n): \nSetting grails 1.3.9 as default.\n\n\n");
formatter.after({
  "duration": 1553330,
  "status": "passed"
});
formatter.before({
  "duration": 3740270,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 26573582,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4735651,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 105079659,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Install a Candidate version that does not exist",
  "description": "",
  "id": "install-candidate;install-a-candidate-version-that-does-not-exist",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "the candidate \"grails\" version \"1.4.4\" is not available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "I enter \"sdk install grails 1.4.4\"",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I see \"Stop! 1.4.4 is not a valid grails version.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.4.4",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:22"
});
formatter.result({
  "duration": 8155241,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 1.4.4",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100594057,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! 1.4.4 is not a valid grails version.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 70489,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nStop! 1.4.4 is not a valid grails version.\n\n\n");
formatter.after({
  "duration": 1110195,
  "status": "passed"
});
formatter.before({
  "duration": 3466943,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 26152479,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3497001,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101458064,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Install a Candidate version that is already installed",
  "description": "",
  "id": "install-candidate;install-a-candidate-version-that-is-already-installed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "the candidate \"grails\" version \"1.3.9\" is available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I enter \"sdk install grails 1.3.9\"",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "I see \"Stop! grails 1.3.9 is already installed.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 18205163,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 1001941,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 1.3.9",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100406404,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 1.3.9 is already installed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 101321,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nStop! grails 1.3.9 is already installed.\n\n\n");
formatter.after({
  "duration": 1373343,
  "status": "passed"
});
formatter.before({
  "duration": 3991818,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 21994901,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4016633,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101807272,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "Install a candidate and select to use it",
  "description": "",
  "id": "install-candidate;install-a-candidate-and-select-to-use-it",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 32,
  "name": "the candidate \"grails\" version \"2.1.0\" is available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 33,
  "name": "I enter \"sdk install grails 2.1.0\" and answer \"Y\"",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "the candidate \"grails\" version \"2.1.0\" is installed",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "I see \"Done installing!\"",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I see \"Do you want grails 2.1.0 to be set as default? (Y/n)\"",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "I see \"Setting grails 2.1.0 as default.\"",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "the candidate \"grails\" version \"2.1.0\" should be the default",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 17713470,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 2.1.0",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 47
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100578052,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:10"
});
formatter.result({
  "duration": 193313,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Done installing!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 43034,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Do you want grails 2.1.0 to be set as default? (Y/n)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 44818,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Setting grails 2.1.0 as default.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 60628,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:30"
});
formatter.result({
  "duration": 187901,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nDownloading: grails 2.1.0\n\n  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n\r100   541  100   541    0     0   290k      0 --:--:-- --:--:-- --:--:--  290k\n\nInstalling: grails 2.1.0\nDone installing!\n\nDo you want grails 2.1.0 to be set as default? (Y/n): \nSetting grails 2.1.0 as default.\n\n\n");
formatter.after({
  "duration": 1423351,
  "status": "passed"
});
formatter.before({
  "duration": 3539112,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 27916194,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 6539069,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 105349850,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Install a candidate and select to use it automatically",
  "description": "",
  "id": "install-candidate;install-a-candidate-and-select-to-use-it-automatically",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 41,
  "name": "the candidate \"grails\" version \"2.1.0\" is available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 42,
  "name": "I have configured \"sdkman_auto_answer\" to \"true\"",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "I enter \"sdk install grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 44,
  "name": "the candidate \"grails\" version \"2.1.0\" is installed",
  "keyword": "Then "
});
formatter.step({
  "line": 45,
  "name": "I see \"Done installing!\"",
  "keyword": "And "
});
formatter.step({
  "line": 46,
  "name": "I see \"Setting grails 2.1.0 as default.\"",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "the candidate \"grails\" version \"2.1.0\" should be the default",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 23606202,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdkman_auto_answer",
      "offset": 19
    },
    {
      "val": "true",
      "offset": 43
    }
  ],
  "location": "installation_steps.groovy:78"
});
formatter.result({
  "duration": 486239,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100558075,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:10"
});
formatter.result({
  "duration": 196538,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Done installing!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 67266,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Setting grails 2.1.0 as default.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 78868,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:30"
});
formatter.result({
  "duration": 337670,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nDownloading: grails 2.1.0\n\n  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n\r100   541  100   541    0     0  93453      0 --:--:-- --:--:-- --:--:-- 93453\n\nInstalling: grails 2.1.0\nDone installing!\n\n\nSetting grails 2.1.0 as default.\n\n\n");
formatter.after({
  "duration": 1405308,
  "status": "passed"
});
formatter.before({
  "duration": 4488004,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 35719701,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4821118,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101743057,
  "status": "passed"
});
formatter.scenario({
  "line": 49,
  "name": "Install a candidate and do not select to use it",
  "description": "",
  "id": "install-candidate;install-a-candidate-and-do-not-select-to-use-it",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 50,
  "name": "the candidate \"grails\" version \"2.1.0\" is available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 51,
  "name": "I enter \"sdk install grails 2.1.0\" and answer \"n\"",
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "the candidate \"grails\" version \"2.1.0\" is installed",
  "keyword": "Then "
});
formatter.step({
  "line": 53,
  "name": "I see \"Done installing!\"",
  "keyword": "And "
});
formatter.step({
  "line": 54,
  "name": "I see \"Do you want grails 2.1.0 to be set as default? (Y/n)\"",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "I do not see \"Setting grails 2.1.0 as default.\"",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "the candidate \"grails\" version \"2.1.0\" should not be the default",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 24791280,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 2.1.0",
      "offset": 9
    },
    {
      "val": "n",
      "offset": 47
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100530026,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:10"
});
formatter.result({
  "duration": 165559,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Done installing!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 45737,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Do you want grails 2.1.0 to be set as default? (Y/n)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 37799,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Setting grails 2.1.0 as default.",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 48789,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:36"
});
formatter.result({
  "duration": 2016732,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nDownloading: grails 2.1.0\n\n  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n\r100   541  100   541    0     0   264k      0 --:--:-- --:--:-- --:--:--  264k\n\nInstalling: grails 2.1.0\nDone installing!\n\nDo you want grails 2.1.0 to be set as default? (Y/n): \n\n");
formatter.after({
  "duration": 1204231,
  "status": "passed"
});
formatter.before({
  "duration": 3765444,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 28527338,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 8075324,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 303343945,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 58,
      "value": "#revisit to redownload automatically"
    }
  ],
  "line": 59,
  "name": "Abort installation on download of a corrupt Candidate archive",
  "description": "",
  "id": "install-candidate;abort-installation-on-download-of-a-corrupt-candidate-archive",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 60,
  "name": "the candidate \"grails\" version \"1.3.6\" is available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 61,
  "name": "the archive for candidate \"grails\" version \"1.3.6\" is corrupt",
  "keyword": "And "
});
formatter.step({
  "line": 62,
  "name": "I enter \"sdk install grails 1.3.6\"",
  "keyword": "When "
});
formatter.step({
  "line": 63,
  "name": "I see \"Stop! The archive was corrupt and has been removed! Please try installing again.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 64,
  "name": "the candidate \"grails\" version \"1.3.6\" is not installed",
  "keyword": "And "
});
formatter.step({
  "line": 65,
  "name": "the archive for candidate \"grails\" version \"1.3.6\" is removed",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.6",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 16997261,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 27
    },
    {
      "val": "1.3.6",
      "offset": 44
    }
  ],
  "location": "initialisation_steps.groovy:20"
});
formatter.result({
  "duration": 2998552,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 1.3.6",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100529757,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! The archive was corrupt and has been removed! Please try installing again.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 68758,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.6",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 650696,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 27
    },
    {
      "val": "1.3.6",
      "offset": 44
    }
  ],
  "location": "initialisation_steps.groovy:30"
});
formatter.result({
  "duration": 310251,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nDownloading: grails 1.3.6\n\n  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n\r100    31  100    31    0     0   4955      0 --:--:-- --:--:-- --:--:--  4955\n\nStop! The archive was corrupt and has been removed! Please try installing again.\n\n\n");
formatter.after({
  "duration": 1217953,
  "status": "passed"
});
formatter.uri("list_candidate_versions.feature");
formatter.feature({
  "line": 1,
  "name": "List Candidate Versions",
  "description": "\nA dummy template to be served back that has the following information:\n* Candidate: grails\n* Current: 2.1.0\n* Versions: 2.1.0,2.1.1,2.1.2 (CSV)",
  "id": "list-candidate-versions",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3473430,
  "status": "passed"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 23133035,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 6847733,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "List an uninstalled available Version",
  "description": "",
  "id": "list-candidate-versions;list-an-uninstalled-available-version",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "I do not have a \"grails\" candidate installed",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "the candidate \"grails\" has a version list available",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I enter \"sdk list grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I see \"Candidate: grails\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 17
    }
  ],
  "location": "installation_steps.groovy:39"
});
formatter.result({
  "duration": 884001,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    }
  ],
  "location": "stub_steps.groovy:38"
});
formatter.result({
  "duration": 15994968,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101614030,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk list grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100381887,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Candidate: grails",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 99573,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nCandidate: grails; Versions: ; Current: \n\n\n");
formatter.after({
  "duration": 1092460,
  "status": "passed"
});
formatter.before({
  "duration": 3579097,
  "status": "passed"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 27004429,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3780968,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "List an installed available Version not in use",
  "description": "",
  "id": "list-candidate-versions;list-an-installed-available-version-not-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed but not default",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "the candidate \"grails\" has a version list available",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I enter \"sdk list grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I see \"Versions: 2.1.0\"",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "I do not see \"Current: 2.1.0\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 744379,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    }
  ],
  "location": "stub_steps.groovy:38"
});
formatter.result({
  "duration": 5397527,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101649140,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk list grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100481470,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Versions: 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 83220,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Current: 2.1.0",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 68156,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nCandidate: grails; Versions: 2.1.0; Current: \n\n\n");
formatter.after({
  "duration": 1077426,
  "status": "passed"
});
formatter.before({
  "duration": 3818351,
  "status": "passed"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 26513037,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3707226,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "List an installed available Version in use",
  "description": "",
  "id": "list-candidate-versions;list-an-installed-available-version-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 28,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "the candidate \"grails\" has a version list available",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I enter \"sdk list grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "I see \"Current: 2.1.0\"",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "I see \"Versions: 2.1.0\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 755958,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    }
  ],
  "location": "stub_steps.groovy:38"
});
formatter.result({
  "duration": 5965124,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101612246,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk list grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100565756,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Current: 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 73596,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Versions: 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 37601,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nCandidate: grails; Versions: 2.1.0; Current: 2.1.0\n\n\n");
formatter.after({
  "duration": 997682,
  "status": "passed"
});
formatter.before({
  "duration": 3551254,
  "status": "passed"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 22938062,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3931643,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "List installed multiple Versions",
  "description": "",
  "id": "list-candidate-versions;list-installed-multiple-versions",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 36,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "the candidate \"grails\" version \"2.0.9\" is already installed but not default",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "the candidate \"grails\" has a version list available",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "I enter \"sdk list grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "I see \"Current: 2.1.0\"",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "I see \"Versions: 2.0.9,2.1.0\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 793334,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.0.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 592483,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    }
  ],
  "location": "stub_steps.groovy:38"
});
formatter.result({
  "duration": 5996760,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 103037085,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk list grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100478415,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Current: 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 72582,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Versions: 2.0.9,2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 40328,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nCandidate: grails; Versions: 2.0.9,2.1.0; Current: 2.1.0\n\n\n");
formatter.after({
  "duration": 1083170,
  "status": "passed"
});
formatter.before({
  "duration": 3749421,
  "status": "passed"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 23381540,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3740374,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "List an installed local version not in use",
  "description": "",
  "id": "list-candidate-versions;list-an-installed-local-version-not-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 45,
  "name": "I have a local candidate \"grails\" version \"2.3-SNAPSHOT\" at \"/tmp/groovy-core\"",
  "keyword": "Given "
});
formatter.step({
  "line": 46,
  "name": "the candidate \"groovy\" version \"2.3-SNAPSHOT\" is already linked to \"/tmp/groovy-core\"",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "the candidate \"groovy\" has a version list available",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "I enter \"sdk list groovy\"",
  "keyword": "When "
});
formatter.step({
  "line": 50,
  "name": "I see \"Versions: 2.3-SNAPSHOT\"",
  "keyword": "Then "
});
formatter.step({
  "line": 51,
  "name": "I do not see \"Current: 2.3-SNAPSHOT\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 26
    },
    {
      "val": "2.3-SNAPSHOT",
      "offset": 43
    },
    {
      "val": "/tmp/groovy-core",
      "offset": 61
    }
  ],
  "location": "installation_steps.groovy:50"
});
formatter.result({
  "duration": 1434055,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.3-SNAPSHOT",
      "offset": 32
    },
    {
      "val": "/tmp/groovy-core",
      "offset": 68
    }
  ],
  "location": "installation_steps.groovy:66"
});
formatter.result({
  "duration": 3607982,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    }
  ],
  "location": "stub_steps.groovy:38"
});
formatter.result({
  "duration": 5154168,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 103148192,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk list groovy",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100435190,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Versions: 2.3-SNAPSHOT",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 105803,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Current: 2.3-SNAPSHOT",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 61581,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nCandidate: groovy; Versions: 2.3-SNAPSHOT; Current: \n\n\n");
formatter.after({
  "duration": 1124488,
  "status": "passed"
});
formatter.before({
  "duration": 3559006,
  "status": "passed"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 23186969,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 5733889,
  "status": "passed"
});
formatter.scenario({
  "line": 53,
  "name": "List an installed local Version in use",
  "description": "",
  "id": "list-candidate-versions;list-an-installed-local-version-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 54,
  "name": "I have a local candidate \"groovy\" version \"2.2-SNAPSHOT\" at \"/tmp/groovy-core\"",
  "keyword": "Given "
});
formatter.step({
  "line": 55,
  "name": "the candidate \"groovy\" version \"2.2-SNAPSHOT\" is already linked to \"/tmp/groovy-core\"",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "the candidate \"groovy\" version \"2.2-SNAPSHOT\" is the default",
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "the candidate \"groovy\" has a version list available",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "I enter \"sdk list groovy\"",
  "keyword": "When "
});
formatter.step({
  "line": 60,
  "name": "I see \"Current: 2.2-SNAPSHOT\"",
  "keyword": "Then "
});
formatter.step({
  "line": 61,
  "name": "I see \"Versions: 2.2-SNAPSHOT\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 26
    },
    {
      "val": "2.2-SNAPSHOT",
      "offset": 43
    },
    {
      "val": "/tmp/groovy-core",
      "offset": 61
    }
  ],
  "location": "installation_steps.groovy:50"
});
formatter.result({
  "duration": 1195022,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.2-SNAPSHOT",
      "offset": 32
    },
    {
      "val": "/tmp/groovy-core",
      "offset": 68
    }
  ],
  "location": "installation_steps.groovy:66"
});
formatter.result({
  "duration": 599193,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.2-SNAPSHOT",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:29"
});
formatter.result({
  "duration": 344738,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    }
  ],
  "location": "stub_steps.groovy:38"
});
formatter.result({
  "duration": 5477482,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 103877658,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk list groovy",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100459088,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Current: 2.2-SNAPSHOT",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 75178,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Versions: 2.2-SNAPSHOT",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 41528,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nCandidate: groovy; Versions: 2.2-SNAPSHOT; Current: 2.2-SNAPSHOT\n\n\n");
formatter.after({
  "duration": 1281575,
  "status": "passed"
});
formatter.uri("list_candidates.feature");
formatter.feature({
  "line": 1,
  "name": "List Candidates",
  "description": "",
  "id": "list-candidates",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3676618,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 36998200,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3239183,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "A List of Available Candidates can be viewed",
  "description": "",
  "id": "list-candidates;a-list-of-available-candidates-can-be-viewed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "The candidate list is available",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I enter \"sdk list\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I see \"Candidate List\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101345860,
  "status": "passed"
});
formatter.match({
  "location": "stub_steps.groovy:46"
});
formatter.result({
  "duration": 4766814,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk list",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 401348079,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Candidate List",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 74163,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nCandidate List\n\n\n");
formatter.after({
  "duration": 1090447,
  "status": "passed"
});
formatter.uri("local_developement_versions.feature");
formatter.feature({
  "line": 1,
  "name": "Local Development Versions",
  "description": "",
  "id": "local-development-versions",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3538001,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16863983,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3141059,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Install a new local development version",
  "description": "",
  "id": "local-development-versions;install-a-new-local-development-version",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" is not available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I have a local candidate \"groovy\" version \"2.1-SNAPSHOT\" at \"/tmp/groovy-core\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I enter \"sdk install groovy 2.1-SNAPSHOT /tmp/groovy-core\"",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I see \"Linking groovy 2.1-SNAPSHOT to /tmp/groovy-core\"",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" is linked to \"/tmp/groovy-core\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:22"
});
formatter.result({
  "duration": 5730690,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 26
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 43
    },
    {
      "val": "/tmp/groovy-core",
      "offset": 61
    }
  ],
  "location": "installation_steps.groovy:50"
});
formatter.result({
  "duration": 689549,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101484782,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install groovy 2.1-SNAPSHOT /tmp/groovy-core",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100536398,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Linking groovy 2.1-SNAPSHOT to /tmp/groovy-core",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 65861,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    },
    {
      "val": "/tmp/groovy-core",
      "offset": 60
    }
  ],
  "location": "installation_steps.groovy:54"
});
formatter.result({
  "duration": 452872,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nLinking groovy 2.1-SNAPSHOT to /tmp/groovy-core\nDone installing!\n\n\n\n");
formatter.after({
  "duration": 1144798,
  "status": "passed"
});
formatter.before({
  "duration": 3478357,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17791709,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3271517,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Attempt installing a local development version that already exists",
  "description": "",
  "id": "local-development-versions;attempt-installing-a-local-development-version-that-already-exists",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" is not available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" is already linked to \"/tmp/groovy-core\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I enter \"sdk install groovy 2.1-SNAPSHOT /tmp/groovy-core\"",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I see \"Stop! groovy 2.1-SNAPSHOT is already installed.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" is linked to \"/tmp/groovy-core\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:22"
});
formatter.result({
  "duration": 4963929,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    },
    {
      "val": "/tmp/groovy-core",
      "offset": 68
    }
  ],
  "location": "installation_steps.groovy:66"
});
formatter.result({
  "duration": 838341,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101473412,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install groovy 2.1-SNAPSHOT /tmp/groovy-core",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100417661,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! groovy 2.1-SNAPSHOT is already installed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 66540,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    },
    {
      "val": "/tmp/groovy-core",
      "offset": 60
    }
  ],
  "location": "installation_steps.groovy:54"
});
formatter.result({
  "duration": 328217,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nStop! groovy 2.1-SNAPSHOT is already installed.\n\n\n");
formatter.after({
  "duration": 1222904,
  "status": "passed"
});
formatter.before({
  "duration": 3452770,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16367321,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3048702,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Uninstall a local development version",
  "description": "",
  "id": "local-development-versions;uninstall-a-local-development-version",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" is already linked to \"/tmp/groovy-core\"",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I enter \"sdk uninstall groovy 2.1-SNAPSHOT\"",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "I see \"Uninstalling groovy 2.1-SNAPSHOT\"",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" is not installed",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    },
    {
      "val": "/tmp/groovy-core",
      "offset": 68
    }
  ],
  "location": "installation_steps.groovy:66"
});
formatter.result({
  "duration": 820619,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101534036,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk uninstall groovy 2.1-SNAPSHOT",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100500200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Uninstalling groovy 2.1-SNAPSHOT",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 99162,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 359716,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nUninstalling groovy 2.1-SNAPSHOT...\n\n\n");
formatter.after({
  "duration": 1144555,
  "status": "passed"
});
formatter.before({
  "duration": 3544100,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17328273,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3096293,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Attempt uninstalling a local development version that is not installed",
  "description": "",
  "id": "local-development-versions;attempt-uninstalling-a-local-development-version-that-is-not-installed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" is not installed",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "I enter \"sdk uninstall groovy 2.1-SNAPSHOT\"",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "I see \"groovy 2.1-SNAPSHOT is not installed.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 372582,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101811207,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk uninstall groovy 2.1-SNAPSHOT",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100534658,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy 2.1-SNAPSHOT is not installed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 76275,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\ngroovy 2.1-SNAPSHOT is not installed.\n\n\n");
formatter.after({
  "duration": 1202219,
  "status": "passed"
});
formatter.before({
  "duration": 3271103,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17350050,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3153146,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Make the local development version the default for the candidate",
  "description": "",
  "id": "local-development-versions;make-the-local-development-version-the-default-for-the-candidate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 37,
  "name": "the candidate \"groovy\" version \"2.0.6\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 38,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" is not available for download",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" is already linked to \"/tmp/groovy-core\"",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "I enter \"sdk default groovy 2.1-SNAPSHOT\"",
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "I see \"Default groovy version set to 2.1-SNAPSHOT\"",
  "keyword": "Then "
});
formatter.step({
  "line": 43,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" should be the default",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.6",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 847093,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:22"
});
formatter.result({
  "duration": 5118216,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    },
    {
      "val": "/tmp/groovy-core",
      "offset": 68
    }
  ],
  "location": "installation_steps.groovy:66"
});
formatter.result({
  "duration": 923848,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101404229,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk default groovy 2.1-SNAPSHOT",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100460333,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Default groovy version set to 2.1-SNAPSHOT",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 63693,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:30"
});
formatter.result({
  "duration": 191609,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nDefault groovy version set to 2.1-SNAPSHOT\n\n\n");
formatter.after({
  "duration": 1087463,
  "status": "passed"
});
formatter.before({
  "duration": 3515966,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17803458,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3581643,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "Use a local development version",
  "description": "",
  "id": "local-development-versions;use-a-local-development-version",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 46,
  "name": "the candidate \"groovy\" version \"2.0.6\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 47,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" is not available for download",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" is already linked to \"/tmp/groovy-core\"",
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 50,
  "name": "I enter \"sdk use groovy 2.1-SNAPSHOT\"",
  "keyword": "When "
});
formatter.step({
  "line": 51,
  "name": "I see \"Using groovy version 2.1-SNAPSHOT in this shell\"",
  "keyword": "Then "
});
formatter.step({
  "line": 52,
  "name": "the candidate \"groovy\" version \"2.1-SNAPSHOT\" should be in use",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.6",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 735787,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:22"
});
formatter.result({
  "duration": 4574704,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    },
    {
      "val": "/tmp/groovy-core",
      "offset": 68
    }
  ],
  "location": "installation_steps.groovy:66"
});
formatter.result({
  "duration": 796681,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101433012,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use groovy 2.1-SNAPSHOT",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100511168,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using groovy version 2.1-SNAPSHOT in this shell",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 82536,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.1-SNAPSHOT",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:25"
});
formatter.result({
  "duration": 100856295,
  "status": "passed"
});
formatter.write("\nOutput: \n\nGroovy Version: 2.1-SNAPSHOT\n\n\n");
formatter.after({
  "duration": 1074572,
  "status": "passed"
});
formatter.uri("mnemonics.feature");
formatter.feature({
  "line": 1,
  "name": "Mnemonics",
  "description": "",
  "id": "mnemonics",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3695068,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17781683,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3120247,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Shortcut for listing an uninstalled available Version",
  "description": "",
  "id": "mnemonics;shortcut-for-listing-an-uninstalled-available-version",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I do not have a \"grails\" candidate installed",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "a \"grails\" list view is available for consumption",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I enter \"sdk l grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I see \"Available Grails Versions\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 17
    }
  ],
  "location": "installation_steps.groovy:39"
});
formatter.result({
  "duration": 217916,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 3
    }
  ],
  "location": "stub_steps.groovy:26"
});
formatter.result({
  "duration": 4897927,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101471638,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk l grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100527056,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Available Grails Versions",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 77977,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nAvailable Grails Versions\n\n\n");
formatter.after({
  "duration": 1211940,
  "status": "passed"
});
formatter.before({
  "duration": 33164308,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 15877758,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3058058,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Alternate shortcut for listing uninstalled available Version",
  "description": "",
  "id": "mnemonics;alternate-shortcut-for-listing-uninstalled-available-version",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I do not have a \"grails\" candidate installed",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "a \"grails\" list view is available for consumption",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I enter \"sdk ls grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "I see \"Available Grails Versions\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 17
    }
  ],
  "location": "installation_steps.groovy:39"
});
formatter.result({
  "duration": 181623,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 3
    }
  ],
  "location": "stub_steps.groovy:26"
});
formatter.result({
  "duration": 4613360,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 102151992,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk ls grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100502982,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Available Grails Versions",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 72485,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nAvailable Grails Versions\n\n\n");
formatter.after({
  "duration": 1014318,
  "status": "passed"
});
formatter.before({
  "duration": 3273966,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16751193,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2963055,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Shortcut for asking help",
  "description": "",
  "id": "mnemonics;shortcut-for-asking-help",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "I enter \"sdk h\"",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I see \"Usage: sdk \u003ccommand\u003e [candidate] [version]\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101524523,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk h",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100481610,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Usage: sdk \u003ccommand\u003e [candidate] [version]",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 66880,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\n");
formatter.after({
  "duration": 1301738,
  "status": "passed"
});
formatter.before({
  "duration": 3253517,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 15987502,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2989836,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "Shortcut for displaying current Candidate Version in use",
  "description": "",
  "id": "mnemonics;shortcut-for-displaying-current-candidate-version-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 27,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I enter \"sdk c grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "I see \"Using grails version 1.3.9\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 1169080,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101496785,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk c grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100430105,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 1.3.9",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 97792,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nUsing grails version 1.3.9\n\n\n");
formatter.after({
  "duration": 1018757,
  "status": "passed"
});
formatter.before({
  "duration": 3343938,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16798961,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3093910,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Shortcut for displaying current Candidate Versions",
  "description": "",
  "id": "mnemonics;shortcut-for-displaying-current-candidate-versions",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "the candidate \"groovy\" version \"2.0.5\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I enter \"sdk c\"",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "I see \"Using:\"",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "I see \"grails: 2.1.0\"",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "I see \"groovy: 2.0.5\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 771626,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 631080,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101593516,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk c",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100447563,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using:",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 83413,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails: 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 35353,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy: 2.0.5",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 33775,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nUsing:\ngroovy: 2.0.5\ngrails: 2.1.0\n\n\n");
formatter.after({
  "duration": 1036691,
  "status": "passed"
});
formatter.before({
  "duration": 3539342,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 15981710,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3126881,
  "status": "passed"
});
formatter.scenario({
  "line": 41,
  "name": "Shortcut for displaying outdated Candidate Version in use",
  "description": "",
  "id": "mnemonics;shortcut-for-displaying-outdated-candidate-version-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 42,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "the default \"grails\" candidate is \"2.4.4\"",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "I enter \"sdk o grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "I see \"Outdated:\"",
  "keyword": "Then "
});
formatter.step({
  "line": 47,
  "name": "I see \"grails (1.3.9 \u003c 2.4.4)\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 682472,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 13
    },
    {
      "val": "2.4.4",
      "offset": 35
    }
  ],
  "location": "stub_steps.groovy:8"
});
formatter.result({
  "duration": 13206001,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101382751,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk o grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100455182,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Outdated:",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 76264,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails (1.3.9 \u003c 2.4.4)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 38757,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nOutdated:\ngrails (1.3.9 \u003c 2.4.4)\n\n\n");
formatter.after({
  "duration": 1160597,
  "status": "passed"
});
formatter.before({
  "duration": 3333537,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16160684,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3158790,
  "status": "passed"
});
formatter.scenario({
  "line": 49,
  "name": "Shortcut for displaying outdated Candidate Versions",
  "description": "",
  "id": "mnemonics;shortcut-for-displaying-outdated-candidate-versions",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 50,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 51,
  "name": "the default \"grails\" candidate is \"2.4.4\"",
  "keyword": "And "
});
formatter.step({
  "line": 52,
  "name": "the candidate \"groovy\" version \"2.0.5\" is already installed and default",
  "keyword": "And "
});
formatter.step({
  "line": 53,
  "name": "the default \"groovy\" candidate is \"2.4.1\"",
  "keyword": "And "
});
formatter.step({
  "line": 54,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "I enter \"sdk o\"",
  "keyword": "When "
});
formatter.step({
  "line": 56,
  "name": "I see \"Outdated:\"",
  "keyword": "Then "
});
formatter.step({
  "line": 57,
  "name": "I see \"grails (1.3.9 \u003c 2.4.4)\"",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "I see \"groovy (2.0.5 \u003c 2.4.1)\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 671346,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 13
    },
    {
      "val": "2.4.4",
      "offset": 35
    }
  ],
  "location": "stub_steps.groovy:8"
});
formatter.result({
  "duration": 13851750,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 1121778,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 13
    },
    {
      "val": "2.4.1",
      "offset": 35
    }
  ],
  "location": "stub_steps.groovy:8"
});
formatter.result({
  "duration": 13787839,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101472857,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk o",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100416566,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Outdated:",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 68369,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails (1.3.9 \u003c 2.4.4)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 35599,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy (2.0.5 \u003c 2.4.1)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 37405,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nOutdated:\ngroovy (2.0.5 \u003c 2.4.1)\ngrails (1.3.9 \u003c 2.4.4)\n\n\n");
formatter.after({
  "duration": 989695,
  "status": "passed"
});
formatter.before({
  "duration": 3425352,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16333968,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3019305,
  "status": "passed"
});
formatter.scenario({
  "line": 60,
  "name": "Shortcut for installing a Candidate Version",
  "description": "",
  "id": "mnemonics;shortcut-for-installing-a-candidate-version",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 61,
  "name": "the candidate \"grails\" version \"2.1.0\" is not installed",
  "keyword": "Given "
});
formatter.step({
  "line": 62,
  "name": "the candidate \"grails\" version \"2.1.0\" is available for download",
  "keyword": "And "
});
formatter.step({
  "line": 63,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 64,
  "name": "I enter \"sdk i grails 2.1.0\" and answer \"Y\"",
  "keyword": "When "
});
formatter.step({
  "line": 65,
  "name": "I see \"Installing: grails 2.1.0\"",
  "keyword": "Then "
});
formatter.step({
  "line": 66,
  "name": "the candidate \"grails\" version \"2.1.0\" is installed",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 343699,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 13129087,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101738113,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk i grails 2.1.0",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 41
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100515879,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Installing: grails 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 72289,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:10"
});
formatter.result({
  "duration": 114649,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nDownloading: grails 2.1.0\n\n  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n\r100   541  100   541    0     0  94845      0 --:--:-- --:--:-- --:--:-- 94845\n\nInstalling: grails 2.1.0\nDone installing!\n\nDo you want grails 2.1.0 to be set as default? (Y/n): \nSetting grails 2.1.0 as default.\n\n\n");
formatter.after({
  "duration": 1021476,
  "status": "passed"
});
formatter.before({
  "duration": 3461768,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16282011,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3137555,
  "status": "passed"
});
formatter.scenario({
  "line": 68,
  "name": "Shortcut for uninstalling a Candidate Version",
  "description": "",
  "id": "mnemonics;shortcut-for-uninstalling-a-candidate-version",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 69,
  "name": "the candidate \"groovy\" version \"2.0.5\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 70,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 71,
  "name": "I enter \"sdk rm groovy 2.0.5\"",
  "keyword": "When "
});
formatter.step({
  "line": 72,
  "name": "I see \"Uninstalling groovy 2.0.5\"",
  "keyword": "Then "
});
formatter.step({
  "line": 73,
  "name": "the candidate \"groovy\" version \"2.0.5\" is not installed",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 758335,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 102338810,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk rm groovy 2.0.5",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 200936640,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Uninstalling groovy 2.0.5",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 73962,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 411466,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nUnselecting groovy 2.0.5...\n\nUninstalling groovy 2.0.5...\n\n\n");
formatter.after({
  "duration": 1098820,
  "status": "passed"
});
formatter.before({
  "duration": 3373283,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17345893,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3717108,
  "status": "passed"
});
formatter.scenario({
  "line": 75,
  "name": "Shortcut for showing the current Version of sdkman",
  "description": "",
  "id": "mnemonics;shortcut-for-showing-the-current-version-of-sdkman",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 76,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 77,
  "name": "I enter \"sdk v\"",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "I see \"SDKMAN x.y.z\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 107101555,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk v",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100460174,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SDKMAN x.y.z",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 75404,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nSDKMAN x.y.z\n\n\n");
formatter.after({
  "duration": 1195648,
  "status": "passed"
});
formatter.before({
  "duration": 3477938,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17094676,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3027176,
  "status": "passed"
});
formatter.scenario({
  "line": 80,
  "name": "Shortcut for using a candidate version that is installed",
  "description": "",
  "id": "mnemonics;shortcut-for-using-a-candidate-version-that-is-installed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 81,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 82,
  "name": "the candidate \"grails\" version \"2.1.0\" is a valid candidate version",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed but not default",
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "the candidate \"grails\" version \"1.3.9\" is a valid candidate version",
  "keyword": "And "
});
formatter.step({
  "line": 85,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 86,
  "name": "I enter \"sdk u grails 1.3.9\"",
  "keyword": "When "
});
formatter.step({
  "line": 87,
  "name": "I see \"Using grails version 1.3.9 in this shell.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 88,
  "name": "the candidate \"grails\" version \"1.3.9\" should be in use",
  "keyword": "Then "
});
formatter.step({
  "line": 89,
  "name": "the candidate \"grails\" version \"2.1.0\" should be the default",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 796531,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:30"
});
formatter.result({
  "duration": 4866982,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 678048,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:30"
});
formatter.result({
  "duration": 4252356,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101636212,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk u grails 1.3.9",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100562924,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 1.3.9 in this shell.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 72377,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:25"
});
formatter.result({
  "duration": 100335030,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:30"
});
formatter.result({
  "duration": 202791,
  "status": "passed"
});
formatter.write("\nOutput: \n\nGrails Version: 1.3.9\n\n\n");
formatter.after({
  "duration": 1017821,
  "status": "passed"
});
formatter.before({
  "duration": 3526974,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16206611,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2977543,
  "status": "passed"
});
formatter.scenario({
  "line": 91,
  "name": "Shortcut for defaulting a Candidate Version that is installed and not default",
  "description": "",
  "id": "mnemonics;shortcut-for-defaulting-a-candidate-version-that-is-installed-and-not-default",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 92,
  "name": "the candidate \"groovy\" version \"2.0.5\" is already installed but not default",
  "keyword": "Given "
});
formatter.step({
  "line": 93,
  "name": "the candidate \"groovy\" version \"2.0.5\" is a valid candidate version",
  "keyword": "And "
});
formatter.step({
  "line": 94,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 95,
  "name": "I enter \"sdk d groovy 2.0.5\"",
  "keyword": "When "
});
formatter.step({
  "line": 96,
  "name": "I see \"Default groovy version set to 2.0.5\"",
  "keyword": "Then "
});
formatter.step({
  "line": 97,
  "name": "the candidate \"groovy\" version \"2.0.5\" should be the default",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 566627,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:30"
});
formatter.result({
  "duration": 4486432,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101485891,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk d groovy 2.0.5",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100461421,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Default groovy version set to 2.0.5",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 75579,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:30"
});
formatter.result({
  "duration": 167093,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nDefault groovy version set to 2.0.5\n\n\n");
formatter.after({
  "duration": 1001366,
  "status": "passed"
});
formatter.before({
  "duration": 3356602,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 15934143,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3121429,
  "status": "passed"
});
formatter.scenario({
  "line": 99,
  "name": "Shortcut for a Broadcast command issued",
  "description": "",
  "id": "mnemonics;shortcut-for-a-broadcast-command-issued",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 100,
  "name": "no prior Broadcast was received",
  "keyword": "Given "
});
formatter.step({
  "line": 101,
  "name": "a new Broadcast \"This is a LIVE Broadcast!\" with id \"12345\" is available",
  "keyword": "And "
});
formatter.step({
  "line": 102,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 103,
  "name": "I enter \"sdk b\"",
  "keyword": "When "
});
formatter.step({
  "line": 104,
  "name": "I see \"This is a LIVE Broadcast!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "broadcast_steps.groovy:6"
});
formatter.result({
  "duration": 85098,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is a LIVE Broadcast!",
      "offset": 17
    },
    {
      "val": "12345",
      "offset": 53
    }
  ],
  "location": "broadcast_steps.groovy:11"
});
formatter.result({
  "duration": 9105236,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101600282,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk b",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100449283,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is a LIVE Broadcast!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 105033,
  "status": "passed"
});
formatter.write("\nOutput: \n\nThis is a LIVE Broadcast!\n\n\n");
formatter.after({
  "duration": 1062437,
  "status": "passed"
});
formatter.uri("offline_mode.feature");
formatter.feature({
  "line": 1,
  "name": "Offline Mode",
  "description": "",
  "id": "offline-mode",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3228868,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "#offline modes"
    }
  ],
  "line": 5,
  "name": "Enter an invalid offline mode",
  "description": "",
  "id": "offline-mode;enter-an-invalid-offline-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "offline mode is disabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I enter \"sdk offline grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I see \"Stop! grails is not a valid offline mode.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:52"
});
formatter.result({
  "duration": 12572257,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3011133,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101512889,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk offline grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100381484,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails is not a valid offline mode.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 68614,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nStop! grails is not a valid offline mode.\n\n\n");
formatter.after({
  "duration": 1026930,
  "status": "passed"
});
formatter.before({
  "duration": 4305980,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Issue Offline command without qualification",
  "description": "",
  "id": "offline-mode;issue-offline-command-without-qualification",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "offline mode is disabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I enter \"sdk offline\"",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I see \"Offline mode enabled.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:52"
});
formatter.result({
  "duration": 13646310,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4423474,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101429522,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk offline",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100462293,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Offline mode enabled.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 80812,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nOffline mode enabled.\n\n\n");
formatter.after({
  "duration": 1050733,
  "status": "passed"
});
formatter.before({
  "duration": 3299072,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Enable Offline Mode with internet reachable",
  "description": "",
  "id": "offline-mode;enable-offline-mode-with-internet-reachable",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "offline mode is disabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I enter \"sdk offline enable\"",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I see \"Offline mode enabled.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "I do not see \"INTERNET NOT REACHABLE!\"",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I enter \"sdk install grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "I do not see \"INTERNET NOT REACHABLE!\"",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "I see \"Stop! grails 2.1.0 is not available while offline.\"",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:52"
});
formatter.result({
  "duration": 12633732,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3307255,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101374736,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk offline enable",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100461408,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Offline mode enabled.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 82367,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "INTERNET NOT REACHABLE!",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 65871,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100433539,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "INTERNET NOT REACHABLE!",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 85778,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 2.1.0 is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 52809,
  "status": "passed"
});
formatter.write("\nOutput: \n\nStop! grails 2.1.0 is not available while offline.\n\n\n");
formatter.after({
  "duration": 1010937,
  "status": "passed"
});
formatter.before({
  "duration": 3518111,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Disable Offline Mode with internet reachable",
  "description": "",
  "id": "offline-mode;disable-offline-mode-with-internet-reachable",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "offline mode is enabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "the candidate \"grails\" version \"2.1.0\" is available for download",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I enter \"sdk offline disable\"",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "I see \"Online mode re-enabled!\"",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "I enter \"sdk install grails 2.1.0\" and answer \"Y\"",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "I see \"Done installing!\"",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the candidate \"grails\" version \"2.1.0\" is installed",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:62"
});
formatter.result({
  "duration": 12003028,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 12389430,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3006162,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101391663,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk offline disable",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100430976,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Online mode re-enabled!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 87325,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 2.1.0",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 47
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100471646,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Done installing!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 110738,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:10"
});
formatter.result({
  "duration": 114875,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nDownloading: grails 2.1.0\n\n  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n\r100   541  100   541    0     0  92462      0 --:--:-- --:--:-- --:--:-- 92462\n\nInstalling: grails 2.1.0\nDone installing!\n\nDo you want grails 2.1.0 to be set as default? (Y/n): \nSetting grails 2.1.0 as default.\n\n\n");
formatter.after({
  "duration": 1079365,
  "status": "passed"
});
formatter.before({
  "duration": 3636130,
  "status": "passed"
});
formatter.scenario({
  "line": 41,
  "name": "Disable Offline Mode with internet unreachable",
  "description": "",
  "id": "offline-mode;disable-offline-mode-with-internet-unreachable",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 42,
  "name": "offline mode is enabled with unreachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "I enter \"sdk offline disable\"",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "I see \"Online mode re-enabled!\"",
  "keyword": "Then "
});
formatter.step({
  "line": 47,
  "name": "I enter \"sdk install grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 48,
  "name": "I see \"INTERNET NOT REACHABLE!\"",
  "keyword": "Then "
});
formatter.step({
  "line": 49,
  "name": "I see \"Stop! grails 2.1.0 is not available while offline.\"",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:72"
});
formatter.result({
  "duration": 134793,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4600089,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101298011,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk offline disable",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100665546,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Online mode re-enabled!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 72566,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100344039,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "INTERNET NOT REACHABLE!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 71581,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 2.1.0 is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 31202,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nStop! grails 2.1.0 is not available while offline.\n\n\n");
formatter.after({
  "duration": 1031619,
  "status": "passed"
});
formatter.before({
  "duration": 3387407,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 51,
      "value": "#broadcast"
    }
  ],
  "line": 52,
  "name": "Recall a broadcast while in Offline Mode",
  "description": "",
  "id": "offline-mode;recall-a-broadcast-while-in-offline-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 53,
  "name": "offline mode is enabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "a prior Broadcast \"This is an OLD Broadcast!\" with id \"12344\" was issued",
  "keyword": "When "
});
formatter.step({
  "line": 57,
  "name": "I enter \"sdk broadcast\"",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "I see \"This is an OLD Broadcast!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:62"
});
formatter.result({
  "duration": 12747495,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3164154,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101529909,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is an OLD Broadcast!",
      "offset": 19
    },
    {
      "val": "12344",
      "offset": 55
    }
  ],
  "location": "broadcast_steps.groovy:16"
});
formatter.result({
  "duration": 288374,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk broadcast",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100414536,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is an OLD Broadcast!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 81363,
  "status": "passed"
});
formatter.write("\nOutput: \n\nThis is an OLD Broadcast!\n\n\n");
formatter.after({
  "duration": 978851,
  "status": "passed"
});
formatter.before({
  "duration": 3406311,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 60,
      "value": "#sdk version"
    }
  ],
  "line": 61,
  "name": "Determine the sdkman version while in Offline Mode",
  "description": "",
  "id": "offline-mode;determine-the-sdkman-version-while-in-offline-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 62,
  "name": "offline mode is enabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 63,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 64,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 65,
  "name": "I enter \"sdk version\"",
  "keyword": "When "
});
formatter.step({
  "line": 66,
  "name": "I see the current sdkman version",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:62"
});
formatter.result({
  "duration": 12672446,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3023308,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101433441,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk version",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100459163,
  "status": "passed"
});
formatter.match({
  "location": "command_line_interop_steps.groovy:27"
});
formatter.result({
  "duration": 221705,
  "status": "passed"
});
formatter.write("\nOutput: \n\nSDKMAN x.y.z\n\n\n");
formatter.after({
  "duration": 1056109,
  "status": "passed"
});
formatter.before({
  "duration": 3224977,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 68,
      "value": "#list candidate version"
    }
  ],
  "line": 69,
  "name": "List candidate versions found while in Offline Mode",
  "description": "",
  "id": "offline-mode;list-candidate-versions-found-while-in-offline-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 70,
  "name": "offline mode is enabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 71,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 72,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 73,
  "name": "I enter \"sdk list grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 74,
  "name": "I see \"Offline: only showing installed grails versions\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:62"
});
formatter.result({
  "duration": 11830297,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2913282,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101435990,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk list grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100455682,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Offline: only showing installed grails versions",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 66491,
  "status": "passed"
});
formatter.write("\nOutput: \n\n------------------------------------------------------------\nOffline: only showing installed grails versions\n------------------------------------------------------------\n                                                            \n   None installed!\n------------------------------------------------------------\n* - installed                                               \n\u003e - currently in use                                        \n------------------------------------------------------------\n\n\n");
formatter.after({
  "duration": 6837475,
  "status": "passed"
});
formatter.before({
  "duration": 3110790,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 76,
      "value": "#use version"
    }
  ],
  "line": 77,
  "name": "Use an uninstalled candidate version while in Offline Mode",
  "description": "",
  "id": "offline-mode;use-an-uninstalled-candidate-version-while-in-offline-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 78,
  "name": "offline mode is enabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 79,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "the candidate \"grails\" version \"2.1.0\" is not installed",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 82,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "I enter \"sdk use grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 84,
  "name": "I see \"Stop! grails 2.1.0 is not available while offline.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:62"
});
formatter.result({
  "duration": 12337286,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 1147198,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 282892,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3181498,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101800402,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100490930,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 2.1.0 is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 70693,
  "status": "passed"
});
formatter.write("\nOutput: \n\nStop! grails 2.1.0 is not available while offline.\n\n\n");
formatter.after({
  "duration": 1078070,
  "status": "passed"
});
formatter.before({
  "duration": 3326045,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 86,
      "value": "#default version"
    }
  ],
  "line": 87,
  "name": "Set the default to an uninstalled candidate version while in Offline Mode",
  "description": "",
  "id": "offline-mode;set-the-default-to-an-uninstalled-candidate-version-while-in-offline-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 88,
  "name": "offline mode is enabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 89,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 91,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 92,
  "name": "I enter \"sdk default grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 93,
  "name": "I see \"Stop! grails 2.1.0 is not available while offline.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:62"
});
formatter.result({
  "duration": 11914717,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 995581,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2816625,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101505888,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk default grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100473496,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 2.1.0 is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 70193,
  "status": "passed"
});
formatter.write("\nOutput: \n\nStop! grails 2.1.0 is not available while offline.\n\n\n");
formatter.after({
  "duration": 1082012,
  "status": "passed"
});
formatter.before({
  "duration": 3459544,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 95,
      "value": "#install command"
    }
  ],
  "line": 96,
  "name": "Install a candidate version that is not installed while in Offline Mode",
  "description": "",
  "id": "offline-mode;install-a-candidate-version-that-is-not-installed-while-in-offline-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 97,
  "name": "offline mode is enabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 98,
  "name": "the candidate \"grails\" version \"2.1.0\" is not installed",
  "keyword": "And "
});
formatter.step({
  "line": 99,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 100,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 101,
  "name": "I enter \"sdk install grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 102,
  "name": "I see \"Stop! grails 2.1.0 is not available while offline.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:62"
});
formatter.result({
  "duration": 11687490,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 353742,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3013894,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101545466,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100395533,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 2.1.0 is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 66784,
  "status": "passed"
});
formatter.write("\nOutput: \n\nStop! grails 2.1.0 is not available while offline.\n\n\n");
formatter.after({
  "duration": 973481,
  "status": "passed"
});
formatter.before({
  "duration": 3424910,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 104,
      "value": "#uninstall command"
    }
  ],
  "line": 105,
  "name": "Uninstall a candidate version while in Offline Mode",
  "description": "",
  "id": "offline-mode;uninstall-a-candidate-version-while-in-offline-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 106,
  "name": "offline mode is enabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 107,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "And "
});
formatter.step({
  "line": 108,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 109,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 110,
  "name": "I enter \"sdk uninstall grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 111,
  "name": "the candidate \"grails\" version \"2.1.0\" is not installed",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:62"
});
formatter.result({
  "duration": 12302773,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 1138928,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2771656,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101441775,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk uninstall grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100463832,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 774853,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\nUnselecting grails 2.1.0...\n\nUninstalling grails 2.1.0...\n\n\n");
formatter.after({
  "duration": 983901,
  "status": "passed"
});
formatter.before({
  "duration": 3089628,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 113,
      "value": "#current command"
    }
  ],
  "line": 114,
  "name": "Display the current version of a candidate while in Offline Mode",
  "description": "",
  "id": "offline-mode;display-the-current-version-of-a-candidate-while-in-offline-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 115,
  "name": "offline mode is enabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 116,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "And "
});
formatter.step({
  "line": 117,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 118,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 119,
  "name": "I enter \"sdk current grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 120,
  "name": "I see \"Using grails version 2.1.0\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:62"
});
formatter.result({
  "duration": 12857083,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 977913,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3054143,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101547465,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk current grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100508801,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 75245,
  "status": "passed"
});
formatter.write("\nOutput: \n\nUsing grails version 2.1.0\n\n\n");
formatter.after({
  "duration": 1175925,
  "status": "passed"
});
formatter.before({
  "duration": 3471612,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 122,
      "value": "#help command"
    }
  ],
  "line": 123,
  "name": "Request help while in Offline Mode",
  "description": "",
  "id": "offline-mode;request-help-while-in-offline-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 124,
  "name": "offline mode is enabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 125,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 126,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 127,
  "name": "I enter \"sdk help\"",
  "keyword": "When "
});
formatter.step({
  "line": 128,
  "name": "I see \"Usage: sdk \u003ccommand\u003e [candidate] [version]\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:62"
});
formatter.result({
  "duration": 12680973,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3135211,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101535912,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk help",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100465243,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Usage: sdk \u003ccommand\u003e [candidate] [version]",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 68230,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\n");
formatter.after({
  "duration": 1178644,
  "status": "passed"
});
formatter.before({
  "duration": 3226967,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 130,
      "value": "#selfupdate command"
    }
  ],
  "line": 131,
  "name": "Attempt self-update while in Offline Mode",
  "description": "",
  "id": "offline-mode;attempt-self-update-while-in-offline-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 132,
  "name": "offline mode is enabled with reachable internet",
  "keyword": "Given "
});
formatter.step({
  "line": 133,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 134,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 135,
  "name": "I enter \"sdk selfupdate\"",
  "keyword": "When "
});
formatter.step({
  "line": 136,
  "name": "I see \"This command is not available while offline.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:62"
});
formatter.result({
  "duration": 15681557,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3832363,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 120612422,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk selfupdate",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100493289,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This command is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 71442,
  "status": "passed"
});
formatter.write("\nOutput: \n\nThis command is not available while offline.\n\n\n");
formatter.after({
  "duration": 1097300,
  "status": "passed"
});
formatter.uri("outdated_candidate.feature");
formatter.feature({
  "line": 1,
  "name": "Outdated Candidate",
  "description": "",
  "id": "outdated-candidate",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3301386,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17002194,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3031764,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Display outdated candidate version in use when it is outdated",
  "description": "",
  "id": "outdated-candidate;display-outdated-candidate-version-in-use-when-it-is-outdated",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the default \"grails\" candidate is \"2.4.4\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I enter \"sdk outdated grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I see \"Outdated:\"",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I see \"grails (1.3.9 \u003c 2.4.4)\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 678079,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 13
    },
    {
      "val": "2.4.4",
      "offset": 35
    }
  ],
  "location": "stub_steps.groovy:8"
});
formatter.result({
  "duration": 13414054,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101443691,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk outdated grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100351263,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Outdated:",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 73308,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails (1.3.9 \u003c 2.4.4)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 46041,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nOutdated:\ngrails (1.3.9 \u003c 2.4.4)\n\n\n");
formatter.after({
  "duration": 1168681,
  "status": "passed"
});
formatter.before({
  "duration": 3363259,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17559172,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3117507,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Display outdated candidate version in use when it is not outdated",
  "description": "",
  "id": "outdated-candidate;display-outdated-candidate-version-in-use-when-it-is-not-outdated",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the default \"grails\" candidate is \"1.3.9\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I enter \"sdk outdated grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I see \"grails is up-to-date\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 752113,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 13
    },
    {
      "val": "1.3.9",
      "offset": 35
    }
  ],
  "location": "stub_steps.groovy:8"
});
formatter.result({
  "duration": 13634623,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101524351,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk outdated grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100409570,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails is up-to-date",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 79423,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\ngrails is up-to-date\n\n\n");
formatter.after({
  "duration": 1137600,
  "status": "passed"
});
formatter.before({
  "duration": 3352781,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 15590177,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3109886,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Display outdated candidate version when none is in use",
  "description": "",
  "id": "outdated-candidate;display-outdated-candidate-version-when-none-is-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 23,
  "name": "the candidate \"grails\" does not exist locally",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I enter \"sdk outdated grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I see \"Not using any version of grails\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    }
  ],
  "location": "installation_steps.groovy:44"
});
formatter.result({
  "duration": 339780,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101449722,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk outdated grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100390502,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not using any version of grails",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 92189,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nNot using any version of grails\ngrails is up-to-date\n\n\n");
formatter.after({
  "duration": 1083556,
  "status": "passed"
});
formatter.before({
  "duration": 3155064,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16039615,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3050575,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "Display outdated candidate versions when none is specified and none is in use",
  "description": "",
  "id": "outdated-candidate;display-outdated-candidate-versions-when-none-is-specified-and-none-is-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 29,
  "name": "the candidate \"grails\" does not exist locally",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I enter \"sdk outdated\"",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "I see \"No candidates are in use\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    }
  ],
  "location": "installation_steps.groovy:44"
});
formatter.result({
  "duration": 216068,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 103123700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk outdated",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100376857,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "No candidates are in use",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 82018,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nNo candidates are in use\n\n\n");
formatter.after({
  "duration": 1229533,
  "status": "passed"
});
formatter.before({
  "duration": 3987010,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 18009282,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3449562,
  "status": "passed"
});
formatter.scenario({
  "line": 34,
  "name": "Display outdated candidate versions when none is specified and one is in use",
  "description": "",
  "id": "outdated-candidate;display-outdated-candidate-versions-when-none-is-specified-and-one-is-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 35,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 36,
  "name": "the default \"grails\" candidate is \"2.4.4\"",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "I enter \"sdk outdated\"",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "I see \"Outdated:\"",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "I see \"grails (1.3.9 \u003c 2.4.4)\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 1075251,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 13
    },
    {
      "val": "2.4.4",
      "offset": 35
    }
  ],
  "location": "stub_steps.groovy:8"
});
formatter.result({
  "duration": 16790594,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101834827,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk outdated",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100469923,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Outdated:",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 99723,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails (1.3.9 \u003c 2.4.4)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 44313,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nOutdated:\ngrails (1.3.9 \u003c 2.4.4)\n\n\n");
formatter.after({
  "duration": 1062574,
  "status": "passed"
});
formatter.before({
  "duration": 3379562,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 15552205,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2968335,
  "status": "passed"
});
formatter.scenario({
  "line": 42,
  "name": "Display outdated candidate versions when none is specified and multiple are in use",
  "description": "",
  "id": "outdated-candidate;display-outdated-candidate-versions-when-none-is-specified-and-multiple-are-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 43,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 44,
  "name": "the default \"grails\" candidate is \"2.4.4\"",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "the candidate \"groovy\" version \"2.0.5\" is already installed and default",
  "keyword": "And "
});
formatter.step({
  "line": 46,
  "name": "the default \"groovy\" candidate is \"2.4.1\"",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "I enter \"sdk outdated\"",
  "keyword": "When "
});
formatter.step({
  "line": 49,
  "name": "I see \"Outdated:\"",
  "keyword": "Then "
});
formatter.step({
  "line": 50,
  "name": "I see \"grails (1.3.9 \u003c 2.4.4)\"",
  "keyword": "And "
});
formatter.step({
  "line": 51,
  "name": "I see \"groovy (2.0.5 \u003c 2.4.1)\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 877241,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 13
    },
    {
      "val": "2.4.4",
      "offset": 35
    }
  ],
  "location": "stub_steps.groovy:8"
});
formatter.result({
  "duration": 17656533,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 1003389,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 13
    },
    {
      "val": "2.4.1",
      "offset": 35
    }
  ],
  "location": "stub_steps.groovy:8"
});
formatter.result({
  "duration": 13981514,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101381598,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk outdated",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100379604,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Outdated:",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 76816,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails (1.3.9 \u003c 2.4.4)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 32448,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy (2.0.5 \u003c 2.4.1)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 57173,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nOutdated:\ngroovy (2.0.5 \u003c 2.4.1)\ngrails (1.3.9 \u003c 2.4.4)\n\n\n");
formatter.after({
  "duration": 1130579,
  "status": "passed"
});
formatter.before({
  "duration": 3564068,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 15781917,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2895830,
  "status": "passed"
});
formatter.scenario({
  "line": 53,
  "name": "Display outdated candidate versions when none specified and multiple in use but not outdated",
  "description": "",
  "id": "outdated-candidate;display-outdated-candidate-versions-when-none-specified-and-multiple-in-use-but-not-outdated",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 54,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 55,
  "name": "the default \"grails\" candidate is \"1.3.9\"",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "the candidate \"groovy\" version \"2.0.5\" is already installed and default",
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "the default \"groovy\" candidate is \"2.0.5\"",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "I enter \"sdk outdated\"",
  "keyword": "When "
});
formatter.step({
  "line": 60,
  "name": "I see \"All candidates are up-to-date\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 607215,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 13
    },
    {
      "val": "1.3.9",
      "offset": 35
    }
  ],
  "location": "stub_steps.groovy:8"
});
formatter.result({
  "duration": 12854079,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 817359,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 13
    },
    {
      "val": "2.0.5",
      "offset": 35
    }
  ],
  "location": "stub_steps.groovy:8"
});
formatter.result({
  "duration": 11519465,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101246087,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk outdated",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100363671,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "All candidates are up-to-date",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 87817,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nAll candidates are up-to-date\n\n\n");
formatter.after({
  "duration": 1164296,
  "status": "passed"
});
formatter.uri("path_initialisation.feature");
formatter.feature({
  "line": 1,
  "name": "Path Initialisation",
  "description": "",
  "id": "path-initialisation",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3460194,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17409436,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2957065,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "sdkman is initialised for the first time",
  "description": "",
  "id": "path-initialisation;sdkman-is-initialised-for-the-first-time",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I enter \"echo $PATH\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I see a single occurrence of \"grails\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 735069,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101545067,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "echo $PATH",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100435155,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 30
    }
  ],
  "location": "command_line_interop_steps.groovy:31"
});
formatter.result({
  "duration": 850374,
  "status": "passed"
});
formatter.write("\nOutput: \n\n/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/candidates/grails/current/bin:/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/bin:/usr/sbin:/usr/bin:/sbin:/bin\n\n\n");
formatter.after({
  "duration": 1095820,
  "status": "passed"
});
formatter.before({
  "duration": 3405276,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16828458,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3078450,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "sdkman is initialised a subsequent time",
  "description": "",
  "id": "path-initialisation;sdkman-is-initialised-a-subsequent-time",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "the system is bootstrapped again",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I enter \"echo $PATH\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I see a single occurrence of \"grails\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 630663,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101182360,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:117"
});
formatter.result({
  "duration": 100488136,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "echo $PATH",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100465062,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 30
    }
  ],
  "location": "command_line_interop_steps.groovy:31"
});
formatter.result({
  "duration": 81248,
  "status": "passed"
});
formatter.write("\nOutput: \n\n/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/candidates/grails/current/bin:/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/bin:/usr/sbin:/usr/bin:/sbin:/bin\n\n\n");
formatter.after({
  "duration": 1067805,
  "status": "passed"
});
formatter.before({
  "duration": 3467145,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16318434,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2875750,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Install a candidate and see it on the PATH",
  "description": "",
  "id": "path-initialisation;install-a-candidate-and-see-it-on-the-path",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "I enter \"echo $PATH\"",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I see no occurrences of \"grails\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101478361,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "echo $PATH",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100450174,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 25
    }
  ],
  "location": "command_line_interop_steps.groovy:35"
});
formatter.result({
  "duration": 218251,
  "status": "passed"
});
formatter.write("\nOutput: \n\n/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/bin:/usr/sbin:/usr/bin:/sbin:/bin\n\n\n");
formatter.after({
  "duration": 1066538,
  "status": "passed"
});
formatter.before({
  "duration": 3231473,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16277507,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3040979,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Install a candidate and see it on the PATH",
  "description": "",
  "id": "path-initialisation;install-a-candidate-and-see-it-on-the-path",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "the candidate \"grails\" version \"2.1.0\" is available for download",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I enter \"sdk install grails 2.1.0\" and answer \"Y\"",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I enter \"echo $PATH\"",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "I see a single occurrence of \"grails\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 14280862,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101385346,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 2.1.0",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 47
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100401214,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "echo $PATH",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100327829,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 30
    }
  ],
  "location": "command_line_interop_steps.groovy:31"
});
formatter.result({
  "duration": 85276,
  "status": "passed"
});
formatter.write("\nOutput: \n\n/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/candidates/grails/current/bin:/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/bin:/usr/sbin:/usr/bin:/sbin:/bin\n\n\n");
formatter.after({
  "duration": 1356751,
  "status": "passed"
});
formatter.before({
  "duration": 3424684,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16147182,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2931786,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Install multiple candidate versions and see it once on the PATH",
  "description": "",
  "id": "path-initialisation;install-multiple-candidate-versions-and-see-it-once-on-the-path",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "the candidate \"grails\" version \"1.3.9\" is available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "the candidate \"grails\" version \"2.1.0\" is available for download",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I enter \"sdk install grails 1.3.9\" and answer \"Y\"",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "I enter \"sdk install grails 2.1.0\" and answer \"Y\"",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "I enter \"echo $PATH\"",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "I see a single occurrence of \"grails\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 13000075,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 12354250,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101460006,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 1.3.9",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 47
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100472910,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 2.1.0",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 47
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100557192,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "echo $PATH",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100505964,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 30
    }
  ],
  "location": "command_line_interop_steps.groovy:31"
});
formatter.result({
  "duration": 87544,
  "status": "passed"
});
formatter.write("\nOutput: \n\n/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/candidates/grails/current/bin:/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/bin:/usr/sbin:/usr/bin:/sbin:/bin\n\n\n");
formatter.after({
  "duration": 1078290,
  "status": "passed"
});
formatter.uri("self_update.feature");
formatter.feature({
  "line": 1,
  "name": "Self Update",
  "description": "",
  "id": "self-update",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3653107,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 15503251,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Force a Selfupdate",
  "description": "",
  "id": "self-update;force-a-selfupdate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "an initialised environment",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I enter \"sdk selfupdate force\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I do not see \"A new version of SDKMAN is available...\"",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I do not see \"Would you like to upgrade now? (Y/n)\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I do not see \"Not upgrading today...\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I see \"Updating SDKMAN...\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I see \"Successfully upgraded SDKMAN.\"",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2854387,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101530353,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk selfupdate force",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100459238,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A new version of SDKMAN is available...",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 71318,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Would you like to upgrade now? (Y/n)",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 36711,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not upgrading today...",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 31945,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Updating SDKMAN...",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 29684,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Successfully upgraded SDKMAN.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 26919,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\nUpdating SDKMAN...\nPurge existing scripts...\nRefresh directory structure...\nPrime the config file...\nExtract script archive...\nUnziping scripts to: /tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/tmp/stage\nMoving sdkman-init file to bin folder...\nMove remaining module scripts to src folder: /tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/src\nClean up staging folder...\n\n\nSuccessfully upgraded SDKMAN.\n\nPlease open a new terminal, or run the following in the existing one:\n\n    source \"/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/bin/sdkman-init.sh\"\n\n\n\n\n");
formatter.after({
  "duration": 1000638,
  "status": "passed"
});
formatter.before({
  "duration": 2869711,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 14544598,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Selfupdate when out of date",
  "description": "",
  "id": "self-update;selfupdate-when-out-of-date",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "an outdated initialised environment",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I enter \"sdk selfupdate\"",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I do not see \"A new version of SDKMAN is available...\"",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "I do not see \"Would you like to upgrade now? (Y/n)\"",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I do not see \"Not upgrading today...\"",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I see \"Updating SDKMAN...\"",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I see \"Successfully upgraded SDKMAN.\"",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:89"
});
formatter.result({
  "duration": 4413210,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101396936,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk selfupdate",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100348826,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A new version of SDKMAN is available...",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 76694,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Would you like to upgrade now? (Y/n)",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 33837,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not upgrading today...",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 31076,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Updating SDKMAN...",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 36230,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Successfully upgraded SDKMAN.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 37004,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\nUpdating SDKMAN...\nPurge existing scripts...\nRefresh directory structure...\nPrime the config file...\nExtract script archive...\nUnziping scripts to: /tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/tmp/stage\nMoving sdkman-init file to bin folder...\nMove remaining module scripts to src folder: /tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/src\nClean up staging folder...\n\n\nSuccessfully upgraded SDKMAN.\n\nPlease open a new terminal, or run the following in the existing one:\n\n    source \"/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/bin/sdkman-init.sh\"\n\n\n\n\n");
formatter.after({
  "duration": 1161363,
  "status": "passed"
});
formatter.before({
  "duration": 3373040,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 15893570,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "Agree to a suggested Selfupdate",
  "description": "",
  "id": "self-update;agree-to-a-suggested-selfupdate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 27,
  "name": "an outdated initialised environment",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I enter \"sdk help\" and answer \"Y\"",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "I see \"A new version of SDKMAN is available...\"",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "I see \"Would you like to upgrade now? (Y/n)\"",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I see \"Successfully upgraded SDKMAN.\"",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "I do not see \"Not upgrading today...\"",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:89"
});
formatter.result({
  "duration": 3413947,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101650752,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk help",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 31
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100666501,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A new version of SDKMAN is available...",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 176289,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Would you like to upgrade now? (Y/n)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 49440,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Successfully upgraded SDKMAN.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 27759,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not upgrading today...",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 36917,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\nATTENTION: A new version of SDKMAN is available...\n\nThe current version is x.y.z, but you have x.y.y.\n\nWould you like to upgrade now? (Y/n)\nUpdating SDKMAN...\nPurge existing scripts...\nRefresh directory structure...\nPrime the config file...\nExtract script archive...\nUnziping scripts to: /tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/tmp/stage\nMoving sdkman-init file to bin folder...\nMove remaining module scripts to src folder: /tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/src\nClean up staging folder...\n\n\nSuccessfully upgraded SDKMAN.\n\nPlease open a new terminal, or run the following in the existing one:\n\n    source \"/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/bin/sdkman-init.sh\"\n\n\n\n\n");
formatter.after({
  "duration": 1162262,
  "status": "passed"
});
formatter.before({
  "duration": 2945986,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16449378,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Do not agree to a suggested Selfupdate",
  "description": "",
  "id": "self-update;do-not-agree-to-a-suggested-selfupdate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 36,
  "name": "an outdated initialised environment",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "I enter \"sdk help\" and answer \"N\"",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "I see \"A new version of SDKMAN is available...\"",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "I see \"Would you like to upgrade now? (Y/n)\"",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "I see \"Not upgrading today...\"",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "I do not see \"Successfully upgraded SDKMAN.\"",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:89"
});
formatter.result({
  "duration": 3389607,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101450395,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk help",
      "offset": 9
    },
    {
      "val": "N",
      "offset": 31
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100541844,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A new version of SDKMAN is available...",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 52147,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Would you like to upgrade now? (Y/n)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 42145,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not upgrading today...",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 23600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Successfully upgraded SDKMAN.",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 36909,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\nATTENTION: A new version of SDKMAN is available...\n\nThe current version is x.y.z, but you have x.y.y.\n\nWould you like to upgrade now? (Y/n)Not upgrading today...\n\n\n");
formatter.after({
  "duration": 1235078,
  "status": "passed"
});
formatter.before({
  "duration": 3194054,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17162492,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "Automatically Selfupdate",
  "description": "",
  "id": "self-update;automatically-selfupdate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 45,
  "name": "an outdated initialised environment",
  "keyword": "Given "
});
formatter.step({
  "line": 46,
  "name": "the configuration file has been primed with \"sdkman_auto_selfupdate\u003dtrue\"",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "I enter \"sdk help\"",
  "keyword": "When "
});
formatter.step({
  "line": 49,
  "name": "I see \"A new version of SDKMAN is available...\"",
  "keyword": "Then "
});
formatter.step({
  "line": 50,
  "name": "I do not see \"Would you like to upgrade now? (Y/n)\"",
  "keyword": "And "
});
formatter.step({
  "line": 51,
  "name": "I do not see \"Not upgrading today...\"",
  "keyword": "And "
});
formatter.step({
  "line": 52,
  "name": "I see \"Successfully upgraded SDKMAN.\"",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:89"
});
formatter.result({
  "duration": 3368028,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdkman_auto_selfupdate\u003dtrue",
      "offset": 45
    }
  ],
  "location": "selfupdate_steps.groovy:5"
});
formatter.result({
  "duration": 436601,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101373869,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk help",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100375257,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A new version of SDKMAN is available...",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 54075,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Would you like to upgrade now? (Y/n)",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 38557,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not upgrading today...",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 419881,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Successfully upgraded SDKMAN.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 33026,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\nATTENTION: A new version of SDKMAN is available...\n\nThe current version is x.y.z, but you have x.y.y.\n\n\nUpdating SDKMAN...\nPurge existing scripts...\nRefresh directory structure...\nPrime the config file...\nExtract script archive...\nUnziping scripts to: /tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/tmp/stage\nMoving sdkman-init file to bin folder...\nMove remaining module scripts to src folder: /tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/src\nClean up staging folder...\n\n\nSuccessfully upgraded SDKMAN.\n\nPlease open a new terminal, or run the following in the existing one:\n\n    source \"/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/bin/sdkman-init.sh\"\n\n\n\n\n");
formatter.after({
  "duration": 1209753,
  "status": "passed"
});
formatter.before({
  "duration": 3705516,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 20814286,
  "status": "passed"
});
formatter.scenario({
  "line": 54,
  "name": "Do not automatically Selfupdate",
  "description": "",
  "id": "self-update;do-not-automatically-selfupdate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 55,
  "name": "an outdated initialised environment",
  "keyword": "Given "
});
formatter.step({
  "line": 56,
  "name": "the configuration file has been primed with \"sdkman_auto_selfupdate\u003dfalse\"",
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "I enter \"sdk help\" and answer \"n\"",
  "keyword": "When "
});
formatter.step({
  "line": 59,
  "name": "I see \"A new version of SDKMAN is available...\"",
  "keyword": "Then "
});
formatter.step({
  "line": 60,
  "name": "I see \"Would you like to upgrade now? (Y/n)\"",
  "keyword": "And "
});
formatter.step({
  "line": 61,
  "name": "I see \"Not upgrading today...\"",
  "keyword": "And "
});
formatter.step({
  "line": 62,
  "name": "I do not see \"Successfully upgraded SDKMAN.\"",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:89"
});
formatter.result({
  "duration": 5019035,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdkman_auto_selfupdate\u003dfalse",
      "offset": 45
    }
  ],
  "location": "selfupdate_steps.groovy:5"
});
formatter.result({
  "duration": 155033,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101512600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk help",
      "offset": 9
    },
    {
      "val": "n",
      "offset": 31
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100527403,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A new version of SDKMAN is available...",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 76858,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Would you like to upgrade now? (Y/n)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 30941,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not upgrading today...",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 29341,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Successfully upgraded SDKMAN.",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 74285,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\nATTENTION: A new version of SDKMAN is available...\n\nThe current version is x.y.z, but you have x.y.y.\n\nWould you like to upgrade now? (Y/n)Not upgrading today...\n\n\n");
formatter.after({
  "duration": 1284363,
  "status": "passed"
});
formatter.before({
  "duration": 4101929,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17866037,
  "status": "passed"
});
formatter.scenario({
  "line": 64,
  "name": "Bother the user with Upgrade message once a day",
  "description": "",
  "id": "self-update;bother-the-user-with-upgrade-message-once-a-day",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 65,
  "name": "an outdated initialised environment",
  "keyword": "Given "
});
formatter.step({
  "line": 66,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 67,
  "name": "I enter \"sdk help\" and answer \"N\"",
  "keyword": "When "
});
formatter.step({
  "line": 68,
  "name": "I see \"A new version of SDKMAN is available...\"",
  "keyword": "Then "
});
formatter.step({
  "line": 69,
  "name": "I see \"Would you like to upgrade now? (Y/n)\"",
  "keyword": "And "
});
formatter.step({
  "line": 70,
  "name": "I see \"Not upgrading today...\"",
  "keyword": "And "
});
formatter.step({
  "line": 71,
  "name": "I enter \"sdk help\"",
  "keyword": "And "
});
formatter.step({
  "line": 72,
  "name": "I do not see \"A new version of SDKMAN is available...\"",
  "keyword": "Then "
});
formatter.step({
  "line": 73,
  "name": "I do not see \"Would you like to upgrade now? (Y/n)\"",
  "keyword": "And "
});
formatter.step({
  "line": 74,
  "name": "I do not see \"Not upgrading now...\"",
  "keyword": "And "
});
formatter.step({
  "line": 75,
  "name": "I do not see \"Successfully upgraded SDKMAN.\"",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:89"
});
formatter.result({
  "duration": 3596641,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101820550,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk help",
      "offset": 9
    },
    {
      "val": "N",
      "offset": 31
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100491864,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A new version of SDKMAN is available...",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 63522,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Would you like to upgrade now? (Y/n)",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 31426,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not upgrading today...",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 30826,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk help",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100480221,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A new version of SDKMAN is available...",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 53255,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Would you like to upgrade now? (Y/n)",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 23808,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not upgrading now...",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 24816,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Successfully upgraded SDKMAN.",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 20366,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\n");
formatter.after({
  "duration": 1103135,
  "status": "passed"
});
formatter.before({
  "duration": 3266828,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 14961366,
  "status": "passed"
});
formatter.scenario({
  "line": 77,
  "name": "Selfupdate when not out of date",
  "description": "",
  "id": "self-update;selfupdate-when-not-out-of-date",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 78,
  "name": "an initialised environment",
  "keyword": "Given "
});
formatter.step({
  "line": 79,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "I enter \"sdk selfupdate\"",
  "keyword": "When "
});
formatter.step({
  "line": 81,
  "name": "I see \"No update available at this time.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2875103,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101435637,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk selfupdate",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100387607,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "No update available at this time.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 59755,
  "status": "passed"
});
formatter.write("\nOutput: \n\nNo update available at this time.\n\n\n");
formatter.after({
  "duration": 1021528,
  "status": "passed"
});
formatter.uri("service_unavailable.feature");
formatter.feature({
  "line": 1,
  "name": "Service Unavailable",
  "description": "",
  "id": "service-unavailable",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3187943,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 130121,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2886755,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 7,
      "value": "# list commands"
    }
  ],
  "line": 9,
  "name": "List candidate versions found while Offline",
  "description": "",
  "id": "service-unavailable;list-candidate-versions-found-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed but not default",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I enter \"sdk list grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I see \"Offline: only showing installed grails versions\"",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I see \"\u003e 2.1.0\"",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I see \"* 1.3.9\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 595946,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 405770,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101589818,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk list grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100443259,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Offline: only showing installed grails versions",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 62387,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "\u003e 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 31214,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "* 1.3.9",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 21731,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n------------------------------------------------------------\nOffline: only showing installed grails versions\n------------------------------------------------------------\n                                                            \n * 1.3.9\n \u003e 2.1.0\n------------------------------------------------------------\n* - installed                                               \n\u003e - currently in use                                        \n------------------------------------------------------------\n\n\n");
formatter.after({
  "duration": 1128724,
  "status": "passed"
});
formatter.before({
  "duration": 3357345,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 33057,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2801007,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "List candidate versions not found while Offline",
  "description": "",
  "id": "service-unavailable;list-candidate-versions-not-found-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "I enter \"sdk list grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I see \"Offline: only showing installed grails versions\"",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "I see \"None installed!\"",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101257454,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk list grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100413394,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Offline: only showing installed grails versions",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 54786,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "None installed!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 26400,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n------------------------------------------------------------\nOffline: only showing installed grails versions\n------------------------------------------------------------\n                                                            \n   None installed!\n------------------------------------------------------------\n* - installed                                               \n\u003e - currently in use                                        \n------------------------------------------------------------\n\n\n");
formatter.after({
  "duration": 1180303,
  "status": "passed"
});
formatter.before({
  "duration": 3382860,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 35205,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3301608,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "List Available Candidates while Offline",
  "description": "",
  "id": "service-unavailable;list-available-candidates-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "I enter \"sdk list\"",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "I see \"This command is not available while offline.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101428592,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk list",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100440210,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This command is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 51106,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nThis command is not available while offline.\n\n\n");
formatter.after({
  "duration": 1018353,
  "status": "passed"
});
formatter.before({
  "duration": 3147278,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 31936,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2817216,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 29,
      "value": "# use command"
    }
  ],
  "line": 31,
  "name": "Use the default candidate version while Offline",
  "description": "",
  "id": "service-unavailable;use-the-default-candidate-version-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 32,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 33,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed but not default",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I enter \"sdk use grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "I see \"Using grails version 2.1.0 in this shell.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 654803,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 404370,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101490618,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100411590,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 2.1.0 in this shell.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 51298,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n\nUsing grails version 2.1.0 in this shell.\n\n\n");
formatter.after({
  "duration": 1092080,
  "status": "passed"
});
formatter.before({
  "duration": 3415238,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 35597,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2888727,
  "status": "passed"
});
formatter.scenario({
  "line": 38,
  "name": "Use the default candidate version when non selected while Offline",
  "description": "",
  "id": "service-unavailable;use-the-default-candidate-version-when-non-selected-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 39,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed but not default",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed but not default",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "I enter \"sdk use grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "I see \"This command is not available while offline.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 545300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 406456,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101431196,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100452256,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This command is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 52465,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nThis command is not available while offline.\n\n\n");
formatter.after({
  "duration": 1080073,
  "status": "passed"
});
formatter.before({
  "duration": 3414236,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 32450,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3031231,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "Use an uninstalled candidate version while Offline",
  "description": "",
  "id": "service-unavailable;use-an-uninstalled-candidate-version-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 46,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 47,
  "name": "the candidate \"grails\" version \"2.1.0\" is not installed",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "I enter \"sdk use grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 50,
  "name": "I see \"Stop! grails 2.1.0 is not available while offline.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 647049,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 246880,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101460175,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100443788,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 2.1.0 is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 56279,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nStop! grails 2.1.0 is not available while offline.\n\n\n");
formatter.after({
  "duration": 1040149,
  "status": "passed"
});
formatter.before({
  "duration": 3634827,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 33434,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2840838,
  "status": "passed"
});
formatter.scenario({
  "line": 52,
  "name": "Use an invalid candidate version while Offline",
  "description": "",
  "id": "service-unavailable;use-an-invalid-candidate-version-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 53,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "I enter \"sdk use grails 9.9.9\"",
  "keyword": "When "
});
formatter.step({
  "line": 56,
  "name": "I see \"Stop! grails 9.9.9 is not available while offline.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 588453,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101315760,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 9.9.9",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100430853,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 9.9.9 is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 52112,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nStop! grails 9.9.9 is not available while offline.\n\n\n");
formatter.after({
  "duration": 1011799,
  "status": "passed"
});
formatter.before({
  "duration": 3342321,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 34092,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2766366,
  "status": "passed"
});
formatter.scenario({
  "line": 58,
  "name": "Use an installed candidate version while Offline",
  "description": "",
  "id": "service-unavailable;use-an-installed-candidate-version-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 59,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 60,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed but not default",
  "keyword": "And "
});
formatter.step({
  "line": 61,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 62,
  "name": "I enter \"sdk use grails 1.3.9\"",
  "keyword": "When "
});
formatter.step({
  "line": 63,
  "name": "I see \"Using grails version 1.3.9 in this shell.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 594683,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 391228,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101272287,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 1.3.9",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100425058,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 1.3.9 in this shell.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 53441,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n\nUsing grails version 1.3.9 in this shell.\n\n\n");
formatter.after({
  "duration": 1067206,
  "status": "passed"
});
formatter.before({
  "duration": 3409385,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 32053,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2764155,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 65,
      "value": "# default command"
    }
  ],
  "line": 67,
  "name": "Set the default to an uninstalled candidate version while Offline",
  "description": "",
  "id": "service-unavailable;set-the-default-to-an-uninstalled-candidate-version-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 68,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 69,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 70,
  "name": "I enter \"sdk default grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 71,
  "name": "I see \"Stop! grails 2.1.0 is not available while offline.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 597535,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101233544,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk default grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100390774,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 2.1.0 is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 54928,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nStop! grails 2.1.0 is not available while offline.\n\n\n");
formatter.after({
  "duration": 1148395,
  "status": "passed"
});
formatter.before({
  "duration": 3307953,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 32020,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2712990,
  "status": "passed"
});
formatter.scenario({
  "line": 73,
  "name": "Set the default to an invalid candidate version while Offline",
  "description": "",
  "id": "service-unavailable;set-the-default-to-an-invalid-candidate-version-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 74,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 75,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 76,
  "name": "I enter \"sdk default grails 999\"",
  "keyword": "When "
});
formatter.step({
  "line": 77,
  "name": "I see \"Stop! grails 999 is not available while offline.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 570019,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101255030,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk default grails 999",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100348239,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 999 is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 51427,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nStop! grails 999 is not available while offline.\n\n\n");
formatter.after({
  "duration": 1066333,
  "status": "passed"
});
formatter.before({
  "duration": 3307403,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 33364,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2782013,
  "status": "passed"
});
formatter.scenario({
  "line": 79,
  "name": "Set the default to an installed candidate version while Offline",
  "description": "",
  "id": "service-unavailable;set-the-default-to-an-installed-candidate-version-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 80,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 81,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed but not default",
  "keyword": "And "
});
formatter.step({
  "line": 82,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "I enter \"sdk default grails 1.3.9\"",
  "keyword": "When "
});
formatter.step({
  "line": 84,
  "name": "I see \"Default grails version set to 1.3.9\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 593065,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 412926,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101245351,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk default grails 1.3.9",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100337446,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Default grails version set to 1.3.9",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 61283,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n\nDefault grails version set to 1.3.9\n\n\n");
formatter.after({
  "duration": 1065761,
  "status": "passed"
});
formatter.before({
  "duration": 3464113,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 31112,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2800740,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 86,
      "value": "# install command"
    }
  ],
  "line": 87,
  "name": "Install a candidate version that is not installed while Offline",
  "description": "",
  "id": "service-unavailable;install-a-candidate-version-that-is-not-installed-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 88,
  "name": "the candidate \"grails\" version \"2.1.0\" is not installed",
  "keyword": "Given "
});
formatter.step({
  "line": 89,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "I enter \"sdk install grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 91,
  "name": "I see \"Stop! grails 2.1.0 is not available while offline.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 299342,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101253193,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100425887,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 2.1.0 is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 55180,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nStop! grails 2.1.0 is not available while offline.\n\n\n");
formatter.after({
  "duration": 1004092,
  "status": "passed"
});
formatter.before({
  "duration": 3222626,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 31058,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2931648,
  "status": "passed"
});
formatter.scenario({
  "line": 93,
  "name": "Install a candidate version that is already installed while Offline",
  "description": "",
  "id": "service-unavailable;install-a-candidate-version-that-is-already-installed-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 94,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 95,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 96,
  "name": "I enter \"sdk install grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 97,
  "name": "I see \"Stop! grails 2.1.0 is already installed.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 587517,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101362164,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk install grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100384797,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 2.1.0 is already installed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 51364,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n\nStop! grails 2.1.0 is already installed.\n\n\n");
formatter.after({
  "duration": 1018895,
  "status": "passed"
});
formatter.before({
  "duration": 3424511,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 34758,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4092401,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 99,
      "value": "# uninstall command"
    }
  ],
  "line": 100,
  "name": "Uninstall a candidate version while Offline",
  "description": "",
  "id": "service-unavailable;uninstall-a-candidate-version-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 101,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 102,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 103,
  "name": "I enter \"sdk uninstall grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 104,
  "name": "I see \"Unselecting grails 2.1.0...\"",
  "keyword": "Then "
});
formatter.step({
  "line": 105,
  "name": "I see \"Uninstalling grails 2.1.0...\"",
  "keyword": "And "
});
formatter.step({
  "line": 106,
  "name": "the candidate \"grails\" version \"2.1.0\" is not in use",
  "keyword": "And "
});
formatter.step({
  "line": 107,
  "name": "the candidate \"grails\" version \"2.1.0\" is not installed",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 810142,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101372352,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk uninstall grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100314888,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Unselecting grails 2.1.0...",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 57868,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Uninstalling grails 2.1.0...",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 31984,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:16"
});
formatter.result({
  "duration": 412197,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 246771,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n\nUnselecting grails 2.1.0...\n\nUninstalling grails 2.1.0...\n\n\n");
formatter.after({
  "duration": 1053028,
  "status": "passed"
});
formatter.before({
  "duration": 3092556,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 34738,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2790457,
  "status": "passed"
});
formatter.scenario({
  "line": 109,
  "name": "Uninstall a candidate version that is not installed while Offline",
  "description": "",
  "id": "service-unavailable;uninstall-a-candidate-version-that-is-not-installed-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 110,
  "name": "the candidate \"grails\" version \"2.1.0\" is not installed",
  "keyword": "Given "
});
formatter.step({
  "line": 111,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 112,
  "name": "I enter \"sdk uninstall grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 113,
  "name": "I see \"grails 2.1.0 is not installed.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 340956,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101277321,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk uninstall grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100438450,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails 2.1.0 is not installed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 67171,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n\ngrails 2.1.0 is not installed.\n\n\n");
formatter.after({
  "duration": 110398327,
  "status": "passed"
});
formatter.before({
  "duration": 3238765,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 329195,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2692345,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 115,
      "value": "# current command"
    }
  ],
  "line": 116,
  "name": "Display the current version of a candidate while Offline",
  "description": "",
  "id": "service-unavailable;display-the-current-version-of-a-candidate-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 117,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 118,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 119,
  "name": "I enter \"sdk current grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 120,
  "name": "I see \"Using grails version 2.1.0\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 588558,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101328572,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk current grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100419188,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 58172,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nUsing grails version 2.1.0\n\n\n");
formatter.after({
  "duration": 1223901,
  "status": "passed"
});
formatter.before({
  "duration": 3250806,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 47918,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3110091,
  "status": "passed"
});
formatter.scenario({
  "line": 122,
  "name": "Display the current version of all candidates while Offline",
  "description": "",
  "id": "service-unavailable;display-the-current-version-of-all-candidates-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 123,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 124,
  "name": "the candidate \"groovy\" version \"2.0.5\" is already installed and default",
  "keyword": "And "
});
formatter.step({
  "line": 125,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 126,
  "name": "I enter \"sdk current\"",
  "keyword": "When "
});
formatter.step({
  "line": 127,
  "name": "I see \"Using:\"",
  "keyword": "Then "
});
formatter.step({
  "line": 128,
  "name": "I see \"grails: 2.1.0\"",
  "keyword": "And "
});
formatter.step({
  "line": 129,
  "name": "I see \"groovy: 2.0.5\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 610418,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "2.0.5",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 428853,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101449142,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk current",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100425517,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using:",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 58243,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails: 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 23072,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groovy: 2.0.5",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 21470,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nUsing:\ngroovy: 2.0.5\ngrails: 2.1.0\n\n\n");
formatter.after({
  "duration": 1025927,
  "status": "passed"
});
formatter.before({
  "duration": 3367214,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 29239,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3142766,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 131,
      "value": "# version command"
    }
  ],
  "line": 132,
  "name": "Determine the sdkman version when Offline",
  "description": "",
  "id": "service-unavailable;determine-the-sdkman-version-when-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 133,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 134,
  "name": "I enter \"sdk version\"",
  "keyword": "When "
});
formatter.step({
  "line": 135,
  "name": "I see the current sdkman version",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101440231,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk version",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100351069,
  "status": "passed"
});
formatter.match({
  "location": "command_line_interop_steps.groovy:27"
});
formatter.result({
  "duration": 40878,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nSDKMAN x.y.z\n\n\n");
formatter.after({
  "duration": 1051325,
  "status": "passed"
});
formatter.before({
  "duration": 3145378,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 28142,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2881760,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 137,
      "value": "# broadcast command"
    }
  ],
  "line": 138,
  "name": "Recall a broadcast while Offline",
  "description": "",
  "id": "service-unavailable;recall-a-broadcast-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 139,
  "name": "a prior Broadcast \"This is an OLD Broadcast!\" with id \"12344\" was issued",
  "keyword": "Given "
});
formatter.step({
  "line": 140,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 141,
  "name": "I enter \"sdk broadcast\"",
  "keyword": "When "
});
formatter.step({
  "line": 142,
  "name": "I see \"This is an OLD Broadcast!\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "This is an OLD Broadcast!",
      "offset": 19
    },
    {
      "val": "12344",
      "offset": 55
    }
  ],
  "location": "broadcast_steps.groovy:16"
});
formatter.result({
  "duration": 214264,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 104027678,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk broadcast",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100431115,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This is an OLD Broadcast!",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 53813,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nThis is an OLD Broadcast!\n\n\n");
formatter.after({
  "duration": 1019007,
  "status": "passed"
});
formatter.before({
  "duration": 3262014,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 25394,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3854108,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 144,
      "value": "# help command"
    }
  ],
  "line": 145,
  "name": "Request help while Offline",
  "description": "",
  "id": "service-unavailable;request-help-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 146,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 147,
  "name": "I enter \"sdk help\"",
  "keyword": "When "
});
formatter.step({
  "line": 148,
  "name": "I see \"Usage: sdk \u003ccommand\u003e [candidate] [version]\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 104274790,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk help",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100434168,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Usage: sdk \u003ccommand\u003e [candidate] [version]",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 54489,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\n");
formatter.after({
  "duration": 1295248,
  "status": "passed"
});
formatter.before({
  "duration": 3203201,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is not reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:46"
});
formatter.result({
  "duration": 32224,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3828660,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 150,
      "value": "# selfupdate command"
    }
  ],
  "line": 151,
  "name": "Attempt self-update while Offline",
  "description": "",
  "id": "service-unavailable;attempt-self-update-while-offline",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 152,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 153,
  "name": "I enter \"sdk selfupdate\"",
  "keyword": "When "
});
formatter.step({
  "line": 154,
  "name": "I see \"This command is not available while offline.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 102549621,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk selfupdate",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100403574,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This command is not available while offline.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 55712,
  "status": "passed"
});
formatter.write("\nOutput: \n\n\u003d\u003d\u003d\u003d INTERNET NOT REACHABLE! \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\n Some functionality is disabled or only partially available.\n If this persists, please enable the offline mode:\n\n   $ sdk offline\n\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\n\nThis command is not available while offline.\n\n\n");
formatter.after({
  "duration": 1030815,
  "status": "passed"
});
formatter.uri("uninstall_candidate.feature");
formatter.feature({
  "line": 1,
  "name": "Uninstall Candidate",
  "description": "",
  "id": "uninstall-candidate",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3332153,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 14941250,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3917459,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Uninstall an installed Candidate Version not in use",
  "description": "",
  "id": "uninstall-candidate;uninstall-an-installed-candidate-version-not-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed but not default",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I enter \"sdk uninstall grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I do not see \"Unselecting grails 2.1.0\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I see \"Uninstalling grails 2.1.0\"",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "the candidate \"grails\" version \"2.1.0\" is not installed",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 517964,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101577166,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk uninstall grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100426797,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Unselecting grails 2.1.0",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 61596,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Uninstalling grails 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 24244,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 298710,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nUninstalling grails 2.1.0...\n\n\n");
formatter.after({
  "duration": 1277684,
  "status": "passed"
});
formatter.before({
  "duration": 3182943,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 19080585,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3741945,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Uninstall a Candidate Version in use",
  "description": "",
  "id": "uninstall-candidate;uninstall-a-candidate-version-in-use",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I enter \"sdk uninstall grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "I see \"Unselecting grails 2.1.0\"",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "I see \"Uninstalling grails 2.1.0\"",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "the candidate \"grails\" version \"2.1.0\" is not installed",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "the candidate \"grails\" is no longer selected",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 806330,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 104604659,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk uninstall grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100450632,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Unselecting grails 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 58620,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Uninstalling grails 2.1.0",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 20826,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 306453,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    }
  ],
  "location": "use_steps.groovy:42"
});
formatter.result({
  "duration": 280677,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nUnselecting grails 2.1.0...\n\nUninstalling grails 2.1.0...\n\n\n");
formatter.after({
  "duration": 988301,
  "status": "passed"
});
formatter.before({
  "duration": 3318184,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 22114608,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3486243,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Attempt uninstalling a Candidate Version that is not installed",
  "description": "",
  "id": "uninstall-candidate;attempt-uninstalling-a-candidate-version-that-is-not-installed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "the candidate \"grails\" version \"1.3.9\" is not installed",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I enter \"sdk uninstall grails 1.3.9\"",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "I see \"grails 1.3.9 is not installed.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:16"
});
formatter.result({
  "duration": 296314,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 104750264,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk uninstall grails 1.3.9",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100465197,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails 1.3.9 is not installed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 68032,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\ngrails 1.3.9 is not installed.\n\n\n");
formatter.after({
  "duration": 1120518,
  "status": "passed"
});
formatter.before({
  "duration": 3261366,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 27424369,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3477855,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Attempt uninstalling with no Candidate specified",
  "description": "",
  "id": "uninstall-candidate;attempt-uninstalling-with-no-candidate-specified",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "I enter \"sdk uninstall\"",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "I see \"No candidate provided.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 102935731,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk uninstall",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100360784,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "No candidate provided.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 68042,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nNo candidate provided.\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\n");
formatter.after({
  "duration": 1078516,
  "status": "passed"
});
formatter.before({
  "duration": 3484651,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 25789078,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3472095,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Attempt uninstalling with an invalid Candidate specified",
  "description": "",
  "id": "uninstall-candidate;attempt-uninstalling-with-an-invalid-candidate-specified",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 36,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "I enter \"sdk uninstall groffle\"",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "I see \"Stop! groffle is not a valid candidate.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101438970,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk uninstall groffle",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100456570,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! groffle is not a valid candidate.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 54639,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nStop! groffle is not a valid candidate.\n\n\n");
formatter.after({
  "duration": 1084352,
  "status": "passed"
});
formatter.before({
  "duration": 3289606,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 21824031,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3815058,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Attempt uninstalling without a version provided",
  "description": "",
  "id": "uninstall-candidate;attempt-uninstalling-without-a-version-provided",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 41,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 42,
  "name": "I enter \"sdk uninstall grails\"",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "I see \"No candidate version provided.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 102840237,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk uninstall grails",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100356873,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "No candidate version provided.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 76577,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nNo candidate version provided.\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\n");
formatter.after({
  "duration": 1397890,
  "status": "passed"
});
formatter.uri("use_version.feature");
formatter.feature({
  "line": 1,
  "name": "Use Version",
  "description": "",
  "id": "use-version",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3249579,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 19683013,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3724910,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Use without providing a Candidate",
  "description": "",
  "id": "use-version;use-without-providing-a-candidate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "the system is bootstrapped",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I enter \"sdk use\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I see \"Usage: sdk \u003ccommand\u003e [candidate] [version]\"",
  "keyword": "Then "
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 104134246,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100450380,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Usage: sdk \u003ccommand\u003e [candidate] [version]",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 57567,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nNo candidate provided.\n\nUsage: sdk \u003ccommand\u003e [candidate] [version]\n       sdk offline \u003cenable|disable\u003e\n\n   commands:\n       install   or i    \u003ccandidate\u003e [version]\n       uninstall or rm   \u003ccandidate\u003e \u003cversion\u003e\n       list      or ls   [candidate]\n       use       or u    \u003ccandidate\u003e [version]\n       default   or d    \u003ccandidate\u003e [version]\n       current   or c    [candidate]\n       outdated  or o    [candidate]\n       version   or v\n       broadcast or b\n       help      or h\n       offline           [enable|disable]\n       selfupdate        [force]\n       flush             \u003ccandidates|broadcast|archives|temp\u003e\n\n   candidate  :  the SDK to install: groovy, scala, grails, akka, etc.\n                 use list command for comprehensive list of candidates\n                 eg: $ sdk list\n\n   version    :  where optional, defaults to latest stable if not provided\n                 eg: $ sdk install groovy\n\n\n\n");
formatter.after({
  "duration": 1068148,
  "status": "passed"
});
formatter.before({
  "duration": 6148409,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 17121164,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3299079,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Use a candidate version that is installed",
  "description": "",
  "id": "use-version;use-a-candidate-version-that-is-installed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "the candidate \"grails\" version \"1.3.9\" is a valid candidate version",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed but not default",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I enter \"sdk use grails 1.3.9\"",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I see \"Using grails version 1.3.9 in this shell.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "the candidate \"grails\" version \"1.3.9\" should be in use",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the candidate \"grails\" version \"2.1.0\" should be the default",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 647202,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:30"
});
formatter.result({
  "duration": 8502013,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 610378,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 102799453,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 1.3.9",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100411581,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 1.3.9 in this shell.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 50810,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:25"
});
formatter.result({
  "duration": 100409323,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:30"
});
formatter.result({
  "duration": 162367,
  "status": "passed"
});
formatter.write("\nOutput: \n\nGrails Version: 1.3.9\n\n\n");
formatter.after({
  "duration": 1049222,
  "status": "passed"
});
formatter.before({
  "duration": 6700110,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 18595665,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3392990,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Use a candidate version that is not installed",
  "description": "",
  "id": "use-version;use-a-candidate-version-that-is-not-installed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 23,
  "name": "the candidate \"grails\" version \"1.3.9\" is available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I enter \"sdk use grails 1.3.9\" and answer \"Y\"",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I see \"Using grails version 1.3.9 in this shell.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "the candidate \"grails\" version \"1.3.9\" should be in use",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 16321604,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 103084725,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 1.3.9",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 43
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100377641,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 1.3.9 in this shell.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 52487,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:25"
});
formatter.result({
  "duration": 100397399,
  "status": "passed"
});
formatter.write("\nOutput: \n\nGrails version: 1.3.9\n\n\n");
formatter.after({
  "duration": 1084494,
  "status": "passed"
});
formatter.before({
  "duration": 4729975,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16872274,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3248624,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Use a candidate version that is automatically installed",
  "description": "",
  "id": "use-version;use-a-candidate-version-that-is-automatically-installed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 30,
  "name": "I have configured \"sdkman_auto_answer\" to \"true\"",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "the candidate \"grails\" version \"1.3.9\" is available for download",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "I enter \"sdk use grails 1.3.9\"",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "I see \"Stop! grails 1.3.9 is not installed.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "I see \"Using grails version 1.3.9 in this shell.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the candidate \"grails\" version \"1.3.9\" should be in use",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "sdkman_auto_answer",
      "offset": 19
    },
    {
      "val": "true",
      "offset": 43
    }
  ],
  "location": "installation_steps.groovy:78"
});
formatter.result({
  "duration": 234519,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 15270539,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 102911581,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 1.3.9",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100417487,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! grails 1.3.9 is not installed.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 123759,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 1.3.9 in this shell.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 21751,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:25"
});
formatter.result({
  "duration": 100361623,
  "status": "passed"
});
formatter.write("\nOutput: \n\nGrails version: 1.3.9\n\n\n");
formatter.after({
  "duration": 1001786,
  "status": "passed"
});
formatter.before({
  "duration": 3529901,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 21055474,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3666219,
  "status": "passed"
});
formatter.scenario({
  "line": 38,
  "name": "Use a candidate version that does not exist",
  "description": "",
  "id": "use-version;use-a-candidate-version-that-does-not-exist",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 39,
  "name": "the candidate \"groovy\" version \"1.9.9\" is not available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "I enter \"sdk use groovy 1.9.9\"",
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "I see \"Stop! 1.9.9 is not a valid groovy version.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "groovy",
      "offset": 15
    },
    {
      "val": "1.9.9",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:22"
});
formatter.result({
  "duration": 7302921,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101269332,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use groovy 1.9.9",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100412179,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stop! 1.9.9 is not a valid groovy version.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 51619,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nStop! 1.9.9 is not a valid groovy version.\n\n\n");
formatter.after({
  "duration": 1062238,
  "status": "passed"
});
formatter.before({
  "duration": 3138219,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 20588949,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3275927,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "Use a candidate version that only exists locally",
  "description": "",
  "id": "use-version;use-a-candidate-version-that-only-exists-locally",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 45,
  "name": "the candidate \"grails\" version \"2.0.0.M1\" is not available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 46,
  "name": "the candidate \"grails\" version \"2.0.0.M1\" is already installed but not default",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "I enter \"sdk use grails 2.0.0.M1\"",
  "keyword": "When "
});
formatter.step({
  "line": 49,
  "name": "I see \"Using grails version 2.0.0.M1 in this shell.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.0.0.M1",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:22"
});
formatter.result({
  "duration": 4787746,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.0.0.M1",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 946895,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 102808287,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 2.0.0.M1",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100434715,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 2.0.0.M1 in this shell.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 54126,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nSetting grails version 2.0.0.M1 as default.\n\nUsing grails version 2.0.0.M1 in this shell.\n\n\n");
formatter.after({
  "duration": 1035573,
  "status": "passed"
});
formatter.before({
  "duration": 3515221,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 19760360,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 3207429,
  "status": "passed"
});
formatter.scenario({
  "line": 51,
  "name": "Use an uninstalled candidate version of an uninstalled candidate and it becomes default",
  "description": "",
  "id": "use-version;use-an-uninstalled-candidate-version-of-an-uninstalled-candidate-and-it-becomes-default",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 52,
  "name": "the candidate \"grails\" version \"1.3.9\" is available for download",
  "keyword": "Given "
});
formatter.step({
  "line": 53,
  "name": "the candidate \"grails\" does not exist locally",
  "keyword": "And "
});
formatter.step({
  "line": 54,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "I enter \"sdk use grails 1.3.9\" and answer \"Y\"",
  "keyword": "When "
});
formatter.step({
  "line": 56,
  "name": "I see \"Setting grails version 1.3.9 as default.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 57,
  "name": "I see \"Using grails version 1.3.9 in this shell.\"",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "the candidate \"grails\" version \"1.3.9\" is installed",
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "the candidate \"grails\" version \"1.3.9\" should be the default",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 12292645,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    }
  ],
  "location": "installation_steps.groovy:44"
});
formatter.result({
  "duration": 210729,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 102891597,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 1.3.9",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 43
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100485501,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Setting grails version 1.3.9 as default.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 52116,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 1.3.9 in this shell.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 26174,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:10"
});
formatter.result({
  "duration": 95105,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:30"
});
formatter.result({
  "duration": 137732,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nStop! grails 1.3.9 is not installed.\nDo you want to install it now? (Y/n): \nDownloading: grails 1.3.9\n\n  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n\r100   541  100   541    0     0  94829      0 --:--:-- --:--:-- --:--:-- 94829\n\nInstalling: grails 1.3.9\nDone installing!\n\nSetting grails version 1.3.9 as default.\n\nUsing grails version 1.3.9 in this shell.\n\n\n");
formatter.after({
  "duration": 1048969,
  "status": "passed"
});
formatter.before({
  "duration": 3508074,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 19665094,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 4837484,
  "status": "passed"
});
formatter.scenario({
  "line": 61,
  "name": "Use an uninstalled candidate version of an installed candidate and it does not become default",
  "description": "",
  "id": "use-version;use-an-uninstalled-candidate-version-of-an-installed-candidate-and-it-does-not-become-default",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 62,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 63,
  "name": "the candidate \"grails\" version \"2.1.0\" is available for download",
  "keyword": "And "
});
formatter.step({
  "line": 64,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 65,
  "name": "I enter \"sdk use grails 2.1.0\" and answer \"Y\"",
  "keyword": "When "
});
formatter.step({
  "line": 66,
  "name": "I do not see \"Setting grails version 1.3.9 as default.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 67,
  "name": "I see \"Using grails version 2.1.0 in this shell.\"",
  "keyword": "And "
});
formatter.step({
  "line": 68,
  "name": "the candidate \"grails\" version \"2.1.0\" is installed",
  "keyword": "And "
});
formatter.step({
  "line": 69,
  "name": "the candidate \"grails\" version \"1.3.9\" should be the default",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 630125,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 33848410,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101265120,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 2.1.0",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 43
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100889051,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Setting grails version 1.3.9 as default.",
      "offset": 14
    }
  ],
  "location": "command_line_interop_steps.groovy:19"
});
formatter.result({
  "duration": 79353,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 2.1.0 in this shell.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 24836,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:10"
});
formatter.result({
  "duration": 106135,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "use_steps.groovy:30"
});
formatter.result({
  "duration": 134303,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\n\nStop! grails 2.1.0 is not installed.\nDo you want to install it now? (Y/n): \nDownloading: grails 2.1.0\n\n  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n\r100   541  100   541    0     0  95921      0 --:--:-- --:--:-- --:--:-- 95921\n\nInstalling: grails 2.1.0\nDone installing!\n\n\nUsing grails version 2.1.0 in this shell.\n\n\n");
formatter.after({
  "duration": 1017099,
  "status": "passed"
});
formatter.before({
  "duration": 3543083,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 16352905,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2660614,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 71,
      "value": "#scenarios related to updating _HOME variable"
    }
  ],
  "line": 73,
  "name": "Use an installed version of an installed candidate updates the candidate _HOME variable",
  "description": "",
  "id": "use-version;use-an-installed-version-of-an-installed-candidate-updates-the-candidate--home-variable",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 74,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 75,
  "name": "the candidate \"grails\" version \"2.1.0\" is already installed but not default",
  "keyword": "And "
});
formatter.step({
  "line": 76,
  "name": "the candidate \"grails\" version \"2.1.0\" is available for download",
  "keyword": "And "
});
formatter.step({
  "line": 77,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 78,
  "name": "the \"GRAILS_HOME\" variable contains \"grails/current\"",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "I enter \"sdk use grails 2.1.0\"",
  "keyword": "When "
});
formatter.step({
  "line": 80,
  "name": "I see \"Using grails version 2.1.0 in this shell.\"",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "the \"GRAILS_HOME\" variable contains \"grails/2.1.0\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 641423,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:35"
});
formatter.result({
  "duration": 490787,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 12650129,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101539195,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GRAILS_HOME",
      "offset": 5
    },
    {
      "val": "grails/current",
      "offset": 37
    }
  ],
  "location": "command_line_interop_steps.groovy:39"
});
formatter.result({
  "duration": 100783032,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 2.1.0",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100348513,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Using grails version 2.1.0 in this shell.",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 50307,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GRAILS_HOME",
      "offset": 5
    },
    {
      "val": "grails/2.1.0",
      "offset": 37
    }
  ],
  "location": "command_line_interop_steps.groovy:39"
});
formatter.result({
  "duration": 100373476,
  "status": "passed"
});
formatter.write("\nOutput: \n\n/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/candidates/grails/2.1.0\n\n\n");
formatter.after({
  "duration": 1050694,
  "status": "passed"
});
formatter.before({
  "duration": 3443012,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 14802456,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2681070,
  "status": "passed"
});
formatter.scenario({
  "line": 83,
  "name": "Use an uninstalled version of an uninstalled candidate updates the candidate _HOME variable",
  "description": "",
  "id": "use-version;use-an-uninstalled-version-of-an-uninstalled-candidate-updates-the-candidate--home-variable",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 84,
  "name": "the candidate \"grails\" does not exist locally",
  "keyword": "Given "
});
formatter.step({
  "line": 85,
  "name": "the candidate \"grails\" version \"2.1.0\" is available for download",
  "keyword": "And "
});
formatter.step({
  "line": 86,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 87,
  "name": "the \"GRAILS_HOME\" variable is not set",
  "keyword": "And "
});
formatter.step({
  "line": 88,
  "name": "I enter \"sdk use grails 2.1.0\" and answer \"Y\"",
  "keyword": "When "
});
formatter.step({
  "line": 89,
  "name": "the \"GRAILS_HOME\" variable contains \"grails/2.1.0\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    }
  ],
  "location": "installation_steps.groovy:44"
});
formatter.result({
  "duration": 147503,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 12967534,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101418771,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GRAILS_HOME",
      "offset": 5
    }
  ],
  "location": "command_line_interop_steps.groovy:44"
});
formatter.result({
  "duration": 100760912,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 2.1.0",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 43
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100530567,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GRAILS_HOME",
      "offset": 5
    },
    {
      "val": "grails/2.1.0",
      "offset": 37
    }
  ],
  "location": "command_line_interop_steps.groovy:39"
});
formatter.result({
  "duration": 100506532,
  "status": "passed"
});
formatter.write("\nOutput: \n\n/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/candidates/grails/2.1.0\n\n\n");
formatter.after({
  "duration": 1055294,
  "status": "passed"
});
formatter.before({
  "duration": 3467630,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 15029868,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2677455,
  "status": "passed"
});
formatter.scenario({
  "line": 91,
  "name": "Use an uninstalled version of an installed candidate updates the candidate _HOME variable",
  "description": "",
  "id": "use-version;use-an-uninstalled-version-of-an-installed-candidate-updates-the-candidate--home-variable",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 92,
  "name": "the candidate \"grails\" version \"1.3.9\" is already installed and default",
  "keyword": "Given "
});
formatter.step({
  "line": 93,
  "name": "the candidate \"grails\" version \"2.1.0\" is available for download",
  "keyword": "And "
});
formatter.step({
  "line": 94,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.step({
  "line": 95,
  "name": "the \"GRAILS_HOME\" variable contains \"grails/current\"",
  "keyword": "And "
});
formatter.step({
  "line": 96,
  "name": "I enter \"sdk use grails 2.1.0\" and answer \"Y\"",
  "keyword": "When "
});
formatter.step({
  "line": 97,
  "name": "the \"GRAILS_HOME\" variable contains \"grails/2.1.0\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "1.3.9",
      "offset": 32
    }
  ],
  "location": "installation_steps.groovy:22"
});
formatter.result({
  "duration": 596773,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "grails",
      "offset": 15
    },
    {
      "val": "2.1.0",
      "offset": 32
    }
  ],
  "location": "stub_steps.groovy:17"
});
formatter.result({
  "duration": 11554243,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101434387,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GRAILS_HOME",
      "offset": 5
    },
    {
      "val": "grails/current",
      "offset": 37
    }
  ],
  "location": "command_line_interop_steps.groovy:39"
});
formatter.result({
  "duration": 100445463,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdk use grails 2.1.0",
      "offset": 9
    },
    {
      "val": "Y",
      "offset": 43
    }
  ],
  "location": "command_line_interop_steps.groovy:10"
});
formatter.result({
  "duration": 100408866,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GRAILS_HOME",
      "offset": 5
    },
    {
      "val": "grails/2.1.0",
      "offset": 37
    }
  ],
  "location": "command_line_interop_steps.groovy:39"
});
formatter.result({
  "duration": 100379577,
  "status": "passed"
});
formatter.write("\nOutput: \n\n/tmp/sdkman-test/c5a977d6-ac59-4993-8c1f-45284a93de65/.sdkman/candidates/grails/2.1.0\n\n\n");
formatter.after({
  "duration": 1008896,
  "status": "passed"
});
formatter.uri("version.feature");
formatter.feature({
  "line": 1,
  "name": "Version",
  "description": "",
  "id": "version",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3517034,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the internet is reachable",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an initialised environment",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the system is bootstrapped",
  "keyword": "And "
});
formatter.match({
  "location": "initialisation_steps.groovy:35"
});
formatter.result({
  "duration": 14338845,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:78"
});
formatter.result({
  "duration": 2642317,
  "status": "passed"
});
formatter.match({
  "location": "initialisation_steps.groovy:112"
});
formatter.result({
  "duration": 101302194,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Show the current version of sdkman",
  "description": "",
  "id": "version;show-the-current-version-of-sdkman",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I enter \"sdk version\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I see \"SDKMAN x.y.z\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "sdk version",
      "offset": 9
    }
  ],
  "location": "command_line_interop_steps.groovy:5"
});
formatter.result({
  "duration": 100392084,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SDKMAN x.y.z",
      "offset": 7
    }
  ],
  "location": "command_line_interop_steps.groovy:15"
});
formatter.result({
  "duration": 69707,
  "status": "passed"
});
formatter.write("\nOutput: \n\nbroadcast message\nSDKMAN x.y.z\n\n\n");
formatter.after({
  "duration": 1071225,
  "status": "passed"
});
});