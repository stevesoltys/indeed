# Indeed
[![Download](https://api.bintray.com/packages/stevesoltys/maven/indeed/images/download.svg?version=0.1.0)](https://bintray.com/stevesoltys/maven/indeed/0.1.0/link)
[![Build Status](https://travis-ci.org/stevesoltys/indeed.svg?branch=master)](https://travis-ci.org/stevesoltys/indeed)
[![License](https://img.shields.io/github/license/stevesoltys/indeed.svg)](https://github.com/stevesoltys/indeed/blob/master/LICENSE)

An Indeed search API wrapper.

## Installation
```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'com.stevesoltys.indeed:indeed:0.1.0'
}
```

## Usage
Create an `Indeed` instance with your publisher ID, build a search query, and run it.

Here's an example:
```java
Indeed indeed = new Indeed("1234567890");

IndeedSearchResults searchResults = indeed.search()
    .query("Java").location("NYC")
    .radius(30).start(50).limit(100).run();

int total = searchResults.getTotalResults();

List<IndeedResult> results = searchResults.getResults();

// ...
```

You can also get an `IndeedResult` for a particular job, if you have the job key:
```java
Indeed indeed = new Indeed("1234567890");

IndeedResult result = indeed.getJob("1a2b3c4d5e6f7g8h9");
System.out.println(result.getTitle() + " at " + result.getCompany());
```


## Development
After checking out the repo, run `gradle compileJava` to build the project. If you want to run the tests, you must first 
define an environmental variable `INDEED_PUBLISHER_KEY` as your API key. Then, run `gradle test`.

## License
This application is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).
