# Touchtunes Mobile App Test

This framework will test the mobile app of Touchtunes.

## Prerequisites
1. https://www.swtestacademy.com/how-to-install-appium-on-mac/
2. Bash Shell for running the scripts
3. Please use the following postal code to setup the location "H3A 1S2".

## Link to the app tested video
Video related to the app tested.
https://drive.google.com/file/d/10_4xDNGfBhKWEEa4y8tnbqFgWHWf1xOt/view?usp=sharing

## Running tests on your local machine
1. Clone the repository into your local machine. 
2. Update your "./touchtunes/src/main/java/sweetiq/touchtunes/global.properties" file based on your requirement.
3. Please use the "./touchtunes/src/main/java/Resources/StartServer.sh" for running the server locally
4. Update the emulator name in "./touchtunes/src/main/java/Resources/StartEmulator.sh" file 
5. use the "./touchtunes/src/main/java/Resources/StartEmulator.sh" for bringing up your emulator
6. Maven build and Run as the "TestNG Test".


## Things to Do
1. Currently i am bringing up the server and emulator manually by using shell scripts, This need to be automated further.
2. Extensive usage of the Page Object Model is not performed, Few values are getting from the properties file. This need to be fixed.
3. Due to the dynamic nature of the app, some times unexpected things are appearing. Because of this reason testing is not handled propertly. Need to handle those kind of issues.
4. Reporting is not good. Need to work on this.
5. Worked only on Nexus 5X emulator, havent done any testing on other emulator, Need to work on this.

## Challenges Faced
1. System got crashed for a huge number of times. so, fixing this issue took a lot of time.
2. Finding the compactable package versions to run the framework.
3. Fixing the network related issues.
4. Refactoring of the code.
5. Spent a huge amount of time for bringing up & shut down the server automatically, but still having some issues with it.
