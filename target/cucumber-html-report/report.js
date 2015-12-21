$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test.feature");
formatter.feature({
  "line": 1,
  "name": "Test feature",
  "description": "",
  "id": "test-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Searching for something",
  "description": "",
  "id": "test-feature;searching-for-something",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Runme"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I am on the homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefs.i_am_on_the_homepage()"
});
formatter.result({
  "duration": 13773591415,
  "status": "passed"
});
formatter.after({
  "duration": 944275598,
  "status": "passed"
});
});