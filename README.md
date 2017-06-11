# Weather app

## How to run

To build and install app just type **./gradlew intstallDebug** from the root of the project. Run **adb devices** to be sure that your device is connected.

To just make a build run **./gradlew assembleDebug** from the root of the project. The result apk will be in the root of the project in *app/build/outputs/apk/*

To use your emulator run **emulator -avd avd_name**. You can find the list of available emulators with **emulator -list-avds**. Once your emulator is ready run **adb install path/to/your_app.apk**.

**Tests are not implemented yet (just examples)**
To run unit tests you can run **./gradlew test** from the root of the project. The test result will be in *path_to_your_project/app/build/reports/tests/* directory.
To run instrumented tests you can run **./gradlew connectedAndroidTest** from the root of the project. The test result will be in *path_to_your_project/app/build/outputs/reports/androidTests/connected/* directory.

The app can be run on minimum 10th version of Android (Gingerbread)

## Examples of features to do in future

- sorting the list of weather records according to the date (descending)
- showing details of weather in a dialog

## Current technical debts

- lack of tests
- lack of dependency injection
- not safe according to the response (null pointers)
- lack of assertions of correctness of the data models
- activity recreation not handled
-- providing the view model by the DI as a singleton to the activity can be a solution

## Tests proposals

- asserting correctness of the data models
- asserting correctness of the view models according to the data models
- unit tests for the view models
- instrumentation tests to assert correctness of the views according to the view models
- asserting correct number of the items in the recycler view
