#enable features
enable virtual machine platform
enable windows subsystem for linux

#install ubuntu from MS store
run ubuntu from startmenu, will start and install ubuntu and will prompt for username ad nd password

#set wslto version 2
wsl --set-version Ubuntu 2

#update everything
sudo apt-get update
sudo apt-get upgrade

#install docker
https://docs.docker.com/install/linux/docker-ce/ubuntu/#install-using-the-convenience-script