Using the stackoverflow.com api documented at: https://api.stackexchange.com/docs retrieve
the list of stack overflow users meeting the following criteria:  
i. Are located in Romania or Moldova  
ii. Have a reputation of min 223 points.  
iii. Answered min 1 question  
iv. Have the tags: "java",".net","docker" or "C#"  
Requirements:  
- The code should be tracked with git and pushed to Github or Bitbucket.  The app should be written in Java (bonus points if written in Kotlin)  
- The list of retrieved users should be dumped in a list in STDOUT.  
Each line should contain:  
- User name  
- Location  
- Answer count  
- Question count  
- Tags as a comma delimited string  
- Link to profile  
- Link to avatar  
Bonus points for:  
- Writing the app in Kotlin  
- Using gradle as a package manager.  
- Use retrofit (https://square.github.io/retrofit/) for API interaction.
