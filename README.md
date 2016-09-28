# DISL-IDE-To-WebDriver
A script I made to convert Selenium IDE autotests to Selenium Webdriver.

# Point to this script
The script parses out the commands contained in the Selenium IDE autotest file and based on the user created rules will generate a single line command in Selenium Webdriver.

# Limitations
The converter is built to output Webdriver commands in the form "CommandName(parm, parm, parm);". There is no support for complex logic or to handle custom addons, it just maps IDE command -> Webdriver command.

# Setup to use
The converter requires the rules to commands, there is examples inside of Generate_Lexicon.java. If the script has no rule for a command it will display a warning and output the ide command in comments. To fix this just add a rule to handle this command or fix it by hand in the output java file. It also uses a pre and post file which are so you can generate full compilable java file. The script will output the file in the form "Output_String = PreFile + Commands + Postfile". There might be some find and replace to automatically name the file and function for you but I don't remember. 

# Warnings
I do not guarantee the successful converting of autotests. I built this at home in my free time for my work so I was not able to test it on real autotests until I got to work. I fixed a few minor bugs and changed a few tiny things to make it nicer to use when I got to work but this does not include those changes.
