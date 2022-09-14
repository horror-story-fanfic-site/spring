echo "          ((((((((((     let's start by uninstallinng docker entirely     ))))))))))          "
	
sudo rm -rf /var/lib/docker
sudo rm -rf /var/lib/containerd
	
sudo yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-engine
				  
sudo yum remove docker-ce docker-ce-cli containerd.io
				  
echo "          ((((((((((     installing docker repo     ))))))))))          "
sudo yum install -y yum-utils
sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
echo "          ((((((((((     installing docker engine     ))))))))))          "
sudo yum install docker-ce docker-ce-cli containerd.io -y
echo "          ((((((((((     starting docker START     ))))))))))          "
sudo systemctl start docker
echo "          ((((((((((     check to see if docker is running     ))))))))))          "
#sudo docker run hello-world




 
 
 