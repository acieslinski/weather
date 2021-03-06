# Weather app

The app can be run on minimum 10th version of Android (Gingerbread). It uses among others Retrofit, Databinding, Picasso, Mockito, constraint layout. It has been written in the MVVM pattern.

## How to run

To build and install app just type **./gradlew intstallDebug** from the root of the project. Run **adb devices** to be sure that your device is connected.

To just make a build run **./gradlew assembleDebug** from the root of the project. The result apk will be in the root of the project in *app/build/outputs/apk/*

To use your emulator run **emulator -avd avd_name**. You can find the list of available emulators with **emulator -list-avds**. Once your emulator is ready run **adb install path/to/your_app.apk**.

### Testing

To run unit tests you can run **./gradlew test** from the root of the project. The test result will be in *path_to_the_project/app/build/reports/tests/* directory.

To run instrumented tests you can run **./gradlew connectedAndroidTest** from the root of the project (a device or an emulator must be connected). The test result will be in *path_to_the_project/app/build/outputs/reports/androidTests/connected/* directory.

Warning: 3 unit tests fail, 1 unit test passes, 1 instrumented test passes

## Examples of features to do in future

- sorting the list of weather records according to the date (descending)
- showing details of weather in a dialog
- implementing the progressbar to show the loading state
- elevating the header area to comply with the material design pattern
- restoring the state of the activity after when app has been killed
- dialog on failed request (network connection lost, etc.)

## Current technical debts

- lack of dependency injection
- not safe according to the response (null pointers)
- not elevated header area to comply with the material design (the scrolling area should hide under another view - not just disappearing)
- no information about the state of the response
- activity recreation not handled
    - providing the view model by the DI as a singleton to the activity can be a solution (not for every case)
    - parceling the view model would be better solution but more difficult to implement & maintain
    - serializing the view model would be easy solution but not effective with bigger quantity of data
- observers are not being disposed of when they are not useful anymore
    - interrupting for fetching the data

## More tests proposals

- unit tests for the WeatherRecordListAdapter
- instrumented tests for WeatherActivity
    - testing the 'GO' button action
    - testing recreating of the activity
