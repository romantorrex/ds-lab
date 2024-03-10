# Data Structures Lab

## Introduction
This repository contains my personal implementations of some data structures using Java 17. The aim of this project is not just to provide a library of data structures, but also to serve as a learning tool for understanding the internals of these fundamental components in computer science.

## Prerequisites
- Java JDK 17
- Gradle (used for building and managing dependencies)

## Setup and Installation
Clone the repository to your local machine:
```bash
git clone https://github.com/[romantorrex]/[ds-lab].git
cd ds-lab
```

## Build
Build the project using Gradle:
```bash
./gradlew build
```

This command compiles the Java code, downloads the necessary dependencies, and generates the build files.

## Running the Tests
This project uses the [Spock Framework](https://spockframework.org/) for unit testing. To run the unit tests, use the following Gradle command:

```bash
./gradlew test
```

The test results are available in `build/reports/tests/test/index.html` which can be opened in a web browser.

## Data Structures Implemented
- Linked List
- Max Heap
- Trie
