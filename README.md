# Implementation Details

To identify which district the FM sould be assigned, `wastage` is calculated for each district
and district with the minimum amount of `wastage` is selected. `wastage` is defined as the number
of additional scooters that can be added to a district to fully consume all assigned FM and FE(if any) capacity.

[`DistrictWastageComparator`] contains logic to calculate wastage for a district.

Once district for FM is selected, number of FEs is [calculated] for each district and [summed up].
For the FM district, the [remaining] number of scooters are considered after considering FM's quota.

[`Challenge`] is the entry point for the application. It accepts user input from command line, validates it
using [`InputValidator`] and then asks [`FECalculator`] for the answer.

Unit test for all logic is under the [test package].

# Pre-requisites

* Java version `1.8`
* `Apache Maven 3.5.0` to compile, test and package

# To execute

`java -jar bin/challenge.jar` from root of the application.

# To package and then execute

`mvn package` will create `target/challenge-1.0.jar` which can then be executed using `java -jar target/challenge-1.0.jar`

# To test

`mvn test` will run the unit tests.

[`DistrictWastageComparator`]: https://github.com/vjcc/challenge/blob/master/src/main/java/com/vivek/selector/DistrictWastageComparator.java#L24-L32
[calculated]: https://github.com/vjcc/challenge/blob/master/src/main/java/com/vivek/FECalculator.java#L42
[summed up]: https://github.com/vjcc/challenge/blob/master/src/main/java/com/vivek/FECalculator.java#L33
[remaining]: https://github.com/vjcc/challenge/blob/master/src/main/java/com/vivek/FECalculator.java#L36-L39
[`Challenge`]: https://github.com/vjcc/challenge/blob/master/src/main/java/com/vivek/Challenge.java#L18
[`InputValidator`]: https://github.com/vjcc/challenge/blob/master/src/main/java/com/vivek/InputValidator.java
[`FECalculator`]: https://github.com/vjcc/challenge/blob/master/src/main/java/com/vivek/FECalculator.java
[test package]: https://github.com/vjcc/challenge/tree/master/src/test/java/com/vivek


