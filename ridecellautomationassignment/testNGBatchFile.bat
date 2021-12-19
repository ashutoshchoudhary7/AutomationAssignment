set projectLocation=C:\Users\LENOVO\eclipse-workspace\ridecellautomationassignment
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause