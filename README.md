# AWS Portfolio 
I built and deployed a personal portfolio website hosted on AWS and accessible globally. 
This project showcases my experience with AWS core services, security best practices, and CI/CD automation. Here is the link to
my [portfolio](https://portfolio.naderay.tech/)


# Frontend
The frontend was initially generated using Claude Code to create the HTML, CSS, and JavaScript.
I then manually edited the HTML to add my personal information and customize the layout and styling to my preferences.

# AWS Configs
Once I had fixed my website I uploaded it to S3 and set it to private. I then set up OAC in Cloudfront so the website can only be accessed through Cloudfront. I bought a .tech 
domain from get.tech which was free because of Github student. I added the domain to Route53 and and got a certificate from AWS Certificate Manager. After that I coded the Lambda
function to increment the view count, display it, then save it back to DynamoDB.

# CI/CD
I also set up Github actions with OIDC so everytime I edit from my computer, it will change on S3 and then the website. This makes it secure since I don't have long lived 
credentials in Github.

# Reflections
This project taught me a lot about topics that I thought I wouldn't have trouble with. One of them being how DNS works and DNS propogation. Along with that I learned how much 
goes into DNS and the options I have with my domain registar. IAM was also particularly tricky and I learned a lot about how IAM affects the whole AWS system. Last thing was 
how to set up secure CI/CD enviroments and just how useful they could be. 

# Credits
I want to credit 2 people for helping make this project possible. My friend [Angel](https://www.linkedin.com/in/it-anc/) and [Rishab in Cloud](https://www.youtube.com/@rishabincloud) from Youtube. Without these 2 people I would have had a harder time trying to piece this project together so thank you.
