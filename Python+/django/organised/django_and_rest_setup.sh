# update this script to take 3rd parameter 
#		for specifying whether or not to install
#		djangorestframework

if [ $# != 2 ];
then
	# check required parametes
	printf "Usage : $0 project_name app_name\n"
	printf "retry ;(\n\n"
	exit
else
	# Create a virtualenv to isolate our package dependencies locally
	printf "\nCreating virtualenv : $1_env\n\n"
	virtualenv -p `which python3` $1_env
	source $1_env/bin/activate
	printf "Created virtualenv : $1_env and activated it\n\n"

	# Install Django and Django REST framework into the virtualenv
	printf "Installing django and djangorestframework\n\n"
	pip install django 
	pip install djangorestframework
	printf "\nInstalled django and djangorestframework\n\n"

	# Set up a new project with a single application
	printf "Creating -\nproject	: $1\napp	: $2\n\n"
	django-admin startproject $1 .  # Note the trailing '.' character
	#cd $1
	django-admin startapp $2
	#cd ..
	printf "
Succesfully created -
virtualenv	: $1_env
project		: $1
app		: $2
\n\n"

	#Manually set propmt and python manage.py alias
printf "Copy paste following :\n
source ./$1_env/bin/activate
PS1='> '
alias pym='python manage.py'
python -V
python -c 'import django; print(django.get_version())'\n\n"

fi