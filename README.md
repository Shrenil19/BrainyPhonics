# BrainyPhonics
An application dedicated towards providing lectures and quizzes to underprivileged elementary school students in a fun and interactive way.

# Motivation
The purpose of this project is to provide an app version of the already existing BrainyPhonics web application. This app runs on Androids and serves to mimic the web application precisely, offering no advantage over the web application or vice versa.

# System Architecture
This project uses a model-view-controller architecture - the models are used to represent entities including the User, Question, Answer, etc. The views are used to provide a kid-friendly interface. The controllers are used to grab data from the Data Analytics Platform, an offline database used to grab assets and information pertaining to classes and quizzes.

# Cloud Server Access
An instance of the Data Analytics Platofrm is currently running on a cloud server, which can be accessed by any device connected to the internet with the proper authentication. Once connected to the server, please refer to the documentation of the DAP which is included below.

Review the Information on the Wiki to get an overview of setting up external Apps to use the DAP
[https://github.com/BrainyEducation/Brainy-Kids/wiki](https://github.com/BrainyEducation/Brainy-Kids/wiki)

To modify the connection to the server ip to the instance's static IP: 45.76.254.167. This connection is found in the app at json/JsonHelper.java . You will require the root password which can be obtained by contacting Shrenil Shaun Sharma, or the current client of the project. You may also modify this connection to point to a DP location of your choice. Please keep in mind that when emulating an android device through android studio, you are not able to emulate endpoint access to external networks. 

Cloud Server Static IP: 45.76.254.167
@root user


# Installation
In order to run this project, JetBrains Toolbox, Gradle, and Android Studio must be installed. Once all of these are installed, clone this repository and open it on Android Studio. Press run in order to have the emulator run the app.

# Credits
Credits to our client - Dr. Walter Evans - who came up with the idea for this project and originally led the team building the web version of the app.
