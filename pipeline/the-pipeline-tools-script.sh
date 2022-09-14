echo "          ((((((((((     installing maven START     ))))))))))          "
sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y apache-maven
echo "          ((((((((((     installing maven END     ))))))))))          "

#echo "installing gradle"
#sudo wget https://services.gradle.org/distributions/gradle-6.8.3-bin.zip -P /tmp
#sudo mkdir /opt/gradle
#sudo unzip -d /opt/gradle /tmp/gradle-*.zip
#echo "time to create the gradle environment variable, BUT, you may have to input this manually, the script isn't triggering it"
#export PATH=$PATH:/opt/gradle/gradle-6.8.3/bin
#echo "gradle installed"


echo "          ((((((((((     installing jenkins START     ))))))))))          "
sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo
sudo rpm --import http://pkg.jenkins.io/redhat/jenkins.io.key
sudo yum install jenkins -y --nobest
echo "          ((((((((((     installing jenkins END     ))))))))))          "

#sudo service jenkins start
#echo "jenkins started"




