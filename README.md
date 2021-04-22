# BrainyPhonics
An application dedicated towards providing lectures and quizzes to underprivileged elementary school students in a fun and interactive way.

### Motivation
The purpose of this project is to provide an app version of the already existing BrainyPhonics web application. This app runs on Androids and serves to mimic the web application precisely, offering no advantage over the web application or vice versa.

### System Architecture
This project uses a model-view-controller architecture - the models are used to represent entities including the User, Question, Answer, etc. The views are used to provide a kid-friendly interface. The controllers are used to grab data from the Data Analytics Platform, an offline database used to grab assets and information pertaining to classes and quizzes.

# Delivery Documentation

### Release Notes (as of V1, 23 April 2021)
- NEW FEATURES
  - blah
- BUG FIXES
  - blah
- KNOWN BUGS
  - blah
  
  ### Team 357 - Cloud Server Access
  An instance of the Data Analytics Platform is currently running on a cloud server, which can be accessed by any device connected to the internet with the proper authentication. Once connected to the server, please refer to the documentation of the DAP which is included below.

  Review the Information on the Wiki to get an overview of setting up external Apps to use the DAP
  [https://github.com/BrainyEducation/Brainy-Kids/wiki](https://github.com/BrainyEducation/Brainy-Kids/wiki)

  To modify the connection to the server ip to the instance's static IP: 45.76.254.167. This connection is found in the app at json/JsonHelper.java . You will require the root password which can be obtained by contacting Shrenil Shaun Sharma, or the current client of the project. You may also modify this connection to point to a DP location of your choice. Please keep in mind that when emulating an android device through android studio, you are not able to emulate endpoint access to external networks. 

  Cloud Server Static IP: 45.76.254.167
  @root user
  
### Installation
PREREQUISITES: 
  - Android Studio 3.2+ and compatible emulator or physical android device
  - [BACKEND] Node.js (Make sure node --version prints out a version number)
  - [BACKEND] MongoDb (pointing to remote access cloud server above)
  - [BACKEND] npm (Run npm --version in your terminal and expect to see a version number printed out)
  
- DEPENDENCIES
  - blah
  
- DOWNLOAD
  - blah
  
- BUILD
  - blah
  
- INSTALLATION:
  - Clone this repository (git clone git@github.com:Shrenil19/BrainyPhonics.git
  - [BACKEND] To install local backend instance, clone this repository (git clone git@github.com:jvt/Brainy-Kidz.git) and follow instructions on: https://github.com/jvt/Brainy-Kids
  - Ensure whichever method (local, Team 357 Cloud, or Client Cloud) of backend connection is properly configured in the app at: BrainyPhonics/app/src/main/java/com/example/heratale_app/json/JsonHelper.java 
  
- HOW TO RUN:
  1. In Android Studio, select your app from the run/debug configurations drop-down menu in the toolbar.
  2. In the toolbar, select the device that you want to run your app on from the target device drop-down menu.
  
- TESTING:
    -From a terminal window, run npm run test or npm test (both do the same thing)
    -Let the tests run, it will generate a coverage window in the terminal once all the tests have completed running
In order to run this project, JetBrains Toolbox, Gradle, and Android Studio must be installed. Once all of these are installed, clone this repository and open it on Android Studio. Press run in order to have the emulator run the app.

# Credits
Credits to our client - Dr. Walter Evans - who came up with the idea for this project and originally led the team building the web version of the app.
